package murach.dao;

import java.util.List;

import murach.model.OrderDetailModel;

public interface IOrderDetailDAO extends GenericDAO<OrderDetailModel> {

	OrderDetailModel findOne(Long id);
	
	Long save(OrderDetailModel orderDetailModel);
	
	void update(OrderDetailModel updateOrderDetail);
	
	void delete(Long id);
	
	List<OrderDetailModel> findAllByOrdersId(Long id);
}
