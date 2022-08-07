package com.user.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dbconnection.DbConnection;
@WebServlet("/user_change_password")
public class ChangePassword extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int uid = Integer.parseInt(req.getParameter("uid"));
		String oldPassword = req.getParameter("oldPassword");
		String newPassword = req.getParameter("newPassword");
		
		try {
			UserDao dao = new UserDao(DbConnection.getDbConnection());
			HttpSession session = req.getSession();
			
			if(dao.checkOldPassword(uid, oldPassword)) {
				if(dao.updatePassword(uid, newPassword)) {
					session.setAttribute("sucMsg", "Password Changed Successfully!");
					resp.sendRedirect("change_password.jsp");
				} else {

					session.setAttribute("failMsg", "Something wrong on server");
					resp.sendRedirect("change_password.jsp");
				}
			}else {
				session.setAttribute("failMsg", "Incorrect Old Password");
				resp.sendRedirect("change_password.jsp");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
				
	}

}
