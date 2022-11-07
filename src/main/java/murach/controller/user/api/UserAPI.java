package murach.controller.user.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import murach.model.UserModel;
import murach.service.IUserService;
import murach.utils.HttpUtil;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = { "/api-user" })
public class UserAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IUserService userService;
	

	// cap nhat

	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		req.setCharacterEncoding("UTF-8");
		resp.setContentType("application/json");

		// mapping dữ liệu vào model
		UserModel updateUser = HttpUtil.of(req.getReader()).toModel(UserModel.class);

		updateUser.setModifiedBy(((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());

		req.getSession().setAttribute("userModel", updateUser);

		updateUser = userService.update(updateUser);

		SessionUtil.getInstance().removeValue(req, "USERMODEL");
		SessionUtil.getInstance().putValue(req, "USERMODEL", updateUser);

		// Trả về client (json)
		mapper.writeValue(resp.getOutputStream(), updateUser);

	}

}
