package io.taskify.tasksmanager.repositories;

import io.taskify.tasksmanager.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TasksRepository extends JpaRepository<Task, Long>, ManagedTasksRepository {
}
