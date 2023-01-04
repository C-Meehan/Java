<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="header">
		<h1>Your Gold: <c:out value="${current}"/></h1>
	</div>
	<div class="location-container">
		<div>
			<form action="/farm" method="POST">
				<label>Farm</label>
				<label>(earns 10-20 gold)</label>
				<input type="submit" value="Find Gold!"/>
			</form>
		</div>
		<div>
			<form action="/cave" method="POST">
				<label>Cave</label>
				<label>(earns 5-10 gold)</label>
				<input type="submit" value="Find Gold!"/>
			</form>
		</div>
		<div>
			<form action="/house" method="POST">
				<label>House</label>
				<label>(earns 2-5 gold)</label>
				<input type="submit" value="Find Gold!"/>
			</form>
		</div>
		<div>
			<form action="/quest" method="POST">
				<label>Quest</label>
				<label>(earns/takes 0-50 gold)</label>
				<input type="submit" value="Find Gold!"/>
			</form>
		</div>
	</div>
	<div class="footer">
		<h2>Activities:</h2>
		<div class="activites">
			<p>PLACEHOLDER INFO FOR NOW</p>
		</div>
	</div>
</body>
</html>