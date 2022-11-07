package murach.controller.load;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import murach.model.ProductModel;
import murach.service.IProductService;

@WebServlet(urlPatterns = {"/search-product"})
public class ProductSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
	

	@Inject
	private IProductService productService;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		resp.setContentType("text/html;charset=UTF-8");
		
		String category = req.getParameter("category");

		String sort = req.getParameter("sort");

		String price = req.getParameter("price");

		String color = req.getParameter("color");
		
		String name = req.getParameter("name");
		
		List<ProductModel> products = productService.getNext20ProductSearch(category, sort, price, color, name);
		
		PrintWriter out = resp.getWriter();
		String html = "";
		String uploadPath = getServletContext().getRealPath("");
		
		
		for(ProductModel product : products) {
			html += "<div class=\"product col-sm-6 col-md-4 col-lg-3 p-b-35 category-" + product.getCategoryId() + "\">\r\n"
					+ "					<!-- Block2 -->\r\n"
					+ "					<div class=\"block2\">\r\n"
					+ "						<div class=\"block2-pic hov-img0\" data-label=\"New\" style=\"min-height: 334px;\"> <!-- label-new -->\r\n"
					+ "							<img style=\"image-rendering: pixelated;\" src=\"/webbandothoitrang/images/" + product.getImage() + "\" alt=\"IMG-PRODUCT\">\r\n"
					+ "\r\n"
					+ "							<a style=\"box-shadow: 1px 1px 1px #333;\" href=\"/webbandothoitrang/product?id=" + product.getId() + "\" class=\"block2-btn flex-c-m stext-103 cl2 size-102 bg0 bor2 hov-btn1 p-lr-15 trans-04 js-show-modal1\">\r\n"
					+ "								Quick View\r\n"
					+ "							</a>\r\n"
					+ "						</div>\r\n"
					+ "\r\n"
					+ "						<div class=\"block2-txt flex-w flex-t p-t-14\">\r\n"
					+ "							<div class=\"block2-txt-child1 flex-col-l \">\r\n"
					+ "								<a href=\"product-detail.html\" class=\"stext-104 cl4 hov-cl1 trans-04 js-name-b2 p-b-6\">\r\n"
					+ "									" + product.getName() + "\r\n"
					+ "								</a>\r\n"
					+ "\r\n"
					+ "								<span class=\"stext-105 cl3\">\r\n"
					+ "									" + product.getPrice() + "\r\n"
					+ "								</span>\r\n"
					+ "							</div>\r\n"
					+ "\r\n"
					+ "							<div class=\"block2-txt-child2 flex-r p-t-3\">\r\n"
					+ "								<a href=\"#\" class=\"btn-addwish-b2 dis-block pos-relative js-addwish-b2\">\r\n"
					+ "									<img class=\"icon-heart1 dis-block trans-04\" src=\"/webbandothoitrang/template/user/images/icons/icon-heart-01.png\" alt=\"ICON\">\r\n"
					+ "									<img class=\"icon-heart2 dis-block trans-04 ab-t-l\" src=\"/webbandothoitrang/template/user/images/icons/icon-heart-02.png\" alt=\"ICON\">\r\n"
					+ "								</a>\r\n"
					+ "							</div>\r\n"
					+ "						</div>\r\n"
					+ "					</div>\r\n"
					+ "				</div>";
		}
		
		/* out.println(html); */
		
		
		ObjectMapper mapper = new ObjectMapper();
		resp.setContentType("application/json");
		mapper.writeValue(resp.getOutputStream(), products);
		
		

	}

}
