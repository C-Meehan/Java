<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Homepage</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class = "homepage-main">
		<div class = "homepage-nav">
			<div class = "homepage-nav-top">
				<h1>Welcome, <c:out value = "${user.name}"/></h1>
				<a href="/logout">logout</a>
			</div>
			<div class = "homepage-nav-bottom">
				<p>Books from everyone's shelves:</p>
				<a href="/books/new">+ Add a book to my shelf!</a>
			</div>
		</div>
		<div class = "main-table">
			<table class="table table-bordered table-striped">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Title</th>
			      <th scope="col">Author Name</th>
			      <th scope="col">Posted By</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="book" items="${books}">
				    <tr>
				      <th scope="row">${book.id}</th>
				      <td><a href="/books/${book.id}">${book.title}</a></td>
				      <td>${book.author}</td>
				      <td>${book.user.name}</td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>