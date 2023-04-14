package com.example.neo4jd3.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

@Getter
@Setter
@ToString
@Data
@RelationshipProperties
public class AchievableRelationship {
    @Id
    @GeneratedValue
    private Long id;

    @Property("method")
    private final String planningMethod;
    @Property("para")
    private final List<Double> parameter;

    private String from;
    private String to;
    private Double length;

    @TargetNode
//    @Relationship("ACHIEVABLE")
    private ArmStatusEntity armStatusEntity;

    public AchievableRelationship(ArmStatusEntity armStatusEntity, String planningMethod, List<Double> parameter) {
        this.armStatusEntity = armStatusEntity;
        this.planningMethod = planningMethod;
        this.parameter = parameter;
    }
}
