package com.example.neo4jd3.dao;

import com.example.neo4jd3.entity.ArmStatusEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

//<T, Id>
@Repository
public interface ArmStatusRepo extends Neo4jRepository<ArmStatusEntity, Long> {

}