<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login/Registration</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="main">
		<div class="nav">
			<h1>Project Manager</h1>
			<p>A place for teams to manage projects.</p>
		</div>
		<div class="registration">
			<h2>Register</h2>
			<form:form action="/register" method="POST" modelAttribute="user">
				<div class="form">
					<form:label path="fname">First Name:</form:label>
					<form:input type="text" path="fname"/>
					<form:errors path="fname" class="text-danger"/>
				</div>
				<div class="form">
					<form:label path="lname">Last Name:</form:label>
					<form:input type="text" path="lname"/>
					<form:errors path="lname" class="text-danger"/>
				</div>
				<div class="form">
					<form:label path="email">Email:</form:label>
					<form:input type="text" path="email"/>
					<form:errors path="email" class="text-danger"/>
				</div>
				<div class="form">
					<form:label path="password">Password:</form:label>
					<form:input type="password" path="password"/>
					<form:errors path="password" class="text-danger"/>
				</div>
				<div class="form">
					<form:label path="confirm">Confirm PW:</form:label>
					<form:input type="password" path="confirm"/>
					<form:errors path="confirm" class="text-danger"/>
				</div>
				<button class="submit">Submit</button>
			</form:form>
		</div>
		<div class="login">
			<h2>Log In</h2>
			<form:form action="/login" method="POST" modelAttribute="loginUser">
				<div class="form">
					<form:label path="email">Email:</form:label>
					<form:input type="text" path="email"/>
					<form:errors path="email" class="text-danger"/>
				</div>
				<div class="form">
					<form:label path="password">Password:</form:label>
					<form:input type="password" path="password"/>
					<form:errors path="password" class="text-danger"/>
				</div>
				<button class="submit">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>