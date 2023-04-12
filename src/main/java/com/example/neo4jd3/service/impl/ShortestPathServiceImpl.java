package com.example.neo4jd3.service.impl;

import com.example.neo4jd3.dao.ShortestPathRepo;
import com.example.neo4jd3.service.ShortestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ShortestPathServiceImpl implements ShortestPathService {
    private final ShortestPathRepo shortestPathRepo;

    @Autowired
    public ShortestPathServiceImpl(ShortestPathRepo shortestPathRepo) {
        this.shortestPathRepo = shortestPathRepo;
    }
}
