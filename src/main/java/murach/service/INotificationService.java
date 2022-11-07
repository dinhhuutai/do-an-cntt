package murach.service;

import java.util.List;

import murach.model.NotificationModel;

public interface INotificationService {

	NotificationModel save(NotificationModel notificationModel);
	
	NotificationModel update(Long id);
	
	List<NotificationModel> findAllByUserId(Long id);
	
	int getTotalNotification(Long id);
	
	NotificationModel findOne(Long id);
}
