<%--
    Project Title
    File name  : Login
    Date       : Feb 18, 2022, 8:52:17 PM
    Author(s)  : Elena Miller
    Supporting File(s):
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html><%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vac Track System - Member Login</title>
        <!--<link rel="stylesheet" href="../Assets/Styles/main.css" type="text/css" />-->
        <link rel="stylesheet" href="../Assets/Styles/loginStyle.css">
        <script src="../Assets/Scripts/validatescript.js" type="text/javascript"></script> 
        
    </head>
    <body >
        <div class="hero">
        <div class="form-box">
            <div class="button-box">
                <div id="btn"></div>
                <button type="button" class="toggle-btn" onclick="login()">Log In</button>
                <button type="button" class="toggle-btn" onclick="register()">Register</button>
            </div>
            <div class="social-icons">
                <a href="https://www.mypatientchart.org/MyChart/Authentication/Login?"> 
                     <img src="../Assets/Images/download.png">
                 </a> 
                 <a href="https://physicians.wustl.edu/for-patients/mychart-patient-portal/"> 
                     <img src="../Assets/Images/washu2.png">
                 </a>
                 <a href="https://www.mymercy.net/login"> 
                     <img src="../Assets/Images/mercy.jpg">
                 </a>
            </div>
            <form id="login" action="Login" method="post" class="input-group">
                <input type="text" class="input-field" id="userid" value="" placeholder="User ID" required>
                <input type="password" class="input-field" id="passwd" value="" placeholder="Enter Password" required>
                <input type="checkbox" class="check-box"><span>Remember Password</span>
                <button type="submit" class="submit-btn">Login</button>
            </form>
            <form id="register" action="NewAccount" method="post" class="input-group" action="">
                <input type="text" class="input-field" id="userid" placeholder="User ID" required>
                <input type="email" class="input-field" id="email" placeholder="Email ID" required>
                <input type="text" class="input-field" id="passwd" placeholder="Enter Password" required>
                <input type="text" class="input-field" id="confpasswd" placeholder="Confirm Password" required>
                <input type="checkbox" class="check-box"><span>I agree to the terms & conditions</span>
                <button type="submit" id="newacct" class="submit-btn">Register</button>
            </form>
            <span id="message">message : ${msg}</span>
        </div>
            
    </div>
    
    <script>
    var x = document.getElementById("login");
    var y = document.getElementById("register");
    var z = document.getElementById("btn");

    
    function register(){
        x.style.left = "-400px";
        y.style.left = "50px";
        z.style.left = "110px";
    }

    function login(){
        x.style.left = "50px";
        y.style.left = "450px";
        z.style.left = "0px";
    }

    </script>
    
</html>
