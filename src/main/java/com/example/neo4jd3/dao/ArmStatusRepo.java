package com.example.neo4jd3.dao;

import com.example.neo4jd3.model.ArmStatusEntity;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

//<T, Id>
@Repository
public interface ArmStatusRepo extends Neo4jRepository<ArmStatusEntity, Long> {

    @Query("MATCH (n:ArmStatus) OPTIONAL MATCH (n:ArmStatus)-[r:ACHIEVABLE]-(m:ArmStatus) RETURN n, collect(r), collect(m)")
    List<ArmStatusEntity> listAllNodes();

    @Query("MATCH (n:ArmStatus {name: $name}) RETURN n")
    ArmStatusEntity getStatusByName(String name);

    @Query("MATCH (n:ArmStatus {id: $id}) RETURN n")
    ArmStatusEntity getStatusById(Long id);

    @Query("CREATE (n:ArmStatus {id: randomUUID(), name: $name, jointAngle: $jointAngle, position: $position}) RETURN n")
    ArmStatusEntity createStatus(String name, List<Double> jointAngle, String position);

    @Query("MATCH (n: ArmStatus {id: $id}) DELETE (n)")
    void deleteStatusById(Long id);
}