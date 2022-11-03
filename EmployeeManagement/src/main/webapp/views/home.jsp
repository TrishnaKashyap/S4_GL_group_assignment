<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Home Page</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<style>
button {
	width: 30%;
}
</style>
</head>
<body>
	<div class="container-xl">
		<div
			style="display: flex; justify-content: space-between; align-items: center; margin: 2rem">
			<h1>Hey Admin! Welcome to the dashboard.</h1>
			<a href="/logout" class="btn btn-primary btn-sm mb-3"> Logout </a>
		</div>
		<hr style="background: orange; height: 1px; border: none" />
		<div class="text-center">
			<button class="btn btn-primary btn-sm">
				<a href="/directory/employees"
					style="color: #fff; text-decoration: none;">See Employee
					Directory</a>
			</button>
			<button class="btn btn-secondary btn-sm">
				<a href="/api/user/fetchAllUsers"
					style="color: #fff; text-decoration: none">See User Directory</a>
			</button>
			<button class="btn btn-info btn-sm">
				<a href="api/role/fetchAllRoles"
					style="color: #fff; text-decoration: none">See Role Directory</a>
			</button>
		</div>
	</div>
</body>
</html>