<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="/css/style.css"/>
<title>Insert title here</title>
</head>
<body>
	<div class="main">
		<h1>Fruit Store</h1>
		<div class="background">
			<table>
				<tr>
					<th>
						Name
					</th>
					<th>
						Price
					</th>
				</tr>
				<c:forEach var="fruits" items= "${fruits}"> 
				<tr>
					<td><c:out value="${fruits.name}"/></td>
					<td><c:out value="${fruits.price}"/></td>
				</tr>
				</c:forEach>
			</table>
		</div>
	</div>
</body>
</html>