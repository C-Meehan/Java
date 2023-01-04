<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form" %>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>New Book</h1>
	<form:form action="/books" method="POST" modelAttribute="book">
		<div>
			<form:label path="title">Title:</form:label>
			<form:errors path="title" class="text-danger"/>
			<form:input type="text" path="title"/>
		</div>
		<div>
			<form:label path="description">Description:</form:label>
			<form:errors path="description" class="text-danger"/>
			<form:textarea path="description"/>
		</div>
		<div>
			<form:label path="language">Language:</form:label>
			<form:errors path="language" class="text-danger"/>
			<form:input type="text" path="language"/>
		</div>
		<div>
			<form:label path="numberOfPages">Pages</form:label>
			<form:errors path="numberOfPages" class="text-danger"/>
			<form:input type="number" path="numberOfPages"/>
		</div>
		<button>Submit</button>
	</form:form>
</body>
</html>