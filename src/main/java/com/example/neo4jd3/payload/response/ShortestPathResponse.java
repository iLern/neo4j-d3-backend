package com.example.neo4jd3.payload.response;

import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ShortestPathResponse {
    // 最短路途经的节点名称 / 编号
    private List<String> nodesInPath;
    private Double totLen;

    // 拷贝构造
    public ShortestPathResponse(ShortestPathResponse shortestPathResponse) {
        this.nodesInPath = shortestPathResponse.getNodesInPath();
        this.totLen = shortestPathResponse.getTotLen();
    }
}
