package murach.mapper;

import java.sql.ResultSet;

import murach.model.NotificationModel;

public class NotificationMapper implements RowMapper<NotificationModel> {

	@Override
	public NotificationModel mapRow(ResultSet resultSet) {
		try {
			NotificationModel notification = new NotificationModel();
			
			notification.setId(resultSet.getLong("id"));
			notification.setUserId(resultSet.getLong("userid"));
			notification.setContent(resultSet.getString("content"));
			notification.setStatus(resultSet.getInt("status"));
			notification.setCreatedDate(resultSet.getTimestamp("createddate"));
			notification.setStatusOrders(resultSet.getInt("statusorders"));
			
			return notification;
			
		} catch (Exception e) {
			return null;
		}
	}

}
