package com.example.neo4jd3.dao;

import com.example.neo4jd3.pojo.ArmStatusEntity;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

import java.util.UUID;

public interface ShortestPathRepo extends ReactiveNeo4jRepository<ArmStatusEntity, UUID> {
    @Query("MATCH (a: ArmStatus {name: $from})\n"
                    + "MATCH (b: ArmStatus {name: $to})\n"
                    + "CALL apoc.algo.dijkstra(a, b, 'ACHIEVABLE', 'para[$lenId]')\n"
                    + "YIELD path, weight\n"
                    + "RETURN path\n"
                    + "ORDER BY weight ASC LIMIT 1")

    Flux<PathValue> shortestPath(@Param("from") String from, @Param("to") String to, @Param("lenId") Integer lenId);
}
