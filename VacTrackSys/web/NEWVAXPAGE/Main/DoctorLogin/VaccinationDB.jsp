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
<script src="../js/functions.js"
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
        } else {
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
                <div class="title">Patient Database Records Selection</div>
                <div class="content">

                    <form name="RecordsSelection" id="RecordsSelection" action="Search" method="post">
                        <div class="info">
                            <div class="user-details">

                                <div class="input-box" id="pat-info">
                                    <table>
                                        <tr>
                                            <td><span class="details">Patient Info</span></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td><span class="details">SSN</span></td>
                                            <td><input type="text" name="ssn" id="ssn" 
                                                       pattern="[0-9]{9,}" placeholder="SSN (000-00-0000)"></td>
                                        </tr>            
                                        <tr>
                                            <td><span class="details">First Name:</span></td>
                                            <td><input type="text" name="fname" id="fname"  size=""
                                                       pattern="[A-Za-z]" ></td>
                                            <td></td>
                                            <td></td>
                                        </tr>
                                        <tr>
                                            <td><span class="details">Middle Init:</span></td>
                                            <td><input type="text" name="midinit" id="midinit"  
                                                       pattern="[A-Za-z]{2}" ></td>
                                        </tr>
                                        <tr>
                                            <td><span class="details">Last Name:</span></td>
                                            <td><input type="text" name="lname" id="lname"  size=""
                                                       placeholder="" ></td>
                                        </tr>
                                        
                                        <tr>
                                            <td><span class="details">Patient Type</span></td>
                                            <td><select id="pat_type">
                                                    <option name="unknown" id="unknown" value="N/A">Select</option>
                                                    <option id="reg-patient" value="PAT">Regular</option>
                                                    <option id="Inpatient" value="IN">Inpatient</option>
                                                    <option name="outpatient" value="OUT">Outpatient</option>
                                                    <option name="other" id="other" value="OTH">Other</option>
                                                </select></td>
                                        </tr>
                                    </table>


                                </div>
                                <!--                                <div class="input-box">
                                                                    <span class="details">Vaccines</span>
                                                                    <input type="text" name="v1id" id="v1id" value="" 
                                                                           pattern="" placeholder="Vaccine #1 ID"></div>-->

                                <!--                                <div class="input-box"><input type="text" name="v2id" id="v2id" value="" 
                                                                                              placeholder="00000000"></div>-->

                                <!--                                <div class="input-box"><input type="text" name="v3id" id="v3id" value="" 
                                                                                              placeholder="Vaccine #3 ID"></div>-->

                                <!--                                <div class="input-box"><input type="text" name="v4id" id="v4id" value="" 
                                                                                              placeholder="Vaccine #4 ID"></div>                        -->
               

                            </div>

                            <div class="vac-details">

                                <div class="input-box">
                                    <table style="width: 100%;">
                                        <tr>
                                            <td><span class="details">Vaccine 1</span></td>
                                            <!--<td></td>-->
                                        </tr>
                                        <tr>
                                            <td><input type="text" name="v1id" id="v1id" 
                                                       pattern="[0-9]{8}" placeholder="00000000"></td>
                                            <td style="width: 100px;"> <input type="submit"  class="edit-btn" name="edit_v1" id="edit_v1" value="Edit Vaccine"></td>
                                        </tr>
                                        <tr>
                                            <td><span class="details">Vaccine 2</span></td>
                                            <!--<td style=""></td>-->
                                        </tr>
                                        <tr>
                                            <td><input type="text" name="v2id" id="v2id" 
                                                       pattern="[0-9]{8}" placeholder="00000000"></td>
                                            <td style=""><input type="submit"  class="edit-btn" value="Edit Vaccine"></td>
                                        </tr>
                                        <tr>
                                            <td><span class="details">Vaccine 3</span></td>
                                            <!--<td style=""></td>-->
                                        </tr>
                                        <tr>
                                            <td><input type="text" name="v3id" id="v3id"  
                                                       pattern="[0-9]{8}" placeholder="00000000"></td>
                                            <td style=""><input type="submit"  class="edit-btn" name="edit_v3" id="edit_v3" value="Edit Vaccine"></td>
                                        </tr>
                                        <tr>
                                            <td><span class="details">Vaccine 4</span></td>
                                            <!--<td style=""></td>-->
                                        </tr>
                                        <tr>
                                            <td> <input type="text" name="v4id" id="v4id" 
                                                        pattern="[0-9]{8}" placeholder="00000000"></td>
                                            <td style=""><input type="submit"  class="edit-btn" name="edit_v4" id="edit_v4" value="Edit Vaccine"></td>
                                        </tr>
                                    </table>

                                </div>


                            </div>
                        </div>

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
                            <input type="submit" name="search" id="search" value="Search Patient">
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

            <div class="container">
                <div class="title">Results</div>
                <div class="content">
                    <div id="results"></div>
                </div>
            </div>

        </body>
    </html>
