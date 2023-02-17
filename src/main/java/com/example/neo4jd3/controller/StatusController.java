package com.example.neo4jd3.controller;

import com.example.neo4jd3.pojo.ArmStatusEntity;
import com.example.neo4jd3.service.ArmStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/api/status/")
public class StatusController {
    ArmStatusService armStatusService;

    public StatusController(ArmStatusService armStatusService) {
        this.armStatusService = armStatusService;
    }

    @GetMapping("/find/id")
    public Optional<ArmStatusEntity> findById(Long id) {
        return armStatusService.findById(id);
    }

    @GetMapping("/find/name")
    public ArmStatusEntity findByName(String name) {
        return armStatusService.findByName(name);
    }
}
