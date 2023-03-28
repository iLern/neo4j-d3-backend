package com.example.neo4jd3.controller;

import com.example.neo4jd3.pojo.ArmStatusEntity;
import com.example.neo4jd3.service.ArmStatusService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/api/get")
public class GetController {
    ArmStatusService armStatusService;

    public GetController(ArmStatusService armStatusService) {
        this.armStatusService = armStatusService;
    }

    @GetMapping("/id")
    public ArmStatusEntity findById(Long id) {
        ArmStatusEntity defaultArmStatus = new ArmStatusEntity("default", null, null);
        return armStatusService.findById(id).orElse(defaultArmStatus);
    }

    @GetMapping("/name")
    public ArmStatusEntity findByName(String name) {
        return armStatusService.findByName(name);
    }

    @GetMapping("/all")
    public Iterable<ArmStatusEntity> findAll() {
        return armStatusService.findAll();
    }
}
