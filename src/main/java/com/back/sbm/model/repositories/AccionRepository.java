package com.back.sbm.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.sbm.model.entities.AccionEntity;

@Repository
public interface AccionRepository extends JpaRepository<AccionEntity, Long> {
}
