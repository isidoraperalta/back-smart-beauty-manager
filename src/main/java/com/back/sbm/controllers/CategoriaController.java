package com.back.sbm.controllers;

import com.back.sbm.controllers.dto.request.CategoriaRequestDTO;
import com.back.sbm.controllers.dto.response.CategoriaResponseDTO;
import com.back.sbm.services.CategoriaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("categorias")
@RequiredArgsConstructor
public class CategoriaController {

    private final CategoriaService categoriaService;

    @GetMapping
    public ResponseEntity<List<CategoriaResponseDTO>> findAll() {
        return ResponseEntity.ok(categoriaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(categoriaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CategoriaResponseDTO> save(@Valid @RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(categoriaService.save(categoriaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CategoriaResponseDTO> updateById(@PathVariable Long id, @Valid @RequestBody CategoriaRequestDTO categoriaRequestDTO) {
        return ResponseEntity.ok(categoriaService.updateById(id, categoriaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        categoriaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
