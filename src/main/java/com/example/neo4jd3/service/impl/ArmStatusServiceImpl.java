package com.example.neo4jd3.service.impl;

import com.example.neo4jd3.dao.ArmStatusRepo;
import com.example.neo4jd3.model.ArmStatusEntity;
import com.example.neo4jd3.service.ArmStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArmStatusServiceImpl implements ArmStatusService {
    final ArmStatusRepo armStatusRepo;

    @Autowired
    public ArmStatusServiceImpl(ArmStatusRepo armStatusRepo) {
        this.armStatusRepo = armStatusRepo;
    }

    public ArmStatusEntity getById(Long id) {
        return armStatusRepo.getStatusById(id);
    }

    public ArmStatusEntity getByName(String name) {
        return armStatusRepo.getStatusByName(name);
    }

    public List<ArmStatusEntity> listAll() {
        return armStatusRepo.listAll();
    }

    public void deleteById(Long id) {
        armStatusRepo.deleteStatusById(id);
    }
}
