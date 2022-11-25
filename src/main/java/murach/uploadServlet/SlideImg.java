package murach.uploadServlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import murach.model.SlideModel;
import murach.utils.MessageUtil;



@WebServlet(urlPatterns = {"/admin-upload-img-slide"})
public class SlideImg extends HttpServlet {
	private static final long serialVersionUID = 1L;


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();
		
		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);
		
		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			SlideModel slideModel = new SlideModel();
			slideModel = (SlideModel) req.getSession().getAttribute("slideModel");
			
			
			for(FileItem item : items) {
				if(item.getSize() > 0 && item.getName() != null) {
					String uploadPath = getServletContext().getRealPath("/images");
					File file = new File(uploadPath + "/" + slideModel.getDatetimeimg() + item.getName());

					item.write(file);
				}
			}


			MessageUtil.showMessage(req);


			req.getSession().removeAttribute("slideModel");
			

			RequestDispatcher rd = req.getRequestDispatcher("/views/admin/slide/edit.jsp");
			rd.forward(req, resp);
			
			/*
			 * String index1 = req.getParameter("index"); int index =
			 * Integer.parseInt(index1); if(index == 1) {
			 * resp.sendRedirect(req.getContextPath() +
			 * "/admin-slide?type=list&index=1&message=update_success"); } else {
			 * RequestDispatcher rd =
			 * req.getRequestDispatcher("/views/admin/slide/edit.jsp"); rd.forward(req,
			 * resp); }
			 */

			
		} catch (Exception e) {
			
		}
		
		
	}
	
}




