<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>



  <!DOCTYPE html>
  <html lang="en">

  <head>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <meta charset="utf-8" />
    <meta content="width=device-width, initial-scale=1.0" name="viewport" />

    <title>Admin_DashBoard</title>
    <meta content="" name="description" />
    <meta content="" name="keywords" />
<style>
table,td,tr {
  border: 3px solid blue;
  padding: 15px;
}
</style>
    <!-- Favicons -->
    <link href="img/favicon.png" rel="icon" />
    <link href="img/apple-touch-icon.png" rel="apple-touch-icon" />

    <!-- Vendor CSS Linkks -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-4bw+/aepP/YC94hEpVNVgiZdgIC5+VKNBQNGCHeKRQN+PtmoHDEXuppvnDJzQIu9" crossorigin="anonymous">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.3.0/font/bootstrap-icons.css">
    <link href="https://cdn.jsdelivr.net/npm/remixicon@2.5.0/fonts/remixicon.min.css" rel="stylesheet">

    <!-- Vendor Script Linkks -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.1/dist/js/bootstrap.bundle.min.js" integrity="sha384-HwwvtgBNo3bZJJLYd8oVXjrBZt8cqVSpeBNS5n7C8IVInixGAoxmnlMuBnhbgrkm" crossorigin="anonymous"></script>

    <!-- Google Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com" />
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin />
    <link
      href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,300;0,400;0,500;0,700;0,900;1,300;1,400;1,500&display=swap"
      rel="stylesheet" />

    <!-- Main CSS Files -->
    <link href="dashboardcss/bootstrap.min.css" rel="stylesheet" />
    <link href="dashboardcss/style.css" rel="stylesheet" />
    <link href="dashboardcss/styleprofile.css" rel="stylesheet" />

  </head>

  <body>
  <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    <!-- ======= Header ======= -->
    <header id="header" class="fixed-top d-flex align-items-center">
      <div class="container d-flex align-items-left justify-content-between">
        <div class="logo">

        </div>
		<div>	
        <nav id="navbar" class="navbar">
          <ul>
           <li>
              <a class="nav-link scrollto"  href=" doctorManagement.jsp">Add Doctors</a>
            </li>
            
            
          </ul>
        </nav>
        
        </div>
        </div>
        <!-- .navbar -->
      
      
      
    </header>
    <!-- End Header -->

    <main id="main">
        
        <div class="d-flex flex-column ">

            <div class="profile pt-5 mt-5">
    
                <h1 class="text-black mt-5">Admin DashBoard</h1>
                
                <div class="social-links mt-3 text-center pt-5">
                  
                </div>
              </div>

            <nav id="navbar" class="nav-menu ">
                <a href="adminViewAppoint.jsp"><button class=" mt-5 p-3" id="btn-prof">Appointments</button></a><br>
                <a href="doctorManagement.jsp"><button class=" mt-5 p-3" id="btn-prof">Manage Doctors</button></a>
                <a href="adminViewLab.jsp"><button class=" mt-5 p-3" id="btn-prof">Lab Appointments</button></a>
                
          
            </nav><!-- .nav-menu -->

          </div>
        </main>
    <!-- End #main -->


    
    
    
        
        <section style="margin-left: 350px;margin-top:150px;">
        
           <h2><strong>Registerd User list</strong></h2><br>
         		
         	<%@ page import="java.sql.*" %>	
         	<table style="width:100%" border="2" >
         	
         	<tr>
         		<td>First name</td>
         		<td>Last name</td>
         		<td>User name</td>
         		<td>Address</td>
         		<td>Email</td>
         		<td>Mobile</td>
         		<td>Password</td>
         		
         		
         	</tr>
         	
         	
         	
         	<%
         	try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
    		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hestia?useSSL=false","root","root");
    		Statement stmt = con.createStatement();
    		
    		
    		String sql = "select * from registration";
    		ResultSet rs = stmt.executeQuery(sql);
         	
    		
    		while(rs.next())
    		{ %>
    		
    		<tr>
    		    
	    		<td><%=rs.getString("fname")%></td>
	    		<td><%=rs.getString("lname")%></td>
	    		<td><%=rs.getString("uname")%></td>
	    		<td><%=rs.getString("address")%></td>
	    		<td><%=rs.getString("email")%></td>
	    		<td><%=rs.getString("mobile")%></td>
	    		<td><%=rs.getString("password")%></td>
    		
    		</tr>
    			
    			
    			
    		<%}
    		
    		
         	 }catch(Exception e)
         	{
         		out.println(e);
         	}
         	
    		
    		
         	%>
         		</table>
         		
         		
 			
         

        </section>


    <!-- ======= Footer ======= -->
    <footer id="footer">
      <div class="container">
        <div class="row d-flex align-items-center">
          <div class="col-lg-6 text-lg-left text-center">
            <div class="copyright">
              &copy; Copyright
              <strong>
                <h1>
                  <a href=""><span style="color: black; font-family: 'Roboto', sans-serif">Hestia</span><span
                      style="color: #3498db">Health Care</span></a>
                </h1>
              </strong>
              <p style="
                  color: black;
                  font-family: 'Roboto', sans-serif;
                  margin-top: -1.2%;
                ">
                We Provide The Largest Array of Health Care Services
              </p>
              All Rights Reserved
            </div>
            <div class="credits">Designed by Group 16</div>
          </div>
         
          </div>
        </div>
      
    </footer>
    <!-- End Footer -->

    <a href="#" class="back-to-top d-flex align-items-center justify-content-center"><i
        class="bi bi-arrow-up-short"></i></a>

    
    <!-- Template Main JS File -->
    
  </body>

  </html>