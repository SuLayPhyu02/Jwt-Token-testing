package com.nexcode.mm.taskmanager_jpa_jwt3.mapper;

import java.util.List;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.TaskDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Task;

public interface TaskMapper {
	TaskDto toDto(Task task);
	List<TaskDto>toDtoList(List<Task>tasks);
}
