package com.user.servlet;

import java.io.IOException;
import java.nio.channels.NonWritableChannelException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.AppointmentDao;
import com.dbconnection.DbConnection;
import com.entity.Appointment;
@WebServlet("/addAppointment")
public class AppointmentServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int userId = Integer.parseInt(req.getParameter("userid"));
		String fullName = req.getParameter("fullname");
		String gender = req.getParameter("gender");
		String age = req.getParameter("age");
		String appointDate = req.getParameter("appoint_date");
		String email = req.getParameter("email");
		String phone = req.getParameter("phone");
		String diseases = req.getParameter("diseases");
		int doctorId = Integer.parseInt(req.getParameter("doct"));
		String address = req.getParameter("address");
		
//		Appointment a = new Appointment();
		Appointment a = new Appointment(userId, fullName, gender, age, appointDate, email, phone, diseases, doctorId, address, "Pending");
		
		try {
			AppointmentDao dao = new AppointmentDao(DbConnection.getDbConnection());
			HttpSession session = req.getSession();
			if(dao.addAppointment(a)) {
				session.setAttribute("sucMsg", "Appointment booked successfully!");
				resp.sendRedirect("user_appointment.jsp");
				
			} else {
				session.setAttribute("failMsg", "Something wrong on server!");
				resp.sendRedirect("user_appointment.jsp");
				
			}
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
		
		
		
	}
	
	

}
