package io.taskify.tasksmanager.controllers.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import io.taskify.tasksmanager.domain.User;
import io.taskify.tasksmanager.repositories.tasks.TasksRepository;
import io.taskify.tasksmanager.repositories.users.UsersRepository;

@Controller
public class TasksController {
	@Autowired
	private TasksRepository tasksRepository;

	@Autowired
	private UsersRepository usersRepository;

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
	public String register(Model model) {
		model.addAttribute("user", new User());
		return "register";
	}

	@PostMapping("/register")
	public ModelAndView registerUser(@ModelAttribute User user) {
		// if (bindingResult.hasErrors()) {
		// return "errors";
		// }

		usersRepository.save(user);
		System.out.println(usersRepository.findAll());
		return new ModelAndView("submit");
	}
}
