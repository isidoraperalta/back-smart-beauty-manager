package com.back.sbm.controllers.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AccionRequestDTO {

    @NotBlank(message = "El nombre de la acción es obligatorio")
    private String nombre;

}
