package com.back.sbm.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

import com.back.sbm.enums.EstadoCita;
import com.back.sbm.enums.LugarCita;

@Entity
@Table(name = "citas")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CitaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "cliente_id", nullable = false)
    private ClienteEntity cliente;
    
    @NotNull
    @ManyToOne(optional = false)
    @JoinColumn(name = "servicio_id", nullable = false)
    private ServicioEntity servicio;
    
    @NotNull
    @Column(nullable = false, unique = true)
    private LocalDateTime fechaHora;
    
    @Enumerated(EnumType.STRING)
    private EstadoCita estado;

    @Enumerated(EnumType.STRING)
    private LugarCita lugar;

    private Long descuento;

    private Long cargoExtra;

    private Long valorTotal;

    private Integer diasParaRetocar;
    
    private String notas;

    @PrePersist
    protected void onCreate() {
        if (this.estado == null) {
            this.estado = EstadoCita.AGENDADA;
        }
        if (this.lugar == null) {
            this.lugar = LugarCita.LOCAL;
        }
    }
}
