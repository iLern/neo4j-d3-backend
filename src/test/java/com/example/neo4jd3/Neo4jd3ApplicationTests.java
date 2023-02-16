package com.example.neo4jd3;

import com.example.neo4jd3.dao.ArmStatusRepo;
import com.example.neo4jd3.entity.ArmStatusEntity;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class Neo4jd3ApplicationTests {

    @Autowired
    ArmStatusRepo armStatusRepo;

    @Test
    void contextLoads() {
    }

    @Test
    public void testCreate() {
        Double[] tmp = {1.0, 2.0, 3.0};
        ArmStatusEntity st1 = new ArmStatusEntity("haha", List.of(tmp), "Right");
        ArmStatusEntity st2 = new ArmStatusEntity("hihi", List.of(tmp), "Right");

        armStatusRepo.save(st1);
        armStatusRepo.save(st2);
    }
}


