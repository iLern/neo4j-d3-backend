package com.example.neo4jd3.dao;

import com.example.neo4jd3.pojo.ArmStatusEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

//<T, Id>
@Repository
public interface ArmStatusRepo extends Neo4jRepository<ArmStatusEntity, UUID> {

    @Query("MATCH (n:ArmStatus) OPTIONAL MATCH (n:ArmStatus)-[r:ACHIEVABLE]->(m:ArmStatus) RETURN n, collect(r), collect(m)")
    List<ArmStatusEntity> listAll();

    @Query("MATCH (n:ArmStatus {name: $name}) RETURN n")
    ArmStatusEntity getByName(String name);

    @Query("MATCH (n:ArmStatus {id: $id}) RETURN n")
    ArmStatusEntity getById(UUID id);
}