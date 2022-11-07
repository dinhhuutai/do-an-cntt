package murach.dao.impl;

import java.sql.Timestamp;
import java.util.List;

import murach.dao.IOrdersDAO;
import murach.mapper.OrdersMapper;
import murach.model.OrdersModel;

public class OrdersDAO extends AbstractDAO<OrdersModel> implements IOrdersDAO {

	@Override
	public OrdersModel findOne(Long id) {
		String sql = "select * from orders where id = ?";
		
		List<OrdersModel> orders = query(sql, new OrdersMapper(), id);
		
		return orders.isEmpty() ? null : orders.get(0);
	}

	@Override
	public Long save(OrdersModel ordersModel) {
		StringBuilder sql = new StringBuilder("insert into orders (delivered, ");
		sql.append("userid, address, phone, orderdate, total, status, confirm) ");
		sql.append("values(?, ?, ?, ?, ?, ?, 1, 1)");
		
		return insert(sql.toString(), ordersModel.getDelivered(),
				ordersModel.getUserId() == null ? null : ordersModel.getUserId(), ordersModel.getAddress() == null ? null : ordersModel.getAddress(),
				ordersModel.getPhone() == null ? null : ordersModel.getPhone(), ordersModel.getOrdersDate() == null ? null : ordersModel.getOrdersDate(),
				ordersModel.getTotal() == null ? null : ordersModel.getTotal());
	}

	@Override
	public void update(OrdersModel updateOrders) {
		StringBuilder sql = new StringBuilder("update orders set delivered = ?, deliverydate = ?,");
		sql.append("userid = ?, address = ?, phone = ?, orderdate = ?, total = ? ");
		sql.append("where id = ?");
		
		update(sql.toString(), updateOrders.getDelivered(), updateOrders.getDeliveryDate(), updateOrders.getUserId(),
				updateOrders.getAddress(), updateOrders.getPhone(), 
				updateOrders.getOrdersDate(), updateOrders.getTotal());
		
	}

	@Override
	public void delete(Long id) {
		String sql = "delete from orders where id = ?";
		
		update(sql, id);
	}

	@Override
	public List<OrdersModel> findWait(Long id) {
		
		String sql = "select * from orders where status = 1 and confirm = 1 and userid = ? ORDER BY orderdate desc";
		
		return query(sql, new OrdersMapper(), id);
	}

	@Override
	public List<OrdersModel> findDelivery(Long id) {
		
		String sql = "select * from orders where status = 1 and confirm = 0 and delivered = 0 and userid = ? ORDER BY orderdate desc";
		
		return query(sql, new OrdersMapper(), id);
	}

	@Override
	public List<OrdersModel> findDelivered(Long id) {
		
		String sql = "select * from orders where status = 1 and delivered = 1 and userid = ? ORDER BY orderdate desc";
		
		return query(sql, new OrdersMapper(), id);
	}

	@Override
	public List<OrdersModel> findCancelled(Long id) {
		
		String sql = "select * from orders where status = 0 and userid = ? ORDER BY orderdate desc";
		
		return query(sql, new OrdersMapper(), id);
	}

	@Override
	public void updateStatus(Long id) {
		StringBuilder sql = new StringBuilder("update orders set status = 0 ");
		sql.append("where id = ?");
		
		update(sql.toString(), id);
	}

	@Override
	public List<OrdersModel> findAllWait(int index, int itemInPage) {
		
		String sql = "select * from orders where status = 1 and confirm = 1 ORDER BY orderdate desc limit ?, ?";
		
		return query(sql, new OrdersMapper(), index, itemInPage);
	}

	@Override
	public List<OrdersModel> findAllDelivery(int index, int itemInPage) {
		
		String sql = "select * from orders where status = 1 and confirm = 0 and delivered = 0 ORDER BY orderdate desc limit ?, ?";
		
		return query(sql, new OrdersMapper(), index, itemInPage);
	}

	@Override
	public List<OrdersModel> findAllDelivered(int index, int itemInPage) {
		
		String sql = "select * from orders where status = 1 and delivered = 1 ORDER BY orderdate desc limit ?, ?";
		
		return query(sql, new OrdersMapper(), index, itemInPage);
	}

	@Override
	public int getTotalItemWait() {
		String sql = "select count(*) from orders where status = 1 and confirm = 1";
		
		return count(sql);
	}

	@Override
	public int getTotalItemDelivery() {
		String sql = "select count(*) from orders where status = 1 and confirm = 0 and delivered = 0";
		
		return count(sql);
	}

	@Override
	public int getTotalItemDelivered() {
		String sql = "select count(*) from orders where status = 1 and delivered = 1";
		
		return count(sql);
	}

	@Override
	public void updateConfirm(Long id) {
		StringBuilder sql = new StringBuilder("update orders set confirm = 0 ");
		sql.append("where id = ?");
		
		update(sql.toString(), id);
	}

	@Override
	public void updateConfirmAndStatus(Long id) {
		StringBuilder sql = new StringBuilder("update orders set confirm = 0, status = 0 ");
		sql.append("where id = ?");
		
		update(sql.toString(), id);
	}

	@Override
	public void updateDelivered(Long id, Timestamp deliverydate) {
		StringBuilder sql = new StringBuilder("update orders set delivered = 1, deliverydate = ? ");
		sql.append("where id = ?");
		
		
		update(sql.toString(), deliverydate, id);
	}

	@Override
	public Long getTotalPriceInTime(Timestamp tStart, Timestamp tEnd) {
		String sql = "select sum(total) from orders where deliverydate >= ? and deliverydate <= ?";
		
		return sum(sql, tStart, tEnd);
	}
	

}
