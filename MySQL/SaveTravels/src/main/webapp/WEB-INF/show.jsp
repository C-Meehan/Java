<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show Expense</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
	<body>
		<div class="main-container">
			<div class="edit-nav">
				<h1>Expense Details</h1>
				<a href="/expenses">Go back</a>
			</div>
			<h3>Expense Name: <c:out value="${expense.expenseName}"/></h3>
			<h3>Expense Description: <c:out value="${expense.description}"/></h3>
			<h3>Vendor: <c:out value="${expense.vendor}"/></h3>
			<h3>Amount Spent: $<c:out value="${expense.amount}"/></h3>
		</div>
	</body>
</html>