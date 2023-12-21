
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
     <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
    <title>Sign Up</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
     <link rel="stylesheet" href="css/sweetalert.css">
     <link rel="stylesheet" href="alert/dist/sweetalert.css">
    
</head>
<body>

<input type = "hidden" id = "status" value = "<%= request.getAttribute("status")%>" >

    <div class="main">

        <!-- Sign up form -->
        <section class="signup">
            <div class="container">
                <div class="signup-content">
                    <div class="signup-form">
                        <h2 class="form-title">User Sign up</h2>
                        <form method="POST" class="register-form" id="register-form" action = "register">
                            <div class="form-group">
                                <label for="first_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="first_name" id="first_name" placeholder="First Name" />
                            </div>
                            <div class="form-group">
                                <label for="last_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="last_name" id="last_name" placeholder="Last Name" />
                            </div>
                             <div class="form-group">
                                <label for="user_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="user_name" id="user_name" placeholder="User Name" />
                            </div>
                             <div class="form-group">
                                <i class="zmdi zmdi-account material-icons-name"></i>
                                <textarea id="add" name="add" rows="4" cols="50" placeholder = "Address" ></textarea>
                         	</div>
                            <div class="form-group">
                                <label for="email"><i class="zmdi zmdi-email"></i></label>
                                <input type="email" name="email" id="email" placeholder="Your Email" />
                            </div>
                            <div class="form-group">
                                <label for="mobile"><i class="zmdi zmdi-email"></i></label>
                                <input type="text" name="mobile" id="mobile" placeholder="Your mobile number" />
                            </div>
                            <div class="form-group">
                                <label for="pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="pass" id="pass" placeholder="Password" />
                            </div>
                            
                            <div class="form-group">
                                <input type="checkbox" name="agree-term" id="agree-term" class="agree-term" />
                                <label for="agree-term" class="label-agree-term"><span><span></span></span>I agree all statements in  <a href="#" class="term-service">Terms of service</a></label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signup" id="signup" class="form-submit" value="Register"/>
                            </div>
                        </form>
                    </div>
                    <div class="signup-image">
                        <figure><img src="images/doc.jpg" alt="sing up image"></figure>
                        <a href="signin.jsp" class="signup-image-link">I am already member</a>
                    </div>
                </div>
            </div>
        </section>

       
    </div>

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
  
	
   
	
    
    <script type = "text/javascript">
    	
    	var status = document.getElementById("status").value;
    	if(status=="success")
    		{
    			swal("Congratulation","Account Created Successfully","success");
    		}
    	if(status=="Invalidfname")
		{
			swal("Sorry","Please enter first name","error");
		}
    	if(status=="Invalidlname")
		{
			swal("Sorry","Please enter last name","error");
		}
    	if(status=="Invaliduname")
		{
			swal("Sorry","Please enter user name","error");
		}
    	if(status=="Invalidadd")
		{
			swal("Sorry","Please enter address","error");
		}
    	if(status=="Invalidemail")
		{
			swal("Sorry","Please enter email","error");
		}

    	if(status=="Invalidpass")
		{
			swal("Sorry","Please enter password","error");
		}
    	
    
    	
    </script>
     
</body>
</html>