package com.example.neo4jd3.pojo;

import org.springframework.data.neo4j.core.schema.RelationshipId;
import org.springframework.data.neo4j.core.schema.RelationshipProperties;
import org.springframework.data.neo4j.core.schema.TargetNode;

import java.util.List;

@RelationshipProperties
public class AchievableRelationship {
    @RelationshipId
    private Long id;

    private final String planningMethod;
    private final List<Double> parameter;

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
}
