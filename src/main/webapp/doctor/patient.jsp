<%@page import="com.entity.Appointment"%>
<%@page import="java.util.List"%>
<%@page import="com.dbconnection.DbConnection"%>
<%@page import="com.dao.AppointmentDao"%>
<%@page import="com.entity.Doctor"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
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
	<c:if test="${empty docObj }">
		<c:redirect url="../doctor_login.jsp"></c:redirect>
	</c:if>

	<%@include file="navbar.jsp"%>

	<div class="container p-3">
		<div class="container p-3">
			<div class="row">

				<div class="col-md-12">
					<div class="card paint-card">
						<div class="card-body">
							<p class="fs-4 text-center">Patient Details</p>

							<c:if test="${not empty sucMsg}">
								<p class="text-center text-success fs-3">${sucMsg }</p>
								<c:remove var="sucMsg" scope="session" />
							</c:if>


							<c:if test="${not empty failMsg}">
								<p class="text-center text-danger fs-3">${failMsg }</p>
								<c:remove var="failMsg" scope="session" />
							</c:if>

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
										<th scope="col">Status</th>
										<th scope="col">Action</th>
									</tr>
								</thead>

								<tbody>

									<%
									Doctor d = (Doctor) session.getAttribute("docObj");
									AppointmentDao dao = new AppointmentDao(DbConnection.getDbConnection());
									List<Appointment> list = dao.getAllAppointmentByDoctor(d.getId());

									for (Appointment a : list) {
									%>
									<tr>
										<th><%=a.getFullName()%></th>
										<td><%=a.getGender()%></td>
										<td><%=a.getAge()%></td>
										<td><%=a.getAppointDate()%></td>
										<td><%=a.getEmail()%></td>
										<td><%=a.getPhno()%></td>
										<td><%=a.getDiseases()%></td>
										<td><%=a.getStatus()%></td>
										<td>
										<%
										if("Pending".equals(a.getStatus())){%>
											<a href="comment.jsp?id=<%=a.getId() %>" class="btn btn-success btn-sm">Comment</a>
										<%}
										else{%>
											<a href="#" class="btn btn-success btn-sm disabled">Comment</a>											
										<%}
										%>

										</td>
									</tr>

									<%
									}
									%>

								</tbody>
							</table>

						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

</body>
</html>