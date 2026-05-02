package com.back.sbm.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

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
    
    @NotNull
    @Column(nullable = false)
    private String estado;

    private Long descuento;
    
    @Column
    private String notas;
}
