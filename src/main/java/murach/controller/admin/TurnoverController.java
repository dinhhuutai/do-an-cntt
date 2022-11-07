package murach.controller.admin;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.inject.Inject;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import murach.service.IOrdersService;

@WebServlet(urlPatterns = {"/admin-turnover"})
public class TurnoverController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	
	@Inject
	private IOrdersService ordersService;
	
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Timestamp time = new Timestamp(System.currentTimeMillis());
		int day = java.time.LocalDate.now().getDayOfMonth();
		int month = java.time.LocalDate.now().getMonthValue();
		int year = java.time.LocalDate.now().getYear();
		
		String t1StringStart =  "01-" + "01-" + year + " 0:0:0";
		String t1StringEnd =  "31-" + "01-" + year + " 23:59:59";
		
		String t2StringStart =  "01-" + "02-" + year + " 0:0:0";
		String t2StringEnd =  "28-" + "02-" + year + " 23:59:59";
		
		String t3StringStart =  "01-" + "03-" + year + " 0:0:0";
		String t3StringEnd =  "31-" + "03-" + year + " 23:59:59";
	
		String t4StringStart =  "01-" + "04-" + year + " 0:0:0";
		String t4StringEnd =  "30-" + "04-" + year + " 23:59:59";
		
		String t5StringStart =  "01-" + "05-" + year + " 0:0:0";
		String t5StringEnd =  "31-" + "05-" + year + " 23:59:59";
		
		String t6StringStart =  "01-" + "06-" + year + " 0:0:0";
		String t6StringEnd =  "30-" + "01-" + year + " 23:59:59";
		
		String t7StringStart =  "01-" + "07-" + year + " 0:0:0";
		String t7StringEnd =  "31-" + "07-" + year + " 23:59:59";
		
		String t8StringStart =  "01-" + "08-" + year + " 0:0:0";
		String t8StringEnd =  "31-" + "08-" + year + " 23:59:59";
		
		String t9StringStart =  "01-" + "09-" + year + " 0:0:0";
		String t9StringEnd =  "30-" + "09-" + year + " 23:59:59";
		
		String t10StringStart =  "01-" + "10-" + year + " 0:0:0";
		String t10StringEnd =  "31-" + "10-" + year + " 23:59:59";
		
		String t11StringStart =  "01-" + "11-" + year + " 0:0:0";
		String t11StringEnd =  "30-" + "11-" + year + " 23:59:59";
		
		String t12StringStart =  "01-" + "12-" + year + " 0:0:0";
		String t12StringEnd =  "31-" + "12-" + year + " 23:59:59";
		
		String todayStringStart = day + "-" + month + "-" + year + " 0:0:0";
		String todayStringEnd = day + "-" + month + "-" + year + " 23:59:59";
		
		switch (month) {
		case 2:
		case 4:
		case 6:
		case 8:
		case 9:
		case 11:
		case 1:
			if(day == 1) {
				day = 31;
			} else {
				day = day - 1;
			}
			break;
		case 5:
		case 7:
		case 10:
		case 12:
			if(day == 1) {
				day = 30;
			} else {
				day = day - 1;
			}
			break;
		case 3:
			if(day == 1) {
				day = 28;
			} else {
				day = day - 1;
			}
			break;
		default:
			break;
		}
		

		String yesterdayStringStart = day + "-" + month + "-" + year + " 0:0:0";
		String yesterdayStringEnd = day + "-" + month + "-" + year + " 23:59:59";
		
		
		
		Date t1DateStart = null;
		Date t1DateEnd = null;

		Date t2DateStart = null;
		Date t2DateEnd = null;

		Date t3DateStart = null;
		Date t3DateEnd = null;

		Date t4DateStart = null;
		Date t4DateEnd = null;
		
		Date t5DateStart = null;
		Date t5DateEnd = null;

		Date t6DateStart = null;
		Date t6DateEnd = null;

		Date t7DateStart = null;
		Date t7DateEnd = null;

		Date t8DateStart = null;
		Date t8DateEnd = null;

		Date t9DateStart = null;
		Date t9DateEnd = null;

		Date t10DateStart = null;
		Date t10DateEnd = null;

		Date t11DateStart = null;
		Date t11DateEnd = null;

		Date t12DateStart = null;
		Date t12DateEnd = null;
		
		Date todayDateStart = null;
		Date todayDateEnd = null;

		Date yesterdayDateStart = null;
		Date yesterdayDateEnd = null;
		
		try {
			
			t1DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t1StringStart);
			t1DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t1StringEnd);

			t2DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t2StringStart);
			t2DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t2StringEnd);

			t3DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t3StringStart);
			t3DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t3StringEnd);

			t4DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t4StringStart);
			t4DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t4StringEnd);

			t5DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t5StringStart);
			t5DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t5StringEnd);

			t6DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t6StringStart);
			t6DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t6StringEnd);

			t7DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t7StringStart);
			t7DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t7StringEnd);

			t8DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t8StringStart);
			t8DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t8StringEnd);

			t9DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t9StringStart);
			t9DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t9StringEnd);

			t10DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t10StringStart);
			t10DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t10StringEnd);

			t11DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t11StringStart);
			t11DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t11StringEnd);

			t12DateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t12StringStart);
			t12DateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(t12StringEnd);

			todayDateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(todayStringStart);
			todayDateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(todayStringEnd);

			yesterdayDateStart = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(yesterdayStringStart);
			yesterdayDateEnd = (Date) new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(yesterdayStringEnd);
			
		} catch (ParseException e) {
			
		}
		
		Timestamp t1Start = new Timestamp(t1DateStart.getTime());
		Timestamp t1End = new Timestamp(t1DateEnd.getTime());

		Timestamp t2Start = new Timestamp(t2DateStart.getTime());
		Timestamp t2End = new Timestamp(t2DateEnd.getTime());

		Timestamp t3Start = new Timestamp(t3DateStart.getTime());
		Timestamp t3End = new Timestamp(t3DateEnd.getTime());

		Timestamp t4Start = new Timestamp(t4DateStart.getTime());
		Timestamp t4End = new Timestamp(t4DateEnd.getTime());

		Timestamp t5Start = new Timestamp(t5DateStart.getTime());
		Timestamp t5End = new Timestamp(t5DateEnd.getTime());

		Timestamp t6Start = new Timestamp(t6DateStart.getTime());
		Timestamp t6End = new Timestamp(t6DateEnd.getTime());

		Timestamp t7Start = new Timestamp(t7DateStart.getTime());
		Timestamp t7End = new Timestamp(t7DateEnd.getTime());

		Timestamp t8Start = new Timestamp(t8DateStart.getTime());
		Timestamp t8End = new Timestamp(t8DateEnd.getTime());

		Timestamp t9Start = new Timestamp(t9DateStart.getTime());
		Timestamp t9End = new Timestamp(t9DateEnd.getTime());

		Timestamp t10Start = new Timestamp(t10DateStart.getTime());
		Timestamp t10End = new Timestamp(t10DateEnd.getTime());

		Timestamp t11Start = new Timestamp(t11DateStart.getTime());
		Timestamp t11End = new Timestamp(t11DateEnd.getTime());

		Timestamp t12Start = new Timestamp(t12DateStart.getTime());
		Timestamp t12End = new Timestamp(t12DateEnd.getTime());

		Timestamp todayStart = new Timestamp(todayDateStart.getTime());
		Timestamp todayEnd = new Timestamp(todayDateEnd.getTime());

		Timestamp yesterdayStart = new Timestamp(yesterdayDateStart.getTime());
		Timestamp yesterdayEnd = new Timestamp(yesterdayDateEnd.getTime());
		
		
		req.setAttribute("t1", ordersService.getTotalPriceInTime(t1Start, t1End));
		req.setAttribute("t2", ordersService.getTotalPriceInTime(t2Start, t2End));
		req.setAttribute("t3", ordersService.getTotalPriceInTime(t3Start, t3End));
		req.setAttribute("t4", ordersService.getTotalPriceInTime(t4Start, t4End));
		req.setAttribute("t5", ordersService.getTotalPriceInTime(t5Start, t5End));
		req.setAttribute("t6", ordersService.getTotalPriceInTime(t6Start, t6End));
		req.setAttribute("t7", ordersService.getTotalPriceInTime(t7Start, t7End));
		req.setAttribute("t8", ordersService.getTotalPriceInTime(t8Start, t8End));
		req.setAttribute("t9", ordersService.getTotalPriceInTime(t9Start, t9End));
		req.setAttribute("t10", ordersService.getTotalPriceInTime(t10Start, t10End));
		req.setAttribute("t11", ordersService.getTotalPriceInTime(t11Start, t11End));
		req.setAttribute("t12", ordersService.getTotalPriceInTime(t12Start, t12End));
		
		Long today = ordersService.getTotalPriceInTime(todayStart, todayEnd);
		req.setAttribute("today", today);
		
		Long yesterday = ordersService.getTotalPriceInTime(yesterdayStart, yesterdayEnd);
		yesterday = today - yesterday;
		req.setAttribute("yesterday", yesterday);
		
		req.setAttribute("year", year);
		

		RequestDispatcher rd = req.getRequestDispatcher("/views/admin/turnover.jsp");
		rd.forward(req, resp);
	}
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
	}
	

}
