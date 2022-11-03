<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Roles Directory</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<style>
.hr_line {
	background: orange;
	height: 1px;
	border: none;
	opacity: 1;
	width: 22%;
	margin: 1rem auto;
}
</style>
</head>
<body>
	<div class='container text-center'>
		<h3>All Roles</h3>
		<hr class="hr_line">

		<div class="d-flex justify-content-between">
			<a href="/api/role/addRole" class="btn btn-primary btn-sm mb-3" style="width: 150px">
				New Role </a> <a href="/logout"
				class="btn btn-primary btn-sm mb-3" style="width: 150px"> Logout </a>
		</div>
		<h1>List Of Roles</h1>
		<table class="table table-bordered table-dark text-center">
			<thead>
				<tr>
					<th>ID</th>
					<th>Name</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Roles}" var="role">
					<tr>
						<td><c:out value="${role.id}" /></td>
						<td><c:out value="${role.name}" /></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<sec:authorize access="hasRole('ADMIN')">
			<a href="/dashboard" class="btn btn-secondary">Dashboard</a>
		</sec:authorize>
	</div>
</body>
</html>