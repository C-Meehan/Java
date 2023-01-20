<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Show</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="show-main">
		<div class="show-nav">
			<h1><c:out value="${book.title}"/></h1>
			<a href="/books">back to the shelves</a>
			<h1><c:out value="${userId}"/></h1>
		</div>
		<div class="show-content">
			<c:if test="${userId != book.user.id}">
				<h2><c:out value="${book.user.name}"/> read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h2>
				<h2>Here are <c:out value="${book.user.name}"/>'s thoughts:</h2>
				<p><c:out value="${book.thoughts}"/></p>
			</c:if>
			<c:if test="${userId == book.user.id}">
				<h2>You read <c:out value="${book.title}"/> by <c:out value="${book.author}"/>.</h2>
				<h2>Here are your thoughts:</h2>
				<p><c:out value="${book.thoughts}"/></p>
			</c:if>
		</div>
		<c:if test="${userId == book.user.id}">
			<a href="/books/${book.id}/edit"><button>Edit</button></a>
			<form action="/books/${book.id}" method="post">
	    		<input type="hidden" name="_method" value="delete">
				<a href="/books/${book.id}"><button>Delete</button></a>
			</form>
		</c:if>
	</div>
</body>
</html>