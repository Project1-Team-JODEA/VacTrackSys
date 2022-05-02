<%--
    Project JODEA 
    File name  : index1.jsp
    Date       : Mar 6, 2022, 1:05:54 PM
    Author(s)  : JaccobStanton, Elena Miller
    
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Login and Registration Form</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="../css/all.css">
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png"/>
        <script src="../js/validate.js" type="text/javascript"></script>
        <script src="../js/functions.js"></script>
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <script>
            // Add attribute events
            window.onload = () => {
                $("v-btn-p").setAttribute("onclick", "toggleV('upwd', 'v-btn-p')");
                $("v-btn-c").setAttribute("onclick", "toggleV('confpasswd', 'v-btn-c')");
                $("terms").setAttribute("onclick", "t()");
                $("validc").setAttribute("onchange", "validatePasswd('upwd', 'confpasswd')");
                $("email").setAttribute("onchange", "validatePattern('email','valide')");
//                   $("uid").setAttribute("onchange", "validatePattern('uid','validid')");  
//                       $("validp").setAttribute("onchange","validatePasswd('upwd', 'confpasswd')"); 
//                $sel("")
            };

            function toggleAlert() {
//               var x document.getElementById("message").innerHTML;
//                $("message").innerHTML
                if ($("message").innerHTML !== "") {
                    alert($("message").innerHTML);
                }
            }
//            if ($("email"))
        </script>
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
                    <table>
                        <tr>
                            <td style="width: "></td>
                            <td></td>
                        </tr>
                    </table>
                    <input type="text" class="input-field" name="userid" id="userid"
                           placeholder="Employee ID" required>
                    <input type="password" class="input-field" name="passwd" id="passwd"
                           placeholder="Enter Password" required>
                    <input type="checkbox" class="check-box"><span>Remember Password</span>
                    
                    <button type="submit" class="submit-btn" onclick="">Login</button>
                    <br>
                    

                </form>
                <form id="register" class="input-group" style="overflow-y: auto;" action="NewAccount" method="post">
                    <table>
                        <tr><td style="width: 240px;"><input type="text" class="input-field" name="uid" 
                                                             id="uid" placeholder="Employee ID" required></td>
                            <td style="width: 40px;"> <i id="validid" class="fas " style="color: green;"
                                                         ></i></td></td>
                        </tr>
                        <tr>
                            <td style="width: 240px;"><input type="email" id="email" class="input-field"
                                                             placeholder="characters@characters.domain"  value="" required></td>
                            <td style="width: 40px;"> <i id="valide" class="fas " style="color: green;"></i></td></td>
                        </tr>

<!--                        <tr><td style="width: 240px;"><input type="text" id="loc" class="input-field" 
                                                             pattern="[a-zA-Z]*" placeholder="Location" required></td></tr>-->
                        
                        <tr><td style="width: 240px;"><input type="password" name="upwd" class="input-field"  id="upwd"
                                                             title="At least 1 number, 1 Uppercase 1 lowercase letter" placeholder="Password" required>
                            </td>
                            <td style="width: 40px;">
                                <i class="fas fa-2x fa-eye" id="v-btn-p"></i>
                                <i id="validp" class="fas fa-check" style="color: green;"></i></td>
                        </tr>
                        <tr>
                            <td id="msg"></td>              
                        </tr>
                        <tr><td style="width: 240px;">
                                <input type="password" name="confpasswd" class="input-field" id="confpasswd"
                                       placeholder="Confirm Password" required></td>
                            <td style="width: 40px;"><i class="fas fa-1-5x fa-eye"  id="v-btn-c" ></i>
                                <i id="validc" class="fas fa-check" style="color: green;" ></i></td>
                        </tr>
                        <tr>
                            <td><input type="text"  class="input-field"  
                                       name="hint"id="hint" required></td>              
                        </tr>
                    </table> 

                    <input type="checkbox" class="check-box" id="terms" ><span>I agree to the terms & conditions</span>
                    <button type="submit" id="newacct" class="submit-btn" disabled>Register</button>
                    <!--<input type="hidden" id="isValid" value="">-->
                </form>
                <button  class="submit-btn" onclick="document.location = 'ForgotPassword.jsp'"><i class="fas fa-angle-right"> Forgot Password?</i></button>
            </div>
            <!--<script src =" ../js/functions" type="text/javascript"></script>-->
            
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

            function t() {
                var c = $("terms").getAttribute("checked");
//            console.log(c);
                if (c === null) {
                    $("terms").setAttribute("checked", null);
                    $("newacct").removeAttribute("disabled");
                } else {
                    $("terms").removeAttribute("checked");
                    $("newacct").setAttribute("disabled", null);
                }
//       if ($("terms").checked){
//            
//        } 
            }

        </script>

    </body>
</html>
