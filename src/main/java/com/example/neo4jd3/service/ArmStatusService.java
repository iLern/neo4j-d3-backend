package com.example.neo4jd3.service;

import com.example.neo4jd3.model.ArmStatusEntity;

import java.util.List;

public interface ArmStatusService {
    ArmStatusEntity getById(Long id);

    ArmStatusEntity getByName(String name);

    List<ArmStatusEntity> listAll();

    void deleteById(Long id);
}
