package com.nexcode.mm.taskmanager_jpa_jwt3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Task;
@Repository
public interface TaskRepository extends JpaRepository<Task, Long>{
	@Modifying
    @Query("delete from Task t where t.id = :id")
    Task myDeleteById(Long id);
	
	
}
