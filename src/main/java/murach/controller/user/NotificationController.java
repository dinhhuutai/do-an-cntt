package murach.controller.user;

import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.model.NotificationModel;
import murach.model.UserModel;
import murach.service.ICategoryService;
import murach.service.INotificationService;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/notification"})
public class NotificationController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private INotificationService notificationService;
	
	@Inject
	private ICategoryService categoryService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		Long id = 0L;
		if((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL") != null) {
			id = ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getId();
		}
		
		List<NotificationModel> notification = (List<NotificationModel>) notificationService.findAllByUserId(id);
		SessionUtil.getInstance().putValue(req, "notificationModel", notification);
		
		
		notificationService.update(id);
		

		req.setAttribute("notification", notificationService.findAllByUserId(id));
		 
		req.setAttribute("notificationSize", notificationService.getTotalNotification(id));
		
		req.setAttribute("category", categoryService.findAll());
		

		RequestDispatcher rd = req.getRequestDispatcher("/views/user/notification.jsp");
		rd.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
