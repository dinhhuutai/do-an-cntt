package murach.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import murach.model.ProductModel;
import murach.model.UserModel;
import murach.service.IProductService;
import murach.utils.HttpUtil;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-product"})
public class ProductAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Inject
	private IProductService productService;
	
	// them
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");

			// mapping dữ liệu vào model
			ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);

			productModel.setCreatedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());


			req.getSession().setAttribute("productModel", productModel);
			// lưu vào database
			productModel = productService.save(productModel);

			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), productModel);
		
		}

		// cap nhat

		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");

			// mapping dữ liệu vào model
			ProductModel updateProduct = HttpUtil.of(req.getReader()).toModel(ProductModel.class);

			updateProduct.setModifiedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());

			req.getSession().setAttribute("productModel", updateProduct);
			
			updateProduct = productService.update(updateProduct);

			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), updateProduct);

		}

		// xoa
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			
			ProductModel productModel = HttpUtil.of(req.getReader()).toModel(ProductModel.class);

			productService.delete(productModel.getIds());
			
			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), "{}");

		}
	
}
