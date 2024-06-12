
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<div class="navbar" style="background-color:#222d32;"> 
                    <div class="container">
                          <div class="navbar-collapse collapse">
                            <ul class="nav navbar-nav">
                              <li class="projectName"><a onclick="return false;">Data Security In Cloud Using Blockchain</a></li>
                                
                              </ul>
                              
                              <c:if test="${user.role=='Admin'}">
	                              <ul class="nav navbar-nav pull-right">
		                               <li><a href="adminHome.jsp">Home</a>
	                                   </li>
	                                    <li class="dropdown">
									        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Doctors
									        <span class="caret"></span></a>
									        <ul class="dropdown-menu">
									          <li><a  href="addDoctor.jsp">Add Doctor</a></li>
									          <li><a href="RegistrationServlet?action=getAllDoctors">Doctors List</a></li>
									        </ul>
								        </li>
	                                   
	                                   <li><a href="PatientMasterServlet?action=GetAllList">Patients</a>
	                                   </li>
	                                   <!-- <li><a href="uploadData.jsp">Upload File</a>
	                                   </li>
	                                   <li><a href="uploadListServlet">Files</a>
	                                   </li> -->
	                                    <li class="dropdown">
									        <a class="dropdown-toggle" data-toggle="dropdown" href="#">${user.username}
									        <span class="caret"></span></a>
									        <ul class="dropdown-menu">
									          <li><a  href="LogoutServletMaster">Logout</a></li>
									        </ul>
								        </li>
	                               </ul>
                               </c:if>
                               
                               
                               <c:if test="${user.role=='Doctor'}">
	                              <ul class="nav navbar-nav pull-right">
		                              <li><a href="doctorHome.jsp">Home</a>
	                                  </li>
	                                  <li><a href="addPatient.jsp">Add patient</a>
	                                  </li>
	                                   <li><a href="PatientMasterServlet?action=GetAllList">Patient List</a>
	                                   </li>
	                                    <li class="dropdown">
									        <a class="dropdown-toggle" data-toggle="dropdown" href="#">${user.username}
									        <span class="caret"></span></a>
									        <ul class="dropdown-menu">
									          <li><a  href="LogoutServletMaster">Logout</a></li>
									        </ul>
								        </li>
	                               </ul>
                               </c:if>
                               <c:if test="${user.role=='Patient'}">
	                              <ul class="nav navbar-nav pull-right">
		                              <li><a href="patientHome.jsp">Home</a>
	                                  </li>
	                                  <li><a href="PatientMasterServlet?action=viewMyHistory&id=${user.id}">My Details</a>
	                                  </li>
	                                   <li class="dropdown">
									        <a class="dropdown-toggle" data-toggle="dropdown" href="#">Reports
									        <span class="caret"></span></a>
									        <ul class="dropdown-menu">
									           <li><a href="addReports.jsp">Add Report</a></li>
									           <li><a href="PatientHistoryAndReportsServlet?action=viewReports&patientId=${user.patientId}">Reports</a></li>
									        </ul>
								        </li>
	                                  
	                                    <li class="dropdown">
									        <a class="dropdown-toggle" data-toggle="dropdown" href="#">${user.username}
									        <span class="caret"></span></a>
									        <ul class="dropdown-menu">
									          <li><a  href="LogoutServletMaster">Logout</a></li>
									        </ul>
								        </li>
	                               </ul>
                               </c:if>
                               
                            </div>
                      </div>
</div>