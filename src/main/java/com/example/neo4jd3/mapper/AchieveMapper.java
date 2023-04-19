package com.example.neo4jd3.mapper;

import com.example.neo4jd3.model.AchievableRelationship;
import com.example.neo4jd3.payload.response.AchievableResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AchieveMapper {
    public AchievableResponse toAchievableResponse(AchievableRelationship achievableRelationship) {
        AchievableResponse achievableResponse = new AchievableResponse();

        achievableResponse.setId(achievableRelationship.getId());
        achievableResponse.setFrom(achievableRelationship.getFrom());
        achievableResponse.setTo(achievableRelationship.getTo());
//        achievableResponse.setLength(achievableRelationship.getLength());
        achievableResponse.setPlanningMethod(achievableRelationship.getPlanningMethod());
        achievableResponse.setParameter(achievableRelationship.getParameter());

        return achievableResponse;
    }

    public List<AchievableResponse> toAchievableResponseList(final List<AchievableRelationship> achievableRelationshipList) {
        if (achievableRelationshipList != null) {
            return achievableRelationshipList.stream().map(this::toAchievableResponse).collect(Collectors.toList());
        }

        return null;
    }
}
