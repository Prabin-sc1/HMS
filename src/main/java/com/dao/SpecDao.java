package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.entity.Specialist;

public class SpecDao {
	private Connection con;

	public SpecDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean addSpec(String s) {
		boolean f = false;
		
		try {
			String query = "insert into specialist(spec_name) values(?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, s);
			
			int i = ps.executeUpdate();
			
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

}
