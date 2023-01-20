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
	<div class="dashboard-main">
		<div class="dash-top">
			<h1>Home Page</h1>
			<a href="/product/create">New Product</a>
			<a href="/category/create">New Category</a>
		</div>
		<div class="dash-bottom">
			<div class="dash-products">
				<h2>Products</h2>
				<c:forEach var="product" items="${products}">
					<a href="/product/${product.id}"><c:out value="${product.name}"/></a>
				</c:forEach>
			</div>
			<div class="dash-categories">
				<h2>Categories</h2>
				<c:forEach var="category" items="${categories}">
					<a href="category/${category.id}"><c:out value="${category.catName}"/></a>
				</c:forEach>
			</div>
		</div>
	</div>
</body>
</html>