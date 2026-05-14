package com.back.sbm.services.map;

import com.back.sbm.controllers.dto.request.ServicioRequestDTO;
import com.back.sbm.controllers.dto.response.ServicioResponseDTO;
import com.back.sbm.model.entities.AccionEntity;
import com.back.sbm.model.entities.ServicioEntity;
import com.back.sbm.model.entities.TipoEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ServicioMapper {

    private final TipoMapper tipoMapper;
    private final AccionMapper accionMapper;

    public ServicioResponseDTO toServicioResponseDTO(ServicioEntity servicioEntity) {
        return ServicioResponseDTO.builder()
                .id(servicioEntity.getId())
                .tipo(tipoMapper.toTipoResponseDTO(servicioEntity.getTipo()))
                .accion(accionMapper.toAccionResponseDTO(servicioEntity.getAccion()))
                .precio(servicioEntity.getPrecio())
                .duracionMinutos(servicioEntity.getDuracionMinutos())
                .diasParaRetocar(servicioEntity.getDiasParaRetocar())
                .build();
    }

    public ServicioEntity toServicioEntity(ServicioRequestDTO servicioRequestDTO, TipoEntity tipoEntity, AccionEntity accionEntity) {
        return ServicioEntity.builder()
                .tipo(tipoEntity)
                .accion(accionEntity)
                .precio(servicioRequestDTO.getPrecio())
                .duracionMinutos(servicioRequestDTO.getDuracionMinutos())
                .diasParaRetocar(servicioRequestDTO.getDiasParaRetocar())
                .build();
    }

}
