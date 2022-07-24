package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	public List<Specialist> getAllSpecialist(){
		List<Specialist> list = new ArrayList<Specialist>();
		Specialist s = null;
		try {
			String query = "select *from specialist";
			PreparedStatement ps = con.prepareStatement(query);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				s = new Specialist();
				s.setId(rs.getInt(1));
				s.setSpecName(rs.getString(2));
				list.add(s);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}

}
