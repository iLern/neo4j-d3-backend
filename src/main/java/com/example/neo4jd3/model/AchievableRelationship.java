package com.example.neo4jd3.model;

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
    private String planningMethod;
    @Property("para")
    private List<Double> parameter;

    private String from;
    private String to;
    private Double length;

    private ArmStatusEntity sourceStatus;


    @TargetNode
    private ArmStatusEntity targetStatus;

    public AchievableRelationship(ArmStatusEntity targetStatus, String planningMethod, List<Double> parameter) {
        this.targetStatus = targetStatus;
        this.planningMethod = planningMethod;
        this.parameter = parameter;

        this.to = this.targetStatus.getName();
        //TODO: length is variable when invoking dijkstra algorithm
        this.length = this.parameter.get(0);
    }
}
