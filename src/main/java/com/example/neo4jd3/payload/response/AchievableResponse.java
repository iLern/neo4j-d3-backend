package com.example.neo4jd3.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievableResponse {

    private UUID id;
    private String from;
    private String destination;

    private Double length;
}
