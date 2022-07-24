package com.user.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.UserDao;
import com.dbconnection.DbConnection;
import com.entity.User;
@WebServlet("/userLogin")
public class UserServlet extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		try {
			String email = req.getParameter("email");
			String password = req.getParameter("password");
			HttpSession session = req.getSession();
			
			UserDao dao = new UserDao(DbConnection.getDbConnection());
			User u = dao.login(email, password);
			if(u != null) {
				session.setAttribute("userObj", u);
				resp.sendRedirect("index.jsp");
			} else {
				session.setAttribute("failMsg", "Invalid email or password");
				resp.sendRedirect("user_login.jsp");
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	
}
