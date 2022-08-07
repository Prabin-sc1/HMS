<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>


<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Doctor"%>


<%@page import="com.dbconnection.DbConnection"%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Appointment</title>
<%@include file="component/allcss.jsp"%>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}

.backImg {
	background: Linear-gradient(rgba(0, 0, 0, .4), rgba(0, 0, 0, .4)),
		url("img/doctor.jpg");
	height: 20vh;
	width: 100%;
	background-size: cover;
	background-repeat: no-repeat;
}

</style>


</head>
<body>
	<%@include file="component/navbar.jsp"%>

	<div class="container-fluid backImg p-5">
		<p class="text-center fs-2 text-white"></p>
	</div>

	<div class="container p-3">
		<div class="row">
			<div class="col-md-6 p-5">
				<img alt="" src="img/doctor.jpg">
			</div>

			<div class="col-md-6">

				<div class="card paint-card">
					<div class="card-body">
						<p class="text-center fs-3">User Appointment</p>

						<c:if test="${not empty sucMsg}">
							<p class="text-center text-success fs-5">${sucMsg }</p>
							<c:remove var="sucMsg" scope="session" />
						</c:if>


						<c:if test="${not empty failMsg}">
							<p class="text-center text-danger fs-5">${failMsg }</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<form class="row g-3" action="addAppointment" method="post">
							<input type ="hidden" name="userid" value="${userObj.id }">
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Full Name</label> <input
									required type="text" class="form-control" name="fullname">
							</div>

							<div class="col-md-6">
								<label>Gender</label><select class="form-control" name="gender"
									required>
									<option value="male">Male</option>
									<option value="female">Female</option>

								</select>
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Age</label><input
									required type="number" class="form-control" name="age">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Appointment
									Date</label><input required type="date" class="form-control"
									name="appoint_date">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Email</label><input
									required type="email" class="form-control" name="email">
							</div>
							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Phone No:</label><input
									maxlength="10" required type="text" class="form-control"
									name="phone">
							</div>

							<div class="col-md-6">
								<label for="inputEmail4" class="form-label">Diseases</label><input
									required type="text" class="form-control" name="diseases">
							</div>

							<div class="col-md-6">
								<label for="inputPassword4" class="form-label">Doctor</label> <select
									required class="form-control" name="doct">
									<option value="">--select--</option>

									<%
									DoctorDao dao = new DoctorDao(DbConnection.getDbConnection());
									List<Doctor> l = dao.getAllDoctor();
									for (Doctor d : l) {
									%>
									<option value="<%=d.getId()%>"><%=d.getFullName()%> (<%=d.getSpecialist()%>)
									</option>
									<%
									}
									%>

								</select>
							</div>

							<div class="col-md-12">
								<label>Full Address</label>
								<textarea required name="address" class="form-control" rows="3"
									cols=""></textarea>
							</div>

							<c:if test="${empty userObj}">
								<a href="user_login.jsp"
									class="col-md-6 offset-md-3 btn btn-success">Submit</a>
							</c:if>


							<c:if test="${not empty userObj}">
								<button class="col-md-6 offset-md-3 btn btn-success">Submit</button>
							</c:if>

						</form>
					</div>
				</div>
			</div>


		</div>
	</div>
</body>
</html>