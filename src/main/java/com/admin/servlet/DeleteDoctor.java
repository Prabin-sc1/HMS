package com.admin.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.DoctorDao;
import com.dbconnection.DbConnection;

@WebServlet("/deleteDoctor")
public class DeleteDoctor extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int id = Integer.parseInt(req.getParameter("id"));
		DoctorDao dao;
		try {
			dao = new DoctorDao(DbConnection.getDbConnection());
			HttpSession session = req.getSession();
			if (dao.deleteDoctor(id)) {
				session.setAttribute("sucMsg", "Doctor Deleted Successfully!");
				resp.sendRedirect("admin/doctor.jsp");
			} else {
				session.setAttribute("failMsg", "Something error on server");
				resp.sendRedirect("admin/doctor.jsp");
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		
	}
	
}
