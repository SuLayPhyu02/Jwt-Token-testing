package com.nexcode.mm.taskmanager_jpa_jwt3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexcode.mm.taskmanager_jpa_jwt3.entities.User;
@Repository
public interface UserRepository extends JpaRepository<User, Long>{
	Optional<User>findByUsername(String username);
}
