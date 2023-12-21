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
                        <h2 class="form-title">User verification</h2>
                        <form method="POST" class="register-form" id="login-form" action = "login">
                            <div class="form-group">
                                <label for="your_name"><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="text" name="your_email" id="your_name" placeholder="Your email" />
                            </div>
                            
                           
                        </form>
                       
                    </div>
                </div>
            </div>
        </section>

    </div>
    
    
