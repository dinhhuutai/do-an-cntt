package murach.model;

public class NotificationModel extends AbstractModel<NotificationModel> {
	
	private Long userId;
	private String content;
	private int status;
	private int statusOrders;
	
	
	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getStatusOrders() {
		return statusOrders;
	}
	public void setStatusOrders(int statusOrders) {
		this.statusOrders = statusOrders;
	}
	
}
