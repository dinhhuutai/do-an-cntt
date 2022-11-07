package murach.dao;


import java.sql.Timestamp;
import java.util.List;

import murach.model.OrdersModel;

public interface IOrdersDAO extends GenericDAO<OrdersModel> {

	OrdersModel findOne(Long id);
	
	Long save(OrdersModel ordersModel);
	
	void update(OrdersModel updateOrders);
	
	void updateStatus(Long id);
	
	void updateConfirm(Long id);

	void updateConfirmAndStatus(Long id);

	void updateDelivered(Long id, Timestamp deliverydate);
	
	void delete(Long id);
	
	List<OrdersModel> findWait(Long id);
	
	List<OrdersModel> findDelivery(Long id);
	
	List<OrdersModel> findDelivered(Long id);
	
	List<OrdersModel> findCancelled(Long id);
	

	List<OrdersModel> findAllWait(int index, int itemInPage);
	int getTotalItemWait();
	
	List<OrdersModel> findAllDelivery(int index, int itemInPage);
	int getTotalItemDelivery();
	
	List<OrdersModel> findAllDelivered(int index, int itemInPage);
	int getTotalItemDelivered();
	
	Long getTotalPriceInTime(Timestamp tStart, Timestamp tEnd);
	
}
