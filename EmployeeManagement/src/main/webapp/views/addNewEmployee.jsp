<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add New Employee</title>
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

		<h3>Add New Employee</h3>
		<hr class="hr_line">
		<form action="/directory/save" method="POST" class="custom-form">
			<p class="h6 mb-4">Enter Employee Details</p>
			<!-- Add hidden form field to handle update -->
			<input type="hidden" name="id" value="${Employee.id}" />
			<div class="form-inline">
				<input type="text" name="firstName" value="${Employee.firstName}"
					class="form-control mb-4 col-4" placeholder="First Name">
			</div>
			<div class="form-inline">
				<input type="text" name="lastName" value="${Employee.lastName}"
					class="form-control mb-4 col-4" placeholder="Last Name">
			</div>
			<div class="form-inline">
				<input type="email" name="email" value="${Employee.email}"
					class="form-control mb-4 col-4" placeholder="Email">
			</div>
			<div class="form-inline">
				<input type="tel" name="phone" value="${Employee.phone}"
					class="form-control mb-4 col-4" placeholder="Phone">
			</div>
			<div class="form-inline">
				<input type="text" name="department" value="${Employee.department}"
					class="form-control mb-4 col-4" placeholder="Department">
			</div>
			<div class="form-inline">
				<input type="date" name="dob" value="${Employee.dob}"
					class="form-control mb-4 col-4" placeholder="Date of Birth">
			</div>
			<div class="form-inline">
				<input type="date" name="doj" value="${Employee.doj}"
					class="form-control mb-4 col-4" placeholder="Date of Joining">
			</div>
			<input name="${_csrf.parameterName }" type="hidden"
				value="${_csrf.token}" />
			<button type="submit" class="btn btn-info col-2">Save</button>

		</form>

		<hr>
		<a href="/directory/employees" class="btn btn-secondary btn-sm">Back to Employee List</a>

	</div>
</body>
</html>