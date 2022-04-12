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
//                $("terms").setAttribute("onclick", "t()");
                $("validc").setAttribute("onchange", "validatePasswd('upwd', 'confpasswd')");
//                $("email").setAttribute("onchange", "validatePattern('email','valide')");

//                $("terms").setAttribute("onclick", "t()");
                $("terms").onclick = () => {
                    var c = document.getElementById("terms");
                    var a = c.checked;
                    //            console.log(c);
                    if (a === null) {
                        c.setAttribute("checked", null);
//                    $("terms").removeAttribute("disabled");
                    } else {
                        c.removeAttribute("checked");
//                    $("check").setAttribute("disabled", null);
    
                    }                    
                };
                $("register").onsubmit = ()=> {$("newacct").disabled = true;};
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
                        <img src="../image/download.png">
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
                                       placeholder="Employee ID" oni required>

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
                                <input type="checkbox" class="check-box" onclick="t()">Remember Password
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
                                                             placeholder="Employee ID"
                                                             required></td>
                            <td style="width: 40px;"> <i id="validid" class="fas " style="color: green;"></i></td>


                        </tr>
                        <tr>
                            <td style="width: 240px;"><input type="email" name="email" id="email"
                                                             class="input-field" placeholder="characters@characters.domain"
                                                             onchange="validatePattern('email', 'valide')" oninvalid="this.setCustomValidity('Not Valid')" required></td>
                            <td style="width: 40px;"> <i id="valide" class="fas " style="color: green;">

                                </i></td>
                            </td>
                        </tr>
                        <tr>
                            <td style="width: 240px;"><input type="text" name="loc" id="loc" class="input-field"
                                                             placeholder="Location" required></td>

                        </tr>
                        <tr>
                            <td style="width: 240px;"><input type="password" name="upwd" class="input-field"
                                                             id="upwd" placeholder="Password"
                                                             onchange="validatePattern('upwd', 'validp')" required>
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
                                       id="confpasswd" placeholder="Confirm Password" 
                                       onchange="validatePattern('confpasswd', 'validc')" required>
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
                            <td>
                                <select name="quest" class="input-field" id="quest" title="security question" id="quest">
                                    <option value="">Select</option>
                                    <option value="What is your Mother's Maiden Name?">What is your Mother's Maiden Name</option>
                                    <option value="Whats your favorite College?">Whats your favorite College? </option>
                                    <option value="What City were you born in?">What City were you born in?</option>
                                    <option value="What is your childhood nickname?">What is your childhood nickname?</option>
                                    <option value="What street did you live on in 3rd grade?">What street did you live on in 3rd grade?</option>
                                    <option value="In what city did you meet your spouse/significant other?">In what city did you meet your spouse/significant other?</option>
                                    <!--                                    <option id="" value="">Select</option>-->
                                </select>
                            </td>

                        </tr>
                        <tr>
                            <td>
                                <input type="text" class="input-field" name="answer" id="answer"
                                       placeholder="Answer">
                            </td>
                        </tr>
                        <tr>
                            <td style="font-size: 12px;"><input type="checkbox" class="check-box" id="terms"
                                                                onclick="">
                                I agree to the terms & conditions</td>
                        </tr>

                    </table>
                    <!--<button type="button" id="check" class="submit-btn" onclick="validateUserReg('newacct')">Check</button>-->
                    <button type="submit" id="newacct" class="submit-btn">Register</button>
                    <!--<input type="hidden" id="isValid" value="">-->

                </form>
                <!--                <form id="register-p" class="input-group" style="overflow-y: auto; max-height: 275px;"
                                      action="NewAccount" method="post">
                                    <table>
                                        <tr><td><input type="text" name="" id="" value="" ></td>
                                        </tr>
                                    </table>
                                </form>-->
            </div>
            <!--<script src =" ../js/functions" type="text/javascript"></script>-->

        </div>
        <input type="hidden" name="step" id="step" value="" onchange="">
        <script>
            var x = document.getElementById("login");
            var y = document.getElementById("register");
            var y2 = document.getElementById("register-p");
            var z = document.getElementById("btn");
            function register() {
                x.style.left = "-400px";
                y.style.left = "50px";
//                y2.style.left = "-690px";
                z.style.left = "110px";

            }
//            function newInfo() {
////                x.style.left = "";
//                x.style.left = "-800px";
//                y.style.left = "50px";
//                y2.style.left = "-690px";
//                z.style.left = "110px";
//            }
            function login() {
                x.style.left = "50px";
                y.style.left = "450px";
//                y2.style.left = "-690px";
                z.style.left = "0px";
//                document.getElementById("").setAttribute("focus")
            }


        </script>

    </body>

</html>