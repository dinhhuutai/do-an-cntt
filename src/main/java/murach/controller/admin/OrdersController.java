package murach.controller.admin;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.model.NotificationModel;
import murach.model.OrderDetailModel;
import murach.model.OrdersModel;
import murach.service.INotificationService;
import murach.service.IOrderDetailService;
import murach.service.IOrdersService;
import murach.service.IUserService;

@WebServlet(urlPatterns = {"/admin-orders"})
public class OrdersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IOrderDetailService orderDetailService;
	
	@Inject
	private IOrdersService ordersService;
	
	@Inject
	private INotificationService notificationService;
	
	@Inject
	private IUserService userService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		String view = "";

		String indexPgae = req.getParameter("index");
		if(indexPgae == null) {
			indexPgae = "1";
		}
		int index = Integer.parseInt(indexPgae);
		int itemInPage = 10;
		
		int count = 0;
		
		
		List<OrdersModel> orders = new ArrayList<OrdersModel>();
		
		if(type != null && type.equals("wait")) {
			// Lấy số lượng sản phẩn trong database
			count = ordersService.getTotalItemWait();
			
			orders = ordersService.findAllWait(index, itemInPage);
			

			view = "/views/admin/orders/ordersWait.jsp";
		} else if(type != null && type.equals("delivery")) {
			
			// Lấy số lượng sản phẩn trong database
			count = ordersService.getTotalItemDelivery();
			
			orders = ordersService.findAllDelivery(index, itemInPage);
			


			view = "/views/admin/orders/ordersDelivery.jsp";
		} else if(type != null && type.equals("delivered")) {
			
			// Lấy số lượng sản phẩn trong database
			count = ordersService.getTotalItemDelivered();
			
			orders = ordersService.findAllDelivered(index, itemInPage);
			

			view = "/views/admin/orders/ordersDelivered.jsp";
		}
		
		

		// Phân trang
		int endPage = count/itemInPage;
		
		if(count % itemInPage != 0) {
			endPage++;
		}
		
		
		req.setAttribute("endP", endPage);
		req.setAttribute("page", index - 1);
		req.setAttribute("pagecurr", index);
		req.setAttribute("inext", index + 1);
		req.getSession().setAttribute("pagei", index - 1);
		req.getSession().setAttribute("itemInPage", itemInPage);
		
		

		for (OrdersModel order : orders) {
			
			List<OrderDetailModel> orderDetailModel = orderDetailService.findAllByOrdersId(order.getId());
			
			order.setOrderDetails(orderDetailModel);
			
			
		}
		
		
		req.setAttribute("orders", orders);
		
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = Long.parseLong(req.getParameter("id"));
		Long userId = Long.parseLong(req.getParameter("userid"));
		String type = req.getParameter("type");
		String view = "";
		
		if(type != null && type.equals("confirm")) {
			
			ordersService.updateConfirm(id);
			
			// Thong bao cho kh
			NotificationModel notificationModel = new NotificationModel();
			
			notificationModel.setContent("Đơn hàng #" + id + " đã xác nhận thành công.");
			notificationModel.setStatusOrders(1);
			notificationModel.setUserId(userId);
			
			notificationService.save(notificationModel);
			
			
			view = "/admin-orders?type=wait";
		} else if(type != null && type.equals("cancel")) {

			ordersService.updateConfirmAndStatus(id);
			
			// Thong bao cho kh
			NotificationModel notificationModel = new NotificationModel();
			
			notificationModel.setContent("Đơn hàng #" + id + " đã bị hủy.");
			notificationModel.setStatusOrders(0);
			notificationModel.setUserId(userId);
			
			notificationService.save(notificationModel);
			
			
			view = "/admin-orders?type=wait";
		} else if(type != null && type.equals("delivered")) {
			
			ordersService.updateDelivered(id);
			
			// Cập nhật lại tổng đơn hàng và tổng tiền cho user
			Long totalOrders = userService.findOne(userId).getTotalOrders() + 1;
			Long totalPrice = userService.findOne(userId).getTotalPrice() + ordersService.findOne(id).getTotal();
			
			userService.updateTotalOrders(userId, totalOrders);
			userService.updateTotalPrice(userId, totalPrice);
			
			view = "/admin-orders?type=delivery";
		}
		
		

		resp.sendRedirect(req.getContextPath() + view);
		
	}
	
	

}
