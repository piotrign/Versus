<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Users</title>
</head>
<body>
	<h1>List of users</h1>

	<table border="1">
		<thead>
			<tr>
				<td>Id</td>
				<td>Username</td>
				<td>Email</td>
				<td>Edit User</td>
				<td>Remove User</td>
			</tr>
		</thead>
		<c:forEach items="${users}" var="user">
			<tr>
				<td><c:out value="${user.id}" /></td>
				<td><c:out value="${user.username}" /></td>
				<td><c:out value="${user.email}" /></td>
				<td><a href="http://localhost:8080/cl.exam6/forms/user/edit/${user.id}">Edit</a>
					<a href="http://localhost:8080/cl.exam6/forms/user/remove/${user.id}">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>
	<a href="${contextPath}/home"><button>Home</button></a>
</body>
</html>