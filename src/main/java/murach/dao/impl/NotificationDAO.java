package murach.dao.impl;

import java.util.List;

import murach.dao.INotificationDAO;
import murach.mapper.NotificationMapper;
import murach.model.NotificationModel;

public class NotificationDAO extends AbstractDAO<NotificationModel> implements INotificationDAO {

	@Override
	public Long save(NotificationModel notificationModel) {
		StringBuilder sql = new StringBuilder("insert into notification (userid, content, ");
		sql.append("status, createddate, statusorders) ");
		sql.append("values(?, ?, ?, ?, ?)");
		
		return insert(sql.toString(), notificationModel.getUserId(), notificationModel.getContent() == null ? null : notificationModel.getContent(),
				notificationModel.getStatus(), notificationModel.getCreatedDate() == null ? null : notificationModel.getCreatedDate(),
				notificationModel.getStatusOrders());
	}

	@Override
	public void update(Long id) {
		StringBuilder sql = new StringBuilder("update notification set status = 0 ");
		sql.append("where userid = ?");
		
		update(sql.toString(), id);
	}

	@Override
	public List<NotificationModel> findAllByUserId(Long id) {

		String sql = "select * from notification where userid = ? and status = 1";
		
		return query(sql, new NotificationMapper(), id);
	}

	@Override
	public int getTotalNotification(Long id) {
		String sql = "select count(*) from notification where userid = ? and status = 1";
		
		return count(sql, id);
	}

	@Override
	public NotificationModel findOne(Long id) {
		String sql = "select * from notification where id = ?";
		
		List<NotificationModel> notification = query(sql, new NotificationMapper(), id);
		
		return notification.isEmpty() ? null : notification.get(0);
	}

}
