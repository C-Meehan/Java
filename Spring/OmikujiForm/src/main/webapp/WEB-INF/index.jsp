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
	<h1>Send an Omikuji</h1>
	<form action="/omikuji/complete" method="POST">
	<div>
		<label>Pick any number from 5 to 25</label>
		<input type="number" name="number"/>
	</div>
	<div>
		<label>Enter the name of any city.</label>
		<input type="text" name="city"/>
	</div>
	<div>
		<label>Enter the name of any real person</label>
		<input type="text" name="person"/>
	</div>
	<div>
		<label>Enter professional endeavor or hobby:</label>
		<input type="text" name="hobby"/>
	</div>
	<div>
		<label>Enter any type of living thing</label>
		<input type="text" name="living"/>
	</div>
	<div>
		<label>Say something nice to someone</label>
		<textarea name="compliment" id="" cols="30" rows="10"></textarea>
	</div>
	<label>Send and show a friend</label>
	<input type="submit" name="Send"/>
	</form>
</body>
</html>