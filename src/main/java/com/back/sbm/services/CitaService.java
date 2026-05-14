package com.back.sbm.services;

import com.back.sbm.controllers.dto.request.CitaRequestDTO;
import com.back.sbm.controllers.dto.response.CitaResponseDTO;
import com.back.sbm.model.entities.CitaEntity;
import com.back.sbm.model.entities.ClienteEntity;
import com.back.sbm.model.entities.ServicioEntity;
import com.back.sbm.model.repositories.CitaRepository;
import com.back.sbm.model.repositories.ClienteRepository;
import com.back.sbm.model.repositories.ServicioRepository;
import com.back.sbm.services.map.CitaMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CitaService {

    private final CitaRepository citaRepository;
    private final ClienteRepository clienteRepository;
    private final ServicioRepository servicioRepository;
    private final CitaMapper citaMapper;

    public List<CitaResponseDTO> findAll() {
        return citaRepository.findAll().stream().map(citaMapper::toCitaResponseDTO).toList();
    }

    public CitaResponseDTO findById(Long id) {
        return citaRepository.findById(id).map(citaMapper::toCitaResponseDTO).orElseThrow(() -> new NoSuchElementException("Cita no encontrada: " + id));
    }

    public CitaResponseDTO save(CitaRequestDTO citaRequestDTO) {
        ClienteEntity cliente = getClienteOrThrow(citaRequestDTO.getClienteId());
        ServicioEntity servicio = getServicioOrThrow(citaRequestDTO.getServicioId());

        LocalDateTime inicio = citaRequestDTO.getFechaHora();
        LocalDateTime fin = inicio.plusMinutes(servicio.getDuracionMinutos());
        if (citaRepository.existsOverlapInBlock(inicio, fin, null)) {
            throw new IllegalArgumentException("Ya existe otra cita en este bloque de horario");
        }

        CitaEntity citaEntity = citaMapper.toCitaEntity(citaRequestDTO, cliente, servicio);
        return citaMapper.toCitaResponseDTO(citaRepository.save(citaEntity));
    }

    public CitaResponseDTO updateById(Long id, CitaRequestDTO citaRequestDTO) {
        findById(id);
        ClienteEntity cliente = getClienteOrThrow(citaRequestDTO.getClienteId());
        ServicioEntity servicio = getServicioOrThrow(citaRequestDTO.getServicioId());

        LocalDateTime inicio = citaRequestDTO.getFechaHora();
        LocalDateTime fin = inicio.plusMinutes(servicio.getDuracionMinutos());
        if (citaRepository.existsOverlapInBlock(inicio, fin, id)) {
            throw new IllegalArgumentException("Ya existe otra cita en este bloque de horario");
        }

        CitaEntity citaEntity = citaMapper.toCitaEntity(citaRequestDTO, cliente, servicio);
        citaEntity.setId(id);
        return citaMapper.toCitaResponseDTO(citaRepository.save(citaEntity));
    }

    public void deleteById(Long id) {
        findById(id);
        citaRepository.deleteById(id);
    }

    private ClienteEntity getClienteOrThrow(Long clienteId) {
        return clienteRepository.findById(clienteId).orElseThrow(() -> new NoSuchElementException("Cliente no encontrado: " + clienteId));
    }

    private ServicioEntity getServicioOrThrow(Long servicioId) {
        return servicioRepository.findById(servicioId).orElseThrow(() -> new NoSuchElementException("Servicio no encontrado: " + servicioId));
    }

}
