package io.taskify.tasksmanager.services.notifications;

import static io.taskify.tasksmanager.services.notifications.NotificationConstants.NOTIFICATION_SUBJECT;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import io.taskify.tasksmanager.domain.User;

@Service
public class EmailNotificationService {
	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	// private TasksRepository tasksRepository;

	@Scheduled
	public void sendScheduledEmailNotification() {
		// tasksRepository.findAllUsersWithUnfinishedTasks();
	}

	public void sendNotificationTo(final User user) {
		SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
		simpleMailMessage.setTo(user.getEmail());
		simpleMailMessage.setFrom("rage2play@gmail.com");
		simpleMailMessage.setSubject(NOTIFICATION_SUBJECT);
		simpleMailMessage.setText("demo txt");

		mailSender.send(simpleMailMessage);
	}

}
