package com.back.sbm.services.map;

import com.back.sbm.controllers.dto.request.CategoriaRequestDTO;
import com.back.sbm.controllers.dto.response.CategoriaResponseDTO;
import com.back.sbm.model.entities.CategoriaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoriaMapper {

    public CategoriaEntity toCategoriaEntity(CategoriaRequestDTO categoriaRequestDTO){
        return CategoriaEntity.builder()
                .nombre(categoriaRequestDTO.getNombre())
                .build();
    }

    public CategoriaResponseDTO toCategoriaResponseDTO(CategoriaEntity categoriaEntity){
        return CategoriaResponseDTO.builder()
                .id(categoriaEntity.getId())
                .nombre(categoriaEntity.getNombre())
                .build();
    }

}
