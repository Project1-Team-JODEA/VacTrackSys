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
<script src="../js/ajax.js" type="text/javascript"></script>
<script src="../js/searchPatient.js" type="text/javascript"></script>
<script type="text/javascript">
    var $ = function (id) {
                return document.getElementById(id);
            };
    function pageAction(action) {
        document.RecordsSelection.actiontype.value = action;
        $("actiontype").value = action;
        if (ajax && action === 'searchPatient') {
            ajax.open('get', 'RecordsSelection?actiontype=searchPatient');
            ajax.send(null);
        } else if (ajax && action === 'Edit') {
            ajax.open('get', 'RecordsSelection?actiontype=edit');
            ajax.send(null);
        }else {
            document.RecordsSelection.submit();
        } 
    }


</script>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vaccination Database</title>
        <link rel="stylesheet" href="formstyle.css" type="text/css"/>

        <script type="text/javascript">
            var $ = function (id) {
                return document.getElementById(id);
            };
            function clrscrn() {
                $("Records").reset();
//                $("rid").focus();
            }
        </script>
    </head>
    <body>
        <!-- Authentication -->
        <%-- <c:if test="${!u.authenticated}">
             <script type="text/javascript">
                 window.window.location = "/VacTrackSys/DoctorLogin/index1.jsp";
             </script>
         </c:if>--%>

        <!-- 
                For Searching through database
        -->
        <p>
            <%--User: ${u.userid}, ${u.access_level} Level--%>
        </p>
        <div class="container">
            <div class="title">Patient Database Records Selection</div>
            <div class="content">
                <form name="RecordsSelection" id="RecordsSelection" action="DBAction" method="post">



                    <div class="user-details">
                        <div class="input-box">
                            <input type="text" name="ssn" id="ssn" value="" placeholder="SSN" required> 
                            <input type="text" name="fname" id="fname" value="" size=""
                                   placeholder="First Name"> <br>
                            <input type="text" name="lname" id="lname" value="" size=""
                                   placeholder="Last Name" > <br>
                            <input type="text" name="midinit" id="midinit" value="" 
                                   placeholder="Middle Name" >
                            <span class="details">Patient Type</span>
                            <select id="pat_type">
                                <option id="reg-patient" value="PAT">Regular</option>
                                <option id="Inpatient" value="IN">Inpatient</option>
                                <option name="outpatient" value="OUT">Outpatient</option>
                                <option name="other" id="other" value="OTH">Other</option>
                                <option name="unknown" id="unknown" value="N/A">Other</option>
                            </select>
                        </div><br>

                        <div class="input-box">
                            <input type="text" name="v1id" id="v1id" value="" 
                                   placeholder="Vaccine #1 ID"><br>
                            <input type="text" name="v2id" id="v2id" value="" 
                                   placeholder="Vaccine #2 ID"><br>
                            <input type="text" name="v3id" id="v3id" value="" 
                                   placeholder="Vaccine #3 ID"><br>
                            <input type="text" name="v4id" id="v4id" value="" 
                                   placeholder="Vaccine #4 ID">
                        </div>

                    </div>

                    <div class="button">
                        <input type="button" name="search" id="search" value="Search Patient" onclick="pageAction('searchPatient')">
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <!--                        <input type="submit" name="search" id="search" value="Search Vaccine" onclick="pageAction('searchVaccine')">
                                                &#8287;  &#8287;  &#8287;  &#8287; -->
                    </div>
                    <br>
                    <!--                    <div id="button">
                                            <input type="reset" class="actionBtn" name="btnClear"  id="btnClear" value="Clear" onclick="clrscrn()">
                                            <input type="submit" class="actionBtn" name="view" id="view" onclick="pageAction('view')" value="Search">
                                            <input type="submit" class="actionBtn" name="create" id="create" onclick="pageAction('create')" value="create">
                                            <br>
                                            <input type="button" class="actionBtn" name="Form 2">
                                            <input type="submit" class="actionBtn" name="report" id="report" onclick="pageAction('report')" value="Create Report">
                                        </div>-->

                    <div class="button">
                        <input type="button" name="btnClear" id="add" value="Add" onclick="document.location = 'VacRecordCreate.jsp';" >
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <input type="reset" name="clear" id="btnClear" value="Clear">
                        &#8287;  &#8287;  &#8287;  &#8287; 

                    </div>
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">SSN</span>
                            <input type="text" placeholder="000-00-000">
                            <input type="submit" value="Edit" onclick="pageAction('edit')">
                        </div>
                        <input type="hidden" name="actiontype" id="actiontype" value="" > 
                    </div>
                    <input type="hidden" name="actiontype" id="actiontype" value="" > 
                </form>
                <form id="editSSN" action="DBAction" method="post">
                    
                    ${msg}
                </form>
                <form action="Logout">
                    <input type="submit" name="logout" id="logout" value="Logout" onclick="document.location = 'index1.jsp';">
                </form>
            </div>


        </div>


        <div id="results"></div>
    </body>
</html>
