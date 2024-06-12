<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>BlockChain-Home</title>

   
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
	
    <div class="container"> 
        <div class="bodyContainer">
            <div class="panel panel-default mtop10">
                <div class="panel-heading">
                    <h3 class="panel-title">Project Description</h3>
                </div>
                <div class="panel-body">
                    <div class="row" style="margin-top: 10px; margin-bottom: 10px;">
                        <div class="col-sm-8">
                            <p>
                                The rise of digital healthcare underscores the importance of creating ecosystems tailored to ensuring patient comfort and safeguarding their data. With health records being highly sensitive and requiring seamless management, prioritizing data security is imperative. Breaches in security not only jeopardize trust but also pose risks to health and lives, given the critical role data plays in cloud-based healthcare systems. To combat the escalating threats from cybercrime, organizations must adopt a comprehensive, multi-faceted approach to security. Additionally, they must factor in compliance standards when devising data protection strategies. Here, we present an overview of the risks to healthcare data, prevalent compliance regulations, and solutions for enhancing data protection.
                            </p>
                        </div>
                        <div class="col-sm-4">
                            <img src="healthcare-data-security.png" alt="Your Image" class="img-responsive">
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
       
    <jsp:include page="footer.jsp"></jsp:include>

</body>
</html>