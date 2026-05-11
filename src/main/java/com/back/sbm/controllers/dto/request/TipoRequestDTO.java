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
public class TipoRequestDTO {

    @NotNull(message = "El ID de la categoría es obligatorio")
    private Long categoriaId;

    private String nombre;
    private String descripcion;
    private Boolean activo;

}
