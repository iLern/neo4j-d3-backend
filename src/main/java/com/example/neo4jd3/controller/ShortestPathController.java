package com.example.neo4jd3.controller;

import com.example.neo4jd3.service.ShortestPathService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/shortest-path")
public class ShortestPathController {
    private final ShortestPathService shortestPathService;

    public ShortestPathController(ShortestPathService shortestPathService) {
        this.shortestPathService = shortestPathService;
    }


}
