package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.CompetenceType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceTypeRepository extends JpaRepository<CompetenceType,Long> {
}
