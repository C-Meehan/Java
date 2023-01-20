<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="new-book-container">
		<div class="new-nav">
			<h1>Add a Book to Your Shelf!</h1>
			<a href="/books">back to the shelves</a>
		</div>
		<form:form action="/books/new" method="POST" modelAttribute="book">
			<form:hidden path="user" value="${userId}"/>
			<div class="bookForm">
				<form:label path="title">Title</form:label>
				<form:input type="text" path="title"/>
				<form:errors path="title" class="text-danger"/>
			</div>
			<div class="bookForm">
				<form:label path="author">Author</form:label>
				<form:input type="text" path="author"/>
				<form:errors path="author" class="text-danger"/>
			</div>
			<div class="bookForm">
				<form:label path="thoughts">My Thoughts</form:label>
				<form:textarea path="thoughts"/>
				<form:errors path="thoughts"/>
			</div>
			<button class="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>