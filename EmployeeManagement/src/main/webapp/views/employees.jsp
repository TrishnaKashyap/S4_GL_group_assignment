<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Directory</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-Zenh87qX5JnK2Jl0vWa8Ck2rdkQ2Bzep5IDxbcnCeuOxjzrPF/et3URy9Bv1WTRi"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.0/css/all.min.css"
	integrity="sha512-xh6O/CkQoPOWDdYTDqeRdPCVd1SpvCA9XXcUnZS2FmJNp1coAFzvtCN9BmamE+4aHK8yyUHUSCcJHgXloTyT2A=="
	crossorigin="anonymous" referrerpolicy="no-referrer" />

</head>
<body>
	<div class='container'>
		<h3 class="text-center">All Employees</h3>
		<hr
			style="background: orange; opacity: 1; height: 1px; border: none; width: 20%; margin: 1rem auto" />

		<form action="/directory/search" class="form-inline"
			style="display: flex; justify-content: space-between; align-items: center; width: 100%">
			<div>
				<input type="search" name="firstName" placeholder="Name" required
					class="form-control-sm ml-5 mr-2" />

				<button type="submit" class="btn btn-success btn-sm">Search</button>
				<a href="/directory/add-employee" class="btn btn-primary btn-sm">
					New Employee </a>
			</div>
			<a href="/logout" class="btn btn-primary btn-sm"> Logout </a>
		</form>

		<h1>List Of Employees</h1>
		<table class="table table-hover table-dark text-center">
			<thead>
				<tr>
					<th>Name</th>
					<th>Email</th>
					<th>Phone</th>
					<th>Department</th>
					<th>Date Of Birth</th>
					<th>Date Of Joining</th>
					<th>Action</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${Employees}" var="emp">
					<tr>
						<td><c:out value="${emp.firstName} ${emp.lastName}" /></td>
						<td><c:out value="${emp.email}" /></td>
						<td><c:out value="${emp.phone}" /></td>
						<td><c:out value="${emp.department}" /></td>
						<td><c:out value="${emp.dob}" /></td>
						<td><c:out value="${emp.doj}" /></td>
						<td><a href="/directory/edit-employee?id=${emp.id}"
							class="btn btn-secondary btn-sm" style="color: #fff"><i
								class="fa-solid fa-pen-to-square"></i></a> <a
							href="/directory/delete?id=${emp.id}"
							class="btn btn-warning btn-sm"
							onclick="if (!(confirm('Are you sure you want to delete this employee?'))) return false"
							style="color: red"><i class="fa-solid fa-trash"></i></a></td>
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