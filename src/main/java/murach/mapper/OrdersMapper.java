package murach.mapper;

import java.sql.ResultSet;

import murach.model.OrdersModel;

public class OrdersMapper implements RowMapper<OrdersModel> {

	@Override
	public OrdersModel mapRow(ResultSet resultSet) {
		try {
			OrdersModel orders = new OrdersModel();
			orders.setId(resultSet.getLong("id"));
			orders.setOrdersDate(resultSet.getTimestamp("orderDate"));
			orders.setStatus(resultSet.getInt("status"));
			orders.setDelivered(resultSet.getInt("delivered"));
			orders.setDeliveryDate(resultSet.getTimestamp("deliverydate"));
			orders.setUserId(resultSet.getLong("userid"));
			orders.setDiscount(resultSet.getLong("discount"));
			orders.setAddress(resultSet.getString("address"));
			orders.setPhone(resultSet.getLong("phone"));
			orders.setTotal(resultSet.getLong("total"));
			orders.setConfirm(resultSet.getInt("confirm"));
			
			
			return orders;
			
		}catch (Exception e) {
			return null;
		}
	}

}
