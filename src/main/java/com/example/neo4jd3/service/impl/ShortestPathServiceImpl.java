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
        return rows
                .map(it -> this.convert(it.asPath()))
                .take(1)
                .next()
                .switchIfEmpty(Mono.empty());
    }

    private ShortestPathResponse convert(org.neo4j.driver.types.Path connection) {
        String beginStat = connection.start().get("name").asString();
        String endStat = connection.end().get("name").asString();

        Double totLen = StreamSupport.stream(connection.relationships().spliterator(), false)
                .filter(edge -> edge.hasType("ACHIEVABLE"))
                .mapToDouble(route -> route.get("para").get(0).asDouble())
                .sum();

        return new ShortestPathResponse(beginStat, endStat, totLen);
    }
}
