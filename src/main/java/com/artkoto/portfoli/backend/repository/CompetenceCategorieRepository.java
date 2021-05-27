package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.CompetenceCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CompetenceCategorieRepository extends JpaRepository<CompetenceCategorie,String> {
}
