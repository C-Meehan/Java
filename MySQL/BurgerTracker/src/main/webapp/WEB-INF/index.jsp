<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<%@ page isErrorPage="true" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Burger Tracker</title>
</head>
<body>
	<h1>Burger Tracker</h1>
	<table class="table table-striped table-bordered">
		<thead>
			<tr>
				<th>Burger Name</th>
				<th>Restaurant Name</th>
				<th>Rating (out of 5)</th>
				<th>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="burger" items="${burgers}">
				<tr>
					<td><c:out value="${burger.burgerName}"/></td>
					<td><c:out value="${burger.restaurantName}"/></td>
					<td><c:out value="${burger.rating}"/></td>
					<td><a href="/burgers/edit/${burger.id}">edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<h2>Add a Burger:</h2>
	<form:form action="/addBurger" method="POST" modelAttribute="burger">
		<div>
			<form:label path="burgerName">Burger Name:</form:label><br>
			<form:errors path="burgerName" class="text-danger"/>
			<form:input type="text" path="burgerName"/>
		</div>
		<div>
			<form:label path="restaurantName">Restaurant Name:</form:label><br>
			<form:errors path="restaurantName" class="text-danger"/>
			<form:input type="text" path="restaurantName"/>
		</div>
		<div>
			<form:label path="rating">Rating:</form:label><br>
			<form:errors path="rating" class="text-danger"/>
			<form:input type="number" path="rating"/>
		</div>
		<div>
			<form:label path="notes">Notes:</form:label><br>
			<form:errors path="notes" class="text-danger"/>
			<form:textarea path="notes"/>
		</div>
		<button>Submit</button>
	</form:form>
</body>
</html>