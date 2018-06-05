package io.taskify.tasksmanager.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import io.taskify.tasksmanager.repositories.TasksRepository;

@Controller
public class TasksController {
	@Autowired
	private TasksRepository tasksRepository;

	@RequestMapping("/")
	public String displayIndex() {
		return "index";
	}

	@RequestMapping("/tasks")
	public String displayTasks(Model model) {
		model.addAttribute("tasks", tasksRepository.findAll());
		return "tasks";
	}
}
