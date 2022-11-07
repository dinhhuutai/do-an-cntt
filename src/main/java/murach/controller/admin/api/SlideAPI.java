package murach.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import murach.model.SlideModel;
import murach.model.UserModel;
import murach.service.ISlideService;
import murach.utils.HttpUtil;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = "/api-admin-slide")
public class SlideAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISlideService slideService;
	
	// them
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");

			// mapping dữ liệu vào model
			SlideModel slideModel = HttpUtil.of(req.getReader()).toModel(SlideModel.class);

			slideModel.setCreatedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());


			req.getSession().setAttribute("slideModel", slideModel);
			// lưu vào database
			slideModel = slideService.save(slideModel);

			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), slideModel);
		
		}

		// cap nhat

		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");

			// mapping dữ liệu vào model
			SlideModel updateSlide = HttpUtil.of(req.getReader()).toModel(SlideModel.class);

			updateSlide.setModifiedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());

			req.getSession().setAttribute("slideModel", updateSlide);
			
			updateSlide = slideService.update(updateSlide);

			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), updateSlide);

		}

		// xoa
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			
			SlideModel slideModel = HttpUtil.of(req.getReader()).toModel(SlideModel.class);

			slideService.delete(slideModel.getIds());
			
			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), "{}");

		}

}
