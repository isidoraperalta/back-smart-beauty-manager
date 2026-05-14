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
public class ServicioRequestDTO {

    @NotNull(message = "El ID del tipo es obligatorio")
    private Long tipoId;

    @NotNull(message = "El ID de la acción es obligatorio")
    private Long accionId;

    @NotNull(message = "El precio es obligatorio")
    private Long precio;

    @NotNull(message = "La duración en minutos es obligatoria")
    private Integer duracionMinutos;

    private Integer diasParaRetocar;

}
