package io.taskify.tasksmanager.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import io.taskify.tasksmanager.domain.User;
import io.taskify.tasksmanager.repositories.TasksRepository;

@Controller
public class TasksController {
	@Autowired
	private TasksRepository tasksRepository;

	@GetMapping("/")
	public String displayIndex() {
		return "index";
	}

	@GetMapping("/tasks")
	public String displayTasks(Model model) {
		model.addAttribute("tasks", tasksRepository.findAll());
		return "tasks";
	}

	@GetMapping("/register")
	public String register() {
		return "register";
	}

	@PostMapping(params = "submit")
	public String registerUser(@ModelAttribute User user, BindingResult bindingResult) {
		if (bindingResult.hasErrors()) {
			return "errors";
		}
		// save user;
		return null;
	}
}
