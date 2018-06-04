package io.taskify.tasksmanager.repositories;

import static java.util.stream.Collectors.toList;
import static java.util.stream.Collectors.toSet;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.taskify.tasksmanager.domain.Task;
import io.taskify.tasksmanager.domain.User;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long> {
	default Set<User> findAllUsersWithUnfinishedTasks() {
		final List<Task> unfinishedTasks = findAll().stream().filter(task -> task.isCompleted() == false)
				.collect(toList());
		return unfinishedTasks.stream().map(Task::getAssignedUser).collect(toSet());
	}
}
