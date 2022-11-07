package murach.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.service.IProductService;
import murach.service.IUserService;

@WebServlet(urlPatterns = {"/admin-top10"})
public class Top10Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService productService;
	
	@Inject
	private IUserService userService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		String views = "";
		
		if(type != null && type.equals("price")) {
			
			
			req.setAttribute("top10", userService.findTop10CustomerPrice());
			
			views = "/views/admin/top10/customer.jsp";
			
		} else if(type != null && type.equals("orders")) {
			

			req.setAttribute("top10", userService.findTop10CustomerOrders());

			views = "/views/admin/top10/customer.jsp";
		} else if(type != null && type.equals("product")) {
			

			req.setAttribute("top10", productService.findTop10ProductPopularity());

			views = "/views/admin/top10/product.jsp";
		}
		
		

		RequestDispatcher rd = req.getRequestDispatcher(views);
		rd.forward(req, resp);
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
