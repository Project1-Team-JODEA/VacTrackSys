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

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Records</title>
        <link rel="stylesheet" href="formstyle.css">
        <link rel="stylesheet" href="../css/all.css" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png"/>
        <link rel="stylesheet" href="../css/tablestyle.css" type="text/css">
    </head>
    <body>
        <div class="container" id="rs-form">
            <div class="title">Results</div>
            <div class="content" id="rs-content">
                <table class="table-content" border="1">
                    <thead>
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
                    </thead>
                    <tbody>
                        <c:forEach var="p" items="${pats}">
                            <tr>
                                <td>${p.ssn}</td>
                                <td>${p.fname}</td>
                                <td>${p.mname}</td>
                                <td>${p.lname}</td>
                                <td>${p.dob}</td>
                                <td>${p.ptype}N/A</td>
                                <td>${p.vac1.vid}</td>
                                <td>${p.vac2.vid}</td>
                                <td>${p.vac3.vid}</td>
                                <td>${p.vac4.vid}</td>
                            </tr>
                        </c:forEach>
                    </tbody>

                </table>
            </div>
            <form action="DBAction" method="post">
                <input type="text" name="ssn" id="ssn" valu="">
                <div class="button">
                    <!--<input type="submit" name="edit" id="edit" value="Edit Patient" onclick="alert('WIP')">-->
                    &#8287;  &#8287;  &#8287;  &#8287; 
                    <input type="submit" name="add" id="add" value="Add Patient" onclick="addPatient">
                    &#8287;  &#8287;  &#8287;  &#8287; 
                    <!-- use jsp for  -->
                    <input type="submit" name="add" id="add" value="Add Patient" onclick="addPatient">
                    &#8287;  &#8287;  &#8287;  &#8287; 
                    <input type="submit" name="report" id="report" value="Print Report" onclick="alert('WIP')">
                    &#8287;  &#8287;  &#8287;  &#8287; 
                </div>
                <input type="hidden" name="actiontype" id="actiontype" value=""> 
            </form>

        </div>


        <!--        <div class="container">
                    <span class="title">Patient Records</span>
                    <div class="content">
                        
                    </div>
                </div>-->

        <%--<c:if test="${u.access_level}"--%>

    </body>
</html>
