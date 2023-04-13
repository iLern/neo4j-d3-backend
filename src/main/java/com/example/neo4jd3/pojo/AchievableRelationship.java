package com.example.neo4jd3.pojo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@Getter
@Setter
@ToString
@Data
@RelationshipProperties
public class AchievableRelationship {
    @RelationshipId
    private Long id;

    @Property("method")
    private final String planningMethod;
    @Property("para")
    private final List<Double> parameter;

    private String from;

    private String to;

    private Double length;

    @TargetNode
    private ArmStatusEntity armStatusEntity;

    public AchievableRelationship(ArmStatusEntity armStatusEntity, String planningMethod, List<Double> parameter) {
        this.armStatusEntity = armStatusEntity;
        this.planningMethod = planningMethod;
        this.parameter = parameter;
    }
}
