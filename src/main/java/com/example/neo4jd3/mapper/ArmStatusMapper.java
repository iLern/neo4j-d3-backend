package com.example.neo4jd3.mapper;

import com.example.neo4jd3.payload.response.ArmStatusResponse;
import com.example.neo4jd3.pojo.ArmStatusEntity;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ArmStatusMapper {
    public ArmStatusResponse mapToArmStatusResponse(ArmStatusEntity armStatusEntity) {
        ArmStatusResponse armStatusResponse = new ArmStatusResponse();

        armStatusResponse.setId(armStatusEntity.getId());
        armStatusResponse.setName(armStatusEntity.getName());

        return armStatusResponse;
    }

    public List<ArmStatusResponse> maptoArmStatusResponseList(final List<ArmStatusEntity> armStatusEntityList) {
        return armStatusEntityList != null ? armStatusEntityList
                        .stream()
                        .map(this::mapToArmStatusResponse)
                        .collect(Collectors.toList())
                : null;

    }
}
