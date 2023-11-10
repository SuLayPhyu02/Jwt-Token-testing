package com.nexcode.mm.taskmanager_jpa_jwt3.mapper.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.TaskDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Task;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.TaskMapper;
@Component
public class TaskMapperImpl implements TaskMapper{

	@Override
	public TaskDto toDto(Task task) {
		if(task!=null)
		{
			TaskDto dto=new TaskDto();
			dto.setId(task.getId());
			dto.setTitle(task.getTitle());
			dto.setDescription(task.getDescription());
			return dto;
		}
		return null;
		
	}

	@Override
	public List<TaskDto> toDtoList(List<Task> tasks) {
		if(tasks==null)
		{
			return null;
		}
		List<TaskDto>dtoList=new ArrayList<>();
		for(Task t:tasks)
		{
			TaskDto dto=new TaskDto();
			dto.setId(t.getId());
			dto.setTitle(t.getTitle());
			dto.setDescription(t.getDescription());
			dtoList.add(dto);
		}
		return dtoList;
	}

}
