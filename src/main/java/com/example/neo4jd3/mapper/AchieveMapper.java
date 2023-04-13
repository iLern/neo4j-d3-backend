package com.example.neo4jd3.mapper;

import com.example.neo4jd3.payload.response.AchievableResponse;
import com.example.neo4jd3.pojo.AchievableRelationship;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AchieveMapper {
    public AchievableResponse mapToAchievableResponse(AchievableRelationship AchievableRelationship) {
        AchievableResponse achievableResponse = new AchievableResponse();

        achievableResponse.setFrom(AchievableRelationship.getFrom());
        achievableResponse.setDestination(AchievableRelationship.getTo());
        achievableResponse.setLength(AchievableRelationship.getLength());

        return achievableResponse;
    }

    public List<AchievableResponse> maptoAchievableResponseList(final List<AchievableRelationship> achievableRelationshipList) {
        return achievableRelationshipList != null ? achievableRelationshipList
                        .stream()
                        .map(this::mapToAchievableResponse)
                        .collect(Collectors.toList())
                : null;

    }
}
