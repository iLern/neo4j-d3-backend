package com.example.neo4jd3.dao;

import com.example.neo4jd3.pojo.ArmStatusEntity;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;

import java.util.UUID;

public interface ShortestPathRepo extends ReactiveNeo4jRepository<ArmStatusEntity, UUID> {

}
