package com.nexcode.mm.taskmanager_jpa_jwt3.service;

import java.util.List;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.TaskDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Task;

public interface TaskService {
	TaskDto addTask(String title,String description);
	TaskDto updateTask(Long id,Task task);
	List<TaskDto> getAllTask();
	TaskDto getTaskById(Long id);
	TaskDto deleteById(Long id);
}
