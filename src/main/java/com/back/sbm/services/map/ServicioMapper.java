package com.back.sbm.services.map;

import com.back.sbm.controllers.dto.request.ServicioRequestDTO;
import com.back.sbm.controllers.dto.response.ServicioResponseDTO;
import com.back.sbm.model.entities.ServicioEntity;
import org.springframework.stereotype.Component;

@Component
public class ServicioMapper {

    public ServicioResponseDTO toServicioResponseDTO(ServicioEntity servicioEntity) {
        return ServicioResponseDTO.builder()
                .id(servicioEntity.getId())
                .nombre(servicioEntity.getNombre())
                .descripcion(servicioEntity.getDescripcion())
                .precio(servicioEntity.getPrecio())
                .duracionMinutos(servicioEntity.getDuracionMinutos())
                .activo(servicioEntity.getActivo())
                .build();
    }

    public ServicioEntity toServicioEntity(ServicioRequestDTO servicioRequestDTO) {
        return ServicioEntity.builder()
                .nombre(servicioRequestDTO.getNombre())
                .descripcion(servicioRequestDTO.getDescripcion())
                .precio(servicioRequestDTO.getPrecio())
                .duracionMinutos(servicioRequestDTO.getDuracionMinutos())
                .activo(servicioRequestDTO.getActivo())
                .build();
    }
}
