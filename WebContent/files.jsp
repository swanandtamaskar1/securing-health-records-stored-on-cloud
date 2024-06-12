<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlockChain-Files</title>

   
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
          <h3 class="panel-title">Files</h3>
        </div>
         <div class="panel-body">
         <div class="row" style="margin-top: 100px;margin-bottom: 100px;">
          <div class="col-sm-4"></div>
           <div class="col-sm-4">
             <table class="table">
              <thead>
                <tr> 
                  <td>File name</td>
                  <td>Action</td>
                </tr>
              </thead>
              <tbody>
                <c:forEach items="${uploadedList}" var="imageUpload">
                <tr>
                  <td><label>${imageUpload.}</label> </td>
                  <td><button class="btn btn-primary btn-sm" type="button" onclick='downloadFile(${imageUpload.file_id})'>Download</button></td>
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

</body>
</html>