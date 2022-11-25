package murach.sendMail;

import java.util.List;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import murach.model.OrderDetailModel;




public class SendMail {
	private static Session Generic(final String username, final String password) {
		Properties prop = new Properties();
		
		prop.put("mail.smtp.host", "smtp.gmail.com");
		prop.put("mail.smtp.port", "587");
		prop.put("mail.smtp.auth", "true");
		prop.put("mail.smtp.starttls.enable", "true");
		
		return Session.getInstance(prop, new javax.mail.Authenticator() {
			protected javax.mail.PasswordAuthentication getPasswordAuthentication() {
				return new javax.mail.PasswordAuthentication(username, password);
			}
		});
		
	}
	
	
	public static void OrdersSendMail(String emailTo, String address, Long phone, List<OrderDetailModel> products, Long total) {

		final String username = "20110562@student.hcmute.edu.vn";
		final String password = "Tai31072002@";
		Session session = Generic(username, password);
		
		
		String productContent = "";
		for (OrderDetailModel product : products) {
			productContent += product.getProductName() + " | Gia: " + product.getPrice() + " | So luong: " + product.getQuantity() + "\n";
		}
		
		String content = "Ban vua dat hang thanh cong tu TNStore" + "\n" +
		"Dia chi nhan hang cua ban la: " + address + "\n" +
		"So dien thoai nhan hang: " + phone + "\n" +
		"Don hang cua ban: " + "\n" +
		productContent +
		"Tong tien: " + total + "\n" +
		"Cam on ban da dat hang tai TNStore!" + "\n" +
		"Chu cua hang.\n" + 
		"http://project-cuoi-ki.herokuapp.com/";
		
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(emailTo)
			);

			
			message.setSubject("Dat thanh cong tu TNStore");
			message.setText(content);
			
			Transport.send(message);
			
		} catch (Exception e) {
			
		}
	}
	
	
	public static void CancelSendMail(String emailTo, String address, Long phone, List<OrderDetailModel> products, Long total) {

		final String username = "20110562@student.hcmute.edu.vn";
		final String password = "Tai31072002@";
		Session session = Generic(username, password);
		
		String productContent = "";
		for (OrderDetailModel product : products) {
			productContent += product.getProductName() + " | Gia: " + product.getPrice() + " | So luong: " + product.getQuantity() + "\n";
		}
		
		String content = "Don hang cua ban da bi huy" + "\n" +
		"Dia chi nhan hang cua ban la: " + address + "\n" +
		"So dien thoai nhan hang: " + phone + "\n" +
		"Don hang cua ban: " + "\n" +
		productContent +
		"Tong tien: " + total + "\n" +
		"Cam on ban da dat hang tai TNStore!" + "\n" +
		"Chu cua hang.\n" + 
		"http://project-cuoi-ki.herokuapp.com/";
		
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(emailTo)
			);

			
			message.setSubject("Don hang bi huy");
			message.setText(content);
			
			Transport.send(message);
			
		} catch (Exception e) {
			
		}
	}
	
	
	public static void SuccessSendMail(String emailTo, String address, Long phone, List<OrderDetailModel> products, Long total) {

		final String username = "20110562@student.hcmute.edu.vn";
		final String password = "Tai31072002@";
		Session session = Generic(username, password);
		
		
		String productContent = "";
		for (OrderDetailModel product : products) {
			productContent += product.getProductName() + " | Gia: " + product.getPrice() + " | So luong: " + product.getQuantity() + "\n";
		}
		
		String content = "Don hang dang duoc dong goi va giao den ban" + "\n" +
		"Dia chi nhan hang cua ban la: " + address + "\n" +
		"So dien thoai nhan hang: " + phone + "\n" +
		"Don hang cua ban: " + "\n" +
		productContent +
		"Tong tien: " + total + "\n" +
		"Cam on ban da dat hang tai TNStore!" + "\n" +
		"Chu cua hang.\n" + 
		"http://project-cuoi-ki.herokuapp.com/";
		
		
		try {
			
			Message message = new MimeMessage(session);
			message.setFrom(new InternetAddress(username));
			message.setRecipients(
					Message.RecipientType.TO,
					InternetAddress.parse(emailTo)
			);

			
			message.setSubject("Don hang da duoc xac nhan tu TNStore");
			message.setText(content);
			
			Transport.send(message);
			
		} catch (Exception e) {
			
		}
	}
}
