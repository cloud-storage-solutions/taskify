package io.taskify.tasksmanager.services.notifications;

import io.taskify.tasksmanager.domain.User;

public interface NotificationSender {
	void sendNotificationTo(final User user);
}
