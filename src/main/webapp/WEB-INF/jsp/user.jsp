<%@page import="brycen.salaryreport.model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page import="brycen.*, java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Success</title>
<link href="assets/css/bootstrap-united.css" rel="stylesheet" />

</head>
<body>
	<script src="jquery-1.8.3.js">
		
	</script>

	<script src="bootstrap/js/bootstrap.js">
		
	</script>

	<div class="navbar navbar-default">

		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-responsive-collapse">
				<span class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
		</div>

		<div class="navbar-collapse collapse navbar-responsive-collapse">
			<form class="navbar-form navbar-right">
				<input type="text" class="form-control" placeholder="Search">
			</form>
			<ul class="nav navbar-nav navbar-right">
				<li><a href="/StudentEnrollmentWithMyBatis">Home</a></li>
				<li><a href="signup.html">Signup</a></li>
				<li class="active"><a href="login.html">Login</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown">Explore<b class="caret"></b></a>
					<ul class="dropdown-menu">
						<li><a href="#">Contact us</a></li>
						<li class="divider"></li>
						<li><a href="#">Further Actions</a></li>
					</ul></li>
			</ul>
		</div>
		<!-- /.nav-collapse -->
	</div>

	<!-- 
	<legend>Student Enrollment Login Success</legend>
	 -->
	<div class="panel panel-success">
		<div class="panel-heading">

			<c:if test="${not empty message}">
				<h3 class="panel-title">${message}</h3>
			</c:if>
		</div>
		<div class="panel-body">
			<table class="table table-hover">
				<thead>
					<tr>
						<th data-field="id" data-checkbox="true">ID</th>
						<th data-field="username" data-align="right" data-sortable="true">Username</th>
						<th data-field="email" data-align="center" data-sortable="true">Email</th>
						<th data-field="action" data-sortable="true"
							data-sorter="priceSorter">Action</th>
					</tr>
				</thead>
				<tbody>

					<%
						List<User> userList = (List) request.getAttribute("userList");
						for (User u : userList) {
							out.println("<tr>");
							out.println("<td>" + u.getId() + "</td>");
							out.println("<td>" + u.getUsername() + "</td>");
							out.println("<td>" + u.getEmail() + "</td>");
							out.println("<td></td>");
							out.println("</tr>");
						}
					%>


				</tbody>
			</table>
		</div>
	</div>
	<div></div>
	<div></div>
</body>
</html>