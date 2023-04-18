package com.example.neo4jd3.mapper;

import com.example.neo4jd3.model.ArmStatusEntity;
import com.example.neo4jd3.payload.response.ArmStatusResponse;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArmStatusMapper {
    public ArmStatusResponse toArmStatusResponse(ArmStatusEntity armStatusEntity) {
        ArmStatusResponse armStatusResponse = new ArmStatusResponse();

        armStatusResponse.setId(armStatusEntity.getId());
        armStatusResponse.setName(armStatusEntity.getName());
        armStatusResponse.setJointAngle(armStatusEntity.getJointAngle());
        armStatusResponse.setPosition(armStatusEntity.getPosition());

        return armStatusResponse;
    }

    public List<ArmStatusResponse> toArmStatusResponseList(final List<ArmStatusEntity> armStatusEntityList) {
        return armStatusEntityList != null ? armStatusEntityList
                        .stream()
                        .map(this::toArmStatusResponse)
                        .collect(Collectors.toList())
                : null;

    }
}
