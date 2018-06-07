package io.taskify.tasksmanager.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = Task.TASKS_PERSISTENCE_NAME)
@Table(name = Task.TASKS_PERSISTENCE_NAME)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Task {
	static final String TASKS_PERSISTENCE_NAME = "TASKS";

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long taskId;

	@NotBlank
	private String name;

	@NotBlank
	private String description;

	private boolean isCompleted;

	@NotNull
	@JsonFormat(pattern = "dd.MM.yyyy")
	private LocalDate dueTo;

	@OneToOne(cascade = ALL, fetch = EAGER)
	private User assignedUser;
}
