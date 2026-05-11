package com.back.sbm.controllers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class TipoResponseDTO {
    private Long id;
    private CategoriaResponseDTO categoria;
    private String nombre;
    private String descripcion;
    private Boolean activo;
}
