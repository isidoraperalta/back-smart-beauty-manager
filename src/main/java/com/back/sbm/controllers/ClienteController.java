package com.back.sbm.controllers;

import com.back.sbm.controllers.dto.request.ClienteRequestDTO;
import com.back.sbm.controllers.dto.response.ClienteResponseDTO;
import com.back.sbm.services.ClienteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("clientes")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService clienteService;

    @GetMapping
    public ResponseEntity<List<ClienteResponseDTO>> findAll() {
        return ResponseEntity.ok(clienteService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> findById(@PathVariable Long id) {
        return ResponseEntity.ok(clienteService.findById(id));
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> save(@Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        return ResponseEntity.status(HttpStatus.CREATED).body(clienteService.save(clienteRequestDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteResponseDTO> updateById(@PathVariable Long id, @Valid @RequestBody ClienteRequestDTO clienteRequestDTO) {
        return ResponseEntity.ok(clienteService.updateById(id, clienteRequestDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteById(@PathVariable Long id) {
        clienteService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
