package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.entity.Appointment;

public class AppointmentDao {
	private Connection con;

	public AppointmentDao(Connection con) {
		super();
		this.con = con;
	}

	public boolean addAppointment(Appointment a) {
		boolean f = false;
		String query = "insert into appointment(user_id, fullname, gender, age, appoint_date, email, phone, disease, doctor_id, address, status) values(?,?,?,?,?,?,?,?,?,?,?)";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, a.getUserId());
			ps.setString(2, a.getFullName());
			ps.setString(3, a.getGender());
			ps.setString(4, a.getAge());
			ps.setString(5, a.getAppointDate());
			ps.setString(6, a.getEmail());
			ps.setString(7, a.getPhno());
			ps.setString(8, a.getDiseases());
			ps.setInt(9, a.getDoctorId());
			ps.setString(10, a.getAddress());
			ps.setString(11, a.getStatus());

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return f;
	}

	public List<Appointment> getAllAppointmentByUser(int userId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment a = null;
		String query = "select * from appointment where user_id =?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, userId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Appointment();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setFullName(rs.getString(3));
				a.setGender(rs.getString(4));
				a.setAge(rs.getString(5));
				a.setAppointDate(rs.getString(6));
				a.setEmail(rs.getString(7));
				a.setPhno(rs.getString(8));
				a.setDiseases(rs.getString(9));
				a.setDoctorId(rs.getInt(10));
				a.setAddress(rs.getString(11));
				a.setStatus(rs.getString(12));
				list.add(a);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public List<Appointment> getAllAppointmentByDoctor(int docId) {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment a = null;
		String query = "select * from appointment where doctor_id =?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, docId);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Appointment();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setFullName(rs.getString(3));
				a.setGender(rs.getString(4));
				a.setAge(rs.getString(5));
				a.setAppointDate(rs.getString(6));
				a.setEmail(rs.getString(7));
				a.setPhno(rs.getString(8));
				a.setDiseases(rs.getString(9));
				a.setDoctorId(rs.getInt(10));
				a.setAddress(rs.getString(11));
				a.setStatus(rs.getString(12));
				list.add(a);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

	public Appointment getAppointmentById(int id) {

		Appointment a = null;
		String query = "select * from appointment where id =?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Appointment();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setFullName(rs.getString(3));
				a.setGender(rs.getString(4));
				a.setAge(rs.getString(5));
				a.setAppointDate(rs.getString(6));
				a.setEmail(rs.getString(7));
				a.setPhno(rs.getString(8));
				a.setDiseases(rs.getString(9));
				a.setDoctorId(rs.getInt(10));
				a.setAddress(rs.getString(11));
				a.setStatus(rs.getString(12));

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return a;
	}

	public boolean updateCommentStatus(int id, int docId, String com) {
		boolean f = false;
		String query = "update appointment set status=? where id=? and doctor_id=?";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, com);
			ps.setInt(2, id);
			ps.setInt(3, docId);

			int i = ps.executeUpdate();

			if (i == 1) {
				f = true;
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return f;
	}

	public List<Appointment> getAllAppointment() {
		List<Appointment> list = new ArrayList<Appointment>();
		Appointment a = null;
		String query = "select * from appointment order by id desc";
		try {
			PreparedStatement ps = con.prepareStatement(query);
			

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a = new Appointment();
				a.setId(rs.getInt(1));
				a.setUserId(rs.getInt(2));
				a.setFullName(rs.getString(3));
				a.setGender(rs.getString(4));
				a.setAge(rs.getString(5));
				a.setAppointDate(rs.getString(6));
				a.setEmail(rs.getString(7));
				a.setPhno(rs.getString(8));
				a.setDiseases(rs.getString(9));
				a.setDoctorId(rs.getInt(10));
				a.setAddress(rs.getString(11));
				a.setStatus(rs.getString(12));
				list.add(a);

			}
		} catch (SQLException e) {

			e.printStackTrace();
		}

		return list;
	}

}
