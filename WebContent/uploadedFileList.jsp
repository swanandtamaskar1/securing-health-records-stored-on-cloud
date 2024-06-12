<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.*,com.login.pojo.*"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<!--Css files-->
<!--  <link rel="Stylesheet" href="assets/css/style.css"/> 
   
    <link rel="Stylesheet" href="assets/bootstrap/css/bootstrap.css" />
    <link rel="Stylesheet" href="assets/font-awesome/css/font-awesome.css" />

    Js Files
    <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
    <script type="text/javascript" src="js/jquery-ui.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script> -->
<!--   <script type="text/javascript" src="scripts/datepicker.js"></script> -->
<!--  <script type="text/javascript" src="scripts/jquery.nicescroll.js"></script> -->

<meta name='description' content=''>
<meta name='viewport'
	content='width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
<link rel="icon" href="images/Events.png" type="image/gif" sizes="16x16" />
<!--Css files-->
<link rel="Stylesheet" href="styles/style.css" />
<link rel="Stylesheet" href="styles/datepicker.css" />
<link rel="Stylesheet" href="styles/bootstrap.css" />
<!--  <link rel="Stylesheet" href="styles/font-awesome.css" /> -->
<link rel="Stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css" />
<!--Js Files-->
<script type="text/javascript" src="scripts/jquery-2.1.3.min.js"></script>
<script type="text/javascript" src="scripts/jquery-ui.js"></script>
<script type="text/javascript" src="scripts/bootstrap.js"></script>
<script type="text/javascript" src="scripts/datepicker.js"></script>
<script type="text/javascript" src="scripts/jquery.nicescroll.js"></script>
<script type="text/javascript" src="scripts/site.js"></script>




<script type="text/javascript">
	$(document).ready(function() {

		//   var viewKey=$("#viewKey").val();
		//  var mailedKey=$("#mailedKey").val();
		var userInop = $("#userInput").val();

		//alert(userInop);
		if (typeof userInop === "undefined") {
			$("#viewKeyDiv").show();
			$("#formwise").hide();

		} else {
			$("#viewKeyDiv").hide();
			$("#formwise").show();
		}

	});
	function checkCode(code) {

		var userInputViewKey = $("#userInputViewKey").val();
		if (code == userInputViewKey) {

			$("#viewKeyDiv").hide();
			$("#formwise").show();

			$.ajax({
				type : "get",
				url : "SetViewKeyInsession",
				data : {
					userInputViewKey : code
				},
				success : function(abc) {

				}
			});

		} else {

			var count = 0;
			var button = document.getElementById("countButton");
			var display = document.getElementById("displayCount");
			var status = "blocked";
			button.onclick = function() {
				count++;
				alert("wrong key");
				if (count == 3) {

					alert("Your Blocked")

					$
							.ajax({
								type : "POST",
								url : "UpdateStatusServlet?action=UpdateBlockUserStatus&status="
										+ status,
								data : {
									userInputViewKey : code
								},
								success : function(abc) {

									location.href = "Login.jsp";

								}
							});

				}

				// display.innerHTML = count;
			}

		}

	}
</script>


<script>
	function getKeyByMail(fileName, id) {
		alert(fileName);

		$.ajax({
			type : "post",
			url : "SendKeyViaEmailServlet",
			data : {
				fileName : fileName,
				id : id
			},
			success : function(abc) {

			}
		});
		location.href = "uploadListServlet?action=view";

	}

	function GetFile(id) {
		//alert(fileName);
		var fileName = $("#fileName").val();
		var secretKey = $("#secretKey").val();
		var mailedKey = $("#mailedKey").val();
		if (secretKey == mailedKey) {

			$("#SecretKeyDiv").hide();
			//location.reload();
			location.href = "DownloadFile?id=" + id + "&knum=" + secretKey
					+ "&name=" + fileName;
		} else {
			alert("wrong key");

		}
	}
</script>


