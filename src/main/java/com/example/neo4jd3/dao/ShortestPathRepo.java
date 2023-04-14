package com.example.neo4jd3.dao;

import com.example.neo4jd3.model.ArmStatusEntity;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.ReactiveNeo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import reactor.core.publisher.Flux;

public interface ShortestPathRepo extends ReactiveNeo4jRepository<ArmStatusEntity, Long> {
    @Query("""
            MATCH (a: ArmStatus {name: $from})
            MATCH (b: ArmStatus {name: $to})
            CALL apoc.algo.dijkstra(a, b, 'ACHIEVABLE', 'para[$lenId]')
            YIELD path, weight
            RETURN path
            ORDER BY weight ASC LIMIT 1""")

    Flux<PathValue> shortestPath(@Param("from") String from, @Param("to") String to, @Param("lenId") Integer lenId);
}
