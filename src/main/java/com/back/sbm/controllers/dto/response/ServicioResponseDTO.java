package com.back.sbm.controllers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioResponseDTO {
    private Long id;
    private TipoResponseDTO tipo;
    private AccionResponseDTO accion;
    private Long precio;
    private Integer duracionMinutos;
    private Integer diasParaRetocar;
}
