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
        <script src="../js/ajax.js">
        </script>
        <script type="text/javascript">
            function pageAction(action) {
                document.dbform.actiontype.value = action;
                if (ajax && action === 'view') {
                    ajax.open('get', 'StoreSelection?actiontype=view');
                    ajax.send(null);
                } else {
                    document.dbform.submit();
                }
            }
            var $ = function (id) {
                return document.getElementById(id);
            };
            function clrscrn() {
                $("dbform").reset();
                $
            }
            }
        </script>
        <style>
            #result{
                float: right;
                height: 1000px;
            }
            #vac_items tr td:nth-child
        </style>
    </head>
    <body>
        <!-- Authentication -->
        <c:if test="${!u.authenticated}">
            <script type="text/javascript">
                window.window.location = "/VacTrackSys/Login.jsp";
            </script>
        </c:if>
        <form name="dbform" id="ActionForm" action="DBAction" method="post">


            <legend> Vaccination Database Search</legend>
            <!-- 
                    For Searching through database
            -->
            <input type="text" name="rid" id="rid" value="" placeholder="Recipient ID">
            <input type="text" name="ssn" id="ssn" value="" placeholder="Enter SSN Number" required>
            <input type="date" required> 
            <input type="text" name="loc" id="loc" required> 
            <input type="text" name="vaccinator" id="vaccinator" required>
            <table id="vac_items">
                <tr></tr>
                <tr>
                    <td>Vaccine #1 </td>
                    
                    <td><input type="text" name="manuf" id="manuf1" value="" placeholder="Manufacturer" ></td>
                    <td><input type="number" name="batchNo" id="batchNo1" value="" placeholder="BatchNo."></td>
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

            <input type="hidden" name="actiontype" id="actiontype" value="" > 
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
