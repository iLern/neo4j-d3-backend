package com.example.neo4jd3;

import com.example.neo4jd3.dao.ArmStatusRepo;
import com.example.neo4jd3.pojo.AchievableRelationship;
import com.example.neo4jd3.pojo.ArmStatusEntity;
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

    @Test
    public void testRelationShip() {
        Double[] tmp = {1.0, 2.0, 3.0};
        ArmStatusEntity st1 = new ArmStatusEntity("hoho", List.of(tmp), "Center");
        ArmStatusEntity st2 = new ArmStatusEntity("hehe", List.of(tmp), "Center");

        Double[] para = {3.0, 4.0, 5.0};
        Double[] negapara = {-3.0, -4.0, -5.0};
        AchievableRelationship st12st2 = new AchievableRelationship(st2, "3", List.of(para));
        AchievableRelationship st22st1 = new AchievableRelationship(st1, "3", List.of(negapara));

        st1.getAchievableStatus().add(st12st2);
        st2.getAchievableStatus().add(st22st1);

        armStatusRepo.save(st1);
        armStatusRepo.save(st2);
    }
}


