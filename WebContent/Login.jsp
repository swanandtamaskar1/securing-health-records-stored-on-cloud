<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

<head>

<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Hybrid Cloud Approach For Secure Authorized Deduplication</title>

<!-- CSS -->
<link rel="stylesheet"
	href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
<link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet"
	href="assets/font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="assets/css/form-elements.css">
<link rel="stylesheet" href="assets/css/style.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

<!-- Favicon and touch icons -->
<link rel="shortcut icon" href="assets/ico/favicon.png">
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="assets/ico/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="assets/ico/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="assets/ico/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="assets/ico/apple-touch-icon-57-precomposed.png">

<link rel="stylesheet" href="styles/default.min.css" type="text/css"
	media="all" />

<script type="text/javascript"
	src="scripts/jquery.sceditor.bbcode.min.js"></script>
<script src="js/jquery-1.8.3.js"></script>
<script type="text/javascript" src="scripts/validation.js"></script>

</head>
<script>
	$(document).ready(function() {

		$('#signUp').hide();
		$('#show').click(function() {

			$('#loginDiv').hide();
			$('#signUp').show();

		});

	});
</script>

<body background="images/bgImage.jpg">

	<!-- Top menu -->


	<nav class="navbar navbar-inverse navbar-no-bg" role="navigation">
		<div class="container">
			<div class="col-sm-12">
				<div class="navbar-header">
					<button type="button" class="navbar-toggle collapsed"
						data-toggle="collapse" data-target="#top-navbar-1">
						<span class="sr-only">Toggle navigation</span> <span
							class="icon-bar"></span> <span class="icon-bar"></span> <span
							class="icon-bar"></span>
					</button>
				</div>
			</div>



			<!-- Collect the nav links, forms, and other content for toggling -->
			<div class="col-sm-12">

				<div class="form-top">
					<div class="form-top-middle">
						<h4 style="color: white" align="center">Hybrid Cloud Approach
							For Secure Authorized Deduplication</h4>
					</div>

				</div>


			</div>
			<!-- 	<div class="collapse navbar-collapse" id="top-navbar-1">
				
					
					<ul class="nav nav-pills">
   			 		<li class="btn btn-primary"><a href="#">Home</a></li>
    				<li class="btn btn-primary"><a href="#">Menu 1</a></li>
    				<li class="btn btn-primary"><a href="#">Menu 2</a></li>
    				<li class="btn btn-primary"><a href="#">Menu 3</a></li>
  				</ul>
				</div> -->
		</div>
	</nav>

	<!-- Top content -->
	<div class="top-content">
		<div class="inner-bg">
			<div class="container">
				<div class="row">
					<div class="col-sm-3 book"></div>
					<div class="col-sm-6 book" id="loginDiv">
						<div class="form-top">
							<div class="form-top-middle">
								<h3 style="color: white">WELCOME TO LOGIN</h3>
								<p>Fill Login details to get instant access:</p>
							</div>
							<%
							String msg = request.getParameter("Message");
							if (msg == null) {
								msg = "";
							}
							%>
							<label style="color: red;"><%=msg%></label>

							<div class="form-top-right">
								<i class="fa fa-pencil"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="RegistrationServlet" method="post"
								class="registration-form">
								<div class="form-group">
									<label class="sr-only" for="form-first-name">Name</label> <input
										type="text" name="uname" placeholder="USERNAME"
										class="form-first-name form-control" required="required"
										id="form-first-name">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-last-name">Password1 </label>
									<input type="password" name="Password1" placeholder="PASSWORD"
										class="form-last-name form-control" required="required"
										id="form-last-name">
								</div>

								<button type="submit" name="action" value="login" class="btn">Login</button>
								&nbsp;&nbsp;&nbsp;&nbsp;

								<button type="button" name="action" id="show" value="signUp"
									class="btn">Register!</button>
							</form>
						</div>
					</div>
					<div class="col-sm-3 book"></div>
				</div>
				<div class="row">
					<div class="col-sm-3 book"></div>
					<div class="col-sm-6 book" id="signUp">
						<div class="form-top">
							<div class="form-top-left"></div>
							<div class="form-top-right">
								<i class="fa fa-pencil"></i>
							</div>
						</div>
						<div class="form-bottom">
							<form role="form" action="RegistrationServlet" method="post"
								class="registration-form">

								<div class="form-group">
									<label class="sr-only" for="form-email">Select Type</label> <select
										name="role" class="form-control">
										<option value="student">student</option>
										<option value="department">IT department</option>
										<option value="examcell">Exam Cell</option>
										<option value="admin">Admin</option>

									</select>
								</div>

								<div class="form-group">
									<label class="sr-only" for="form-first-name">Name</label> <input
										type="text" name="fname" placeholder="First name"
										class="form-first-name form-control" required="required"
										id="form-first-name">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-last-name">Email </label> <input
										type="text" name="email" class="form-email form-control"
										placeholder="Email" required="required" id="form-last-name">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-email">PASSWORD</label> <input
										type="password" name="PASSWORD"
										class="form-email form-control" placeholder="Password"
										required="required" id="form-email">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-email">ADDRESS</label> <input
										type="text" name="ADDRESS" class="form-email form-control"
										placeholder="Address" required="required" id="form-email">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-email">State</label> <input
										type="text" name="state" class="form-email form-control"
										placeholder="State" required="required" id="form-email">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-email">city</label> <input
										type="text" name="city" class="form-email form-control"
										placeholder="city" required="required" id="form-email">
								</div>
								<div class="form-group">
									<label class="sr-only" for="form-email">PINCODE</label> <input
										type="text" name="PINCODE"
										class="form-email form-control onlyNumberWithOutDecimal"
										placeholder="pincode" required="required" id="form-email">
								</div>
								<button type="submit" name="action" value="signUp" class="btn">Save</button>
							</form>
						</div>
					</div>
					<div class="col-sm-3 book"></div>
				</div>
			</div>
		</div>
	</div>

	<!-- Javascript -->
	<script src="assets/js/jquery-1.11.1.min.js"></script>
	<script src="assets/bootstrap/js/bootstrap.min.js"></script>
	<script src="assets/js/jquery.backstretch.min.js"></script>
	<script src="assets/js/retina-1.1.0.min.js"></script>
	<script src="assets/js/scripts.js"></script>

	<!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->
</body>

</html>