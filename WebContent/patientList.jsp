<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlockChain-Patients</title>


<meta name='description' content=''>
<meta name='viewport'
	content='width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>

<!--Css files-->
<link rel="Stylesheet" href="css/style.css" />
<link rel="Stylesheet" href="css/HCo_fonts.css" />
<link rel="Stylesheet" href="css/bootstrap.css" />
<link rel="Stylesheet" href="css/dataTables.bootstrap.css" />

<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
<script type="text/javascript" src="js/jquery.dataTables.min.js"></script>
<script type="text/javascript" src="js/dataTables.bootstrap.min.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="container">
		<div class="bodyContainer">
			<div class="panel panel-default mtop20">
				<div class="panel-heading">
					<h3 class="panel-title">Patient List</h3>
				</div>
				<div class="panel-body">
					<div class="row" style="margin-top: 50px; margin-bottom: 100px;">
						<div class="col-sm-12">
							<table id="patientList"
								class="table table-bordered table-striped hover">
								<thead>
									<tr>
										<th>ID</th>
										<th>Name</th>
										<th>Age</th>
										<th>Contact No.</th>
										<th>City</th>
										<th>State</th>
										<th>Action</th>
										<c:if test="${user.role=='Doctor'}">
											<th>Reports</th>
										</c:if>
									</tr>
								</thead>
								<tbody>
									<c:forEach var="patientMaster" items="${patientMaterList}">
										<tr>
											<td>${patientMaster.id}</td>
											<td>${patientMaster.first_name}
												${patientMaster.last_name}</td>
											<td>${patientMaster.age}</td>
											<td>${patientMaster.contact_no}</td>
											<td>${patientMaster.city}</td>
											<td>${patientMaster.state}</td>
											<td><a
												href="PatientMasterServlet?action=Delete&id=${patientMaster.id}">Delete</a>
												<c:if test="${user.role=='Doctor'}">
													<%-- <a href="PatientMasterServlet?action=Edit&id=${patientMaster.id}">Edit</a> --%>
													<a
														href="PatientMasterServlet?action=View&id=${patientMaster.id}">View</a>
												</c:if></td>
											<c:if test="${user.role=='Doctor'}">
												<td><a
													href="PatientHistoryAndReportsServlet?action=viewReports&patientId=${patientMaster.id}">view</a></td>
											</c:if>
										</tr>

									</c:forEach>

								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">
		$(function() {

			$('#patientList').DataTable({
				"paging" : true,
				"lengthChange" : true,
				"searching" : true,
				"ordering" : true,
				"info" : true,
				"autoWidth" : true
			});
		});
	</script>

</body>
</html>