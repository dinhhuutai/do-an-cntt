package murach.mapper;

import java.sql.ResultSet;

import murach.model.OrderDetailModel;

public class OrderDetailMapper implements RowMapper<OrderDetailModel> {

	@Override
	public OrderDetailModel mapRow(ResultSet resultSet) {
		try {
			OrderDetailModel orderdetail = new OrderDetailModel();
			
			orderdetail.setId(resultSet.getLong("id"));
			orderdetail.setOrdersId(resultSet.getLong("ordersid"));
			orderdetail.setProductId(resultSet.getLong("productid"));
			orderdetail.setProductName(resultSet.getString("productname"));
			orderdetail.setPrice(resultSet.getLong("price"));
			orderdetail.setQuantity(resultSet.getLong("quantity"));
			
			return orderdetail;
			
		} catch (Exception e) {
			return null;
		}
	}

}
