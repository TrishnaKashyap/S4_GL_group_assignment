<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Role</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
</head>
<body>
	<div class="container">

		<h3>Add New Role</h3>
		<hr>
		<form action="/api/role/save" method="POST">
			<div class="form-inline">
				<input type="text" name="name"
					class="form-control mb-4 col-4" placeholder="Name">
			</div>
			<input name="${_csrf.parameterName }" type="hidden"
				value="${_csrf.token}" />
			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/api/role/fetchAllRoles">Back to All Roles</a>

	</div>
</body>
</html>