package murach.dao;

import java.util.List;

import murach.model.NotificationModel;

public interface INotificationDAO extends GenericDAO<NotificationModel> {

	Long save(NotificationModel notificationModel);
	
	void update(Long id);
	
	List<NotificationModel> findAllByUserId(Long id);
	
	int getTotalNotification(Long id);
	
	NotificationModel findOne(Long id);

}
