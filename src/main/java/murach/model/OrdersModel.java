package murach.model;

import java.sql.Timestamp;
import java.util.List;

public class OrdersModel extends AbstractModel<OrdersModel> {

	private Timestamp ordersDate;
	private int status;
	private int delivered;
	private Timestamp deliveryDate;
	private Long userId;
	private Long discount;
	private String address;
	private Long phone;
	private Long total;
	private int confirm;
	private List<OrderDetailModel> orderDetails;
	
	
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Timestamp getOrdersDate() {
		return ordersDate;
	}
	public void setOrdersDate(Timestamp ordersDate) {
		this.ordersDate = ordersDate;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getDelivered() {
		return delivered;
	}
	public void setDelivered(int delivered) {
		this.delivered = delivered;
	}
	public Timestamp getDeliveryDate() {
		return deliveryDate;
	}
	public void setDeliveryDate(Timestamp deliveryDate) {
		this.deliveryDate = deliveryDate;
	}
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public Long getDiscount() {
		return discount;
	}
	public void setDiscount(Long discount) {
		this.discount = discount;
	}
	public Long getTotal() {
		return total;
	}
	public void setTotal(Long total) {
		this.total = total;
	}
	public int getConfirm() {
		return confirm;
	}
	public void setConfirm(int confirm) {
		this.confirm = confirm;
	}
	public List<OrderDetailModel> getOrderDetails() {
		return orderDetails;
	}
	public void setOrderDetails(List<OrderDetailModel> orderDetails) {
		this.orderDetails = orderDetails;
	}
}
