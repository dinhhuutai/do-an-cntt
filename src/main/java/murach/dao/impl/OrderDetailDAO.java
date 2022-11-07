package murach.dao.impl;

import java.util.List;

import murach.dao.IOrderDetailDAO;
import murach.mapper.OrderDetailMapper;
import murach.model.OrderDetailModel;

public class OrderDetailDAO extends AbstractDAO<OrderDetailModel> implements IOrderDetailDAO {

	@Override
	public OrderDetailModel findOne(Long id) {
		String sql = "select * from orderdetail where id = ?";
		
		List<OrderDetailModel> orderDetail = query(sql, new OrderDetailMapper(), id);
		
		return orderDetail.isEmpty() ? null : orderDetail.get(0);
	}

	@Override
	public Long save(OrderDetailModel orderDetailModel) {
		StringBuilder sql = new StringBuilder("insert into orderdetail (ordersid, productid, ");
		sql.append("productname, price, quantity) ");
		sql.append("values(?, ?, ?, ?, ?)");
		
		return insert(sql.toString(), orderDetailModel.getOrdersId(), orderDetailModel.getProductId() == null ? null : orderDetailModel.getProductId(),
				orderDetailModel.getProductName() == null ? null : orderDetailModel.getProductName(), orderDetailModel.getPrice() == null ? null : orderDetailModel.getPrice(),
				orderDetailModel.getQuantity() == null ? null : orderDetailModel.getQuantity());
	}

	@Override
	public void update(OrderDetailModel updateOrderDetail) {
		StringBuilder sql = new StringBuilder("update orderdetail set ordersid = ?, productid = ?,");
		sql.append("productname = ?, price = ?, quantity = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), updateOrderDetail.getOrdersId(), updateOrderDetail.getProductId(), updateOrderDetail.getProductName(),
				updateOrderDetail.getPrice(), updateOrderDetail.getQuantity());
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from orderdetail where ordersid = ?";
		
		update(sql, id);
	}

	@Override
	public List<OrderDetailModel> findAllByOrdersId(Long id) {

		String sql = "select * from orderdetail where ordersid = ?";
		
		return query(sql, new OrderDetailMapper(), id);
	}

}
