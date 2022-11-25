package murach.controller.user.api;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.model.OrderDetailModel;
import murach.model.OrdersModel;
import murach.model.ProductCart;
import murach.model.UserModel;
import murach.sendMail.SendMail;
import murach.service.IOrderDetailService;
import murach.service.IOrdersService;
import murach.service.IProductService;
import murach.service.IUserService;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-orders"})
public class OrdersAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService userService;
	
	@Inject
	private IOrdersService ordersService;
	
	@Inject
	private IOrderDetailService orderDetailService;
	
	@Inject
	private IProductService productService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String type = req.getParameter("type");
		if(type.equals("cancel")) {

			String iid = req.getParameter("id");
			
			Long id = Long.parseLong(iid);
			
			List<OrderDetailModel> orderDetailModels = orderDetailService.findAllByOrdersId(id);
			
			for (OrderDetailModel orderDetailModel : orderDetailModels) {
				
				Long popularity = productService.findOne(orderDetailModel.getId()).getPopularity() - 1;
				
				productService.updatePopularity(orderDetailModel.getId(), popularity);
			}
			
			ordersService.updateStatus(id);
			
			resp.sendRedirect(req.getContextPath() + "/my-order?type=wait");
		} else if(type != null && type.equals("buy")) {

			String address = req.getParameter("shippingInput");
			Long phone = Long.parseLong(req.getParameter("phoneInput"));
			
			List<ProductCart> carts = (List<ProductCart>) SessionUtil.getInstance().getValue(req, "cart");
		
			Timestamp modifieddate = new Timestamp(System.currentTimeMillis());
			String modifiedby = ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName();
			Long id = ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getId();
			
			
			// Cáº­p nháº­t láº¡i address and phone cho user
			userService.updateAddressAndPhone(address, phone, id, modifieddate, modifiedby);
			
			
			OrdersModel ordersModel = new OrdersModel();
			
			ordersModel.setUserId(id);
			ordersModel.setAddress(address);
			ordersModel.setPhone(phone);
			ordersModel.setTotal((Long) SessionUtil.getInstance().getValue(req, "totalPrice"));
			
			// ThÃªm Ä‘Æ¡n hÃ ng
			ordersModel = ordersService.save(ordersModel);
			
			Long ordersid = ordersModel.getId();
			
			
			
			// ThÃªm chi tiáº¿t Ä‘Æ¡n hÃ ng
			for (ProductCart cart : carts) {
				OrderDetailModel orderDetailModel = new OrderDetailModel();
				
				orderDetailModel.setOrdersId(ordersid);
				orderDetailModel.setProductId(cart.getId());
				orderDetailModel.setProductName(cart.getName());
				orderDetailModel.setPrice(cart.getPrice());
				orderDetailModel.setQuantity(cart.getQuantity());
				
				orderDetailService.save(orderDetailModel);
			}
			

			
			// Cáº­p nháº­t láº¡i popularity in product

			for (ProductCart cart : carts) {
				
				Long popularity = productService.findOne(cart.getId()).getPopularity() + 1;
				
				
				productService.updatePopularity(cart.getId(), popularity);
				
			}

			List<OrderDetailModel> products = orderDetailService.findAllByOrdersId(ordersid);
			
			SendMail.OrdersSendMail(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getEmail(), address, phone, products, ordersModel.getTotal());
			
			
			// XÃ³a sáº£n pháº©m trong giá»� hÃ ng khi mua thÃ nh cÃ´ng
			SessionUtil.getInstance().removeValue(req, "cart");
			SessionUtil.getInstance().removeValue(req, "cartSize");
			SessionUtil.getInstance().removeValue(req, "totalPrice");
			
			
			
		}
		
	}
	
	
	/*
	 * @Override protected void doDelete(HttpServletRequest req, HttpServletResponse
	 * resp) throws ServletException, IOException {
	 * 
	 * 
	 * System.out.println("11111111"); String iid = req.getParameter("id");
	 * System.out.println(iid);
	 * 
	 * Long id = Long.parseLong(iid);
	 * 
	 * 
	 * orderDetailService.delete(id);
	 * 
	 * ordersService.delete(id);
	 * 
	 * resp.sendRedirect(req.getContextPath() + "/my-order?type=wait");
	 * 
	 * }
	 */

}
