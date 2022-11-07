package murach.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.constant.SystemConstant;
import murach.service.IContactService;
import murach.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-contact"})
public class ContactController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IContactService contactService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Long id = 1L;

		MessageUtil.showMessage(req);

		req.setAttribute(SystemConstant.MODEL, contactService.findOne(id));
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/contact.jsp");
		rd.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
