package com.back.sbm.model.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.sbm.model.entities.CitaEntity;

@Repository
public interface CitaRepository extends JpaRepository<CitaEntity, Long> {
    /**
     * Verifica si existe una cita con la fecha y hora especificada.
     * Utilizado en POST (crear nueva cita).
     */
    boolean existsByFechaHora(LocalDateTime fechaHora);
    
    /**
     * Verifica si existe una cita con la fecha y hora especificada, 
     * excluyendo la cita con el ID especificado.
     * Utilizado en PUT (actualizar cita existente) para permitir cambiar otros campos
     * sin que falle la validación de fecha/hora duplicada.
     */
    boolean existsByFechaHoraAndIdNot(LocalDateTime fechaHora, Long id);
}
