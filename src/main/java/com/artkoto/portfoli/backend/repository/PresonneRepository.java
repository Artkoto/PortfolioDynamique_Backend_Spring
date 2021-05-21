package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.Personne;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresonneRepository extends CrudRepository<Personne , Long> {
}
