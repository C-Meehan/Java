<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>New Product</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<div class="new-product-main">
		<div class="new-product-top">
			<h1>New Product</h1>
			<a href="/">home</a>
		</div>
		<div class="new-product-bottom">
			<form:form action="/product/create" method="POST" modelAttribute="product">
				<div class="form">
					<form:label path="name">Name:</form:label>
					<form:input type="text" path="name"/>
					<form:errors path="name" class="text-danger"/>
				</div>
				<div class="form">
					<form:label path="description">Description:</form:label>
					<form:input type="text" path="description"/>
					<form:errors path="description" class="text-danger"/>
				</div>
				<div class="form">
					<form:label path="price">Price:</form:label>
					<form:input type="number" path="price" step=".01"/>
					<form:errors path="price" class="text-danger"/>
				</div>
				<button class="submit">Submit</button>
			</form:form>
		</div>
	</div>
</body>
</html>