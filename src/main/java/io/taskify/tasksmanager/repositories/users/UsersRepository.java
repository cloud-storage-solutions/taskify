package io.taskify.tasksmanager.repositories.users;

import org.springframework.data.jpa.repository.JpaRepository;

import io.taskify.tasksmanager.domain.User;

public interface UsersRepository extends JpaRepository<User, Long> {
}
