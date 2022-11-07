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
import murach.model.SlideModel;
import murach.service.ISlideService;
import murach.utils.FormUtil;
import murach.utils.MessageUtil;

@WebServlet(urlPatterns = {"/admin-slide"})
public class SlideController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private ISlideService slideService;
	
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		SlideModel model = FormUtil.toModel(SlideModel.class, req);
		
		String view = "";
		
		if (model.getType().equals(SystemConstant.LIST)) {
			
			String indexPgae = req.getParameter("index");
			if(indexPgae == null) {
				indexPgae = "1";
			}
			int index = Integer.parseInt(indexPgae);
			int itemInPage = 10;
			
			// Lấy số lượng sản phẩn trong database
			int count = slideService.getTotalItem();
			
			// Phân trang
			int endPage = count/itemInPage;
			if(count % itemInPage != 0) {
				endPage++;
			}
			
			req.setAttribute("slide", slideService.findAll(index, itemInPage));
			req.setAttribute("endP", endPage);
			req.setAttribute("page", index - 1);
			req.setAttribute("pagecurr", index);
			req.setAttribute("inext", index + 1);
			req.getSession().setAttribute("pagei", index - 1);
			req.getSession().setAttribute("itemInPage", itemInPage);
			
			view = "/views/admin/slide/list.jsp";
			
		} else if (model.getType().equals(SystemConstant.EDIT)) {
			if(model.getId() != null) {
				model = slideService.findOne(model.getId());
				
			} else {
				
			}
			
			view = "/views/admin/slide/edit.jsp";
			
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
