<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Expenses</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
<body>
	<div class="main-container">
		<div class="main-top">
			<h1>Save Travels</h1>
			<table class="table table-dark table-striped table-bordered border-warning">
				<thead>
					<tr>
				    	<th scope="col">Expense</th>
				    	<th scope="col">Vendor</th>
				    	<th scope="col">Amount</th>
				    	<th scope="col">Actions</th>
				    </tr>
				</thead>
				<tbody>
				<c:forEach var="expense" items="${expenses}">
					<tr>
				    	<td scope="row"><a href="/show/${expense.id}"><c:out value="${expense.expenseName}"/></a></td>
				    	<td><c:out value="${expense.vendor}"/></td>
				    	<td>$<c:out value="${expense.amount}"/></td>
				    	<td class="actions"><a href="/edit/${expense.id}">edit</a>
				    	<form action="/delete/${expense.id}" method="post">
				    		<input type="hidden" name="_method" value="delete">
				    		<button class="delete">delete</button>
				    	</form>
				    	</td>
				    </tr>
				</c:forEach>
				</tbody>
			</table>
		</div>
		<div class="main-bottom">
			<h2>Add an Expense:</h2>
			<form:form action="/addExpense" method="POST" modelAttribute="expense">
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
	</div>
</body>
</html>

