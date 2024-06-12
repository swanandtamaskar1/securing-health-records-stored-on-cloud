<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlockChain-patient details</title>

   
     <meta name='description' content=''>
    <meta name='viewport' content='width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
      
    <!--Css files-->
    <link rel="Stylesheet" href="css/style.css"/> 
    <link rel="Stylesheet" href="css/HCo_fonts.css" /> 
    <link rel="Stylesheet" href="css/bootstrap.css" />
    <script type="text/javascript" src="js/jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="js/bootstrap.js"></script>
</head>
<body>
    <jsp:include page="menu.jsp"></jsp:include>
	
    <div class="container" > 
        <div class="bodyContainer">
        <div class="panel panel-default mtop20">
		<div class="panel-heading">
          <h3 class="panel-title">Patient History</h3>
        </div>
         <div class="panel-body">
         <div class="row" style="margin-top: 50px;margin-bottom: 20px;">
           <div class="col-sm-6">
			   Patient Name : <label>${patientMaster.first_name}&nbsp;&nbsp;&nbsp;${patientMaster.last_name}</label><br>
			   Address : <label>${patientMaster.city}&nbsp;&nbsp;&nbsp;${patientMaster.state}</label><br>
			   Contact No. : <label>${patientMaster.contact_no}&nbsp;&nbsp;&nbsp;</label><br>
			   Email : <label>${patientMaster.email}&nbsp;&nbsp;&nbsp;</label><br>
           	   Age : <label>${patientMaster.age}</label><br>
           	   Weight : <label>${patientMaster.weight}&nbsp;kg</label><br>
           	   Height : <label>${patientMaster.height}&nbsp;cm</label><br>
           	   Blood Group : <label>${patientMaster.blood_group}</label><br>
           </div>
           <div class="col-sm-6">
				<table class="table table-bordered">
				 <thead>
				   <tr>
				     <th>Prescribed Date</th>
				     <th>Symptoms</th>
				     <th>Prescription</th>
				     <th>Prescribed By</th>
				   </tr>
				 </thead>
				<tbody>
			   		<c:forEach var="patientHistory" items="${patientHistories}">
			         <tr>
			          <td> <fmt:formatDate pattern = "dd-MM-yyyy" 
         					value = "${patientHistory.prescribedDate}" /></td>
			          <td>${patientHistory.symptoms}</td>
			          <td>${patientHistory.prescription}</td>
			          <td>Dr.&nbsp;${patientHistory.prescribedByName}</td>
			         </tr>
			   		</c:forEach>
			   </tbody>
			   </table>
           </div>
           </div>
           
           <div class="row" style="margin-top: 15px;margin-bottom: 10px;">
           	   <div class="col-sm-3"></div>
	           <div class="col-sm-6">
	              <form action="PatientHistoryAndReportsServlet" method="post">
	                <input type="hidden" name="patientId" value="${patientMaster.id}"> 
	                 <div class="row">
	                    <div class="col-sm-6">
					            <div class="form-group has-feedback">
									 <label>Symptoms</label>            
									 <input type="text" name="symptoms" class="form-control input-sm" required>
								</div>
	           			</div>
	           			<div class="col-sm-6">
					            <div class="form-group has-feedback">
									 <label>Prescription</label>            
									 <input type="text" name="prescription" class="form-control input-sm" required>
								</div>
	           			</div>
	                 </div>
	                  <div class="row" style="margin-bottom: 10px;">
				        <!-- /.col -->
				        <div class="col-sm-4"></div>
				        <div class="col-sm-4">
				          <button type="submit"  class="btn btn-primary btn-block btn-flat" name="action" value="addPrescription">Add</button>
				        </div>
				        <!-- /.col -->
				    </div>
	                 
	                  
	              </form>
	           </div>
           </div>
           
         </div>
         </div>
        </div>
       </div>
       
<jsp:include page="footer.jsp"></jsp:include>

</body>
</html>