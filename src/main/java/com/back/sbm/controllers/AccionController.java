package com.back.sbm.controllers;

import com.back.sbm.controllers.dto.request.AccionRequestDTO;
import com.back.sbm.controllers.dto.response.AccionResponseDTO;
import com.back.sbm.services.AccionService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("acciones")
@RequiredArgsConstructor
@CrossOrigin(origins = "*")
public class AccionController {

    private final AccionService accionService;

    @GetMapping
    public ResponseEntity<List<AccionResponseDTO>> findAll() {
        return ResponseEntity.ok(accionService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccionResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(accionService.findById(id));
    }

    @PostMapping
    public ResponseEntity<AccionResponseDTO> save(@Valid @RequestBody AccionRequestDTO accionRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(accionService.save(accionRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<AccionResponseDTO> updateById(@PathVariable Long id, @Valid @RequestBody AccionRequestDTO accionRequestDTO) {
        return ResponseEntity.ok(accionService.updateById(id, accionRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        accionService.deleteById(id);
        return ResponseEntity.noContent().build();
    }

}
