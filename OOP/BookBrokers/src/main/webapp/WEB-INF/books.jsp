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
			      <th scope="col">Owner</th>
			      <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="book" items="${books}">
			  		<c:if test="${book.borrower.id == null}">
				    <tr>
				      <th scope="row">${book.id}</th>
				      <td><a href="/books/${book.id}">${book.title}</a></td>
				      <td>${book.author}</td>
				      <td>${book.user.name}</td>
				      <td><c:if test="${userId == book.user.id}"><a href="/books/${book.id}/edit">Edit</a>
					  	<form action="/books/${book.id}" method="post">
	    					<input type="hidden" name="_method" value="delete">
							<a href="/books/${book.id}">Delete</a>
						</form></c:if>
						<c:if test="${userId != book.user.id}"><a href="/add/borrower/${book.id}">borrow</a></c:if>
					  </td>
				    </tr>
				    </c:if>
				</c:forEach>
			  </tbody>
			</table>
			<h2>Books I'm Borrowing</h2>
			<table class="table table-bordered table-striped">
			  <thead>
			    <tr>
			      <th scope="col">ID</th>
			      <th scope="col">Title</th>
			      <th scope="col">Author Name</th>
			      <th scope="col">Owner</th>
			      <th scope="col">Actions</th>
			    </tr>
			  </thead>
			  <tbody>
			  	<c:forEach var="book" items="${user.borrowed_books}">
				    <tr>
				      <th scope="row">${book.id}</th>
				      <td><a href="/books/${book.id}">${book.title}</a></td>
				      <td>${book.author}</td>
				      <td>${book.user.name}</td>
				      <td><a href="/return/borrower/${book.id}">return</a></td>
				    </tr>
				</c:forEach>
			  </tbody>
			</table>
		</div>
	</div>
</body>
</html>