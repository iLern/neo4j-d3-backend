package com.example.neo4jd3.service.impl;

import com.example.neo4jd3.dao.ArmStatusRepo;
import com.example.neo4jd3.pojo.ArmStatusEntity;
import com.example.neo4jd3.service.ArmStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ArmStatusServiceImpl implements ArmStatusService {
    ArmStatusRepo armStatusRepo;

    @Autowired
    public ArmStatusServiceImpl(ArmStatusRepo armStatusRepo) {
        this.armStatusRepo = armStatusRepo;
    }

    public ArmStatusEntity getById(Long id) {
        return armStatusRepo.getById(id);
    }

    public ArmStatusEntity getByName(String name) {
        return armStatusRepo.getByName(name);
    }

    public List<ArmStatusEntity> listAll() {
        return armStatusRepo.listAll();
    }
}
