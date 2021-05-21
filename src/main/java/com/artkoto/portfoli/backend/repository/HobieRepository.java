package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.Hobie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HobieRepository extends JpaRepository<Hobie,Long> {
}
