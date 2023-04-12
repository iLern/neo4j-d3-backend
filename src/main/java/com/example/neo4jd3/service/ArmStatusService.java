package com.example.neo4jd3.service;

import com.example.neo4jd3.pojo.ArmStatusEntity;

import java.util.List;
import java.util.UUID;

public interface ArmStatusService {
    ArmStatusEntity getById(UUID id);

    ArmStatusEntity getByName(String name);

    List<ArmStatusEntity> listAll();
}
