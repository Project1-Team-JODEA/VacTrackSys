<%--
    Project Title
    File name  : Login
    Date       : Feb 18, 2022, 8:52:17 PM
    Author(s)  : Elena Miller
    Supporting File(s):
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vac Track System - State Mo Login</title>
         <link rel="stylesheet" href="../Assets/Styles/main.css" type="text/css" />
    </head>
    <body style="background-color: black;">
        <header>
            <nav>
                <ul>
                    <li><a href="../index2.html">Welcome</a></li>
                    <li><a href="../Patient/PatientSearch.jsp">Patients</a></li>
                    <li><a href="../CDC/Login.jsp">Center of Disease Control</a></li>
                      <li><a href="../Member/Login.jsp">Member Login</a></li>
                    <li><a href="Login.jsp">State of Missouri</a></li>
                </ul>
            </nav>
        </header>
        <form action="login">
            <h1>State of Missouri Login</h1>
            <table>
                <tr>
                    <td style="color: white;">Username:</td>
                    <td><input type="text" name="userid" id="userid" size="15"></td>
                </tr>
                <tr>
                    <td style="color: white;">Password:</td>
                    <td><input type="password" name="passwd" id="passwd" size="15"></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Login"></td>
                    <td></td>
                    <td></td>
                </tr>
            </table>
        </form>
        <a href="NewAccount.jsp">Create User Account</a>
        <footer>
            
        </footer>
    </body>
</html>
