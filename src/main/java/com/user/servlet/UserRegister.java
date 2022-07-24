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

@WebServlet("/user_register")
public class UserRegister extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	try {
		String name = req.getParameter("fullName");
		String email = req.getParameter("email");
		String password = req.getParameter("password");
		
		User u = new User(name, email, password);
		UserDao d = new UserDao(DbConnection.getDbConnection());
		HttpSession session = req.getSession();
		
		boolean f = d.userRegister(u);
		if(f) {
//			System.out.println("Data inserted successfully!");
			session.setAttribute("sucMsg", "Registered Successfully!");
			resp.sendRedirect("signup.jsp");
//			
		}else {
//			System.out.println("Something wrong on server!");
			session.setAttribute("failMsg", "Something wrong on server!");
			resp.sendRedirect("signup.jsp");
		}
	}catch(Exception e) {
		e.printStackTrace();
	   }
	}
}
