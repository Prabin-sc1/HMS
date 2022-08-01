package com.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.entity.Doctor;

public class DoctorDao {
	private Connection con;

	public DoctorDao(Connection con) {
		super();
		this.con = con;
	}
	
	public boolean registerDoctor(Doctor d) {
		boolean f = false;
		try {
			String query = "insert into doctor(full_name,dob,qualification,specialist,email,phone,password) values(?,?,?,?,?,?,?)";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getPhone());
			ps.setString(7, d.getPassword());
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			} 
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	public List<Doctor> getAllDoctor(){
		List<Doctor> d = new ArrayList<Doctor>();
		Doctor doctor = null;
		try {
			String query = "select * from doctor order by id desc";
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				doctor = new Doctor();
				doctor.setId(rs.getInt(1));
				doctor.setFullName(rs.getString(2));
				doctor.setDob(rs.getString(3));
				doctor.setQualification(rs.getString(4));
				doctor.setSpecialist(rs.getString(5));
				doctor.setEmail(rs.getString(6));
				doctor.setPhone(rs.getString(7));
				doctor.setPassword(rs.getString(8));
				d.add(doctor);
				
				
				
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return d;
	}
	
	public Doctor getDoctorById(int id){
		Doctor doctor = null;
		try {
			String query = "select * from doctor where id=?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				doctor = new Doctor();
				doctor.setId(rs.getInt(1));
				doctor.setFullName(rs.getString(2));
				doctor.setDob(rs.getString(3));
				doctor.setQualification(rs.getString(4));
				doctor.setSpecialist(rs.getString(5));
				doctor.setEmail(rs.getString(6));
				doctor.setPhone(rs.getString(7));
				doctor.setPassword(rs.getString(8));
					
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		return doctor;
	}
	
	public boolean updateDoctor(Doctor d) {
		boolean f = false;
		try {
			String query = "update doctor set full_name=?,dob=?,qualification=?,specialist=?,email=?,phone=?,password=? where id= ?";
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, d.getFullName());
			ps.setString(2, d.getDob());
			ps.setString(3, d.getQualification());
			ps.setString(4, d.getSpecialist());
			ps.setString(5, d.getEmail());
			ps.setString(6, d.getPhone());
			ps.setString(7, d.getPassword());
			ps.setInt(8, d.getId());
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
