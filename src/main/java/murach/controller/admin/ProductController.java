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
import murach.model.ProductModel;
import murach.service.ICategoryService;
import murach.service.IColorService;
import murach.service.IProductService;
import murach.service.ISizeService;
import murach.utils.FormUtil;
import murach.utils.MessageUtil;


@WebServlet(urlPatterns = {"/admin-product"})
public class ProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Inject
	private IProductService productService;
	
	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IColorService colorService;

	@Inject
	private ISizeService sizeService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductModel model = FormUtil.toModel(ProductModel.class, req);
		
		String view = "";
		
		if (model.getType().equals(SystemConstant.LIST)) {
			
			String indexPgae = req.getParameter("index");
			if(indexPgae == null) {
				indexPgae = "1";
			}
			int index = Integer.parseInt(indexPgae);
			int itemInPage = 10;
			
			// Lấy số lượng sản phẩn trong database
			int count = productService.getTotalItem();
			
			// Phân trang
			int endPage = count/itemInPage;
			if(count % itemInPage != 0) {
				endPage++;
			}
			
			req.setAttribute("product", productService.findAll(index, itemInPage));
			req.setAttribute("endP", endPage);
			req.setAttribute("page", index - 1);
			req.setAttribute("pagecurr", index);
			req.setAttribute("inext", index + 1);
			req.getSession().setAttribute("pagei", index - 1);
			req.getSession().setAttribute("itemInPage", itemInPage);
			
			view = "/views/admin/product/list.jsp";
			
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId() != null) {
				model = productService.findOne(model.getId());
				
			} else {
				
			}
			
			
			req.setAttribute("categories", categoryService.findAll());
			req.setAttribute("color", colorService.findAll());
			req.setAttribute("size", sizeService.findAll());
			
			view = "/views/admin/product/edit.jsp";
			
		}
		
		MessageUtil.showMessage(req);

		req.setAttribute(SystemConstant.MODEL, model);
		
		RequestDispatcher rd = req.getRequestDispatcher(view);
		rd.forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
}
