<%--
    Team JODEA Vaccination Tracking System
    File name  : NewAccount.jsp
    Date       : Feb 18, 2022, 8:55:33 PM
    Author(s)  : Elena Miller, 
    Supporting File(s):
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>New Account</title>
        <link rel="stylesheet" href="../Assets/Styles/main.css" type="text/css" />
        <style>
            body {
                background-image: url("../Assets/Images/Homepage.png");
                background-repeat: no-repeat;
                background-attachment: fixed;
                background-size: cover;
            }
        </style>
    </head>
    <body style="background-color: black;">
        <nav>
                <ul>
                    <li><a href="../index2.html">Welcome</a></li>
                    
                    <li><a href="../Patients/PatientSearch.jsp">Patients</a></li>
                     <li><a href="Login.jsp">Member Login</a></li>
                    <li><a href="../CDC/Login.jsp">Center of Disease Control</a></li>
                    <li><a href="../StateMo/Login.jsp">State of Missouri</a></li>
                </ul>
            </nav>
        <form id="newAcct" action="NewAccount" method="post">
            <h1> New Account Form </h1>
            
            <table>
                <tr>
                    <td style="color: white;">Email:</td>
                    <td><input type="email" name="email" id="email" value="" placeholer="example@gmail.com"></td>
                </tr>
                <tr>
                    <td style="color: white;">Username:</td>
                    <td><input type="text" name="username" id="username" value="" ></td>
                </tr>
                <tr>
                    <td style="color: white;">Password:</td>
                    <td><input type="password" name="newpasswd" id="newpasswd" value=""></td>
                </tr>
                <tr>
                    <td style="color: white;">Confirm Password:</td>
                    <td><input type="password" name="confpasswd" id="confpasswd" value=""></td>
                    <td></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Create"></td>
                </tr>
            </table>
        </form>
        <br>
        <a href="../index2.html">Return to Homepage</a>
        ${msg}
    </body>
</html>
