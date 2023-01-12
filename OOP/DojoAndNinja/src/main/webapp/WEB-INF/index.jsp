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
	<h1>NEW DOJO</h1>
	<form:form action="/dojos/new" method="POST" modelAttribute="dojo">
		<div class="dojoForm">
			<form:label path="name">Name:</form:label>
			<form:input type="text" path="name"/>
			<form:errors path="name" class="text-danger"/>
		</div>
		<button>Create</button>
	</form:form>
	<a href="/ninja/new">Create Ninja</a>
</body>
</html>

