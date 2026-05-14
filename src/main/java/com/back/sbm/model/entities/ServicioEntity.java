package com.back.sbm.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "servicios", uniqueConstraints = {
        @UniqueConstraint(name = "uq_servicios_tipo_accion", columnNames = {"tipo_id", "accion_id"})
})
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "tipo_id", nullable = false)
    private TipoEntity tipo;

    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "accion_id", nullable = false)
    private AccionEntity accion;

    @NotNull
    @Column(nullable = false)
    private Long precio;

    @NotNull
    @Column(nullable = false)
    private Integer duracionMinutos;

    private Integer diasParaRetocar;

}
