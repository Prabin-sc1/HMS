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

			<div class="col-md-4 offset-md-4">
				<div class="card paint-card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Doctor Details</p>
						<c:if test="${not empty sucMsg}">
							<p class="text-center text-success fs-5">${sucMsg }</p>
							<c:remove var="sucMsg" scope="session" />
						</c:if>


						<c:if test="${not empty failMsg}">
							<p class="text-center text-danger fs-5">${failMsg }</p>
							<c:remove var="failMsg" scope="session" />
						</c:if>

						<%
						int id = Integer.parseInt(request.getParameter("id"));
						DoctorDao dao2 = new DoctorDao(DbConnection.getDbConnection());
						Doctor d = dao2.getDoctorById(id);
						%>

						<form action="../updateDoctor" method="post">
							<div class="mb-3">
								<label class="form-label">Full Name</label><input type="text"
									required name="fullname" class="form-control" value="<%=d.getFullName() %>">
							</div>

							<div class="mb-3">
								<label class="form-label">DOB</label><input type="date" required
									name="dob" class="form-control" value ="<%=d.getDob() %>">
							</div>

							<div class="mb-3">
								<label class="form-label">Qualification</label><input
									type="text" required name="qualification" class="form-control" value="<%=d.getQualification() %>">
							</div>

							<div class="mb-3">
								<label class="form-label">Specialist</label> <select name="spec"
									required class="form-control">
									<option><%=d.getSpecialist() %></option>
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
									required name="email" class="form-control"
									value="<%=d.getEmail() %>">
							</div>

							<div class="mb-3">
								<label class="form-label">Mobile No.</label><input type="text"
									required name="mobno" class="form-control" value="<%=d.getPhone() %>">
							</div>

							<div class="mb-3">
								<label class="form-label">Password</label><input type="password"
									required name="password" class="form-control" value="<%=d.getPassword() %>">
							</div>
							<input type="hidden" name="id" value="<%= d.getId() %>">

							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>

					</div>

				</div>

			</div>

		</div>

	</div>

</body>
</html>