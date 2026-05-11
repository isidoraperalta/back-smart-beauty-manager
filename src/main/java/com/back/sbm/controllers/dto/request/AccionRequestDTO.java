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
public class AccionRequestDTO {

    @NotNull(message = "El nombre de la acción es obligatorio")
    private String nombre;

}
