<%--
    Project Title
    File name  : Update
    Date       : Mar 6, 2022, 2:11:34 PM
    Author(s)  : Elena Miller
    Supporting File(s): DBAction Servlet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="ajax.js" lang="javascript" type="text/javascript"></script>
<script lang="javascript" type="text/javascript">
    function pageAction(){
        document.rec.actiontype.value = action;
        document.rec.submit();
    }
</script>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Patient Records</title>
        <link rel="stylesheet" href="../css/all.css" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!--<link rel="stylesheet" href="../.css" type="text/css"/>-->
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png" />
        <link rel="stylesheet" href="formstyle.css">
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png"/>
    </head>
    <body>
        <table>
            <tr>
                <td><input type="number" name="ssn" id="ssn" maxlength="10" placeholder="(000-00-0000)"></td>
                <td><</td>
            </tr>
        </table>
        <table class="table-content" border="1">
            <tr>
                <th>SSN</th>
                <th>First Name</th>
                <th>Middle Init:</th>
                <th>Last Name:</th>
                <th>DOB</th>
                <th>P Type</th>
                <th>Vaccine 1</th>
                <th>Vaccine 2</th>  
                <th>Vaccine 3</th>
                <th>Vaccine 4</th>
            </tr>
            <c:forEach var="p" items="${patientset}">
                <tr>
                    <td>${p.ssn}</td>
                    <td>${p.fname}</td>
                    <td>${p.mname}</td>
                    <td>${p.lname}</td>
                    <td>${p.dob}</td>
                    <td>${p.ptype}</td>
                    <td>${p.vac1.vid}</td>
                    <td>${p.vac2.vid}</td>
                    <td>${p.vac3.vid}</td>
                    <td>${p.vac4.vid}</td>
                </tr>
            </c:forEach>
        </table>
        <br>
        <div class="button">
            <!--                    <input type="submit" name="edit" id="edit" value="Edit Patient" onclick="alert('WIP')">-->
            <!--&#8287;  &#8287;  &#8287;  &#8287;--> 
            <!--<input type="submit" form="rec" name="back" id="back" value="Go Back" onclick="pageAction(action)">-->
            &#8287;  &#8287;  &#8287;  &#8287; 
            <!--<input type="submit" name="report" id="report" value="Print Report" onclick="alert('To Be Implemented')">-->

            &#8287;  &#8287;  &#8287;  &#8287; 
        </div>
<!--        <form id="rec" action="DBAction">
            <input type="hidden" name="actiontype" id="actiontype" value="">
        </form>-->
        <%--<c:if test="${u.access_level == 'Admin' || u.access_level == 'MedicalStaff'}>"--%>
        <form action="DBAction">
            
        </form>
    </body>
</html>
