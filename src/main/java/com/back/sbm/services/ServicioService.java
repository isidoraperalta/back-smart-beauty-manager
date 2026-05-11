package com.back.sbm.services;

import com.back.sbm.controllers.dto.request.ServicioRequestDTO;
import com.back.sbm.controllers.dto.response.ServicioResponseDTO;
import com.back.sbm.model.entities.AccionEntity;
import com.back.sbm.model.entities.ServicioEntity;
import com.back.sbm.model.entities.TipoEntity;
import com.back.sbm.model.repositories.AccionRepository;
import com.back.sbm.model.repositories.ServicioRepository;
import com.back.sbm.model.repositories.TipoRepository;
import com.back.sbm.services.map.ServicioMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class ServicioService {

    private final ServicioRepository servicioRepository;
    private final TipoRepository tipoRepository;
    private final AccionRepository accionRepository;
    private final ServicioMapper servicioMapper;

    public List<ServicioResponseDTO> findAll() {
        return servicioRepository.findAll().stream().map(servicioMapper::toServicioResponseDTO).toList();
    }

    public ServicioResponseDTO findById(Long id) {
        return servicioRepository.findById(id).map(servicioMapper::toServicioResponseDTO).orElseThrow(() -> new NoSuchElementException("Servicio no encontrado: " + id));
    }

    public ServicioResponseDTO save(ServicioRequestDTO servicioRequestDTO) {
        TipoEntity tipo = getTipoOrThrow(servicioRequestDTO.getTipoId());
        AccionEntity accion = getAccionOrThrow(servicioRequestDTO.getAccionId());
        ServicioEntity servicioEntity = servicioMapper.toServicioEntity(servicioRequestDTO, tipo, accion);
        return servicioMapper.toServicioResponseDTO(servicioRepository.save(servicioEntity));
    }

    public ServicioResponseDTO updateById(Long id, ServicioRequestDTO servicioRequestDTO) {
        findById(id);
        TipoEntity tipo = getTipoOrThrow(servicioRequestDTO.getTipoId());
        AccionEntity accion = getAccionOrThrow(servicioRequestDTO.getAccionId());
        ServicioEntity servicioEntity = servicioMapper.toServicioEntity(servicioRequestDTO, tipo, accion);
        servicioEntity.setId(id);
        return servicioMapper.toServicioResponseDTO(servicioRepository.save(servicioEntity));
    }

    public void deleteById(Long id) {
        findById(id);
        servicioRepository.deleteById(id);
    }

    private TipoEntity getTipoOrThrow(Long tipoId) {
        return tipoRepository.findById(tipoId).orElseThrow(() -> new NoSuchElementException("Tipo no encontrado: " + tipoId));
    }

    private AccionEntity getAccionOrThrow(Long accionId) {
        return accionRepository.findById(accionId).orElseThrow(() -> new NoSuchElementException("Acción no encontrada: " + accionId));
    }

}

