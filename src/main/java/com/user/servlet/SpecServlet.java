package com.user.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.SpecDao;
import com.dbconnection.DbConnection;

@WebServlet("/specServlet")
public class SpecServlet extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String specName = req.getParameter("specName");

		try {
			SpecDao dao = new SpecDao(DbConnection.getDbConnection());
			boolean f = dao.addSpec(specName);
			HttpSession session = req.getSession();

			if (f) {
				session.setAttribute("sucMsg", "Specialist added");
				resp.sendRedirect("admin/index.jsp");
			} else {
				session.setAttribute("failMsg", "Something wrong on server");
				resp.sendRedirect("admin/index.jsp");
			}
		} catch (SQLException e) {

		}

	}
}
