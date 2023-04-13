package com.example.neo4jd3.pojo;

import lombok.*;
import org.springframework.data.neo4j.core.schema.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@ToString
@Data
@Getter
@Setter
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

    public ArmStatusEntity(String name, List<Double> jointAngle, String position) {
        this.name = name;
        this.jointAngle = jointAngle;
        this.position = position;
    }
}
