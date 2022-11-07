package murach.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import murach.model.AboutModel;
import murach.model.SlideModel;
import murach.model.UserModel;
import murach.service.IAboutService;
import murach.utils.HttpUtil;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-about"})
public class AboutAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private IAboutService aboutService;
	
	// them
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");

			// mapping dữ liệu vào model
			AboutModel aboutModel = HttpUtil.of(req.getReader()).toModel(AboutModel.class);

			aboutModel.setCreatedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());


			req.getSession().setAttribute("aboutModel", aboutModel);
			// lưu vào database
			aboutModel = aboutService.save(aboutModel);

			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), aboutModel);
		
		}

		// cap nhat

		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");

			// mapping dữ liệu vào model
			AboutModel updateAbout = HttpUtil.of(req.getReader()).toModel(AboutModel.class);

			updateAbout.setModifiedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());

			req.getSession().setAttribute("aboutModel", updateAbout);
			
			updateAbout = aboutService.update(updateAbout);

			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), updateAbout);

		}

		// xoa
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			
			SlideModel slideModel = HttpUtil.of(req.getReader()).toModel(SlideModel.class);

			aboutService.delete(slideModel.getIds());
			
			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), "{}");

		}
	

}
