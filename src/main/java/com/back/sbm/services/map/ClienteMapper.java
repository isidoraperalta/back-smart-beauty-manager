package com.back.sbm.services.map;

import com.back.sbm.controllers.dto.request.ClienteRequestDTO;
import com.back.sbm.controllers.dto.response.ClienteResponseDTO;
import com.back.sbm.model.entities.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    public ClienteResponseDTO toClienteResponseDTO(ClienteEntity clienteEntity) {
        return ClienteResponseDTO.builder()
                .id(clienteEntity.getId())
                .nombre(clienteEntity.getNombre())
                .email(clienteEntity.getEmail())
                .telefono(clienteEntity.getTelefono())
                .direccion(clienteEntity.getDireccion())
                .fechaNacimiento(clienteEntity.getFechaNacimiento())
                .fechaRegistro(clienteEntity.getFechaRegistro())
                .notas(clienteEntity.getNotas())
                .build();
    }

    public ClienteEntity toClienteEntity(ClienteRequestDTO clienteRequestDTO) {
        return ClienteEntity.builder()
                .nombre(clienteRequestDTO.getNombre())
                .email(clienteRequestDTO.getEmail())
                .telefono(clienteRequestDTO.getTelefono())
                .direccion(clienteRequestDTO.getDireccion())
                .fechaNacimiento(clienteRequestDTO.getFechaNacimiento())
                .notas(clienteRequestDTO.getNotas())
                .build();
    }
}
