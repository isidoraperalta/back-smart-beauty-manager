package com.back.sbm.model.repositories;

import java.time.LocalDateTime;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.back.sbm.model.entities.CitaEntity;

@Repository
public interface CitaRepository extends JpaRepository<CitaEntity, Long> {

    @Query(value = "SELECT EXISTS(" +
            "SELECT 1 FROM citas c JOIN servicios s ON c.servicio_id = s.id " +
            "WHERE (:excludeId IS NULL OR c.id <> :excludeId) " +
            "AND :nuevaFin > c.fecha_hora " +
            "AND :nuevaInicio < c.fecha_hora + (s.duracion_minutos * INTERVAL '1 minute')" +
            ")",
            nativeQuery = true)
    boolean existsOverlapInBlock(@Param("nuevaInicio") LocalDateTime nuevaInicio, @Param("nuevaFin") LocalDateTime nuevaFin, @Param("excludeId") Long excludeId);
}
