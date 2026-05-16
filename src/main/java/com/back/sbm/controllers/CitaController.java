package com.back.sbm.controllers;

import com.back.sbm.controllers.dto.request.CitaRequestDTO;
import com.back.sbm.controllers.dto.response.CitaResponseDTO;
import com.back.sbm.services.CitaService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("citas")
@RequiredArgsConstructor
public class CitaController {

    private final CitaService citaService;

    @GetMapping
    public ResponseEntity<List<CitaResponseDTO>> findAll() {
        return ResponseEntity.ok(citaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<CitaResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(citaService.findById(id));
    }

    @PostMapping
    public ResponseEntity<CitaResponseDTO> save(@Valid @RequestBody CitaRequestDTO citaRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(citaService.save(citaRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<CitaResponseDTO> updateById(@PathVariable Long id, @Valid @RequestBody CitaRequestDTO citaRequestDTO) {
        return ResponseEntity.ok(citaService.updateById(id, citaRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        citaService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
