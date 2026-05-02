package com.back.sbm.services;

import com.back.sbm.controllers.dto.request.ClienteRequestDTO;
import com.back.sbm.controllers.dto.response.ClienteResponseDTO;
import com.back.sbm.model.entities.ClienteEntity;
import com.back.sbm.model.repositories.ClienteRepository;
import com.back.sbm.services.map.ClienteMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ClienteService {

    private final ClienteRepository clienteRepository;
    private final ClienteMapper clienteMapper;

    public List<ClienteResponseDTO> findAll() {
        return clienteRepository.findAll().stream().map(clienteMapper::toClienteResponseDTO).toList();
    }

    public ClienteResponseDTO findById(Long id) {
        return clienteRepository.findById(id).map(clienteMapper::toClienteResponseDTO).orElseThrow(() -> new NoSuchElementException("Cliente no encontrado: " + id));
    }

    public ClienteResponseDTO save(ClienteRequestDTO clienteRequestDTO) {
        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(clienteRequestDTO);
        return clienteMapper.toClienteResponseDTO(clienteRepository.save(clienteEntity));
    }

    public ClienteResponseDTO updateById(Long id, ClienteRequestDTO clienteRequestDTO) {
        findById(id);
        ClienteEntity clienteEntity = clienteMapper.toClienteEntity(clienteRequestDTO);
        clienteEntity.setId(id);
        return clienteMapper.toClienteResponseDTO(clienteRepository.save(clienteEntity));
    }

    public void deleteById(Long id) {
        findById(id);
        clienteRepository.deleteById(id);
    }
}
