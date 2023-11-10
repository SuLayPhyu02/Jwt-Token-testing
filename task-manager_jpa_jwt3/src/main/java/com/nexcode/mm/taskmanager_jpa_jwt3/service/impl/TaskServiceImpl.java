package com.nexcode.mm.taskmanager_jpa_jwt3.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.TaskDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Task;
import com.nexcode.mm.taskmanager_jpa_jwt3.mapper.TaskMapper;
import com.nexcode.mm.taskmanager_jpa_jwt3.repository.TaskRepository;
import com.nexcode.mm.taskmanager_jpa_jwt3.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {

	@Autowired
	private TaskRepository taskRepository;
	@Autowired
	private TaskMapper taskMapper;

	@Override
	public TaskDto addTask(String title,String description) 
	{
		Task task=new Task();
		task.setTitle(title);
		task.setDescription(description);
		Task savedTask=taskRepository.save(task);
		TaskDto taskDto=taskMapper.toDto(savedTask);
		return taskDto;
	}

	@Override
	public TaskDto updateTask(Long id,Task task) {
		
//		Optional <Task>optional=taskRepository.findById(id);
//		Task foundTask=optional.get();
//		foundTask.setTitle(task.getTitle());
//		foundTask.setDescription(task.getDescription());
//		Task updatedTask=taskRepository.save(foundTask);
//		TaskDto taskDto=new TaskDto();
//		taskDto.setId(updatedTask.getId());
//		taskDto.setTitle(updatedTask.getTitle());
//		taskDto.setDescription(updatedTask.getDescription());
//		return taskDto;
		
		Optional <Task>optional=taskRepository.findById(id);
		Task foundTask=optional.get();
		foundTask.setTitle(task.getTitle());
		foundTask.setDescription(task.getDescription());
		Task updatedTask=taskRepository.save(foundTask);
		TaskDto taskDto=taskMapper.toDto(updatedTask);
		return taskDto;
	}

	@Override
	public List<TaskDto> getAllTask() {
		List<Task>tasks=taskRepository.findAll();
		List<TaskDto>TaskDtos=taskMapper.toDtoList(tasks);
		return TaskDtos;
	}

	@Override
	public TaskDto getTaskById(Long id) {
		Optional<Task> task=taskRepository.findById(id);
		Task foundTask=task.get();
		TaskDto taskDto=null;
		if(foundTask!=null)
		{
			taskDto=taskMapper.toDto(foundTask);
			
		}
		return taskDto;
		
	}

	@Override
	public TaskDto deleteById(Long id) {
		Task task=taskRepository.myDeleteById(id);
		TaskDto taskDto=taskMapper.toDto(task);
		return taskDto;
	}


}
