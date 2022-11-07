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

import murach.model.UserModel;
import murach.utils.MessageUtil;

@WebServlet(urlPatterns = { "/upload-img-user" })
public class UserImg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		DiskFileItemFactory diskFileItemFactory = new DiskFileItemFactory();

		ServletFileUpload servletFileUpload = new ServletFileUpload(diskFileItemFactory);

		try {
			List<FileItem> items = servletFileUpload.parseRequest(req);
			UserModel userModel = new UserModel();
			userModel = (UserModel) req.getSession().getAttribute("userModel");

			for (FileItem item : items) {
				if (item.getSize() > 0 && item.getName() != null) {
					String uploadPath = getServletContext().getRealPath("");
					File file = new File(uploadPath + "/images/" + userModel.getDatetimeimg() + item.getName());

					item.write(file);
				}
			}

			MessageUtil.showMessage(req);

			req.getSession().removeAttribute("userModel");

			RequestDispatcher rd = req.getRequestDispatcher("/views/user/myProfile.jsp");
			rd.forward(req, resp);

			

		} catch (Exception e) {

		}
	}

}
