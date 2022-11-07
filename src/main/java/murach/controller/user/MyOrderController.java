package murach.controller.user;

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

import murach.model.OrderDetailModel;
import murach.model.OrdersModel;
import murach.model.UserModel;
import murach.service.ICategoryService;
import murach.service.INotificationService;
import murach.service.IOrderDetailService;
import murach.service.IOrdersService;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/my-order"})
public class MyOrderController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IOrdersService ordersService;
	
	@Inject
	private IOrderDetailService orderDetailService;
	
	@Inject
	private INotificationService notificationService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		
		List<OrdersModel> orders = new ArrayList<OrdersModel>();
		
		Long userId = ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getId();
		
		if (type != null && type.equals("wait")) {
			orders = ordersService.findWait(userId);
			req.setAttribute("wait", "wait");
		} else if(type != null && type.equals("delivery")) {
			orders = ordersService.findDelivery(userId);
			req.setAttribute("delivery", "delivery");
		} else if(type != null && type.equals("delivered")) {
			orders = ordersService.findDelivered(userId);
			req.setAttribute("delivered", "delivered");
		} else if(type != null && type.equals("cancelled")) {
			orders = ordersService.findCancelled(userId);
			req.setAttribute("cancelled", "cancelled");
		}
		
		
		for (OrdersModel order : orders) {
			
			List<OrderDetailModel> orderDetailModel = orderDetailService.findAllByOrdersId(order.getId());
			
			order.setOrderDetails(orderDetailModel);
			
			
		}
		
		req.setAttribute("category", categoryService.findAll());
		req.setAttribute("orders", orders);
		

		Long id = 0L;
		if((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL") != null) {
			id = ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getId();
		}
		req.setAttribute("notification", notificationService.findAllByUserId(id));
		 
		req.setAttribute("notificationSize", notificationService.getTotalNotification(id));
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/myOrder.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}

}
