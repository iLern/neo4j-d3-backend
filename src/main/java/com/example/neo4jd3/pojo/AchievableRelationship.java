package com.example.neo4jd3.pojo;

import org.springframework.data.neo4j.core.schema.Property;
import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

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

    public String getPlanningMethod() {
        return planningMethod;
    }

    public List<Double> getParameter() {
        return parameter;
    }

    public ArmStatusEntity getArmStatus() {
        return armStatusEntity;
    }

    public void setArmStatus(ArmStatusEntity armStatusEntity) {
        this.armStatusEntity = armStatusEntity;
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public Double getLength() {
        return length;
    }
}
