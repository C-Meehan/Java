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
			<h2><c:out value="${product.name}"/></h2>
			<a href="/">Home</a>
		</div>
		<div class="show-product-bottom">
			<h2>Categories:</h2>
			<c:forEach var="cat" items="${product.categories}">
				<c:out value="${cat.catName}"/>
			</c:forEach>
		</div>
		<h2>Add Category:</h2>
		<form:form action="/product/${product.id}" method="Post" modelAttribute="category">
			<form:select path="id">
				<c:forEach var="cat" items="${categories}">
					<form:option path="id" value="${cat.id}"><c:out value="${cat.catName}"/></form:option>
				</c:forEach>
			</form:select>
			<button class="submit">Submit</button>
		</form:form>
	</div>
</body>
</html>