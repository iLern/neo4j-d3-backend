package com.example.neo4jd3.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortestPathResponse {

    private String from;
    private String to;
    private Double totLen;

    // 拷贝构造
    public ShortestPathResponse(ShortestPathResponse shortestPathResponse) {
        this.from = shortestPathResponse.getFrom();
        this.to = shortestPathResponse.getTo();
        this.totLen = shortestPathResponse.getTotLen();
    }
}