</head>
<body
	background="http://wallpaperscraft.com/image/london_ride_river_house_dock_9656_3840x2400.jpg?orig=3">


	<div class="siteWrapper">
		<header class="header"
			style="background: -webkit-linear-gradient(left, #C9AA54, #6D8475, #A00816); min-height: 70px;">
			<div class="company-logo col-sm-2 text-center">

				<a href="admin_home.jsp" title="Home"> </a>
			</div>
			<div class="user col-sm-4 text-right">
				<label>Welcome:: </label> <a href="LogoutServletMaster"
					class="sign-out"> Sign Out <i class="fa fa-sign-out"></i></a>
			</div>
		</header>
		<nav class="menu nav">
			<div class="container">
				<ul>
					<li><a href="uploadImage.jsp">Home</a></li>
					<!-- <li><a href="AddRuleRegServlet?action=rules&showId=">Rules & Regulation</a></li>
      <li><a href="AddRuleRegServlet?action=timeLine&showId=">Timeline</a></li>
      <li><a href="AdminMasterServlet?Action=AdminExhibitorData">Exhibitors Data</a></li>
      <li  class="active"><a href="ReportFormMasterServlet?Action=getFormReportByShowId">Report</a></li> -->
				</ul>
			</div>
		</nav>

		<section class="container">
			<div class="bodyContainer">
				<div class="panel panel-default mtop20">
					<div class="panel-heading">
						<h3 class="panel-title">Hybrid Cloud Approach For Secure Authorized Deduplication</h3>
					</div>
					<div class="panel-body">
						<!--     <ul>
           <li class="active"><a href="#tab1" data-toggle="tab" aria-expanded="true">Home</a></li>
                 <li class=""><a href="#tab2" data-toggle="tab" aria-expanded="false">upload Data</a></li>
                  <li class=""><a href="#tab3" data-toggle="tab" aria-expanded="false">Download</a></li>

       </ul>  -->
						<div class="tab-content">
							<div class="tab-pane form-group active" id="tab1">
								<div class="panel-body" id="viewKeyDiv">
									<div class="table-responsive col-sm-8">
										<div class="col-sm-4" id="">
											<input type="hidden" id="viewKey"
												value="<%=(String) session.getAttribute("viewKey")%>" /> <label>Enter
												Code :</label> <br> <input type="text" id="userInputViewKey"
												class="form-control"> <input type="button"
												class="btn btn-primary" value="submit" id="countButton"
												onclick="checkCode('<%=(String) session.getAttribute("viewKey")%>')">
											<input type="hidden" id="displayCount" value="0" />
										</div>
									</div>
								</div>
								<div class="panel-body" id="formwise">
									<div class="table-responsive col-sm-8">
										<table class="table">
											<tr>
												<th>FILE NAMES</th>
												<th>DOWNLOAD</th>
											</tr>
											<%
											List uploadedList = (List) session.getAttribute("uploadedList");
											if (uploadedList != null && uploadedList.size() > 0) {
												for (int i = 0; i < uploadedList.size(); i++) {
													ImageUplaod imageUpload = (ImageUplaod) uploadedList.get(i);
											%>

											<tr>
												<td><%=imageUpload.getPATH()%></td>
												<td><a
													onclick="getKeyByMail('<%=imageUpload.getPATH()%>','<%=imageUpload.getFile_id()%>')"
													class="export"><i class="fa fa-download"></i></a></td>

											</tr>

											<!--  <tr>
                                <td><a href="javascript:;">Form 2</a></td>
                                <td><a href="javascript:;" class="export"><i class="fa fa-download"></i></a></td>
                            </tr>
                             <tr>
                                <td><a href="javascript:;">Form 3</a></td>
                                <td><a href="javascript:;" class="export"><i class="fa fa-download"></i></a></td>
                            </tr> -->
											<%
											}
											}
											%>
										</table>
										<br>
										<br>
										<br>
										<br>
										<br>
										<br>
										<%
										if (session.getAttribute("key") != null)

										{
										%>

										<div class="col-sm-4" id="SecretKeyDiv">
											<input type="hidden" id="mailedKey"
												value="<%=(String) session.getAttribute("key")%>" /> <label>Enter
												Code :</label> <br> <input type="text" id="secretKey"
												class="form-control"> <input type="button"
												class="btn btn-primary" value="GetFile" id="countButton_1"
												onclick="GetFile('<%=(String) session.getAttribute("id")%>')">
											<input type="hidden" id="fileName"
												value="<%=session.getAttribute("fileName")%>"></input> <input
												type="hidden" id="displayCount_1" value="0" />
										</div>
										<%
										}
										%>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
			<%
			if (session.getAttribute("userInput") != null) {
			%>
			<input type="hidden" id="userInput"
				value="<%=session.getAttribute("userInput")%>" class="form-control">
			<%
			}
			%>
		</section>


		<!-- <footer class="footer">
     <div id="powered" class="copyright text-right"><i class="fa fa-shield"></i></div> 
</footer> -->
		<!--[if lt IE 7]>
      <p class="browsehappy">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->

	</div>
	<script type="text/javascript">
		$(document).ready(function() {

			$('#search').keyup(function() {
				searchTable($(this).val());
			});
		});

		function searchTable(inputVal) {
			var table = $('#tblData');
			table.find('tr').each(function(index, row) {
				var allCells = $(row).find('td');
				if (allCells.length > 0) {
					var found = false;
					allCells.each(function(index, td) {
						var regExp = new RegExp(inputVal, 'i');
						if (regExp.test($(td).text())) {
							found = true;
							return false;
						}
					});
					if (found == true) {
						$(row).show();
						$('#nodata').hide();
					} else {
						$(row).hide();
						$('#nodata').show();
					}
				}
			});
		}
	</script>
</body>
</html>