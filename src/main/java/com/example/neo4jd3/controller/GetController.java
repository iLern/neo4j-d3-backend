package com.example.neo4jd3.controller;

import com.example.neo4jd3.pojo.ArmStatusEntity;
import com.example.neo4jd3.service.impl.ArmStatusServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/get/")
public class GetController {
    ArmStatusServiceImpl armStatusService;

    @Autowired
    public GetController(ArmStatusServiceImpl armStatusService) {
        this.armStatusService = armStatusService;
    }

    @GetMapping("/{id}")
    public ArmStatusEntity getById(@PathVariable(value = "id") UUID id) {
        return armStatusService.getById(id);
    }

    @GetMapping("/name/{name}")
    public ArmStatusEntity getByName(@PathVariable(value = "name") String name) {
        return armStatusService.getByName(name);
    }

    @GetMapping("/all")
    public List<ArmStatusEntity> listAll() {
        return armStatusService.listAll();
    }
}
