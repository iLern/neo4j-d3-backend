package com.example.neo4jd3.payload.response;

import lombok.*;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class GraphResponse {
    List<ArmStatusResponse> nodes;
    List<AchievableResponse> edges;
}
