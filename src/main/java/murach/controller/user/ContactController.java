package murach.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.model.UserModel;
import murach.service.ICategoryService;
import murach.service.IContactService;
import murach.service.INotificationService;
import murach.utils.SessionUtil;


@WebServlet(urlPatterns = {"/contact"})
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IContactService contactService;
	
	@Inject
	private INotificationService notificationService;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		req.setAttribute("category", categoryService.findAll());
		req.setAttribute("contact", contactService.findOne(1L));
		

		Long id = 0L;
		if((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL") != null) {
			id = ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getId();
		}
		req.setAttribute("notification", notificationService.findAllByUserId(id));
		 
		req.setAttribute("notificationSize", notificationService.getTotalNotification(id));
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/contact.jsp");
		rd.forward(req, resp);
		
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
	}
}
