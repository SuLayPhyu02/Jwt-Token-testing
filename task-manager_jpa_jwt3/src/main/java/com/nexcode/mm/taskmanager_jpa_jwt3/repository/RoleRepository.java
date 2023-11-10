package com.nexcode.mm.taskmanager_jpa_jwt3.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Role;
@Repository
public interface RoleRepository extends JpaRepository<Role, Long>{
	
	 Optional<Role> findByRoleid(Long roleid);

}
