package com.back.sbm.services;

import com.back.sbm.controllers.dto.request.TipoRequestDTO;
import com.back.sbm.controllers.dto.response.TipoResponseDTO;
import com.back.sbm.model.entities.CategoriaEntity;
import com.back.sbm.model.entities.TipoEntity;
import com.back.sbm.model.repositories.CategoriaRepository;
import com.back.sbm.model.repositories.TipoRepository;
import com.back.sbm.services.map.TipoMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class TipoService {

    private final TipoRepository tipoRepository;
    private final TipoMapper tipoMapper;
    private final CategoriaRepository categoriaRepository;

    public List<TipoResponseDTO> findAll() {
        return tipoRepository.findAll().stream().map(tipoMapper::toTipoResponseDTO).toList();
    }

    public TipoResponseDTO findById(Long id) {
        return tipoRepository.findById(id).map(tipoMapper::toTipoResponseDTO).orElseThrow(() -> new NoSuchElementException("Tipo no encontrado: " + id));
    }

    public TipoResponseDTO save(TipoRequestDTO tipoRequestDTO) {
        CategoriaEntity categoria = getCategoriaOrThrow(tipoRequestDTO.getCategoriaId());
        TipoEntity tipoEntity = tipoMapper.toTipoEntity(tipoRequestDTO, categoria);
        return tipoMapper.toTipoResponseDTO(tipoRepository.save(tipoEntity));
    }

    public TipoResponseDTO updateById(Long id, TipoRequestDTO tipoRequestDTO) {
        findById(id);
        CategoriaEntity categoria = getCategoriaOrThrow(tipoRequestDTO.getCategoriaId());
        TipoEntity tipoEntity = tipoMapper.toTipoEntity(tipoRequestDTO, categoria);
        tipoEntity.setId(id);
        return tipoMapper.toTipoResponseDTO(tipoRepository.save(tipoEntity));
    }

    public void deleteById(Long id) {
        findById(id);
        tipoRepository.deleteById(id);
    }

    private CategoriaEntity getCategoriaOrThrow(Long categoriaId) {
        return categoriaRepository.findById(categoriaId).orElseThrow(() -> new NoSuchElementException("Categoría no encontrada: " + categoriaId));
    }

}

