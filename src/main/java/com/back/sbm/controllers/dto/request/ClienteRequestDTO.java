package com.back.sbm.controllers.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ClienteRequestDTO {
    @NotNull(message = "El nombre es obligatorio")
    private String nombre;
    
    @NotNull(message = "El email es obligatorio")
    private String email;
    
    @NotNull(message = "El teléfono es obligatorio")
    private String telefono;
    
    private String direccion;
    private String ciudad;
    private String notas;
}
