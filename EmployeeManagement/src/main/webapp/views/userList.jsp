<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Users Directory</title>
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
		<h3>All Users</h3>
		<hr class="hr_line">

		<!-- Add a button -->
		<div class="d-flex justify-content-between">
			<a href="/api/user/addUser" class="btn btn-primary btn-sm mb-3"
				style="width: 150px"> New User </a> <a href="/logout"
				class="btn btn-primary btn-sm mb-3" style="width: 150px"> Logout
			</a>
		</div>

		<h1>List Of Users</h1>
		<table class="table table-bordered table-dark">
			<thead>
				<tr>
					<th>ID</th>
					<th>Username</th>
					<th>Role</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Users}" var="user">
					<tr>
						<td><c:out value="${user.id}" /></td>
						<td><c:out value="${user.username}" /></td>
						<td><c:forEach items="${user.roles}" var="role">
								<c:out value="${role.name}" />
							</c:forEach></td>
						<td><a href="/api/user/edit?id=${user.id}"
							class="btn btn-warning btn-sm"> Update </a> <!-- Add "delete" button/link -->
							<a href="/api/user/delete?id=${user.id}"
							class="btn btn-danger btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this user?'))) return false">
								Delete </a></td>
					</tr>
				</c:forEach>

			</tbody>
		</table>
		<sec:authorize access="hasRole('ADMIN')">
			<a href="/dashboard" class="btn btn-secondary btn-sm">Dashboard</a>
		</sec:authorize>
	</div>
</body>
</html>