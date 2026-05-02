package com.back.sbm.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Entity
@Table(name = "servicios")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ServicioEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(nullable = false)
    private String nombre;
    
    @Column
    private String descripcion;
    
    @NotNull
    @Column(nullable = false)
    private BigDecimal precio;
    
    @NotNull
    @Column(nullable = false)
    private Integer duracionMinutos;
    
    @Column
    private Boolean activo = true;
}
