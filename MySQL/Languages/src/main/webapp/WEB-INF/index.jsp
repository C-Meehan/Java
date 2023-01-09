<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page isErrorPage="true" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>HomePage</title>
<link rel="stylesheet" href="/webjars/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" href="/css/style.css">
<script src="/webjars/jquery/jquery.min.js"></script>
<script src="/webjars/bootstrap/js/bootstrap.min.js"></script>
</head>
	<body>
   		<div class="main-container">
			<div class="main-top">
				<table class="table table-dark table-striped table-bordered border-warning">
					<thead>
						<tr>
					    	<th scope="col">Name</th>
					    	<th scope="col">Creator</th>
					    	<th scope="col">Version</th>
					    	<th scope="col">Actions</th>
					    </tr>
					</thead>
					<tbody>
					<c:forEach var="language" items="${languages}">
						<tr>
					    	<td scope="row"><a href="/languages/${language.id}"><c:out value="${language.name}"/></a></td>
					    	<td><c:out value="${language.creator}"/></td>
					    	<td><c:out value="${language.version}"/></td>
					    	<td class="actions">
					    	<form action="/languages/${language.id}/delete" method="post">
					    		<input type="hidden" name="_method" value="delete">
					    		<button class="delete">delete</button>
					    	</form>
					    	<a href="/languages/${language.id}/edit">edit</a>
					    	</td>
					    </tr>
					</c:forEach>
					</tbody>
				</table>
			</div>
			<div class="main-bottom">
			<form:form action="/language" method="POST" modelAttribute="language">
				<div class="form">
					<form:label path="name">Name:</form:label>
					<form:input type="text" path="name"/>
					<form:errors path="name" class="text-warning"/>
				</div>
				<div class="form">
					<form:label path="creator">Creator:</form:label>
					<form:input type="text" path="creator"/>
					<form:errors path="creator" class="text-warning"/>
				</div>
				<div class="form">
					<form:label path="version">Version:</form:label>
					<form:input path="version"/>
					<form:errors path="version" class="text-warning"/>
				</div>
				<button class="submit">Submit</button>
			</form:form>
		</div>
		</div>
	</body>
</html>

