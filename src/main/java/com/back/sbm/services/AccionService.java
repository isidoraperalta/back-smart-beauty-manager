package com.back.sbm.services;

import com.back.sbm.controllers.dto.request.AccionRequestDTO;
import com.back.sbm.controllers.dto.response.AccionResponseDTO;
import com.back.sbm.model.entities.AccionEntity;
import com.back.sbm.model.repositories.AccionRepository;
import com.back.sbm.services.map.AccionMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class AccionService {

    private final AccionRepository accionRepository;
    private final AccionMapper accionMapper;

    public List<AccionResponseDTO> findAll() {
        return accionRepository.findAll().stream().map(accionMapper::toAccionResponseDTO).toList();
    }

    public AccionResponseDTO findById(Long id) {
        return accionRepository.findById(id).map(accionMapper::toAccionResponseDTO).orElseThrow(() -> new NoSuchElementException("Acción no encontrada: " + id));
    }

    public AccionResponseDTO save(AccionRequestDTO accionRequestDTO) {
        AccionEntity accionEntity = accionMapper.toAccionEntity(accionRequestDTO);
        return accionMapper.toAccionResponseDTO(accionRepository.save(accionEntity));
    }

    public AccionResponseDTO updateById(Long id, AccionRequestDTO accionRequestDTO) {
        findById(id);
        AccionEntity accionEntity = accionMapper.toAccionEntity(accionRequestDTO);
        accionEntity.setId(id);
        return accionMapper.toAccionResponseDTO(accionRepository.save(accionEntity));
    }

    public void deleteById(Long id) {
        findById(id);
        accionRepository.deleteById(id);
    }

}
