package com.example.neo4jd3.payload.response;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AchievableResponse {
    private Long id;

    private String from;
    private String to;

    private String planningMethod;
    private List<Double> parameter;
}
