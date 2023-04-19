package com.example.neo4jd3.controller;

import com.example.neo4jd3.payload.response.ShortestPathResponse;
import com.example.neo4jd3.service.ShortestPathService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping(path = "/api/shortest-path")
public class ShortestPathController {
    private final ShortestPathService shortestPathService;

    public ShortestPathController(ShortestPathService shortestPathService) {
        this.shortestPathService = shortestPathService;
    }

    @GetMapping(path = "/")
    public Mono<ShortestPathResponse> getShortestPath(@RequestParam String from, @RequestParam String to, @RequestParam Integer type) {
        return shortestPathService.getShortestPath(from, to, type);
    }
}
