package murach.service;

import java.sql.Timestamp;
import java.util.List;

import murach.model.OrdersModel;

public interface IOrdersService {
	

	OrdersModel save(OrdersModel ordersModel);
	
	OrdersModel update(OrdersModel updateOrders);
	
	void delete(Long id);

	OrdersModel updateStatus(Long id);

	OrdersModel updateConfirm(Long id);

	OrdersModel updateConfirmAndStatus(Long id);

	OrdersModel updateDelivered(Long id);

	OrdersModel findOne(Long id);
	

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
