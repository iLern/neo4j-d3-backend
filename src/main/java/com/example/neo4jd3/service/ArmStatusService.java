package com.example.neo4jd3.service;

import com.example.neo4jd3.dao.ArmStatusRepo;
import com.example.neo4jd3.pojo.ArmStatusEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ArmStatusService {
    ArmStatusRepo armStatusRepo;

    public ArmStatusService(ArmStatusRepo armStatusRepo) {
        this.armStatusRepo = armStatusRepo;
    }

    public Optional<ArmStatusEntity> findById(Long id) {
        return armStatusRepo.findById(id);
    }

    public ArmStatusEntity findByName(String name) {
        return armStatusRepo.findByName(name);
    }

    public Iterable<ArmStatusEntity> findAll() {
        return armStatusRepo.findAll();
    }
}
