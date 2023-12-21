<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign In</title>

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


 
        <!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/the-key-to-meaningful-patient-engagement-in-medical-device-trials-engage-patients-early-and-often-scaled.webp" alt="sing up image"></figure>
                        <a href="signup.jsp" class="signup-image-link">Create an account</a>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">User Sign in</h2>
                        <form method="POST" class="register-form" id="login-form" action = "login">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="your_email" id="your_name" placeholder="Your email" />
                            </div>
                            
                            <div class="form-group">
                                <label for="your_pass"><i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="your_pass" id="your_pass" placeholder="Password" />
                            </div>
                            <div class="form-group">
                                <input type="checkbox" name="remember-me" id="remember-me" class="agree-term" />
                                <label for="remember-me" class="label-agree-term"><span><span></span></span>Remember me</label>
                            </div>
                            <div class="form-group form-button">
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                        </form>
                        <div class="social-login">
                            <span class="social-label">Or login with</span>
                            <ul class="socials">
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-facebook"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-twitter"></i></a></li>
                                <li><a href="#"><i class="display-flex-center zmdi zmdi-google"></i></a></li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
        </section>

    </div>
    
    

    <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
    <script src="https://unpkg.com/sweetalert/dist/sweetalert.min.js"></script> 
      <script type = "text/javascript">
    	
    	var status = document.getElementById("status").value;
    	var status = document.getElementById("status").value;
    	if(status=="success")
    		{
    			swal("Congratulation","Account updated Successfully","success");
    		}
    	if(status=="failed")
    		{
    			swal("Sorry","Wrong password or Invalid user name","error");
    		}
    	if(status=="Invaliduname")
		{
			swal("Sorry","Please enter User name","error");
		}
    	if(status=="Invalidupass")
		{
			swal("Sorry","Please enter password","error");
		}
    	
    	
    </script>
    
</body><!-- This templates was made by Colorlib (https://colorlib.com) -->
</html>