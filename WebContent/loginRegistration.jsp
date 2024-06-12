<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>

<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
		<title>BlockChain-Home</title>
		<meta name='description' content=''>
		<meta name='viewport' content='width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
	
		<!--Css files-->
		<link rel="Stylesheet" href="css/style.css" />
		<link rel="Stylesheet" href="css/HCo_fonts.css" />
		<link rel="Stylesheet" href="css/bootstrap.css" />
		<script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
		<script type="text/javascript" src="js/bootstrap.js"></script>
		<style type="text/css">
		.login-box, .register-box {
			width: 400px;
			margin: 10% auto;
			margin-top: 25px;
			padding-top: 0px;
		}
		.login-box-body, .register-box-body {
			background: #fff;
			padding: 20px;
			border-top: 0;
			color: #666;
		}
		</style>
	</head>
	
	<body>
		<div class="navbar" style="background-color: #222d32;">
			<div class="container">
				<div class="navbar-collapse collapse">
					<ul class="nav navbar-nav">
						<li class="projectName"><a onclick="return false;">Data Security In Cloud Using Blockchain</a></li>
					</ul>
				</div>
			</div>
		</div>
		<div class="container" style="overflow: hidden;">
	
			<!-- login block -->
	
			<div class="login-box" id="logBox">
				<div class="login-box-body">
					<p class="login-box-msg">Sign in to start your session</p>
					<label style="color: red;">${message}</label>
					<form action="RegistrationServlet" method="post">
						<div class="form-group has-feedback">
							<select class="form-control" name="role">
								<option value="Admin">Admin</option>
								<option value="Doctor">Doctor</option>
								<option value="Patient">Patient</option>
							</select>
						</div>
	
						<div class="form-group has-feedback">
							<input type="email" name="uname" class="form-control"
								placeholder="Email" required value="swanandtamaskar1@gmail.com"> <span
								class="glyphicon glyphicon-envelope form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<input type="password" name="password" class="form-control"
								placeholder="Password" required value="6rrzjK9H"> 
							<span class="glyphicon glyphicon-lock form-control-feedback"></span>
						</div>
						<div class="row" style="margin-bottom: 10px;">
							<!-- /.col -->
							<div class="col-xs-4">
								<button type="submit" name="action" value="login"
									class="btn btn-primary btn-block btn-flat">Sign In</button>
							</div>
							<!-- /.col -->
						</div>
					</form>
					<!-- <a onclick="toggle(2);"
						style="text-decoration: none; cursor: pointer;" class="text-center">I
						forgot my password</a><br> -->
					<!-- <a onclick="toggle(0);" style="text-decoration:none;cursor: pointer;" class="text-center">Register a new membership</a> -->
				</div>
			</div>
	
			<!-- Forget password block -->
			<div class="login-box" style="display: none;" id="forgetPassBox"> <!--  -->
				<div class="login-box-body">
					<p class="login-box-msg">Enter your email address</p>
					<label style="color: red;" id="forgetPassMsg"></label>
					<form action="RegistrationServlet" method="post">
						<div class="form-group has-feedback">
							<input type="email" name="emailAddress" class="form-control"
								placeholder="Email" required> <span
								class="glyphicon glyphicon-envelope form-control-feedback"></span>
						</div>
	
						<div class="row" style="margin-bottom: 10px;">
							<!-- /.col -->
							<div class="col-xs-4">
								<button type="button" onclick="sendPasswordMail(this);"
									class="btn btn-primary btn-block btn-flat">Submit</button>
							</div>
							<!-- /.col -->
						</div>
					</form>
	
					<a onclick="toggle(1);"
						style="text-decoration: none; cursor: pointer;" class="text-center">Back</a>
				</div>
			</div>
	
	
			<!-- Registration block -->
	
			<div class="login-box" style="display: none;" id="regBox"> <!--  -->
				<div class="login-box-body">
					<p class="login-box-msg">Register a new membership</p>
					<form action="RegistrationServlet" method="post">
	
						<div class="form-group has-feedback">
							<select class="form-control" name="role">
								<option value="Admin">Admin</option>
								<option value="Doctor">Doctor</option>
								<option value="Patient">Patient</option>
							</select>
						</div>
	
						<div class="form-group has-feedback">
							<input type="text" name="fname" class="form-control"
								placeholder="Name" required> <span
								class="form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<input type="email" name="email" class="form-control"
								placeholder="Email" required> <span
								class="form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<input type="password" name="password" class="form-control"
								placeholder="Password" required> <span
								class="form-control-feedback"></span>
						</div>
	
						<input type="hidden" name="address" class="form-control"
							placeholder="City" required>
						<div class="form-group has-feedback">
							<input type="text" name="city" class="form-control"
								placeholder="City" required> <span
								class="form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<input type="text" name="state" class="form-control"
								placeholder="State" required> <span
								class="form-control-feedback"></span>
						</div>
						<div class="form-group has-feedback">
							<input type="text" name="pincode" class="form-control"
								placeholder="Pincode" required> <span
								class="form-control-feedback"></span>
						</div>
						<div class="row" style="margin-bottom: 10px;">
							<!-- /.col -->
							<div class="col-xs-4">
								<button type="submit" name="action" value="signUp"
									class="btn btn-primary btn-block btn-flat">Register</button>
							</div>
							<!-- /.col -->
						</div>
					</form>
					<a onclick="toggle(1)"
						style="text-decoration: none; cursor: pointer;" class="text-center">I already have a membership</a>
				</div>
			</div>
		</div>
	
		<jsp:include page="footer.jsp"></jsp:include>
		
		<script type="text/javascript">
			function toggle(v) {
				$(".login-box").css('display', 'none');
				if (v == 0)
					$("#regBox").css('display', 'block');
				else if (v == 1)
					$("#logBox").css('display', 'block');
				else if (v == 2)
					$("#forgetPassBox").css('display', 'block');
	
			}
	
			function sendPasswordMail(obj) {
	
				$(obj).attr('disabled', true);
	
				var emailAddress = $("input[name='emailAddress']").val();
				if (emailAddress.trim() == "") {
					$("#forgetPassMsg").empty().text("please enter email address");
					$(obj).attr('disabled', false);
					return false;
				}
				$.ajax({
					url : 'RegistrationServlet',
					data : {
						action : "forgetPass",
						emailAddress : emailAddress
					},
					type : 'get',
					success : function(data) {
						$("#forgetPassMsg").empty().text(data);
						$(obj).attr('disabled', false);
					}
	
				});
				
			}
		</script>
	</body>
</html>