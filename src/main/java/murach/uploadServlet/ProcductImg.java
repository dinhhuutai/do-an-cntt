package murach.uploadServlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import murach.model.ProductModel;
import murach.service.ICategoryService;
import murach.service.IColorService;
import murach.service.ISizeService;
import murach.utils.MessageUtil;



@WebServlet(urlPatterns = {"/admin-upload-img-product"})
public class ProcductImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private ICategoryService categoryService;
	
	@Inject
	private IColorService colorService;

	@Inject
	private ISizeService sizeService;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		
		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			ProductModel productModel = new ProductModel();
			productModel = (ProductModel) req.getSession().getAttribute("productModel");
			
			
			for(FileItem item : items) {
				if(item.getSize() > 0 && item.getName() != null) {
					String uploadPath = getServletContext().getRealPath("");
					File file = new File(uploadPath + "/images/" + productModel.getDatetimeimg()+ item.getName());
					item.write(file);
				}
			}
			
			req.setAttribute("categories", categoryService.findAll());
			req.setAttribute("color", colorService.findAll());
			req.setAttribute("size", sizeService.findAll());

			MessageUtil.showMessage(req);

			req.getSession().removeAttribute("productModel");
			

			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/product/edit.jsp");
			rd.forward(req, resp);

			/*
			 * String index1 = req.getParameter("index"); int index =
			 * Integer.parseInt(index1); if(index == 1) {
			 * resp.sendRedirect(req.getContextPath() +
			 * "/admin-product?type=list&index=1&message=update_success"); } else {
			 * RequestDispatcher rd =
			 * req.getRequestDispatcher("/views/admin/product/edit.jsp"); rd.forward(req,
			 * resp); }
			 */
			
			
			
			
		} catch (Exception e) {
			
		}
		
		
	}
	
}




