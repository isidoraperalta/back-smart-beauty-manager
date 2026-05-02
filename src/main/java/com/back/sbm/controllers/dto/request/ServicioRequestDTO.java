package com.back.sbm.controllers.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioRequestDTO {
    @NotNull(message = "El nombre del servicio es obligatorio")
    private String nombre;
    
    private String descripcion;
    
    @NotNull(message = "El precio es obligatorio")
    private BigDecimal precio;
    
    @NotNull(message = "La duración en minutos es obligatoria")
    private Integer duracionMinutos;
    
    private Boolean activo;
}
