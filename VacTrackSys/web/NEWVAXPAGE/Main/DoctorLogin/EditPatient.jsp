<%-- 
    Document   : EditPatient
    Created on : Mar 7, 2022, 9:51:18 PM
    Author     : alexs
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Edit Patient</title>
        <style>
            table.edit-patient{
                border-collapse: collapse;
            }
            table.edit-patient td, table.edit-patient th{
                padding: 6px;
                border: 1px solid #999;
            }
        </style>
    </head>
    <body>
        <h1>Edit Patient</h1>
        User: ${u.username},  ${u.accesslevel}
        <br>
        <br>
        <form id="EditPatientForm" action="UpdatePatient" method="post">
            <table class="edit-patient">
                <tr>
                    <td>SSN</td>
                    <td><input type="text" id="ssn" name="ssn" value="${selectedPatient.ssn}" readonly="true"></input></td>
                </tr>
                <tr>
                    <td>First Name</td>
                    <td><input type="text" id="fname" name="fname" value="${selectedPatient.fname}"></input></td>
                </tr>
                <tr>
                    <td>Middle Initial</td>
                    <td><input type="text" id="minit" name="minit" value="${selectedPatient.mname}"></input></td>
                </tr>
                <tr>
                    <td>Last Name</td>
                    <td><input type="text" id="lnamne" name="lname" value="${selectedPatient.lname}"></input></td>
                </tr>
                <tr>
                    <td>Patient Type</td>
                    <td><input type="text" id="ptype" name="ptype" value="${selectedPatient.ptype}"></input></td>
                </tr>
                <tr>
                    <td>Vaccine 1 ID</td>
                    <td><input type="text" id="v1id" name="v1id" value="${selectedPatient.vac1.vid}"></input></td>
                </tr>
                <tr>
                    <td>Vaccine 2 ID</td>
                    <td><input type="text" id="v2id" name="v2id" value="${selectedPatient.vac2.vid}"></input></td>
                </tr>
                <tr>
                    <td>Vaccine 3 ID</td>
                    <td><input type="text" id="v3id" name="v3id" value="${selectedPatient.vac3.vid}"></input></td>
                </tr>
                <tr>
                    <td>Vaccine 4 ID</td>
                    <td><input type="text" id="v4id" name="v4id" value="${selectedPatient.vac4.vid}"></input></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Update"></input></td>
                </tr>
            </table>
        </form>
        <form id="EditPatientCancel" action="UpdatePatientCancel" method="post">
            <input type="submit" value="Cancel"</input>
        </form>
    </body>
</html>
