package com.back.sbm.controllers;

import com.back.sbm.controllers.dto.request.TipoRequestDTO;
import com.back.sbm.controllers.dto.response.TipoResponseDTO;
import com.back.sbm.services.TipoService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("tipos")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class TipoController {

    private final TipoService tipoService;

    @GetMapping
    public ResponseEntity<List<TipoResponseDTO>> findAll() {
        return ResponseEntity.ok(tipoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TipoResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(tipoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TipoResponseDTO> save(@Valid @RequestBody TipoRequestDTO tipoRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(tipoService.save(tipoRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TipoResponseDTO> updateById(@PathVariable Long id, @Valid @RequestBody TipoRequestDTO tipoRequestDTO) {
        return ResponseEntity.ok(tipoService.updateById(id, tipoRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        tipoService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
