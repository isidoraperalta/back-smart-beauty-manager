package com.back.sbm.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "categorias")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CategoriaEntity {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Column(nullable = false)
    private String nombre;
    
}
