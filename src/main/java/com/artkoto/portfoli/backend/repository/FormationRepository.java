package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.Formation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FormationRepository extends JpaRepository<Formation, Long> {

}
