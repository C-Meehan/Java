<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Language</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="navbar">
		<a href="/languages/${language.id}/delete">Delete</a>
		<a href="/languages">Dashboard</a>
	</div>
	<div class="edit-form">
		<form:form action="/languages/${language.id}" method="PUT" modelAttribute="language">
			<div class="form">
					<form:label path="name">Name:</form:label>
					<form:input type="text" path="name"/>
					<form:errors path="name" class="text-warning"/>
				</div>
				<div class="form">
					<form:label path="creator">Creator:</form:label>
					<form:input type="text" path="creator"/>
					<form:errors path="creator" class="text-warning"/>
				</div>
				<div class="form">
					<form:label path="version">Version:</form:label>
					<form:input path="version"/>
					<form:errors path="version" class="text-warning"/>
				</div>
				<button class="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>

