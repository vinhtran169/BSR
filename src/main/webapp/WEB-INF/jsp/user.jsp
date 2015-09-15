<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User List</title>
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
		<c:if test="${not empty message}">
			<div class="panel-heading">
				<h3 class="panel-title">${message}</h3>
			</div>
		</c:if>
		<div class="panel-body">
			<form:form id="myForm" method="POST"
				class="bs-example form-horizontal" commandName="editUser">
				<button class="btn btn-primary" name="action" value="edit" id="edit"">Edit</button>
				<button class="btn btn-primary" name="action" value="delete" id="delete">Delete</button>
				<table class="table table-hover">
					<thead>
						<tr>
							<th data-field="selectedID" data-checkbox="true"></th>
							<th data-field="id">ID</th>
							<th data-field="username" data-align="right" data-sortable="true">Username</th>
							<th data-field="email" data-align="center" data-sortable="true">Email</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="u" items="${userList}" varStatus="status">
							<tr>
								<td><input type="checkbox" class="sltEdit" name="sltEdit"
									value="${u.id}" /></td>
								<td>${u.id}</td>
								<td>${u.username}</td>
								<td>${u.email}</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>

			</form:form>
		</div>
	</div>
	<div></div>
	<div></div>
</body>
<script type="text/javascript">
	$(function() {
		$('input[type="checkbox"]').bind('click', function() {
			$('input[type="checkbox"]').not(this).prop("checked", false);
		});
		$("#edit").click(function() {
			selected_value = $('input:checked').length
			if(selected_value != 1){
				alert("Please select only 1 checkbox")
				return false;
			}
		});
		$("#delete").click(function() {
			selected_value = $('input:checked').length
			if(selected_value == 1){
				return confirm('Are you sure?');
			}else{
				alert("Please select only 1 checkbox")
				return false;
			}
		});
	});
</script>

</html>