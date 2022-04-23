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
<script src="../js/ajax.js" lang="javascript" type="text/javascript"></script>
<!--<script src="../js/searchPatient.js" type="text/javascript"></script>-->
<link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png"/>
<script type="text/javascript">
    var $ = function (id) {
        return document.getElementById(id);
    };
    function pageAction(action) {
        document.NewRecord.actiontype.value = action;
        $("actiontype").value = action;
//        if (ajax && action === 'add') {
//            ajax.open('get', '?actiontype=searchPatient');
//            ajax.send(null);
//        } else if (ajax && action === 'Edit') {
//            ajax.open('get', '?actiontype=AddPatient');
//            ajax.send(null);
//        } else {
//            
//        }
        document.NewRecord.submit();
    }
</script>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vaccination Database - New Patient</title>
        <link rel="stylesheet" href="formstyle.css" type="text/css"/>
        <!--<link rel="stylesheet" href="formstyle.css" type="text/css">-->
        <link rel="stylesheet" href="../css/all.css" type="text/css">
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png">
        <script src="../js/functions.js" type="text/javascript"></script>
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
    <c:if test="${!u.authenticated}">
        <script type="text/javascript">
            window.window.location = "/VacTrackSys/DoctorLogin/index1.jsp";
        </script>
    </c:if>
    <body>
        <!-- Authentication -->


        <!-- 
                For Searching through database
        -->
        <p>
            <%--User: ${u.userid}, ${u.access_level} Level--%>
        </p>
        <div class="toggle-box" id="loading-box">
            <div class="toggle-content" id="loading-content" style="display: none;">
                <i class="fas fa-spinner fa-spin fa-5x" 
                   style="font-family: 'Poppins', serif;"></i>

            </div>
        </div>
        <div class="toggle-box" id="msg-box">
            <div class="toggle-content" id="msg-content" style="display: none;">
                <span style="font-weight: bold ;">Database Messages</span> <br>
                <p>${msg}</p>
            </div>
        </div>
        <div class="container">
            <i class="fas fa-user-circle fa-2x" class="vac-btn" id="prof-btn"
               title="User profile"></i><p>User: ${u.username} - ${u.accesslevel} </p>
            <div class="title">Patient Database Records - New Entry</div>
            <div class="content">

                <form name="NewRecord" id="NewRecord" action="EditPatient" method="post">
                    <div class="user-details">

                        <div class="input-box">
                            <span class="details">Patient Info</span>
                            <input type="text" name="ssn" id="ssn" value="${selectedPatient.ssn}" placeholder="SSN" required>
                        </div>
                        <div class="input-box">
                            <span class="details">Vaccines</span>
                            <input type="text" name="v1id" id="v1id" value="${selectedPatient.vac1.vid}" 
                                   placeholder="Vaccine #1 ID"></div>
                        <div class="input-box"><input type="text" name="fname" id="fname" value="${selectedPatient.fname}" size=""
                                                      placeholder="First Name"></div>
                        <div class="input-box"><input type="text" name="v2id" id="v2id" value="${selectedPatient.vac2.vid}" 
                                                      placeholder="Vaccine #2 ID"></div>
                        <div class="input-box"><input type="text" name="lname" id="lname" value="${selectedPatient.lname}" size=""
                                                      placeholder="Last Name" > </div>
                        <div class="input-box"><input type="text" name="v3id" id="v3id" value="${selectedPatient.vac4.vid}" 
                                                      placeholder="Vaccine #3 ID"></div>
                        <div class="input-box"> <input type="text" name="midinit" id="midinit" value="${selectedPatient.mname}" 
                                                       placeholder="Middle Init" maxlength="1"></div>
                        <div class="input-box"><input type="text" name="v4id" id="v4id" value="${selectedPatient.vac4.vid}" 
                                                      placeholder="Vaccine #4 ID"></div>                        
                        <div class="input-box">
                            <span class="details">Patient Type</span>
                            <select id="pat_type">
                                <option id="reg-patient" value="PAT">Regular</option>
                                <option id="Inpatient" value="IN">Inpatient</option>
                                <option value="OUT">Outpatient</option>
                                <option  id="other" value="OTH">Other</option>
                                <option  id="unknown" value="N/A">Other</option>
                            </select>
                        </div>
                        <div class="input-box">
                            <span class="details">DOB</span>
                            <input type="date" name="dob" id="dob" value="${selectedPatient.dob}">
                        </div>
                        <!--                        <div class="input-box">
                                                    <span class="details">Location</span>
                                                    <input name="loc" id="loc" value="" >
                                                    <select id="loc">
                                                        
                                                    </select>
                                                </div>-->
                    </div>
                    <div></div>
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
                        <input type="submit" name="add" id="add" value="Add" onclick="pageAction('add')" ><!--onclick="pageAction2('add')" -->
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <input type="submit" name="edit" id="edit" value="Update" onclick="pageAction('update')" ><!--onclick="pageAction2('add')" -->
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <input type="submit" name="backbtn" id="back" value="Cancel" onclick="pageAction('cancel')" >

                    </div>

                    <input type="hidden" name="actiontype" id="actiontype" value="" > 
                </form>
                <!--<i class="fas fa-1-5x fa-door-open" title="Logout" style="float: right;" onclick="pageAction2('Logout', '')"></i>-->
                <i class="fa-1-5x fas fa-exclamation-triangle" onclick="toggleList('msg-content')" id="msg-btn">Messages</i>
                <!--<form action="DBAction"></form>-->
            </div>


        </div>


        <div id="results"></div>
    </body>
</html>
