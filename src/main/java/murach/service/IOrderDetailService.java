package murach.service;

import java.util.List;

import murach.model.OrderDetailModel;

public interface IOrderDetailService {

	OrderDetailModel save(OrderDetailModel orderDetailModel);
	
	OrderDetailModel update(OrderDetailModel updateOrderDetail);
	
	void delete(Long id);

	OrderDetailModel findOne(Long id);
	
	List<OrderDetailModel> findAllByOrdersId(Long id);
}
