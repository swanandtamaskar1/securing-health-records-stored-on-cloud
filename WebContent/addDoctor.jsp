<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlockChain-Add Doctor</title>


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
					<h3 class="panel-title">Add New Doctor</h3>
				</div>
				<div class="panel-body">
					<form action="RegistrationServlet" method="post">
						<div class="row" style="margin-top: 15px;">
							<div class="col-sm-4"></div>
							<div class="col-sm-4">
								<div class="form-group has-feedback">
								<label>Dr. Name</label> 
									<input type="text" name="fname" class="form-control"
										placeholder="Dr Name" required value="Swanand"> <span
										class="form-control-feedback"></span>
								</div>
								<div class="form-group has-feedback">
									<label>Email</label> 
									<input type="email" name="email" class="form-control"
										placeholder="Email" required value="swanandtamaskar1@gmail.com"> <span
										class="form-control-feedback"></span>
								</div>
								<!-- <div class="form-group has-feedback">
							        <input type="password" name="password" class="form-control" placeholder="Password" required>
							        <span class="form-control-feedback"></span>
							      </div> -->
								<label>City</label> 
								<input type="hidden" name="address" class="form-control"
									placeholder="City" required>
								
								<div class="form-group has-feedback">
									<input type="text" name="city" class="form-control"
										placeholder="City" required value="Pune"> <span
										class="form-control-feedback"></span>
								</div>
								<label>State</label> 
								<div class="form-group has-feedback">
									<input type="text" name="state" class="form-control"
										placeholder="State" required value="Maharashtra"> <span
										class="form-control-feedback"></span>
								</div>
								<label>Pincode</label> 
								<div class="form-group has-feedback">
									<input type="text" name="pincode" class="form-control"
										placeholder="Pincode" required value="411033"> <span
										class="form-control-feedback"></span>
								</div>
							</div>
						</div>
						<div class="row" style="margin-bottom: 10px;">
							<!-- /.col -->
							<div class="col-sm-5"></div>
							<div class="col-sm-2">
								<button type="submit" name="action" value="signUp"
									class="btn btn-primary btn-block btn-flat">Register</button>
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