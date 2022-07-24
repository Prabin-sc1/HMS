package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.entity.User;

public class UserDao {
	private Connection conn;

	public UserDao(Connection conn) {
		super();
		this.conn = conn;
	}

	public boolean userRegister(User u) {
		boolean f = false;
		try {
			String query = "insert into users(fullName, email, password) values(?,?,?)";
			PreparedStatement ps = conn.prepareStatement(query);
			ps.setString(1, u.getFullName());
			ps.setString(2, u.getEmail());
			ps.setString(3, u.getPassword());
			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public User login(String em, String pw) {
		User u = null;
		try {
			String query = "Select * from users where email=? and password=?";
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, em);
			pst.setString(2, pw);
			
			ResultSet rs = pst.executeQuery();
			while(rs.next()) {
				u = new User();
				u.setId(rs.getInt(1));
				u.setFullName(rs.getString(2));
				u.setEmail(rs.getString(3));
				u.setPassword(rs.getString(4));
			}
			
		} catch (Exception e) {

		}
		return u;
	}

}
