package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.ApiUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ApiUserRepository extends JpaRepository<ApiUser,Long> {

    @Query("SELECT t FROM ApiUser t WHERE t.api_key = ?1 ")
    Optional<ApiUser> findByApi_key(String s);
}
