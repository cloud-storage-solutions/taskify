package io.taskify.tasksmanager.controllers.mvc;

import javax.validation.Valid;

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

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/register")
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult bindingResult, Model model) {
		if (bindingResult.hasErrors()) {
			model.addAttribute("errors", bindingResult.getAllErrors());
			return "error";
		}
		// TODO extend to save user in DB
		return null;

	}
}
