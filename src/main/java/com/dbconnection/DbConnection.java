package com.dbconnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {
	private static Connection con;

	public static Connection getDbConnection() throws SQLException {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/hms";
			con = (Connection) DriverManager.getConnection(url, "root", "");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}
}
