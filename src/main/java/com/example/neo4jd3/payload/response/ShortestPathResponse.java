package com.example.neo4jd3.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortestPathResponse {

    private String from;
    private String destination;
    private String path;
    private Double distance;

    // 拷贝构造
    public ShortestPathResponse(ShortestPathResponse shortestPathResponse) {
        this.from = shortestPathResponse.getFrom();
        this.destination = shortestPathResponse.getDestination();
        this.path = shortestPathResponse.getPath();
        this.distance = shortestPathResponse.getDistance();
    }
}
