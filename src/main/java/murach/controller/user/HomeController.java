package murach.controller.user;

import java.io.IOException;
import java.util.ResourceBundle;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.model.UserModel;
import murach.service.IBannerService;
import murach.service.ICategoryService;
import murach.service.IColorService;
import murach.service.IContactService;
import murach.service.INotificationService;
import murach.service.IProductService;
import murach.service.ISlideService;
import murach.service.IUserService;
import murach.utils.FormUtil;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/trang-chu", "/home", "/dang-nhap", "/thoat"})
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IUserService userService;
	
	@Inject
	private IProductService productService;
	
	@Inject
	private ISlideService slideService;
	
	@Inject
	private IBannerService bannerService;
	
	@Inject
	private IColorService colorService;
	
	@Inject
	private IContactService contactService;
	
	@Inject
	private INotificationService notificationService;
	
	
	ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String action = req.getParameter("action");
		if(action != null && action.equals("login")) {
			
			String message = req.getParameter("message");
			String alert = req.getParameter("alert");
			
			if(message != null && alert != null) {
				req.setAttribute("message", resourceBundle.getString(message));
				req.setAttribute("alert", alert);
			}
			
			RequestDispatcher rd = req.getRequestDispatcher("/views/login.jsp");
			rd.forward(req, resp);
			
		} else if(action != null && action.equals("logout")) {
			
			SessionUtil.getInstance().removeValue(req, "USERMODEL");
			SessionUtil.getInstance().removeValue(req, "cart");
			SessionUtil.getInstance().removeValue(req, "cartSize");
			SessionUtil.getInstance().removeValue(req, "totalPrice");
			SessionUtil.getInstance().removeValue(req, "notificationModel");
			
			resp.sendRedirect(req.getContextPath() + "/trang-chu");
			
		} else {
			int itemProductNew = 8;
			Long id = 0L;
			if((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL") != null) {
				id = ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getId();
			}
			
			req.setAttribute("product", productService.findProductNew(itemProductNew));
			req.setAttribute("slide", slideService.findAllSlide());
			req.setAttribute("banner2", bannerService.find2Banner());
			req.setAttribute("banner3", bannerService.find3Banner());
			req.setAttribute("category", categoryService.findAll());
			req.setAttribute("color", colorService.findAll());
			req.setAttribute("contact", contactService.findOne(1L));
			

			req.setAttribute("notification", notificationService.findAllByUserId(id));
			 
			req.setAttribute("notificationSize", notificationService.getTotalNotification(id));
			
			
			RequestDispatcher rd = req.getRequestDispatcher("/views/user/home.jsp");
			rd.forward(req, resp);
			
		}
		 
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		 String action = req.getParameter("action");
		 if(action != null && action.equals("login")) {
		 
			 // mapping dữ liệu truyền từ client vs các model 
			 UserModel model = FormUtil.toModel(UserModel.class, req);
		  
		 
			 model = userService.findByUserNameAndPasswordAndStatus(model.getUserName(), model.getPassword(), 1);
		 
			 if(model != null) {
		 
				 SessionUtil.getInstance().putValue(req, "USERMODEL", model);
				 
		 
				 if(model.getRole().getCode().equals("USER")) {
		 
				 resp.sendRedirect(req.getContextPath() + "/trang-chu");
				 
			 } else if(model.getRole().getCode().equals("ADMIN")) {
		 
				 resp.sendRedirect(req.getContextPath() + "/admin-trang-chu");
		 
			 } 
		 } else { 
			 resp.sendRedirect(req.getContextPath() + "/dang-nhap?action=login&message=username_password_invalid&alert=danger"); }
		 
		 }
		 
		
		
	}
}
