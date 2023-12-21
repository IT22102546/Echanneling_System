<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="ISO-8859-1">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="lab assets/css/bootstrap.min.css">
    <link rel="stylesheet" href="lab assets/css/datepicker.css">
    <link rel="stylesheet" href="lab assets/css/style.css">
  </head>

    <body>
      <div class="inner-layer">
          <div class="container">
            <div class="row no-margin">
                <div class="col-sm-7">
                    <div class="content">
                        <h1>Book You Slot Now and Save your time</h1>
                        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Morbi sagittis at lacus at rhoncus. Integer pharetra lacus vitae sapien blandit eleifend. </p>
                        <h2>For Help Call : +189-123-453</h2>
                    </div>
                </div>
                <div class="col-sm-5">
                    <div class="form-data">
                        <div class="form-head">
                            <h2>Book Appointment</h2>
                        </div>
						
						<form action = "LabInsert" method="post" >
                        <div class="form-body">
                            <div class="row form-row">
                              <input type="text" placeholder="Enter Full name" name="name" class="form-control" value="<%out.println(session.getAttribute("name"));%>" readonly>
                            </div>
                            <div class="row form-row">
                              <input type="text" placeholder="Enter Mobile Number" name="phone" class="form-control" value="<%out.println(session.getAttribute("mob"));%>">
                            </div>
                             <div class="row form-row">
                              <input type="text" placeholder="Enter Email Adresse" name="email" class="form-control" value="<%out.println(session.getAttribute("email"));%>" readonly>
                            </div>
                           <div class="row form-row">
                              <input id="date" type="text" placeholder="Appointment Date" name="date" class="form-control">
                            </div>
                             <div class="row form-row">
                                <div class="col-sm-6">
                                   <input type="text" placeholder="Enter Address" name="address" class="form-control"> <br>
                              </div>  
							Lab Test<select name="test">
  										<option value="option1">Option 1</option>
  										<option value="option2">Option 2</option>
 										<option value="option3">Option 3</option>
									</select><br>
							

							<br>
                             <div class="row form-row">
                              <input type="submit" value="Book Appoinment"><br> 
                               
                            </div>

                             </div>
                           </div>  
						</form>
                    </div>
                </div>
            </div>
          </div>
      </div>
      
    </body>
  
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="assets/js/jquery-3.3.1.min.js"></script>
    <script src="assets/js/popper.min.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>
    <script src="assets/js/bootstrap-datepicker.js"></script>

    <script>
      $(document).ready(function(){
          $("#dat").datepicker();
      })
    </script>
    
  </body>
</html>