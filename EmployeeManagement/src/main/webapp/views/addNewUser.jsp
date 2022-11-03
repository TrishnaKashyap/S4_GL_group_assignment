<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New User</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<style>
form.custom-form {
	width: 40%;
	margin: 0 auto;
	background: #edecec;
	padding: 2rem;
	border-radius: 10px;
	text-align: center;
}

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
	<div class="container text-center">

		<h3>Add New User</h3>
		<hr class="hr_line">
		<form action="/api/user/save" method="POST" class="custom-form">
			<input type="hidden" name="id" value="${User.id}" />
			<div class="form-inline">
				<input type="text" name="username" value="${User.username}"
					class="form-control mb-4 col-4" placeholder="Username">
			</div>
			<div class="form-inline">
				<input type="password" name="password" value="${User.password}"
					class="form-control mb-4 col-4" placeholder="Password">
			</div>
			<div class="form-inline">
				<select name="roles" class="form-select mb-4 col-4">
					<option value="-1">Select role</option>
					<c:forEach items="${Roles}" var="role">
						<option value="<c:out value="${role.id}" />"><c:out value="${role.name}" /></option>
					</c:forEach>
				</select>
			</div>
			<input name="${_csrf.parameterName }" type="hidden"
				value="${_csrf.token}" />
			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/api/user/fetchAllUsers" class="btn btn-secondary btn-sm">Back
			to All Users</a>

	</div>
</body>
</html>