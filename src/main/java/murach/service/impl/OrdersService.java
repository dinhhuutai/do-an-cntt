package murach.service.impl;

import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;

import murach.dao.IOrdersDAO;
import murach.model.OrdersModel;
import murach.service.IOrdersService;

public class OrdersService implements IOrdersService {
	
	@Inject
	private IOrdersDAO ordersDao;

	@Override
	public OrdersModel save(OrdersModel ordersModel) {
		
		ordersModel.setOrdersDate(new Timestamp(System.currentTimeMillis()));
		ordersModel.setDelivered(0);

		Long ordersId = ordersDao.save(ordersModel);
		
		return ordersDao.findOne(ordersId);
	}

	@Override
	public OrdersModel update(OrdersModel updateOrders) {

		ordersDao.update(updateOrders);

		return ordersDao.findOne(updateOrders.getId());
	}

	@Override
	public void delete(Long id) {

		ordersDao.delete(id);
	}

	@Override
	public OrdersModel findOne(Long id) {
		OrdersModel ordersModel = ordersDao.findOne(id);
		
		return ordersModel;
	}

	@Override
	public List<OrdersModel> findWait(Long id) {
		return ordersDao.findWait(id);
	}

	@Override
	public List<OrdersModel> findDelivery(Long id) {
		return ordersDao.findDelivery(id);
	}

	@Override
	public List<OrdersModel> findDelivered(Long id) {
		return ordersDao.findDelivered(id);
	}

	@Override
	public List<OrdersModel> findCancelled(Long id) {
		return ordersDao.findCancelled(id);
	}

	@Override
	public OrdersModel updateStatus(Long id) {
		ordersDao.updateStatus(id);

		return ordersDao.findOne(id);
	}

	@Override
	public List<OrdersModel> findAllWait(int index, int itemInPage) {
		index = (index - 1) * itemInPage;
		return ordersDao.findAllWait(index, itemInPage);
	}

	@Override
	public List<OrdersModel> findAllDelivery(int index, int itemInPage) {
		index = (index - 1) * itemInPage;
		return ordersDao.findAllDelivery(index, itemInPage);
	}

	@Override
	public List<OrdersModel> findAllDelivered(int index, int itemInPage) {
		index = (index - 1) * itemInPage;
		return ordersDao.findAllDelivered(index, itemInPage);
	}

	@Override
	public int getTotalItemWait() {
		return ordersDao.getTotalItemWait();
	}

	@Override
	public int getTotalItemDelivery() {
		return ordersDao.getTotalItemDelivery();
	}

	@Override
	public int getTotalItemDelivered() {
		return ordersDao.getTotalItemDelivered();
	}

	@Override
	public OrdersModel updateConfirm(Long id) {
		
		ordersDao.updateConfirm(id);

		return ordersDao.findOne(id);
	}

	@Override
	public OrdersModel updateConfirmAndStatus(Long id) {
		ordersDao.updateConfirmAndStatus(id);

		return ordersDao.findOne(id);
	}

	@Override
	public OrdersModel updateDelivered(Long id) {
		
		Timestamp deliverydate = new Timestamp(System.currentTimeMillis());
		
		ordersDao.updateDelivered(id, deliverydate);

		return ordersDao.findOne(id);
	}

	@Override
	public Long getTotalPriceInTime(Timestamp tStart, Timestamp tEnd) {
		return ordersDao.getTotalPriceInTime(tStart, tEnd);
	}

}
