package io.taskify.tasksmanager.controllers.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.taskify.tasksmanager.domain.Task;
import io.taskify.tasksmanager.repositories.tasks.TasksRepository;

@RestController
@RequestMapping("/rest")
public class TasksRestController {
	@Autowired
	private TasksRepository tasksRepository;

	@GetMapping("/tasks")
	public List<Task> listAllTasks() {
		return tasksRepository.findAll();
	}
}
