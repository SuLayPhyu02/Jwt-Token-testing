package com.nexcode.mm.taskmanager_jpa_jwt3.controller;

import java.security.Principal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nexcode.mm.taskmanager_jpa_jwt3.dto.TaskDto;
import com.nexcode.mm.taskmanager_jpa_jwt3.entities.Task;
import com.nexcode.mm.taskmanager_jpa_jwt3.service.TaskService;

@RestController
@RequestMapping("/api/tasks")
public class TaskController {
	
	
	@Autowired
	private TaskService taskService;
	
	@GetMapping
	public List<TaskDto> getTasks()
	{
		List<TaskDto>taskDtos=taskService.getAllTask();
		return taskDtos;
	}
	
	@GetMapping("/{id}")
	public TaskDto getTask(@PathVariable Long id,Principal curPrincipal)
	{
		System.out.println("current Principlal "+curPrincipal.getName());
		return taskService.getTaskById(id);
	}
	@PostMapping
	public TaskDto addTask(@RequestBody Task task)
	{
		TaskDto addedTask=taskService.addTask(task.getTitle(),task.getDescription());
		return addedTask;
	}
	@PutMapping("/{id}")
	public TaskDto updateTask(@PathVariable Long id,@RequestBody Task task)
	{
		TaskDto updateTask=taskService.updateTask(id,task);
		return updateTask;
	}
	@DeleteMapping("/{id}")
	public TaskDto deleteTask(@PathVariable Long id)
	{
		 TaskDto taskDto=taskService.deleteById(id);
		 return taskDto;
	}
//	@PostMapping
//	public boolean createTask(@RequestBody Task task)
//	{
//		return taskService.createTask(task.getTitle(),task.getDescription());
//	}

}
