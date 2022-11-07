package murach.controller.user;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import murach.model.ProductCart;
import murach.model.ProductModel;
import murach.service.IProductService;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/cart"})
public class CartController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IProductService productService;
	


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String type = req.getParameter("type");
		Long id = Long.parseLong(req.getParameter("id"));
		
		ProductModel product = productService.findOne(id);
		
		ProductCart productCart = null;
		List<ProductCart> carts = (List<ProductCart>) SessionUtil.getInstance().getValue(req, "cart");
		
		
		Long totalPrice = 0L;
		
		if(type != null && type.equals("add")) {
			
			Long quantity = Long.parseLong(req.getParameter("quantity"));
			
			
			if(carts == null) {
				carts = new ArrayList<ProductCart>();
				
				
				productCart = new ProductCart(id, product.getName(), product.getImage(), product.getPrice(), quantity);
				carts.add(productCart);
				
			} else {
				
				boolean isHasProductInCart = false;
				for (ProductCart cart : carts) {
					if(cart.getId() == id) {
						productCart = cart;
						isHasProductInCart = true;
						break;
					}
				}
				
				if(isHasProductInCart) {
					for(int i = 0; i < quantity; i++) {
						productCart.incrementQuantity();
					}
				} else {
					productCart = new ProductCart(id, product.getName(), product.getImage(), product.getPrice(), quantity);
					carts.add(productCart);
				}
			}
			
		} else if(type != null && type.equals("delete")) {

			Long popularity = productService.findOne(id).getPopularity() - 1;
			
			productService.updatePopularity(id, popularity);
			
			for (ProductCart cart : carts) {
				if(cart.getId() == id) {
					carts.remove(cart);
					break;
				}
			}
			
		}
		

		for (ProductCart cart : carts) {
			totalPrice += (cart.getPrice()*cart.getQuantity());
		}
		
		
		SessionUtil.getInstance().putValue(req, "cart", carts);
		if(carts.size() == 0) {
			SessionUtil.getInstance().removeValue(req, "cartSize");
		} else {
			SessionUtil.getInstance().putValue(req, "cartSize", carts.size());
		}
		
		SessionUtil.getInstance().putValue(req, "totalPrice", totalPrice);
		
		
		
		if(type != null && type.equals("add")) {
			
			ObjectMapper mapper = new ObjectMapper();
			mapper.writeValue(resp.getOutputStream(), id);
			
			
		} else if(type != null && type.equals("delete")) {
			resp.sendRedirect(req.getContextPath() + "/orders");
			
		}
		
		/* resp.sendRedirect(req.getContextPath() + "/product?id=" + id); */
		
	}
	
}
