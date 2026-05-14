package com.back.sbm.controllers.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.back.sbm.enums.EstadoCita;
import com.back.sbm.enums.LugarCita;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaResponseDTO {
    private Long id;
    private ClienteResponseDTO cliente;
    private ServicioResponseDTO servicio;
    private LocalDateTime fechaHora;
    private EstadoCita estado;
    private LugarCita lugar;
    private Long descuento;
    private Long cargoExtra;
    private Long valorTotal;
    private Integer diasParaRetocar;
    private String notas;
}
