package com.back.sbm.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.sbm.model.entities.CategoriaEntity;

@Repository
public interface CategoriaRepository extends JpaRepository<CategoriaEntity, Long> {
}
