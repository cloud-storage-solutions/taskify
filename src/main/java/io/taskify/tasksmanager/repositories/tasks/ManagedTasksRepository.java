package io.taskify.tasksmanager.repositories.tasks;

import io.taskify.tasksmanager.domain.Task;
import io.taskify.tasksmanager.domain.User;

import java.util.List;
import java.util.Set;

public interface ManagedTasksRepository {
	List<Task> findAllUnfinishedTasks();
	Set<User> findAllUsersWithUnfinishedTasks();
	Set<Task> findAllUnfinishedTasksPerUser(final User user);
}
