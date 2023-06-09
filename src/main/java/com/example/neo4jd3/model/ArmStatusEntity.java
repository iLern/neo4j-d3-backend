package com.example.neo4jd3.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.neo4j.core.schema.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ToString
@Data
@Getter
@Setter
@Node(labels = "ArmStatus")
public class ArmStatusEntity implements Serializable {
    @Id
    @GeneratedValue
    private Long id;

    @Property("name")
    private String name;
    @Property("jointAngle")
    private List<Double> jointAngle;
    @Property("position")
    private String position;

    @Relationship(type = "ACHIEVABLE", direction = Relationship.Direction.OUTGOING)
    private Set<AchievableRelationship> AchievableStatus = new HashSet<>();

    public ArmStatusEntity(String name, List<Double> jointAngle, String position) {
        this.name = name;
        this.jointAngle = jointAngle;
        this.position = position;
    }
}
