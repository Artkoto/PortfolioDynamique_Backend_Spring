package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.Competence;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceRepository extends JpaRepository<Competence,Long> {
}
