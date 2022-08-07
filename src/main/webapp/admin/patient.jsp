<%@page import="com.entity.Doctor"%>
<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.dbconnection.DbConnection"%>
<%@page import="com.dao.AppointmentDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="../component/allcss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>


</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="col-md-12">
		<div class="card paint-card">
			<div class="card-body">
				<p class="fs-3 text-center">Patient Details</p>


				<table class="table">
					<thead>
						<tr>
							<th scope="col">Full Name</th>
							<th scope="col">Gender</th>
							<th scope="col">Age</th>
							<th scope="col">Appointment Date</th>
							<th scope="col">Email</th>
							<th scope="col">Phone</th>
							<th scope="col">Diseases</th>
							<th scope="col">Doctor Name</th>
							<th scope="col">Address</th>
							<th scope="col">Status</th>
						</tr>
					</thead>

					<tbody>

						<%
						AppointmentDao dao = new AppointmentDao(DbConnection.getDbConnection());
						DoctorDao d = new DoctorDao(DbConnection.getDbConnection());
						List<Appointment> l = dao.getAllAppointment();
						for (Appointment a : l) {
							Doctor doc=  d.getDoctorById(a.getDoctorId());
						%>

						<tr>
							<th><%=a.getFullName() %></th>
							<td><%=a.getGender() %></td>
							<td><%=a.getAge() %></td>
							<td><%=a.getAppointDate() %></td>
							<td><%=a.getEmail() %></td>
							<td><%=a.getPhno() %></td>
							<td><%=a.getDiseases() %></td>
							<td><%=doc.getFullName() %></td>
							<td><%=a.getAddress() %></td>
							<td><%=a.getStatus() %></td>
							
						</tr>

						<%
						}
						%>

					</tbody>
				</table>
			</div>
		</div>

	</div>

</body>
</html>