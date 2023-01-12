<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Ninja</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1>New Ninja</h1>
	<form:form action="/ninja/new" method="POST" modelAttribute="ninja">
		<div class="ninjaForm">
			<form:select path="dojo">
				<c:forEach var="dojo" items="${dojos}">
					<option value="${dojo.id}">${dojo.name}</option>
				</c:forEach>
			</form:select>
		</div>
		<div class="ninjaForm">
			<form:label path="firstName">First Name:</form:label>
			<form:input type="text" path="firstName"/>
			<form:errors path="firstName" class="text-danger"/>
		</div>
		<div class="ninjaForm">
			<form:label path="lastName">Last Name:</form:label>
			<form:input type="text" path="lastName"/>
			<form:errors path="lastName" class="text-danger"/>
		</div>
		<div class="ninjaForm">
			<form:label path="age">Age:</form:label>
			<form:input type="number" path="age"/>
			<form:errors path="age" class="text-danger"/>
		</div>
		<button>Create</button>
	</form:form>
	<a href="/dojos/new">Create Dojo</a>
</body>
</html>