package com.example.neo4jd3.service;

import com.example.neo4jd3.payload.response.ShortestPathResponse;
import reactor.core.publisher.Mono;

public interface ShortestPathService {
    Mono<ShortestPathResponse> getShortestPath(String from, String to, Integer lenId);
}
