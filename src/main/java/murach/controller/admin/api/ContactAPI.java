package murach.controller.admin.api;

import java.io.IOException;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

import murach.model.ContactModel;
import murach.model.UserModel;
import murach.service.IContactService;
import murach.utils.HttpUtil;
import murach.utils.SessionUtil;

@WebServlet(urlPatterns = {"/api-admin-contact"})
public class ContactAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@Inject
	private IContactService contactService;
	
	// cap nhat

			@Override
			protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
				ObjectMapper mapper = new ObjectMapper();

				req.setCharacterEncoding("UTF-8");
				resp.setContentType("application/json");

				// mapping dữ liệu vào model
				ContactModel updateContact = HttpUtil.of(req.getReader()).toModel(ContactModel.class);

				updateContact.setModifiedBy( ((UserModel) SessionUtil.getInstance().getValue(req, "USERMODEL")).getFullName());

				req.getSession().setAttribute("contactModel", updateContact);
				
				updateContact = contactService.update(updateContact);

				// Trả về client (json)
				mapper.writeValue(resp.getOutputStream(), updateContact);

			}

}
