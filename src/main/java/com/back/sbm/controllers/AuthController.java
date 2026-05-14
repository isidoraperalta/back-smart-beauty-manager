package com.back.sbm.controllers;

import com.back.sbm.controllers.dto.request.LoginRequestDTO;
import com.back.sbm.controllers.dto.response.LoginResponseDTO;
import com.back.sbm.security.JwtUtils;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthenticationManager authManager;
    private final JwtUtils jwtUtils;

    @PostMapping("/login")
    public ResponseEntity<LoginResponseDTO> login(@RequestBody @Valid LoginRequestDTO dto) {
        authManager.authenticate(new UsernamePasswordAuthenticationToken(dto.getUsername(), dto.getPassword()));

        String token = jwtUtils.generarToken(dto.getUsername());
        return ResponseEntity.ok(new LoginResponseDTO(token));
    }
}