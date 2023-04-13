<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Report Generation</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ"
	crossorigin="anonymous">

<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	text-align: center;
	padding: 10px;
}
</style>

</head>



<body>

	<div class="container">
		<h3 class="pb-3 pt-3">Report Application</h3>

		<form:form action="search" modelAttribute="searchRequest"
			method="POST">
			<table>
				<tr>
					<td>Plan Name:</td>
					<td><form:select path="planName">
							<form:option value="" label="-Select Plan-" />
							<form:options items="${name}" />
						</form:select></td>

					<td>Plan Status:</td>
					<td><form:select path="planStatus">
							<form:option value="" label="-Select Status-" />
							<form:options items="${status}" />
						</form:select></td>

					<td>Gender:</td>
					<td><form:select path="gender">
							<form:option value="">-Select-</form:option>
							<form:option value="Male">Male</form:option>
							<form:option value="Female">Female</form:option>

						</form:select></td>
				</tr>

				<tr>
					<td>Start Date:</td>
					<td><form:input path="startDate" type="date" /></td>
					<td>End Date:</td>
					<td><form:input type="date" path="endDate" /></td>
				</tr>

				<tr>
					<td><input type="submit" value="Search"
						class="btn btn-primary"></td>
					<td><a href="/" type="reset" class="btn btn-secondary">Reset</a></td>
					<td>Export:</td>
					<td><a href="/excel" class="btn btn-info">Excel</a> <a href="/pdf"
						class="btn btn-dark">Pdf</a></td>

				</tr>



			</table>

		</form:form>
		<hr />
		<table class="table table-striped table-hover">
			<thead>
				<tr>
					<th>S.No.</th>
					<th>Holder Name</th>
					<th>Gender</th>
					<th>Plan Name</th>
					<th>Plan Status</th>
					<th>Start Date</th>
					<th>End Date</th>
					<th>Benefit Amount</th>
					<th>Denial Reason</th>
					<th>Termination Reason</th>
				</tr>
			</thead>

			<tbody>
				<c:forEach items="${dynamicSearch}" var="dynamicSearch"
					varStatus="index">
					<tr>
						<td>${index.count}</td>
						<td>${dynamicSearch.name}</td>
						<td>${dynamicSearch.gender}</td>
						<td>${dynamicSearch.planName}</td>
						<td>${dynamicSearch.planStatus}</td>
						<td>${dynamicSearch.startDate}</td>
						<td>${dynamicSearch.endDate}</td>
						<td>${dynamicSearch.benifitAmount}</td>
						<td>${dynamicSearch.denialReason}</td>
						<td>${dynamicSearch.terminationReason}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<hr />

	</div>












	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe"
		crossorigin="anonymous"></script>
</body>
</html>