package io.taskify.tasksmanager.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.taskify.tasksmanager.domain.Task;
import io.taskify.tasksmanager.repositories.TasksRepository;

@RestController
@RequestMapping("/tasks")
public class TasksController {
	@Autowired
	private TasksRepository tasksRepository;

	@GetMapping
	public List<Task> listAllTasks() {
		return tasksRepository.findAll();
	}
}
