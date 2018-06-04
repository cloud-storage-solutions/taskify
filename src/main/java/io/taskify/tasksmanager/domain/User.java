package io.taskify.tasksmanager.domain;

import static javax.persistence.CascadeType.ALL;
import static javax.persistence.FetchType.EAGER;
import static javax.persistence.GenerationType.AUTO;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

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

	@Email
	private String email;
}
