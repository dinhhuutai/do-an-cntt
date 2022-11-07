package murach.service.impl;

import java.util.List;

import javax.inject.Inject;

import murach.dao.IOrderDetailDAO;
import murach.model.OrderDetailModel;
import murach.service.IOrderDetailService;

public class OrderDetailService implements IOrderDetailService {
	
	@Inject
	private IOrderDetailDAO orderDetailDao;

	@Override
	public OrderDetailModel save(OrderDetailModel orderDetailModel) {

		Long orderDetailId = orderDetailDao.save(orderDetailModel);
		
		return orderDetailDao.findOne(orderDetailId);
	}

	@Override
	public OrderDetailModel update(OrderDetailModel updateOrderDetail) {
		orderDetailDao.update(updateOrderDetail);

		return orderDetailDao.findOne(updateOrderDetail.getId());
	}

	@Override
	public void delete(Long id) {

		orderDetailDao.delete(id);
	}

	@Override
	public OrderDetailModel findOne(Long id) {
		
		OrderDetailModel orderDetailModel = orderDetailDao.findOne(id);

		return orderDetailModel;
	}

	@Override
	public List<OrderDetailModel> findAllByOrdersId(Long id) {
		return orderDetailDao.findAllByOrdersId(id);
	}

}
