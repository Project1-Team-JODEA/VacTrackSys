<%-- 
    Document   : MainDBForm
    Created on : Mar 7, 2022, 7:20:54 PM
    Author     : alexs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Database</title>
        <style>
            table.patient-details{
                border-collapse: collapse;
            }
            table.patient-details td, table.patient-details th{
                padding: 6px;
                border: 1px solid #999;
            }
        </style>
    </head>
    <body>
        <h1>Patient Database</h1>
        User: ${u.username},  ${u.accesslevel}
        <br>
        <br>
        <form id="SearchCriteria" action="Search" method="post">
            <table class="patient-details">
                <tr>
                    <td>SSN</td>
                    <td><input type="text" id="ssn" name="ssn"></input></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" id="fname" name="fname"></input></td>
                </tr>
                <tr>
                    <td>Middle Initial</td>
                    <td><input type="text" id="minit" name="minit"></input></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" id="lnamne" name="lname"></input></td>
                </tr>
                <tr>
                    <td>Patient Type</td>
                    <td><input type="text" id="ptype" name="ptype"></input></td>
                </tr>
                <tr>
                    <td>Vaccine 1 ID</td>
                    <td><input type="text" id="v1id" name="v1id"></input></td>
                </tr>
                <tr>
                    <td>Vaccine 2 ID</td>
                    <td><input type="text" id="v2id" name="v2id"></input></td>
                </tr>
                <tr>
                    <td>Vaccine 3 ID</td>
                    <td><input type="text" id="v3id" name="v3id"></input></td>
                </tr>
                <tr>
                    <td>Vaccine 4 ID</td>
                    <td><input type="text" id="v4id" name="v4id"></input></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Search"></input></td>
                </tr>
            </table>
        </form>
        <form id="EditSSN" action="EditPatient" method="post">
            <br>
            SSN  <input type="text" id="ssnedit" name="ssnedit"></input>
            <br>
            <input type="submit" value="Edit"></input>
            <br>
        </form>
        <br>
    <c:if test="${u.searchedPatients}">
        <table border="1">
            <tr>
                <th>SSN</th>
                <th>Fisrt Name</th>
                <th>M Init</th>
                <th>Last Name</th>
                <th>Patient Type</th>
                <th>Vaccine 1</th>
                <th>Vaccine 2</th>
                <th>Vaccine 3</th>
                <th>Vaccine 4</th>
            </tr>
            <c:forEach var="p" items="${patientset}">
                <tr>
                    <td align="right">${p.ssn}</td>
                    <td align="right">${p.fname}</td>
                    <td align="right">${p.mname}</td>
                    <td align="right">${p.lname}</td>
                    <td align="right">${p.ptype}</td>
                    <td align="right">${p.vac1.vid}</td>
                    <td align="right">${p.vac2.vid}</td>
                    <td align="right">${p.vac3.vid}</td>
                    <td align="right">${p.vac4.vid}</td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
    </body>
</html>
