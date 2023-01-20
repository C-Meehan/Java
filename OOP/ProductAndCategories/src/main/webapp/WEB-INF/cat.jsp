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
	<div class="show-product-main">
		<div class="show-product-top">
			<h2><c:out value="${category.catName}"/></h2>
			<a href="/">Home</a>
		</div>
		<div class="show-product-bottom">
			<h2>Products:</h2>
			<c:forEach var="product" items="${category.products}">
				<c:out value="${product.name}"/>
			</c:forEach>
		</div>
		<h2>Add Product:</h2>
		<form:form action="/category/${category.id}" method="Post" modelAttribute="product">
			<form:select path="id">
				<c:forEach var="product" items="${products}">
					<form:option path="id" value="${product.id}"><c:out value="${product.name}"/></form:option>
				</c:forEach>
			</form:select>
			<button class="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>