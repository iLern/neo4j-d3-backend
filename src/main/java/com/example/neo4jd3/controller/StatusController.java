package com.example.neo4jd3.controller;

import com.example.neo4jd3.dao.ArmStatusRepo;
import com.example.neo4jd3.entity.ArmStatusEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StatusController {
    private final ArmStatusRepo armStatusRepo;
    public StatusController(ArmStatusRepo armStatusRepo) {
        this.armStatusRepo = armStatusRepo;
    }

    @GetMapping(value = "/status")
    public Iterable<ArmStatusEntity> findAllNodes() {
        System.out.println("hello");
        return armStatusRepo.findAll();
    }
}
