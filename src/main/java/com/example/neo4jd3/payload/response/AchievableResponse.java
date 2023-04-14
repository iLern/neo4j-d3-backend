package com.example.neo4jd3.payload.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AchievableResponse {
    private Long id;

    private String from;
    private String to;
    private Double length;

    private String planningMethod;
    private List<Double> parameter;
}
