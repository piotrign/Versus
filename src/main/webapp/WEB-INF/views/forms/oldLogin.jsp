<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<title>Login Page</title>
</head>
<body>
	<h1>Welcome on Tweeter</h1>
	
	<form:form method="POST" modelAttribute="user">
		<h2>Plese sign in:</h2>
		Your username:
		<br>
		<form:input path="username" />
		Email:
		<br>
		<form:input path="email" />
		Password:
		<br>
		<input type="submit" value="save">
	</form:form>
	<br>
	<br>
<a href="http://localhost:8080/home"><button>Home page</button></a>
</body>
</html>