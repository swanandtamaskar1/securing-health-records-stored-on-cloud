<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
 <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">
        <title>data Leakage</title>

        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="assets/bootstrap/css/bootstrap.min.css">
        <link rel="stylesheet" href="assets/font-awesome/css/font-awesome.min.css">
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
        <link rel="apple-touch-icon-precomposed" sizes="144x144" href="assets/ico/apple-touch-icon-144-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="114x114" href="assets/ico/apple-touch-icon-114-precomposed.png">
        <link rel="apple-touch-icon-precomposed" sizes="72x72" href="assets/ico/apple-touch-icon-72-precomposed.png">
        <link rel="apple-touch-icon-precomposed" href="assets/ico/apple-touch-icon-57-precomposed.png">
		 
		  <link rel="stylesheet" href="styles/default.min.css" type="text/css" media="all" />
   
     <script type="text/javascript" src="jquery-2.1.3.min.js"></script>
    <script type="text/javascript" src="dist/js/jquery-ui.js"></script>
    <script type="text/javascript" src="dist/js/bootstrap.js"></script>
    <script type="text/javascript" src="dist/js/datepicker.js"></script>
    <script type="text/javascript" src="dist/js/jquery.nicescroll.js"></script>
    <script type="text/javascript" src="dist/js/site.js"></script>
      <script type="text/javascript" src="js/jquery.cookie.js"></script>
 <script type="text/javascript" src="js/jquery-1.8.3.js"></script>
<script src="js/jquery.AjaxFileUpload.js"></script>
	
		  <script type="text/javascript" src="scripts/jquery.sceditor.bbcode.min.js"></script>
		  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
    </head>
   <script language="Javascript">
$(document).ready(function(){ 
	alert(123);
	
	var name="";
	

  
    var attr=0;
  $('input[type="file"]').ajaxfileupload({

	 
		  'action': "ImageUploadServlet1?name="+name, 
			'onComplete' : function(response) {
	 		
	  name=$(this).attr('id');
	  alert(name);
				var statusVal = JSON.stringify(response.status);
				var fileName=$(this).val();
				alert("fileName"+fileName);
				var filePath=fileName.replace('C:\\fakepath\\','');
				//alert(filePath);
				 attr=$(this).attr("alt");
				 var id=$(this).attr("id");
				 alert("id"+id);
				//alert("attr....."+attr);
				$("#hidId"+id).remove();
				$("#hidPath"+id).remove();
				$("#images").append("<input type='hidden' id='hidPath"+id+"' name='imagePath' value='"+filePath+"'></input>");
				
				//alert(fileName);
				//alert(fileName.substring(fileName.lastIndexOf("\\")+1));
				$("#image"+attr).attr("src","ImageUploadServlet1?action=search&fileName="+fileName.substring(fileName.lastIndexOf('\\')+1));
				
				if(statusVal == "false")
				{
					$("#message").html("<font color='red'>"+ JSON.stringify(response.message) +" </font>");
				}	
				 if(statusVal == "true")
				{
					$("#message").html("<font color='green'>"+ JSON.stringify(response.message) +" </font>");
				}	 		
			},
			'onStart' : function() {
			
				
			}
	
});
  });


</script>


<style>
#topbar {
width:1000%;
height:100px;
background-color: white;



}





</style>
    <body>

		<!-- Top menu -->
		
		
        <!-- Top content -->
        <div class="tab-pane form-group active" id="tab1">
                <div class="panel-body" id="formwise">
                    <div class="table-responsive col-sm-6">
                        
                    </div>
                </div>
                
              
            </div>
            
        </div>
         <section class="container">
        <div class="bodyContainer">
        <div class="panel panel-default mtop20">
		<div class="panel-heading">
          <h3 class="panel-title">Report</h3>
        </div>
        <div class="panel-body">
            <ul class="nav-tabs form-group responsive-tabs nav mtop20">
            
                  <li class="active"><a href="#tab1" data-toggle="tab" aria-expanded="true">HOME </a></li>
                  <li class=""><a href="#tab2" data-toggle="tab" aria-expanded="true">UPLOAD </a></li>
                 <li class=""><a href="#tab2" data-toggle="tab" aria-expanded="false">DOWNLOAD</a></li>
                  <li class=""><a href="#tab3" data-toggle="tab" aria-expanded="false" id="view"></a></li><!-- 
                   <li class=""><a href="#tab5" data-toggle="tab" aria-expanded="false">upload Report</a></li>
                    <li class=""><a href="#tab6" data-toggle="tab" aria-expanded="false">download Report</a></li> -->
                   
                  
       </ul>
        <div class="tab-content">
            <div class="tab-pane form-group active" id="tab1">
                <div class="panel-body" id="formwise">
                    <div class="table-responsive col-sm-6">
                        
                    </div>
                </div>
                
              
            </div>
         <div class="tab-pane form-group" id="tab2">
                <div class="panel-body" id="exhibitorwise">
                  <form action="ImageUploadServlet1" method="post">

 <table>
<tr>
    <td><img src="" class="furniture-img" alt="furniture" id="image1" width="100px" height="80px"/></td></tr>
	<tr><td><input type="file" id="fileFlrPlan" class="form-control" alt="1" name="file" required/></td></tr>
	
	
                     
	 <div id="images">
	 
	 </div>
	       
	  </table> 
	  </form>
                </div>
                
              
            </div>
            
     
    
  <form action="uploadListServlet" method="post">
	  
	   <input type="submit" value="view" name="action">
	  
	    </form>
                                <!-- /.modal-dialog -->
                           
    
    </section>


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