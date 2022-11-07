package murach.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import murach.model.BannerModel;
import murach.model.UserModel;
import murach.service.IBannerService;
import murach.utils.HttpUtil;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-banner"})
public class BannerAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IBannerService bannerService;
	
	// them
		@Override
		protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");

			// mapping dữ liệu vào model
			BannerModel bannerModel = HttpUtil.of(req.getReader()).toModel(BannerModel.class);

			bannerModel.setCreatedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());


			req.getSession().setAttribute("bannerModel", bannerModel);
			// lưu vào database
			bannerModel = bannerService.save(bannerModel);

			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), bannerModel);
		
		}

		// cap nhat

		@Override
		protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");

			// mapping dữ liệu vào model
			BannerModel updateBanner = HttpUtil.of(req.getReader()).toModel(BannerModel.class);

			updateBanner.setModifiedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());

			req.getSession().setAttribute("bannerModel", updateBanner);
			
			updateBanner = bannerService.update(updateBanner);

			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), updateBanner);

		}

		// xoa
		@Override
		protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
			ObjectMapper mapper = new ObjectMapper();

			req.setCharacterEncoding("UTF-8");
			resp.setContentType("application/json");
			
			BannerModel bannerModel = HttpUtil.of(req.getReader()).toModel(BannerModel.class);

			bannerService.delete(bannerModel.getIds());
			
			// Trả về client (json)
			mapper.writeValue(resp.getOutputStream(), "{}");

		}
		
}
