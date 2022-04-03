<%-- Project JODEA File name : index1.jsp Date : Mar 6, 2022, 1:05:54 PM Author(s) : JaccobStanton, Elena Miller --%>

<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Login and Registration Form</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="../css/all.css">
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png" />
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
            };
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
                        <img src="../image/washu2.png">
                    </a>
                    <a href="https://www.mymercy.net/login">

                        <img src="../image/mercy.jpg">
                    </a>
                </div>

                <form id="login" class="input-group" action="Login" method="post">
                    <table>
                        <tr>
                            <td style="width: 280px; ">
                                <input type="text" class="input-field" name="userid" id="userid"
                                       placeholder="CDC ID" required>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 280px; ">
                                <input type="password" class="input-field" name="passwd" id="passwd"
                                       placeholder="Enter Password" required>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 280px; ">
                                <input type="checkbox" class="check-box">Remember Password
                            </td>
                        </tr>
                    </table>
                    <input type="submit" class="submit-btn" value="Login" onclick="">
                    <a href="Password_Reset.jsp">Forgot Password?</a>
                    <br>
                    <!--<button  class="submit-btn" onclick="document.location = 'ForgotPassword.jsp'"><i class="fas fa-angle-right"> Forgot Password?</i></button>-->
                    <div id="message" style="padding: 
                         5px; background: white;">${msg}</div>

                </form>
                <form id="register" class="input-group" style="overflow-y: auto; max-height: 275px;"
                      action="NewAccount" method="post">
                    <i class="fas fa-1-5x fa-circle-info" id="req-btn" style="color: blue;"
                       title="Click for Requirements"></i>
<!--                    <div class="help" style="display: none;">
                        Password: At Least 15 Characters <br>
                    </div>-->
                    <table>
                        <tr>
                            <td style="width: 240px;"><input type="text" class="input-field" name="uid" id="uid"
                                                             placeholder="Employee ID" required></td>
                            <td style="width: 40px;"> <i id="validid" class="fas " style="color: green;"></i></td>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 240px;"><input type="email" name="email" id="email"
                                                             class="input-field" placeholder="characters@characters.domain"
                                                             required></td>
                            <td style="width: 40px;"> <i id="valide" class="fas " style="color: green;"></i></td>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 240px;"><input type="text" name="loc" id="loc" class="input-field"
                                                             placeholder="Location" required></td>
                        </tr>
                        <tr>
                            <td style="width: 240px;"><input type="password" name="upwd" class="input-field"
                                                             id="upwd" placeholder="Password" required>
                            </td>
                            <td style="width: 40px;">
                                <i class="fas fa-1-5x fa-eye" id="v-btn-p"></i>
                                <i id="validp" class="fas fa-check" style="color: green;"></i>
                            </td>
                        </tr>
                        <tr>
                            <!--<td id="msg"></td>-->
                        </tr>
                        <tr>
                            <td style="width: 240px;">
                                <input type="password" name="confpasswd" class="input-field" name="confpasswd"
                                       id="confpasswd" placeholder="Confirm Password" required>
                            </td>
                            <td style="width: 40px;"><i class="fas fa-1-5x fa-eye" id="v-btn-c"></i>
                                <i id="validc" class="fas fa-check" style="color: green;"></i>
                            </td>
                        </tr>
                        <tr>
                            <td><input type="text" class="input-field" name="hint" id="hint"
                                       title="hint for password" placeholder="Hint" required></td>
                        </tr>
                        <tr>
                            <td style="font-size: 12px;"><input type="checkbox" class="check-box" id="terms">
                                I agree to the terms & conditions</td>
                        </tr>
                    </table>
                    <button type="submit" id="newacct" class="submit-btn" disabled>Register</button>
                    <!--<input type="hidden" id="isValid" value="">-->
                    
                </form>

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