package com.back.sbm.services.map;

import com.back.sbm.controllers.dto.request.TipoRequestDTO;
import com.back.sbm.controllers.dto.response.TipoResponseDTO;
import com.back.sbm.model.entities.CategoriaEntity;
import com.back.sbm.model.entities.TipoEntity;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TipoMapper {

    private final CategoriaMapper categoriaMapper;

    public TipoEntity toTipoEntity(TipoRequestDTO tipoRequestDTO, CategoriaEntity categoriaEntity) {
        return TipoEntity.builder()
                .categoria(categoriaEntity)
                .nombre(tipoRequestDTO.getNombre())
                .descripcion(tipoRequestDTO.getDescripcion())
                .activo(tipoRequestDTO.getActivo())
                .build();
    }

    public TipoResponseDTO toTipoResponseDTO(TipoEntity tipoEntity) {
        return TipoResponseDTO.builder()
                .id(tipoEntity.getId())
                .categoria(categoriaMapper.toCategoriaResponseDTO(tipoEntity.getCategoria()))
                .nombre(tipoEntity.getNombre())
                .descripcion(tipoEntity.getDescripcion())
                .activo(tipoEntity.getActivo())
                .build();
    }

}
