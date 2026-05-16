package com.back.sbm.controllers;

import com.back.sbm.controllers.dto.request.ServicioRequestDTO;
import com.back.sbm.controllers.dto.response.ServicioResponseDTO;
import com.back.sbm.services.ServicioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("servicios")
@RequiredArgsConstructor
public class ServicioController {

    private final ServicioService servicioService;

    @GetMapping
    public ResponseEntity<List<ServicioResponseDTO>> findAll() {
        return ResponseEntity.ok(servicioService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ServicioResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(servicioService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ServicioResponseDTO> save(@Valid @RequestBody ServicioRequestDTO servicioRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicioService.save(servicioRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ServicioResponseDTO> updateById(@PathVariable Long id, @Valid @RequestBody ServicioRequestDTO servicioRequestDTO) {
        return ResponseEntity.ok(servicioService.updateById(id, servicioRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        servicioService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
