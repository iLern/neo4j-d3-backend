package com.example.neo4jd3.mapper;

import com.example.neo4jd3.model.AchievableRelationship;
import com.example.neo4jd3.model.ArmStatusEntity;
import com.example.neo4jd3.payload.response.AchievableResponse;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class AchieveMapper {
    public AchievableResponse toAchievableResponse(AchievableRelationship achievableRelationship) {
        AchievableResponse achievableResponse = new AchievableResponse();

        achievableResponse.setId(achievableRelationship.getId());
        achievableResponse.setFrom(achievableRelationship.getFrom());
        achievableResponse.setTo(achievableRelationship.getTo());
        achievableResponse.setLength(achievableRelationship.getLength());
        achievableResponse.setPlanningMethod(achievableRelationship.getPlanningMethod());
        achievableResponse.setParameter(achievableRelationship.getParameter());

        return achievableResponse;
    }

    // 传入一个邻接表，返回一个可达性列表
    public List<AchievableResponse> toAchievableResponseList(final List<ArmStatusEntity> armStatusEntityList) {
        ArmStatusEntity node = armStatusEntityList.get(0);

        for (AchievableRelationship e : node.getAchievableStatus()) {
            AchievableResponse achievableResponse = toAchievableResponse(e);
            System.out.println(achievableResponse);
        }

        return null;
    }
}
