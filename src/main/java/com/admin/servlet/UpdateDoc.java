package com.admin.servlet;

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
@WebServlet("/updateDoctor")
public class UpdateDoc extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String fullName = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qual = req.getParameter("qualification");
			String spec = req.getParameter("spec");
			String email = req.getParameter("email");
			String mob = req.getParameter("mobno");
			String password = req.getParameter("password");
			int id = Integer.parseInt(req.getParameter("id"));

			Doctor d = new Doctor(id,fullName, dob, qual, spec, email, mob, password);

			DoctorDao dao = new DoctorDao(DbConnection.getDbConnection());

			HttpSession session = req.getSession();
			if (dao.updateDoctor(d)) {
				session.setAttribute("sucMsg", "Doctor Updated Successfully!");
				resp.sendRedirect("admin/doctor.jsp");
			} else {
				session.setAttribute("failMsg", "Something on server");
				resp.sendRedirect("admin/doctor.jsp");
			}

		} catch (Exception e) {

		}
	}
	

}
