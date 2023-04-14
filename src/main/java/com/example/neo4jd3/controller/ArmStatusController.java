package com.example.neo4jd3.controller;

import com.example.neo4jd3.mapper.ArmStatusMapper;
import com.example.neo4jd3.model.ArmStatusEntity;
import com.example.neo4jd3.payload.response.ArmStatusResponse;
import com.example.neo4jd3.service.ArmStatusService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/arm-status")
public class ArmStatusController {
    private final Logger LOGGER = LoggerFactory.getLogger(getClass());
    private final ArmStatusService armStatusService;
    private final ArmStatusMapper armStatusMapper;

    public ArmStatusController(ArmStatusService armStatusService, ArmStatusMapper armStatusMapper) {
        this.armStatusService = armStatusService;
        this.armStatusMapper = armStatusMapper;
    }

    @GetMapping("/id/{id}")
    public ArmStatusResponse getById(@PathVariable(value = "id") Long id) {
        ArmStatusEntity armStatusEntity = armStatusService.getById(id);
        ArmStatusResponse armStatusResponse = armStatusMapper.toArmStatusResponse(armStatusEntity);

        LOGGER.info("ArmStatusController | getById | armStatusResponse : " + armStatusResponse.toString());

        return armStatusResponse;
    }

    @GetMapping("/name/{name}")
    public ArmStatusResponse getByName(@PathVariable(value = "name") String name) {
        ArmStatusEntity armStatusEntity = armStatusService.getByName(name);
        ArmStatusResponse armStatusResponse = armStatusMapper.toArmStatusResponse(armStatusEntity);

        LOGGER.info("ArmStatusController | getByName | armStatusResponse : " + armStatusResponse.toString());

        return armStatusResponse;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ArmStatusResponse>> listAll() {
        List<ArmStatusEntity> armStatusEntities = armStatusService.listAll();
        List<ArmStatusResponse> armStatusResponses = armStatusMapper.toArmStatusResponseList(armStatusEntities);

        LOGGER.info("ArmStatusController | listAll | armStatusResponses : " + armStatusResponses.toString());

        return ResponseEntity.ok(armStatusResponses);
    }
}
