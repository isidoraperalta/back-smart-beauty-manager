package com.back.sbm.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.back.sbm.model.entities.TipoEntity;

@Repository
public interface TipoRepository extends JpaRepository<TipoEntity, Long> {
}
