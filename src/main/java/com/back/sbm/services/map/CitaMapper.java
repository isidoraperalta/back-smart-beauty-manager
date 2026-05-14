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
                .cliente(clienteMapper.toClienteResponseDTO(citaEntity.getCliente()))
                .servicio(servicioMapper.toServicioResponseDTO(citaEntity.getServicio()))
                .fechaHora(citaEntity.getFechaHora())
                .estado(citaEntity.getEstado())
                .lugar(citaEntity.getLugar())
                .descuento(citaEntity.getDescuento())
                .cargoExtra(citaEntity.getCargoExtra())
                .valorTotal(citaEntity.getValorTotal())
                .diasParaRetocar(citaEntity.getDiasParaRetocar())
                .notas(citaEntity.getNotas())
                .build();
    }

    public CitaEntity toCitaEntity(CitaRequestDTO citaRequestDTO, ClienteEntity clienteEntity, ServicioEntity servicioEntity) {
        Integer diasParaRetocar = citaRequestDTO.getDiasParaRetocar() != null
                ? citaRequestDTO.getDiasParaRetocar()
                : servicioEntity.getDiasParaRetocar();
        Long descuento = citaRequestDTO.getDescuento() != null ? citaRequestDTO.getDescuento() : 0;
        Long cargoExtra = citaRequestDTO.getCargoExtra() != null ? citaRequestDTO.getCargoExtra() : 0;
        Long valorTotal = servicioEntity.getPrecio() - descuento + cargoExtra;
        return CitaEntity.builder()
                .cliente(clienteEntity)
                .servicio(servicioEntity)
                .fechaHora(citaRequestDTO.getFechaHora())
                .estado(citaRequestDTO.getEstado())
                .lugar(citaRequestDTO.getLugar())
                .descuento(citaRequestDTO.getDescuento())
                .cargoExtra(citaRequestDTO.getCargoExtra())
                .valorTotal(valorTotal)
                .diasParaRetocar(diasParaRetocar)
                .notas(citaRequestDTO.getNotas())
                .build();
    }

}
