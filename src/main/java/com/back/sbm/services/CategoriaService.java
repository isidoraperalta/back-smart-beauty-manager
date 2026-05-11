package com.back.sbm.services;

import com.back.sbm.controllers.dto.request.CategoriaRequestDTO;
import com.back.sbm.controllers.dto.response.CategoriaResponseDTO;
import com.back.sbm.model.entities.CategoriaEntity;
import com.back.sbm.model.repositories.CategoriaRepository;
import com.back.sbm.services.map.CategoriaMapper;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;
    private final CategoriaMapper categoriaMapper;

    public List<CategoriaResponseDTO> findAll() {
        return categoriaRepository.findAll().stream().map(categoriaMapper::toCategoriaResponseDTO).toList();
    }

    public CategoriaResponseDTO findById(Long id) {
        return categoriaRepository.findById(id).map(categoriaMapper::toCategoriaResponseDTO).orElseThrow(() -> new NoSuchElementException("Categoría no encontrada: " + id));
    }

    public CategoriaResponseDTO save(CategoriaRequestDTO categoriaRequestDTO) {
        CategoriaEntity categoriaEntity = categoriaMapper.toCategoriaEntity(categoriaRequestDTO);
        return categoriaMapper.toCategoriaResponseDTO(categoriaRepository.save(categoriaEntity));
    }

    public CategoriaResponseDTO updateById(Long id, CategoriaRequestDTO categoriaRequestDTO) {
        findById(id);
        CategoriaEntity categoriaEntity = categoriaMapper.toCategoriaEntity(categoriaRequestDTO);
        categoriaEntity.setId(id);
        
        return categoriaMapper.toCategoriaResponseDTO(categoriaRepository.save(categoriaEntity));
    }

    public void deleteById(Long id) {
        findById(id);
        categoriaRepository.deleteById(id);
    }

}
