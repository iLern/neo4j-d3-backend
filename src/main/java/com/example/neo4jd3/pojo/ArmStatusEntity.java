package com.example.neo4jd3.pojo;

import org.springframework.data.neo4j.core.schema.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Node(labels = "ArmStatus")
public class ArmStatusEntity implements Serializable {
    @Id
    @GeneratedValue
    private UUID id;

    @Property
    private String name;
    @Property
    private List<Double> jointAngle;
    @Property
    private String position;

    @Relationship(type = "ACHIEVABLE", direction = Relationship.Direction.OUTGOING)
    private Set<AchievableRelationship> AchievableStatus = new HashSet<>();

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Double> getJointAngle() {
        return jointAngle;
    }

    public void setJointAngle(List<Double> jointAngle) {
        this.jointAngle = jointAngle;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Set<AchievableRelationship> getAchievableStatus() {
        return AchievableStatus;
    }

    public ArmStatusEntity(String name, List<Double> jointAngle, String position) {
        this.name = name;
        this.jointAngle = jointAngle;
        this.position = position;
    }

    @Override
    public String toString() {
        return "ArmStatus{" +
                "name='" + name + '\'' +
                ", jointAngle=" + jointAngle +
                ", position='" + position + '\'' +
                '}';
    }
}
