package murach.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import murach.dao.INotificationDAO;
import murach.model.NotificationModel;
import murach.model.OrdersModel;
import murach.service.INotificationService;

public class NotificationService implements INotificationService {
	
	@Inject
	private INotificationDAO notificationDao;

	@Override
	public NotificationModel save(NotificationModel notificationModel) {
		
		notificationModel.setCreatedDate(new Timestamp(System.currentTimeMillis()));
		notificationModel.setStatus(1);

		Long notificationId = notificationDao.save(notificationModel);
		
		return notificationDao.findOne(notificationId);
	}

	@Override
	public NotificationModel update(Long id) {
		notificationDao.update(id);

		return notificationDao.findOne(id);
	}

	@Override
	public List<NotificationModel> findAllByUserId(Long id) {
		return notificationDao.findAllByUserId(id);
	}

	@Override
	public int getTotalNotification(Long id) {
		return notificationDao.getTotalNotification(id);
	}

	@Override
	public NotificationModel findOne(Long id) {
		NotificationModel notificationModel = notificationDao.findOne(id);
		
		return notificationModel;
	}

}
