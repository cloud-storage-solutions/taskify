package io.taskify.tasksmanager.repositories;

import io.taskify.tasksmanager.domain.Task;
import io.taskify.tasksmanager.domain.User;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Set;

import static java.util.Collections.unmodifiableList;
import static java.util.Collections.unmodifiableSet;
import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

public class TasksRepositoryImpl implements ManagedTasksRepository {
	@Autowired
	private TasksRepository tasksRepository;

	@Override
	public List<Task> findAllUnfinishedTasks() {
		return unmodifiableList(tasksRepository.findAll().stream().filter(task -> task.isCompleted() == false)
				.collect(toList()));
	}

	@Override
	public Set<User> findAllUsersWithUnfinishedTasks() {
		return unmodifiableSet(findAllUnfinishedTasks().stream().map(Task::getAssignedUser).collect(toSet()));
	}

	@Override
	public Set<Task> findAllUnfinishedTasksPerUser(final User user) {
		return unmodifiableSet(findAllUnfinishedTasks().stream()
				.filter(task -> task.getAssignedUser().equals(user))
				.collect(toSet()));
	}
}
