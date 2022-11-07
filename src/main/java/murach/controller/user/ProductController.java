package murach.controller.user;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.model.ProductModel;
import murach.model.UserModel;
import murach.service.ICategoryService;
import murach.service.IColorService;
import murach.service.INotificationService;
import murach.service.IProductService;
import murach.service.ISizeService;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/product"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService productService;
	
	@Inject
	private IColorService colorService;
	
	@Inject
	private ISizeService sizeService;
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private INotificationService notificationService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String iid = req.getParameter("id");
		Long id = Long.parseLong(iid);
		
		ProductModel product = productService.findOne(id);
		
		req.setAttribute("product", product);
		req.setAttribute("color", colorService.findAll());
		req.setAttribute("size", sizeService.findAll());
		req.setAttribute("category", categoryService.findAll());
		

		Long userid = 0L;
		if((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL") != null) {
			userid = ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getId();
		}
		req.setAttribute("notification", notificationService.findAllByUserId(userid));
		 
		req.setAttribute("notificationSize", notificationService.getTotalNotification(userid));
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/user/product.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
}
