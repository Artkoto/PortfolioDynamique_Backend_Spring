package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.Projet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjetRepository extends JpaRepository<Projet,Long> {

}
