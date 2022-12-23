<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" href="/css/style.css"/>
<title>Insert title here</title>
</head>
<body>
	<h1>Here's your Omikuji!</h1>
	<div class="main">
		<c:out value="${results}"/>
	</div>
	<a href="/omikuji">Go back</a>
</body>
</html>