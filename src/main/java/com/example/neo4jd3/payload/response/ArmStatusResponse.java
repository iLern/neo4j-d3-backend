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
}
