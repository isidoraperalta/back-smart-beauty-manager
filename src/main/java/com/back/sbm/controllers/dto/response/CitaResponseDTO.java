package com.back.sbm.controllers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaResponseDTO {
    private Long id;
    private ClienteResponseDTO cliente;
    private ServicioResponseDTO servicio;
    private LocalDateTime fechaHora;
    private String estado;
    private Long descuento;
    private String notas;
}
