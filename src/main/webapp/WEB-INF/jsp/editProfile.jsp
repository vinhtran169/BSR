<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>	
	<c:if test="${not empty message}">
		<div class="message green">${message}</div>
	</c:if>
	<form:form id="myForm" method="post" class="bs-example form-horizontal" modelAttribute="user" action="../${user.id}">
		<fieldset>
			<legend>Edit user</legend>
			<div class="form-group" style="display:none">
				<label for="usernameInput" class="col-lg-3 control-label">ID</label>
				<div class="col-lg-9">
					<form:input type="text" class="form-control" path="id"/>
					<form:errors path="username" cssClass="error" />
				</div>
			</div>
			<div class="form-group">
				<label for="usernameInput" class="col-lg-3 control-label">User
					Name</label>
				<div class="col-lg-9">
					<form:input type="text" class="form-control" path="username"/>
					<form:errors path="username" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="passwordInput" class="col-lg-3 control-label">Password</label>
				<div class="col-lg-9">
					<form:input type="password" class="form-control" path="password"/>
					<form:errors path="password" cssClass="error" />
				</div>
			</div>

			<div class="form-group">
				<label for="emailInput" class="col-lg-3 control-label">Email
					Address</label>
				<div class="col-lg-9">
					<form:input type="text" class="form-control" path="email"
						id="emailInput" placeholder="Email Address" />
					<form:errors path="email" cssClass="error" />
				</div>
			</div>

			<div class="col-lg-9 col-lg-offset-3">
				<button class="btn btn-default">Cancel</button>

				<button class="btn btn-primary" data-toggle="modal"
					data-target="#themodal">Submit</button>
			</div>

		</fieldset>
	</form:form>
</body>
</html>