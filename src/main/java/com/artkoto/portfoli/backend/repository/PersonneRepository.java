package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.Personne;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonneRepository extends JpaRepository<Personne , Long> {
}
