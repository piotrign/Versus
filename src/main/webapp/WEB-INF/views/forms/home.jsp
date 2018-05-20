<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tweeter Main Page</title>
</head>
<body>
	<h1>Main Page</h1>
	<a href="${contextPath}/login"><button>Login</button></a>
	<a href="${contextPath}/tweet/add"><button>Send tweet</button></a>
	<a href="${contextPath}/user/add"><button>Add user</button></a>
	<a href="${contextPath}/user/all"><button>Show all users</button></a>
	<br>
	<br>
	<h2>List of tweets</h2>
	<br>
	<table border="2">
		<thead>
			<tr>
				<td>Title</td>
				<td>Tweet Text</td>
				<td>Created</td>
			</tr>
		</thead>
		<c:forEach items="${tweets}" var="tweet">
			<tr>
				<td><c:out value="${tweet.title}" /></td>
				<td><c:out value="${tweet.textBox}" /></td>
				<td><c:out value="${tweet.created}" /></td>
			</tr>
		</c:forEach>
	</table>

</body>
</html>