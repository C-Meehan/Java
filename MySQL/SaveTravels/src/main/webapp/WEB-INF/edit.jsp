<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit Expenses</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
	<body>
		<div class="main-container">
			<div class="edit-nav">
				<h1>Edit Expense</h1>
				<a href="/expenses">Go back</a>
			</div>
			<form:form action="/edit/${expense.id}" method="PUT" modelAttribute="expense">
				<div>
					<form:label path="expenseName">Expense Name:</form:label><br>
					<form:input type="text" path="expenseName"/>
					<form:errors path="expenseName" class="text-warning"/>
				</div>
				<div>
					<form:label path="vendor">Vendor:</form:label><br>
					<form:input type="text" path="vendor"/>
					<form:errors path="vendor" class="text-warning"/>
				</div>
				<div>
					<form:label path="amount">Amount:</form:label><br>
					<form:input path="amount"/>
					<form:errors path="amount" class="text-warning"/>
				</div>
				<div>
					<form:label path="description">Description:</form:label><br>
					<form:textarea path="description"/>
					<form:errors path="description" class="text-warning"/>
				</div>
				<button class="submit">Submit</button>
			</form:form>
		</div>
	</body>
</html>