<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang = "en">

<head>
  <meta charset="utf-8">
  <meta content="width=device-width, initial-scale=1.0" name="viewport">

  <title>Inner Page - Medilab Bootstrap Template</title>
  <meta content="" name="description">
  <meta content="" name="keywords">

  <!-- Favicons -->
  <link href="img/favicon.png" rel="icon">
  <link href="img/apple-touch-icon.png" rel="apple-touch-icon">

  <!-- Google Fonts -->
  <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i" rel="stylesheet">

  <!-- Vendor CSS Files -->
  <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet">
  <link href="vendor/animate.css/animate.min.css" rel="stylesheet">
  <link href="vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
  <link href="vendor/bootstrap-icons/bootstrap-icons.css" rel="stylesheet">
  <link href="vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
  <link href="vendor/glightbox/css/glightbox.min.css" rel="stylesheet">
  <link href="vendor/remixicon/remixicon.css" rel="stylesheet">
  <link href="vendor/swiper/swiper-bundle.min.css" rel="stylesheet">
  
  

  <!-- Template Main CSS File -->
  <link href="homecss/style.css" rel="stylesheet">

  <!-- =======================================================
  * Template Name: Medilab
  * Updated: Sep 18 2023 with Bootstrap v5.3.2
  * Template URL: https://bootstrapmade.com/medilab-free-medical-bootstrap-theme/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
</head>

<body>

  <!-- ======= Top Bar ======= -->
 
<div class="container-xl px-4 mt-4">
    <!-- Account page navigation-->
    <nav class="nav nav-borders">
        <a class="nav-link active ms-0" href="#">Profile</a>
        <a class="nav-link" href="appointment.jsp" target="__blank">My Appointments</a>
        <a class="nav-link" href="passwordChange.jsp" target="__blank">Security</a>
        <a class="nav-link" href="patientHome.jsp"  target="__blank">Home</a>
    </nav>
    <hr class="mt-0 mb-4">
    <div class="row">
      
        
            <!-- Account details card-->
            <div class="card mb-4">
          
                <div class="card-header">All Appointments</div>
             <table border="1">
               <tr>
         		<td>Appointment ID</td>
         		<td>Patient name</td>
         		<td>email</td>
         		<td>mobile</td>
         		<td>date</td>
         		<td>department</td>
         		<td>Doctor name</td>
         	</tr>
                <%@ page import="java.sql.*" %>	
                <%
         	try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
    		Statement stmt = con.createStatement();
    		
    		
    		String sql = "select * from appointment";
    		ResultSet rs = stmt.executeQuery(sql);
         	
    		
    		while(rs.next())
    		{ %>
    		
    		<tr>
    		    
	    		<td><%=rs.getString("id")%></td>
	    		<td><%=rs.getString("pname")%></td>
	    		<td><%=rs.getString("email")%></td>
	    		<td><%=rs.getString("mobile")%></td>
	    		<td><%=rs.getString("date")%></td>
	    		<td><%=rs.getString("department")%></td>
	    		<td><%=rs.getString("dname")%></td>
	    		
	    		
	    		
	    	
    		
    		
    		</tr>
    		
    		
    			
    			
    			
    		<%}
    		
    		
         	 }catch(Exception e)
         	{
         		out.println(e);
         	}
         	
    		
    		
         	%>
         	
         	</table>
         	 Please Complete Your Appointment To Have Next Appointment
         	 
         	 <a href="validappoint.jsp">
                        <button class="btn btn-primary" type="button">Edit and Complete My Appointments</button>
         	
         
            </div>
            		
        </div>
    </div>

	
</body>
</html>