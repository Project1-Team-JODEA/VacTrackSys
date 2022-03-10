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
<link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png"/>
<script type="text/javascript">
    var $ = function (id) {
        return document.getElementById(id);
    };
    function pageAction(action) {
        document.RecordsSelection.actiontype.value = action;
        $("actiontype").value = action;
        if (ajax && action === 'searchPatient') {
            ajax.open('get', '?actiontype=searchPatient');
            ajax.send(null);
        } else if (ajax && action === 'Edit') {
            ajax.open('get', '?actiontype=AddPatient');
            ajax.send(null);
        } else {
            document.RecordsSelection.submit();
        }
    }


</script>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vaccination Database - New Patient</title>
        <link rel="stylesheet" href="formstyle.css" type="text/css"/>

        <script type="text/javascript">
            var $ = function (id) {
                return document.getElementById(id);
            };
            function clrscrn() {
                //$("Records").reset();
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
            <div class="title">Patient Database Records - New Entry</div>
            <div class="content">

                <form name="NewRecord" id="NewRecord" action="addRecord" method="post">
                    <div class="user-details">

                        <div class="input-box">
                            <span class="details">Patient Info</span>
                            <input type="text" name="ssn" id="ssn" value="" placeholder="SSN" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Vaccines</span>
                            <input type="text" name="v1id" id="v1id" value="" 
                                   placeholder="Vaccine #1 ID"></div>
                        <div class="input-box"><input type="text" name="fname" id="fname" value="" size=""
                                                      placeholder="First Name"></div>
                        <div class="input-box"><input type="text" name="v2id" id="v2id" value="" 
                                                      placeholder="Vaccine #2 ID"></div>
                        <div class="input-box"><input type="text" name="lname" id="lname" value="" size=""
                                                      placeholder="Last Name" > </div>
                        <div class="input-box"><input type="text" name="v3id" id="v3id" value="" 
                                                      placeholder="Vaccine #3 ID"></div>
                        <div class="input-box"> <input type="text" name="midinit" id="midinit" value="" 
                                                       placeholder="Middle Init" ></div>
                        <div class="input-box"><input type="text" name="v4id" id="v4id" value="" 
                                                      placeholder="Vaccine #4 ID"></div>                        
                        <div class="input-box">
                            <span class="details">Patient Type</span>
                            <select id="pat_type">
                                <option id="reg-patient" value="PAT">Regular</option>
                                <option id="Inpatient" value="IN">Inpatient</option>
                                <option name="outpatient" value="OUT">Outpatient</option>
                                <option name="other" id="other" value="OTH">Other</option>
                                <option name="unknown" id="unknown" value="N/A">Other</option>
                            </select>
                        </div>
                        
                    </div>
                    <div></div>
                        


                    <!--                    <div class="button">
                                            
                                                                    <input type="submit" name="search" id="search" value="Search Vaccine" onclick="pageAction('searchVaccine')">
                                                                    &#8287;  &#8287;  &#8287;  &#8287; 
                                        </div>-->
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
                        <input type="submit" name="add" id="add" value="Add">
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <!--<input type="button" name="btnClear" id="add" value="Add" onclick="document.location = 'VacRecordCreate.jsp';" >-->
                        <!--&#8287;  &#8287;  &#8287;  &#8287;--> 
                        <input type="reset" name="clear" id="btnClear" value="Clear">
                        &#8287;  &#8287;  &#8287;  &#8287; 
                    </div>

                    <input type="hidden" name="actiontype" id="actiontype" value="" > 
                </form>
<!--                <form id="editSSN" action="DBAction" method="post">
                    

                </form>-->
                 <input type="button" name="logout" id="logout" value="Logout" onclick="document.location = 'index1.jsp';">
                
                ${msg}
            </div>


        </div>


        <div id="results"></div>
    </body>
</html>
