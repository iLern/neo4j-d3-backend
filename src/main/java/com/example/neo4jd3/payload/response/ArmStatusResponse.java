package com.example.neo4jd3.payload.response;

import lombok.*;

import java.util.List;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ArmStatusResponse {
    private Long id;
    private String name;
    private List<Double> jointAngle;
    private String position;
}
