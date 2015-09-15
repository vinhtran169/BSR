<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="display" uri="http://displaytag.sf.net"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List user</title>
</head>
<body>
	<style>
table tr td,table tr th {
	border: 1px solid #aaa;
	padding: 2px;
}

table {
	border-collapse: collapse;
	width: 500px;
}
</style>
	<h1>User List</h1>

	<div>
		<form action="">
		<table border="1">
			<tr>
				<th style="width: 100px; text-align: center">User ID</th>
				<th style="width: 200px">User Name</th>
				<th style="width: 75px">Email</th>
				<th style="width:50px">Delete</th>
				<th style="width:50px">Edit</th>
               
            
			</tr>
			<tr> <input type="Submit" value="Edit" /></tr>
			<c:forEach items="${userList}" var="user">
				<tr>
					<td style=" text-align:center">${user.id}</td>
					<td style=" text-align:center">${user.userName}</td>
					<td style=" text-align:center">${user.email}</td>
					<td><a href="list/delete/${user.id}" >Delete</a></td>
					<td><input type="checkbox" name="edit"></td>
					
				</tr>

			</c:forEach>
		</table>
		</form>
	</div>
</body>
</html>