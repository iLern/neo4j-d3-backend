package com.example.neo4jd3;

import com.example.neo4jd3.dao.ShortestPathRepo;
import com.example.neo4jd3.payload.response.ShortestPathResponse;
import org.junit.jupiter.api.Test;
import org.neo4j.driver.internal.value.PathValue;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

public class ShortestPathTests {
    private final ShortestPathRepo shortestPathRepo;

    public ShortestPathTests(ShortestPathRepo shortestPathRepo) {
        this.shortestPathRepo = shortestPathRepo;
    }

    @Test
    public void getShortestPath() {
        String from = "st3";
        String to = "st6";
        Integer lenId = 1;

        final Flux<PathValue> rows = shortestPathRepo.shortestPath(from, to, lenId);

        Mono<ShortestPathResponse> response = rows.map(it -> this.convert(it.asPath(), lenId))
                .take(1)
                .next()
                .switchIfEmpty(Mono.empty());

//        rows.subscribe(System.out::println); //path[(24)-[6:ACHIEVABLE]->(25), (25)-[11:ACHIEVABLE]->(27)]
//        rows.map(PathValue::asPath).subscribe(System.out::println);
//        return Mono.empty();
    }

    private ShortestPathResponse convert(org.neo4j.driver.types.Path path, Integer lenId) {
        String beginStat = path.start().get("name").asString();
        String endStat = path.end().get("name").asString();

        List<String> nodesInPath = new ArrayList<>();
        System.out.println(path.nodes());

        for (var node : path.nodes()) {
            System.out.println(node.asMap());
        }

        Double totLen = StreamSupport.stream(path.relationships().spliterator(), false)
                .filter(edge -> edge.hasType("ACHIEVABLE"))
                .mapToDouble(route -> route.get("para").get(lenId).asDouble())
                .sum();

        return new ShortestPathResponse(nodesInPath, totLen);
    }
}
