package com.artkoto.portfoli.backend.repository;

import com.artkoto.portfoli.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
