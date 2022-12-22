<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.Date"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<script type="text/javascript" src="js/script.js"></script>
<title>Insert title here</title>
</head>
<body>
	<h1>Hello World</h1>
	
	<% for (int i = 0; i < 5; i++){%>
		<h1><%= i %></h1>
	<% } %>
	
	<h3>The time is: <%= new Date() %></h3>
	
	<h1>Two plus two is: </h1>
	<h2><c:out value="${2+2}"/></h2>
	
	<h1>Fruit of the Day: </h1>
	<h2><c:out value="${fruit}"/></h2>
	
	
	
</body>
</html>