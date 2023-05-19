package com.example.neo4jd3.service.impl;

import com.example.neo4jd3.dao.ShortestPathRepo;
import com.example.neo4jd3.payload.response.ShortestPathResponse;
import com.example.neo4jd3.service.ShortestPathService;
import jakarta.transaction.Transactional;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.StreamSupport;

@Service
@Transactional
public class ShortestPathServiceImpl implements ShortestPathService {
    private final ShortestPathRepo shortestPathRepo;

    @Autowired
    public ShortestPathServiceImpl(ShortestPathRepo shortestPathRepo) {
        this.shortestPathRepo = shortestPathRepo;
    }

    @Override
    public Mono<ShortestPathResponse> getShortestPath(String from, String to, Integer lenId) {
        final Flux<PathValue> rows = shortestPathRepo.shortestPath(from, to, lenId);

        rows.map(PathValue::asPath).subscribe(System.out::println);

        return rows.map(it -> this.convert(it.asPath(), lenId))
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
//        System.out.println(path.nodes());

        for (var node : path.nodes()) {
            String nodeName = node.get("name").asString();
            nodesInPath.add(nodeName);
//            System.out.println(nodeName);
        }

        Double totLen = StreamSupport.stream(path.relationships().spliterator(), false)
                .filter(edge -> edge.hasType("ACHIEVABLE"))
                .mapToDouble(route -> route.get("para").get(lenId).asDouble())
                .sum();

        return new ShortestPathResponse(nodesInPath, totLen);
    }
}