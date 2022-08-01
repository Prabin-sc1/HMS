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

@WebServlet("/addDoctor")
public class AddDoctor extends HttpServlet {
	
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		try {
			String fullName = req.getParameter("fullname");
			String dob = req.getParameter("dob");
			String qual = req.getParameter("qualification");
			String spec = req.getParameter("spec");
			String email = req.getParameter("email");
			String mob = req.getParameter("mobno");
			String password = req.getParameter("password");

			Doctor d = new Doctor(fullName, dob, qual, spec, email, mob, password);

			DoctorDao dao = new DoctorDao(DbConnection.getDbConnection());

			HttpSession session = req.getSession();
			if (dao.registerDoctor(d)) {
				session.setAttribute("sucMsg", "Doctor Added Successfully!");
				res.sendRedirect("admin/doctor.jsp");
			} else {
				session.setAttribute("failMsg", "Something on server");
				res.sendRedirect("admin/doctor.jsp");
			}

		} catch (Exception e) {

		}
	}

}
