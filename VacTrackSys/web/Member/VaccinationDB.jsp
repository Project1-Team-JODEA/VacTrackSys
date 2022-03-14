<%--
    Vaccination Tracking System
    File name  : VaccinationDB
    Date       : Feb 18, 2022, 3:49:10 PM
    Author(s)  : Elena Miller, DeShane` Sims
    Supporting File(s):
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vaccination Database</title>
        <link rel="stylesheet" href="../Assets/Styles/dbformstyle.css" type="text/css">
        <script src="../Assets/Scripts/pageAction.js"></script>
        <style>
            
        </style>
    </head>
    <body>
        <!-- Authentication -->
        <c:if test="${!u.authenticated}">
            <script type="text/javascript">
                window.window.location = "/VacTrackSys/Member/Login.jsp";
            </script>
        </c:if>
        <form id="ActionForm" action="/DBAction" method="post">


            <legend> Vaccination Database Search</legend>
            <!-- 
                    For Searching through database
            -->
            <input type="text" name="ssn" id="ssn" value="" placeholder="Enter SSN Number" required>
            <input type="date" required> 
            <input type="text" name="loc" id="loc" required> 
            <input type="text" name="vaccinator" id="vaccinator" required>
            <table>
                <tr>
                    <td>1st</td>
                    <td><input type="text" name="manuf" id="manuf" placeholder="Manufacturer" ></td>
                    <td><input type="number" name="batchNo" id="batchNo" value="" placeholder="BatchNo."></td>
                </tr>
            </table>
            <!-- For Searching for 'person' object in database -->
            <table>
                <tr>
                    <td><label for="fname">First Name:</label></td>
                    <td><label for="midinit">MI:</label></td>
                    <td><label for="lname">Last Name:</label></td>
                    <td><label for="dob">Date Of Birth:</label></td>
                </tr>
            </table>
            <input type="text" name="fname" id="fname" value="" required>
            <input type="text" name="lname" id="lname" value="" required>
            <input type="text" name="midinit" id="midinit" required> 
            <input type="date" name="dob" id="dob" required>
            <input type="button" name="btnClear" value="Clear">
            <input type="submit" name="clear" value="Clear" onclick="clrscrn()">

            <input type="hidden" name="action" id="action" > 
        </form>
        <!--        <form id="" action="Records">
                     To be in
                    to be implemented
                </form>-->
        <form action="/Logout">
            <input type="submit" value="Logout">
        </form>
        <div id="result"></div>
    </body>
</html>
