package io.taskify.tasksmanager;

import static java.util.Arrays.asList;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import io.taskify.tasksmanager.domain.Task;
import io.taskify.tasksmanager.domain.User;
import io.taskify.tasksmanager.repositories.TasksRepository;

@SpringBootApplication
public class TasksManagerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TasksManagerApplication.class, args);
	}

	@Bean
	CommandLineRunner initializeRepository(final TasksRepository tasksRepository) {
		User user = User.builder().username("nikola").email("nikola.angelov.popov@gmail.com").build();
		Task task1 = Task.builder().name("task-1").description("description1").isCompleted(true)
				.dueTo(LocalDate.of(2011, Month.APRIL, 23)).assignedUser(user).build();
		Task task2 = Task.builder().name("task-2").description("description2").isCompleted(false)
				.dueTo(LocalDate.of(2014, Month.MARCH, 11)).assignedUser(user).build();
		Task task3 = Task.builder().name("task-3").description("description3").isCompleted(true)
				.dueTo(LocalDate.of(2012, Month.AUGUST, 3)).assignedUser(user).build();
		User lubo = User.builder().username("lubo").email("lubokkanev@gmail.com").build();
		Task task4 = Task.builder().name("task-4").description("potki3").isCompleted(false).dueTo(LocalDate.of(2012, Month.AUGUST, 3)).assignedUser(lubo).build();
		Task task5 = Task.builder().name("task-4").description("potki4").isCompleted(false).dueTo(LocalDate.of(2012, Month.AUGUST, 3)).assignedUser(lubo).build();

		List<Task> tasks = asList(task1, task2, task3, task4, task5);
		return args -> {
			tasksRepository.saveAll(tasks);
			/* Consider fixing this issue */
			// user.setAssignedTasks(Arrays.asList(task1, task2, task3));
			// usersRepository.save(user);
			// List<Task> assignedTasks = user.getAssignedTasks();
			tasksRepository.findAll().forEach(System.out::println);
			System.out.println("*******\nUsers with unfinished tasks = "
					+ tasksRepository.findAllUsersWithUnfinishedTasks() + "\n*******");


			System.out.println("********\nLubo's tasks = "
					+ tasksRepository.findAllUnfinishedTasksPerUser(lubo) + "\n************");
		};
	}

}
