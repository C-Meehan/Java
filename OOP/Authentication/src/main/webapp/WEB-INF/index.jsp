<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Dojo</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="main">
		<div class="nav">
			<h1 class="welccome">Welcome!</h1>
			<p>Join our growing community.</p>
		</div>
		<div class="main-sub">
			<div class="register">
				<form:form action="/register" method="POST" modelAttribute="user">
					<h1>Register</h1>
					<div>
						<form:label path="userName">User Name:</form:label>
						<form:input type="text" path="userName"/>
						<form:errors path="userName" class="text-danger"/>
					</div>
					<div>
						<form:label path="email">Email:</form:label>
						<form:input type="text" path="email"/>
						<form:errors path="email" class="text-danger"/>
					</div>
					<div>
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
						<form:errors path="password" class="text-danger"/>
					</div>
					<div>
						<form:label path="confirm">Confirm PW:</form:label>
						<form:input type="password" path="confirm"/>
						<form:errors path="confirm" class="text-danger"/>
					</div>
					<button>Submit</button>
				</form:form>
			</div>
			<div class="Login">
				<form:form action="/login" method="POST" modelAttribute="loginUser">
					<h1>Log in</h1>
					<div>
						<form:label path="email">Email:</form:label>
						<form:input type="text" path="email"/>
						<form:errors path="email" class="text-danger"/>
					</div>
					<div>
						<form:label path="password">Password:</form:label>
						<form:input type="password" path="password"/>
						<form:errors path="password" class="text-danger"/>
					</div>
					<button>Submit</button>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>