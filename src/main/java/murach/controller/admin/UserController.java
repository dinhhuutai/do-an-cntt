package murach.controller.admin;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.service.IUserService;

@WebServlet(urlPatterns = {"/admin-user"})
public class UserController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService userService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

		String indexPgae = req.getParameter("index");
		if(indexPgae == null) {
			indexPgae = "1";
		}
		int index = Integer.parseInt(indexPgae);
		int itemInPage = 10;
		
		// Lấy số lượng sản phẩn trong database
		int count = userService.getTotalItem();
		
		// Phân trang
		int endPage = count/itemInPage;
		if(count % itemInPage != 0) {
			endPage++;
		}
		
		req.setAttribute("user", userService.findAll(index, itemInPage));
		req.setAttribute("endP", endPage);
		req.setAttribute("page", index - 1);
		req.setAttribute("pagecurr", index);
		req.setAttribute("inext", index + 1);
		req.getSession().setAttribute("pagei", index - 1);
		req.getSession().setAttribute("itemInPage", itemInPage);
		
		
		
		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/user.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
