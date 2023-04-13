package com.example.neo4jd3.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ArmStatusResponse {

    private UUID id;
    private String name;
    private List<AchievableResponse> achievable;

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<AchievableResponse> getAchievable() {
        return achievable;
    }

    public void setAchievable(List<AchievableResponse> achievable) {
        this.achievable = achievable;
    }
}
