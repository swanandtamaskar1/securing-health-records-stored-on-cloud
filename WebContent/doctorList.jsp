<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlockChain-Doctors</title>

   
     <meta name='description' content=''>
    <meta name='viewport' content='width=device-width, minimum-scale=1.0, maximum-scale=1.0, user-scalable=no'>
      
    <!--Css files-->
    <link rel="Stylesheet" href="css/style.css"/> 
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
	
    <div class="container" > 
        <div class="bodyContainer">
        <div class="panel panel-default mtop20">
		<div class="panel-heading">
          <h3 class="panel-title">Doctors List</h3>
        </div>
         <div class="panel-body">
         <div class="row" style="margin-top: 50px;margin-bottom: 100px;">
          <div class="col-sm-12">
             <table id="doctorsList" class="table table-bordered table-striped hover">
              <thead>
                <tr>
                  <th>No</th>
                  <th>Name</th>
                  <th>Email</th>
                  <th>City</th>
                  <th>State</th>
                  <th>Action</th>
                </tr>
              </thead>
              <tbody>
               <c:set value="1" var="i"></c:set>
               <c:forEach var="doctor" items="${doctorList}"> 
	               <tr>
	                 <td>${i}</td>
	                 <td>Dr ${doctor.username}</td>
	                 <td>${doctor.EMAIL_ID}</td>
	                 <td>${doctor.CITY}</td>
	                 <td>${doctor.STATE}</td>
	                 <td><a href="RegistrationServlet?action=deleteById&userId=${doctor.id}" >Delete</a></td>
	               </tr>
	               <c:set value="${i+1}" var="i"></c:set>
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


$(function () {
 
  $('#doctorsList').DataTable({
    "paging": true,
    "lengthChange": true,
    "searching": true,
    "ordering": true,
    "info": true,
    "autoWidth": true
  }); 
});

</script>

</body>
</html>