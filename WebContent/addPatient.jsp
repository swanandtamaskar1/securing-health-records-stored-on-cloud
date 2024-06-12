<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlockChain-Home</title>


<meta name='description' content=''>
<meta name='viewport'
	content='width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>

<!--Css files-->
<link rel="Stylesheet" href="css/style.css" />
<link rel="Stylesheet" href="css/HCo_fonts.css" />
<link rel="Stylesheet" href="css/bootstrap.css" />
<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
	<jsp:include page="menu.jsp"></jsp:include>

	<div class="container">
		<div class="bodyContainer">
			<div class="panel panel-default mtop20">
				<div class="panel-heading">
					<h3 class="panel-title">Add New Patient</h3>
				</div>
				<div class="panel-body">
					<form action="PatientMasterServlet" method="post">
						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-4">
								<div class="form-group has-feedback">
									<label>First Name</label> <input type="text" name="FIRST_NAME"
										class="form-control input-sm" required value="Suwarna">
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group has-feedback">
									<label>Last Name</label> <input type="text" name="LAST_NAME"
										class="form-control input-sm" required value="Tamaskar">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-4">
								<div class="form-group has-feedback">
									<label>City</label> <input type="text" name="CITY"
										class="form-control input-sm" required value="Mumbai">
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group has-feedback">
									<label>State</label> <input type="text" name="STATE"
										class="form-control input-sm" required value="Maharashtra">
								</div>
							</div>
						</div>


						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-4">
								<div class="form-group has-feedback">
									<label>Pincode</label> <input type="number" name="PINCODE"
										class="form-control input-sm" required value="400050">
								</div>
							</div>
							<div class="col-sm-4">
								<div class="form-group has-feedback">
									<label>Contact No</label> <input type="number"
										name="CONTACT_NO" class="form-control input-sm" required value="2345474476">
								</div>
							</div>
						</div>

						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-4">
								<div class="form-group has-feedback">
									<label>Email</label> <input type="text" name="EMAIL"
										class="form-control input-sm" required value="tamaskarsuwarna@gmail.com">
								</div>
							</div>

						</div>

						<div class="row">
							<div class="col-sm-2"></div>
							<div class="col-sm-2">
								<div class="form-group has-feedback">
									<label>Age</label> <input type="number" name="AGE"
										class="form-control input-sm" required value="45">
								</div>
							</div>
							<div class="col-sm-2">
								<div class="form-group has-feedback">
									<label>Weight in kg</label> <input type="number" name="WEIGHT"
										class="form-control input-sm" required value="65">
								</div>
							</div>
							<div class="col-sm-2">
								<div class="form-group has-feedback">
									<label>Height in cm</label> <input type="number" name="HEIGHT"
										class="form-control input-sm" required value="172">
								</div>
							</div>
							<div class="col-sm-2">
								<div class="form-group has-feedback">
									<label>Blood Group</label> <input type="text"
										name="BLOOD_GROUP" class="form-control input-sm" required value="B+">
								</div>
							</div>
						</div>
						<div class="row" style="margin-bottom: 10px;">
							<!-- /.col -->
							<div class="col-sm-5"></div>
							<div class="col-sm-2">

								<button type="submit" class="btn btn-primary btn-block btn-flat"
									name="action" value="Save">Submit</button>
							</div>
							<!-- /.col -->
						</div>

					</form>

				</div>
			</div>
		</div>
	</div>

	<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>