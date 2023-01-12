<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${dojo.name}"/></title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
<script type="text/javascript" src="/js/app.js"></script>
</head>
<body>
	<h1><c:out value="${dojo.name}"/> Location Ninjas</h1>
	<table class="table table-striped table-bordered">
  <thead>
    <tr>
      <th scope="col">First Name</th>
      <th scope="col">Last Name</th>
      <th scope="col">Age</th>
    </tr>
  </thead>
  <tbody>
	  <c:forEach var="ninja" items="${dojo.ninja}">
	    <tr>
	      <th scope="row"><c:out value="${ninja.firstName}"/></th>
	      <td><c:out value="${ninja.lastName}"/></td>
	      <td><c:out value="${ninja.age}"/></td>
	    </tr>
	  </c:forEach>
  </tbody>
</table>
	<a href="/ninja/new">Create Ninja</a>
	<a href="/dojos/new">Create Dojo</a>
</body>
</html>