<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home Page</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="new-cat-main">
		<div class="new-cat-top">
			<h2>New Category</h2>
			<a href="/">Home</a>
		</div>
		<div class="new-cat-bottom">
			<form:form action="/category/create" method="POST" modelAttribute="category">
				<div class="form">
					<form:label path="catName">Name:</form:label>
					<form:input path="catName"/>
					<form:errors path="catName"/>
				</div>
				<button class="submit">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>