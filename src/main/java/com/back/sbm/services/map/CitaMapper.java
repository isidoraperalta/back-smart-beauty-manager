package com.back.sbm.services.map;

import com.back.sbm.controllers.dto.request.CitaRequestDTO;
import com.back.sbm.controllers.dto.response.CitaResponseDTO;
import com.back.sbm.model.entities.CitaEntity;
import com.back.sbm.model.entities.ClienteEntity;
import com.back.sbm.model.entities.ServicioEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CitaMapper {

    private final ClienteMapper clienteMapper;
    private final ServicioMapper servicioMapper;

    public CitaResponseDTO toCitaResponseDTO(CitaEntity citaEntity) {
        return CitaResponseDTO.builder()
                .id(citaEntity.getId())
                .nombreCliente(citaEntity.getCliente().getNombre())
                .servicio(servicioMapper.toServicioResponseDTO(citaEntity.getServicio()))
                .fechaHora(citaEntity.getFechaHora())
                .estado(citaEntity.getEstado())
                .descuento(citaEntity.getDescuento())
                .notas(citaEntity.getNotas())
                .build();
    }

    public CitaEntity toCitaEntity(CitaRequestDTO citaRequestDTO, ClienteEntity clienteEntity, ServicioEntity servicioEntity) {
        return CitaEntity.builder()
                .cliente(clienteEntity)
                .servicio(servicioEntity)
                .fechaHora(citaRequestDTO.getFechaHora())
                .estado(citaRequestDTO.getEstado())
                .descuento(citaRequestDTO.getDescuento())
                .notas(citaRequestDTO.getNotas())
                .build();
    }
}
