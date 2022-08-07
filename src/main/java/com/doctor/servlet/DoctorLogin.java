package com.doctor.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.dbconnection.DbConnection;
import com.entity.Doctor;
@WebServlet("/doctorLogin")
public class DoctorLogin extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			HttpSession session = req.getSession();

			DoctorDao dao = new DoctorDao(DbConnection.getDbConnection());
			Doctor u = dao.login(email, password);
			if (u != null) {
				session.setAttribute("docObj", u);
				resp.sendRedirect("doctor/index.jsp");
			} else {
				session.setAttribute("failMsg", "Invalid email or password");
				resp.sendRedirect("doctor_login.jsp");
			}
		} catch (Exception e) {
			e.printStackTrace();

		}

	}
}
