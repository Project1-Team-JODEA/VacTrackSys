<%--
    Project Title
    File name  : index1
    Date       : Mar 6, 2022, 1:05:54 PM
    Author(s)  : Jaccob, Elena Miller
    Supporting File(s):
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CDC Login and Registration Form</title>
        <link rel="stylesheet" href="style.css">

    
    </head>
    <body>
        <div class="hero">
            <div class="form-box">
                <div class="button-box">
                    <div id="btn"></div>
                    <button type="button" class="toggle-btn" onclick="login()">Log In</button>
                    <button type="button" class="toggle-btn" onclick="register()">Register</button>
                </div>
                <div class="social-icons">
                    <a href="https://www.mypatientchart.org/MyChart/Authentication/Login?"> 
                        <img src="download.png">
                    </a> 
                    <a href="https://physicians.wustl.edu/for-patients/mychart-patient-portal/"> 
                        <img src="washu2.png">
                    </a>
                        <a href="https://www.mymercy.net/login"> 
                            
                            <img src="mercy.jpg">
                        </a>
                </div>
                <form id="login" class="input-group" action="Login" method="post">
                    <input type="text" class="input-field" name="userid" id="userid"
                           pattern="{6,}" placeholder="Employee ID" required>
                    <input type="password" class="input-field" name="passwd" id="passwd" placeholder="Enter Password" required>
                    <input type="checkbox" class="check-box"><span>Remember Password</span>
                    <button type="submit" class="submit-btn">Login</button>
                </form>
                <form id="register" class="input-group" action="NewAccount" method="post">
                    <input type="text"id="uid" name="uid" class="input-field"  placeholder="Employee ID" required>
                    <input type="email" id="email" class="input-field"  placeholder="Email ID" required>
                    <!--<input type="text" id="loc" class="input-field" placeholder="Location" required>-->
                    <input type="password" id="upwd" class="input-field"  placeholder="Enter Password" required>
                    <input type="password" id="confpasswd" class="input-field" 
                           pattern="{6,}" placeholder="Confirm Password" required>

                    <input type="checkbox" class="check-box"><span>I agree to the terms & conditions</span>
                    <button type="submit" id="newacct" class="submit-btn">Register</button>
                </form>
                <span id="message">${msg}</span>
            </div>
        </div>

        <script>
            var x = document.getElementById("login");
            var y = document.getElementById("register");
            var z = document.getElementById("btn");


            function register() {
                x.style.left = "-400px";
                y.style.left = "50px";
                z.style.left = "110px";
            }

            function login() {
                x.style.left = "50px";
                y.style.left = "450px";
                z.style.left = "0px";
            }

        </script>

    </body>
</html>
