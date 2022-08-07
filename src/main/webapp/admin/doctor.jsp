<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.dbconnection.DbConnection"%>
<%@page import="com.entity.Specialist"%>
<%@page import="com.dao.SpecDao"%>

<%@page import="com.dao.DoctorDao"%>
<%@page import="com.entity.Doctor"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3);
}
</style>

<%@include file="navbar.jsp"%>
<%@include file="../component/allcss.jsp"%>

</head>
<body>

	<div class="container-fluid p-3">
		<div class="row">

			<div class="col-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Add Doctor</p>

						<c:if test="${not empty succMsg}">
							<p class="text-center text-success fs-5">${succMsg }</p>
							<c:remove var="succMsg" scope="session" />
						</c:if>


						<c:if test="${not empty faillMsg}">
							<p class="text-center text-danger fs-5">${faillMsg }</p>
							<c:remove var="faillMsg" scope="session" />
						</c:if>

						<form action="../addDoctor" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label><input type="text"
									required name="fullname" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label><input type="date" required
									name="dob" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label><input
									type="text" required name="qualification" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									required class="form-control">
									<option>--Select--</option>
									<%
									SpecDao dao = new SpecDao(DbConnection.getDbConnection());

									List<Specialist> list = dao.getAllSpecialist();

									for (Specialist s : list) {
									%>
									<option><%=s.getSpecName()%></option>
									<%
									}
									%>

								</select>
							</div>



							<div class="mb-3">
								<label class="form-label">Email</label><input type="text"
									required name="email" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Mobile No.</label><input type="text"
									required name="mobno" class="form-control">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label><input type="password"
									required name="password" class="form-control">
							</div>

							<button type="submit" class="btn btn-primary">Submit</button>
						</form>

					</div>

				</div>

			</div>



			<div class="col-md-8">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Doctor Details</p>

						<c:if test="${not empty sucMsg}">
							<p class="text-center text-success fs-5">${sucMsg }</p>
							<c:remove var="sucMsg" scope="session" />
						</c:if>


						<c:if test="${not empty failMsg}">
							<p class="text-center text-danger fs-5">${failMsg }</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<table class="table">
							<thead>
								<tr>
									<th scope="col">Name</th>
									<th scope="col">DOB</th>
									<th scope="col">Qualification</th>
									<th scope="col">Specialist</th>
									<th scope="col">Email</th>
									<th scope="col">Phone</th>
									<th scope="col">Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								DoctorDao d = new DoctorDao(DbConnection.getDbConnection());
								List<Doctor> l = d.getAllDoctor();
								for (Doctor doc : l) {
								%>
								<tr>
									<td><%=doc.getFullName()%></td>
									<td><%=doc.getDob()%></td>
									<td><%=doc.getQualification()%></td>
									<td><%=doc.getSpecialist()%></td>
									<td><%=doc.getEmail()%></td>
									<td><%=doc.getPhone()%></td>
									<td><a href="edit_doc.jsp?id=<%=doc.getId()%>"
										class="btn btn-primary">Edit</a> <a
										href="../deleteDoctor?id=<%=doc.getId()%>"
										class="btn btn-danger">Delete</a></td>
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

</body>
</html>