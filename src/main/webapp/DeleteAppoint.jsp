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

   <nav class="nav nav-borders">
        <a class="nav-link active ms-0" href="useracc.jsp">Profile</a>
        <a class="nav-link" href="appointment.jsp" target="__blank">Doctor Appointment</a>
        <a class="nav-link" href="laboratorylist.jsp" target="__blank">Lab Appointment</a>
        <a class="nav-link" href="passwordChange.jsp" target="__blank">Security</a>
        <a class="nav-link" href="patientHome.jsp"  target="__blank">Home</a>
    </nav>

        <div class="col-xl-8">
            <!-- Account details card-->
            <div class="card mb-4">
                <div class="card-header">Delete Appointment</div>
                <div class="card-body">
                    <form method="post" action="deleteappoint">
                    <div class="mb-3">
                            <label class="small mb-1" for="inputUsername">Appointment ID</label>
                            <input class="form-control" id="inputUsername" type="text" name ="aid" placeholder="ID" value="<%out.println(session.getAttribute("aid"));%>" readonly>
                        </div>
                        <!-- Form Group (username)-->
                        <div class="mb-3">
                            <label class="small mb-1" for="inputUsername">Patient name</label>
                            <input class="form-control" id="inputUsername" type="text"  name ="pname" placeholder="Enter your username" value="<%out.println(session.getAttribute("pname"));%>"readonly>
                        </div>
                        <!-- Form Row-->
                        <div class="row gx-3 mb-3">
                            <!-- Form Group (first name)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputFirstName">Patient email</label>
                                <input class="form-control" id="inputFirstName" type="text"  name ="pemail" placeholder="Enter your first name" value="<%out.println(session.getAttribute("pemail"));%>"readonly>
                            </div>
                            <!-- Form Group (last name)-->
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputLastName">Mobile Number</label>
                                <input class="form-control" id="inputLastName" type="text"  name ="pmob" placeholder="Enter your last name" value="<%out.println(session.getAttribute("pmobile"));%>" readonly>
                            </div>
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputLastName">Date</label>
                                <input class="form-control" id="inputLastName" type="text"  name ="date" placeholder="Enter your last name" value="<%out.println(session.getAttribute("depart"));%>"readonly>
                            </div>
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputLastName">Department</label>
                                <input class="form-control" id="inputLastName" type="text"  name ="dept" placeholder="Enter your last name" value="<%out.println(session.getAttribute("date"));%>"readonly>
                            </div>
                            <div class="col-md-6">
                                <label class="small mb-1" for="inputLastName">Doctor name</label>
                                <input class="form-control" id="inputLastName" type="text"  name ="dname" placeholder="Enter your last name" value="<%out.println(session.getAttribute("doc"));%>"readonly>
                            </div>
                        </div>
                        <!-- Form Row        -->
                        <div class="row gx-3 mb-3">
                   
                              
                           
                            
                        </div>
                        <!-- Save changes button-->
                        <button class="btn btn-primary" type="submit" value = "">Complete and Delete Appointment</button>
                        
                    </form>
                    
                    
                     
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>