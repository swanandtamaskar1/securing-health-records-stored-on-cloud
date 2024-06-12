<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlockChain-Reports</title>


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
					<h3 class="panel-title">Reports</h3>
				</div>
				<div class="panel-body">
					<div class="row" style="margin-top: 50px; margin-bottom: 80px;">
						<div class="col-sm-12 commonDiv" id="otpDiv"
							style="display: none;">
							<div class="row">
								<div class="col-sm-4"></div>
								<div class="col-sm-4">
									<label>Enter OTP Here </label> <input type="hidden"
										class="form-control" id="sentOtp" /><br> <input
										type="text" class="form-control" id="otp" /><br> <input
										type="hidden" id="reportId"> <a href="#"
										onclick="sendOtp();">Re-send OTP</a>
								</div>
							</div>

							<div class="row" style="margin-top: 10px;">
								<div class="col-sm-4"></div>
								<div class="col-sm-2">
									<button type="button" class="btn btn-default"
										onclick="closeOtpDiv();">Back</button>
								</div>
								<div class="col-sm-2">
									<button type="button" onclick="downloadFile()"
										class="btn btn-success">Download</button>
								</div>
							</div>

						</div>
						<div class="col-sm-12 commonDiv" id="listDiv">
							<c:if test="${user.role=='Doctor'}">
								<div style="margin-bottom: 8px;">
									<a href="PatientMasterServlet?action=GetAllList"><button
											type="button" class="btn btn-primary">Back to
											patients</button></a>
								</div>
							</c:if>


							<table id="reportList"
								class="table table-bordered table-striped hover">
								<thead>
									<tr>
										<th>No</th>
										<th>Report name</th>
										<th>Report Date</th>
										<th>Attachment</th>
										<c:if test="${user.role=='Doctor'}">
											<th>Download</th>
										</c:if>
										<c:if test="${user.role=='Patient'}">
											<th>Download</th>
											<th>Action</th>
										</c:if>

									</tr>
								</thead>
								<tbody>
									<c:set var="i" value="1"></c:set>
									<c:forEach var="patientReport" items="${PatientReportList}">
										<tr>
											<td>${1}</td>
											<td>${patientReport.report}</td>

											<td><fmt:formatDate pattern="dd-MM-yyyy"
													value="${patientReport.reportDate}" /></td>
											<td>${patientReport.reportFileName}</td>
											<c:if test="${user.role=='Doctor'}">
												<td><a onclick="openOtpModal(${patientReport.id});">Download</a></td>
											</c:if>
											<c:if test="${user.role=='Patient'}">
												<td><a href="DownloadFile?id=${patientReport.id}">Download</a></td>
												<%-- <td><button type="button"  class="btn btn-danger btn-sm" onclick="deleteFile(this,'${patientReport.id}','${patientReport.patient_id}');" >Delete </button></td> --%>
												<td><a
													href="PatientReportServlet?reportId=${patientReport.id}">Delete</a>
												</td>
											</c:if>

										</tr>
										<c:set var="i" value="${i + 1}"></c:set>
									</c:forEach>
								</tbody>
							</table>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<!-- Modal -->

	<jsp:include page="footer.jsp"></jsp:include>
	<script type="text/javascript">


$(function () {
 
  $('#reportList').DataTable({
    "paging": true,
    "lengthChange": true,
    "searching": true,
    "ordering": true,
    "info": true,
    "autoWidth": true
  }); 
});
function closeOtpDiv(){
	$("#sentOtp").val(0);
	$(".commonDiv").css('display','none');
	$("#listDiv").css('display','block');
}
var reportId = null;
function sendOtp(){
	$.ajax({
		url:"${pageContext.request.contextPath}/PatientHistoryAndReportsServlet?action=sendOtp&reportId="+reportId,
		method:"get",
		success:function(otp){
			$("#sentOtp").val(otp.trim());
		}
	});
}
function openOtpModal(repId){
	reportId = repId;
	$("#reportId").val(repId);
	sendOtp(repId);
	$(".commonDiv").css('display','none');
	$("#otpDiv").css('display','block');
}

function downloadFile(){
	var reportId = $("#reportId").val();
	if($("#sentOtp").val()==$("#otp").val()){
			location.href = "${pageContext.request.contextPath}/DownloadFile?id="+reportId;
			closeOtpDiv();
	}else{		
		alert("Please Enter correct otp");
	}
}

/* function deleteFile(obj,id,patientId){
	
	$.ajax({
		url:"${pageContext.request.contextPath}/PatientReportServlet?reportId="+id,
		method:"get",
		success:function(){
			alert(12)
			location.href ="${pageContext.request.contextPath}/PatientMasterServlet?action=viewReports&patientId="+patientId;
		}
	});
	
	
} */
</script>

</body>
</html>