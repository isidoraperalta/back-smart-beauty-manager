package com.back.sbm.services.map;

import com.back.sbm.controllers.dto.request.AccionRequestDTO;
import com.back.sbm.controllers.dto.response.AccionResponseDTO;
import com.back.sbm.model.entities.AccionEntity;
import org.springframework.stereotype.Component;

@Component
public class AccionMapper {

    public AccionEntity toAccionEntity(AccionRequestDTO accionRequestDTO) {
        return AccionEntity.builder()
                .nombre(accionRequestDTO.getNombre())
                .build();
    }

    public AccionResponseDTO toAccionResponseDTO(AccionEntity accionEntity) {
        return AccionResponseDTO.builder()
                .id(accionEntity.getId())
                .nombre(accionEntity.getNombre())
                .build();
    }

}
