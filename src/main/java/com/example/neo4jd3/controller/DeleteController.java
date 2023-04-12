package com.example.neo4jd3.controller;

import com.example.neo4jd3.dao.ArmStatusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/delete")
public class DeleteController {
    ArmStatusRepo armStatusRepo;

    @Autowired
    public DeleteController(ArmStatusRepo armStatusRepo) {
        this.armStatusRepo = armStatusRepo;
    }

    @DeleteMapping("/id")
    public String deleteById(Long id) {
        armStatusRepo.deleteById(id);
        return "成功";
    }
}
