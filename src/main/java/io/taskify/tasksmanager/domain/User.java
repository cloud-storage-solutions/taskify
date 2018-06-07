package io.taskify.tasksmanager.domain;

import static javax.persistence.GenerationType.AUTO;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = User.USERS_PERSISTENCE_NAME)
@Table(name = User.USERS_PERSISTENCE_NAME)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class User {
	static final String USERS_PERSISTENCE_NAME = "USERS";

	@Id
	@GeneratedValue(strategy = AUTO)
	private Long userId;

	@NotBlank
	private String username;

	// Minimum eight characters, at least one letter and one number
	// TODO mark as @NotBlank
	@Pattern(regexp = "\"^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,}$\"")
	private String password;

	@Email
	private String email;
}
