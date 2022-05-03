<%-- Vaccination Tracking System File name : VaccinationDB Date : Feb 18, 2022, 3:49:10 PM Author(s) : Elena Miller,
    DeShane` Sims Supporting File(s): --%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="../js/ajax.js" lang="javascript" type="text/javascript"></script>

<script>

</script>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Team_JODEA"> 
        <title>Doctor - Patient Vaccination Database</title>
        <link rel="stylesheet" href="formstyle.css" type="text/css">
        <link rel="stylesheet" href="../css/all.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!--<link rel="stylesheet" href="../.css" type="text/css"/>-->
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png">
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <script src="../js/functions.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="script.js"  lang="javascript" type="text/javascript"></script>
        <script language="javascript" type="text/javascript">

    function pageAction(action) {
        if (ajax && action === 'SearchPatient') {
            ajax.open('get', 'DBAction?type=SearchPatient', true);

            ajax.send();
            /**  $.get('DBAction', 'actiontype=SearchPatient', function (data, status) {
             $.
             });*/

        } else {
            document.dbaction.submit();
        }
    }
    function pageAction2(action, val_id) {
        //        var a = window
        //        console.log(val);
        //        document.getElementById("actiontype").setAttribute("value", action);
        document.dbaction.actiontype.value = action;
        console.log(document.dbaction.actiontype.value);
        if (action === 'SearchPatient') {
            pageAction(action);
            document.dbaction.vid.value = val;
            document.dbaction.submit();
        } else if (action == 'EditVaccine') {
            var val = $(val_id).value;
            document.dbaction.vid.value = val;
            document.dbaction.submit();
        }
        // else if (ajax && action == 'AddPatient'){
        //     ajax.open('get', 'RecordsSelection?actiontype=SearchPatient');
        //     ajax.send(null);
        // }
        else {
            document.dbaction.submit();
        }
    }
    window.onload = () => {

    };
        </script>

    </head>
    <c:if test="${!u.authenticated}">
        <script type="text/javascript">
            window.window.location = "/VacTrackSys/Redirect_Home.jsp";
            ``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````</script>
        </c:if>
    <body>
        <!-- Authentication -->
        <!-- 
For Searching through database
        -->
        <c:if test="${u.authenticated}">

            <div class="toggle-box" id="loading-box">
                <div class="toggle-content" id="loading-content" style="display: none;">
                    <i class="fas fa-spin fa-spinner"
                       style="color: blue; font-size: 10em;
                       text-align: center;"></i>
                </div>
            </div>

            <!-- Message Box is for Viewing Database Error Messages-->


            <div class="container" id="input-form">
                <i class="fas fa-user-circle fa-1-5x toggle-btn" class="vac-btn" id="prof-btn"
                   title="User profile">${u.username} - ${u.accesslevel}</i>

                <div class="title">Patient/Vaccine Records
                    <i class="fas fa-1-x fa-question-circle toggle-btn" id="help-btn" title="Click to open Help/Guide"
                       style="float: right;">HELP</i>
                    <i class="fa-1-x fas fa-database toggle-btn" title="Click to view Transaction Messages" onclick="" id="msg-btn" style="float: right;"></i>
                    <div class="toggle-box" id="pro-box">
                        <div class="toggle-content" id="pro-content" style="display: none;">
                            <span style="font-weight: bold ;">${u.username}</span> <br>
                            <p></p>
                        </div>
                    </div>
                </div><br>
                <div class="toggle-box" id="msg-box">
                    <div class="toggle-content" id="msg-content" style="display: none;">
                        <span style="font-weight: bold ;">Database Messages</span> <br>
                        <p>${msg}</p>
                    </div>
                </div>
                <div class="toggle-box" id="help-box">
                    <div class="toggle-content" id="help-content" style="display: none; ">
                        <span style="font-weight: bold ;">Help/Tips</span>
                        <ul>
                            <li>Click on the Message icon (<i class="fas fa-database"></i>) to
                                view any error messages then click on it again to close it.</li>
                            <li>When </li>
                            <li> Try not to refresh the page too many times at once.
                                Otherwise, your search input may not go through.</li>
                            <li><details>
                                    <summary>Patient Records</summary>
                                    <ol>
                                        <li></li>
                                        <li></li>
                                        <li></li>
                                        <li></li>
                                    </ol>
                                </details></li>
                            <li></li>
                        </ul>
                        <!--<textarea readonly> </textarea>-->
                    </div>
                </div> 
                <div class="content">
                    <form name="dbaction" 
                          id="dbaction" action="DBAction"  onsubmit="toggleList('loading-content')">
                        <div class="info">

                            <div class="user-details">
                                <div class="input-box" id="pat-info">
                                    <span class="details">Select Record Action</span>
                                    <div class="button" style="margin: 25px 0;">
                                        <table class="actions">
                                            <tr>
                                                <td><i class="fas fa-user fa-2x" title="Patient Record Actions">Patient</i></td>

                                                <td> <button type="button" class="fas fa-magnifying-glass"  title="Search Patient" value="SearchPatient">
                                                    </button>
                                                </td>
                                                <td> <button type="button" class="fas fa-user-edit" title="Edit Patient" value="EditPatient">
                                                    </button>
                                                </td>
                                                <td> <button type="button" class="fas fa-user-plus" title="Add Patient" value="AddPatient" id="patadd">
                                                    </button>
                                                </td>
                                            </tr>
                                            <tr>
                                                <td><i class="fas fa-syringe fa-2x">Vaccine</i></td>
                                                <td><button type="button"  class="fas fa-plus" title="Add Vaccine" value="AddVaccine" >
                                                    </button>
                                                </td>
                                                <td><button type="button"  class="fas fa-pen fa-1x" title="Edit Vaccine"value="Edit Vaccine" >
                                                    </button></td>
                                            </tr>
                                        </table>
                                        <!--&#8287; &#8287; &#8287; &#8287;-->
                                        <!-- &#8287; &#8287; &#8287; &#8287; -->
                                    </div>

                                    <table>
                                        <tr class="sch" style="display: none;">
                                            <td>
                                                <input type="button" name="list-btn" class="sortbtn"
                                                       id="list-btn" value="Search By: " onclick="toggleList('searchlist')">
                                                <!--<span class="detailes">Search By: </span>-->
                                            </td>
                                            <td><div name="list" class="sort">
                                                    <div class="items" id="searchlist" style="display: none;">
                                                        <ul>
                                                            <li>
                                                                <input type="checkbox" name="sortval" class="sortval" name="ssn1" value="ssn1">
                                                                <label for="ssn1" class="details">Social Security</label> 
                                                            </li>
                                                            <li><input type="checkbox" name="sortval"  class="sortval" name="fname1" value="fname1">
                                                                <label for="fname1" class="details">First Name</label>
                                                            </li>
                                                            <li><input type="checkbox" name="sortval" class="sortval" name="lname1" value="lname1">
                                                                <label for="lname1" class="details">Last Name</label></li>
                                                            <li><input type="checkbox" name="sortval" class="sortval" name="midinit1"  value="midinit1">
                                                                <label for="midinit1" class="details">Middle Initial</label></li>
                                                            <li><input type="checkbox" name="sortval" class="sortval" name="dob1" value="dob1">
                                                                <label for="dob1" class="details">Date of Birth</label></li>
                                                            <li><input type="checkbox" name="sortval" class="sortval" name="vac_id1"  value="vac_id1">
                                                                <label for="vac_id1" class="details">Vaccine (ID)</label></li>
                                                            <li><input type="checkbox" name="sortval" class="sortval"  name="man1" value="man1">
                                                                <label for="man1" class="details">Vaccine (Manufacturer)</label></li>
                                                        </ul>
                                                    </div>
                                                </div></td>
                                        </tr>
                                        <tr id="ssn1" style="display: none;">
                                            <td><label class="details">SSN: </label></td>
                                            <td><input class="pat_info" type="text" name="ssn" id="ssn" maxlength="11" pattern="^(?!000|666)[0-8][0-9]{2}-(?!00)[0-9]{2}-(?!0000)[0-9]{4}$"
                                                       placeholder="(###-##-####)"  title="Nine digit social security code"></td><!--  pattern="[0-9]{3}-[0-9]{2}-[0-9]{4}$" pattern="^(?!666|000|9\d{2})\d{3}-(?!00{2})\d{2}-(?!0000{4})\d{4}$"pattern="\d{3}[\-]\d{2}[\-]\d{4}"-->

                                        </tr>
                                        <tr id="fname1" style="display: none;">
                                            <td><span class="details">First Name:</span></td>
                                            <td><input class="pat_info" type="text"
                                                       name="fname" id="fname" pattern="[a-zA-z]"></td>
                                            <!-- pattern="[A-Za-z].{1,}"  -->
                                        </tr>
                                        <tr  id="midinit1" style="display: none;">
                                            <td><span class="details">Middle Initial:</span></td>
                                            <td><input class="pat_info" type="text" name="midinit" id="midinit" maxlength="1" pattern="[a-zA-Z]{1}" width="5"></td>

                                        </tr>
                                        <tr id="lname1" style="display: none;">
                                            <td><span class="details">Last Name:</span></td>
                                            <td><input  type="text" class="pat_info" name="lname" id="lname" pattern="[a-zA-z].{1,}"></td>

                                        </tr>
                                        <tr id="dob1" style="display: none;">
                                            <td><span class="details">Birth Date: </span></td>
                                            <td><input type="date" class="pat_info" name="dob" id="dob" max=""></td>
                                        </tr>
                                        <tr  class="vac_date" style="display: none;">
                                            <td><span class="details">Vaccination Date: </span></td>
                                            <td><input type="date" class="pat_info" name="vac_date" id="vac_date" min="2021-11-30" max=""></td>
                                        </tr>
                                        <tr id="pat_type1" style="display: none;">
                                            <td><span class="details">Patient Type</span></td>
                                            <td><select id="pat_type" class="pat_info">
                                                    <option value="">Select</option>
                                                    <option svalue="PAT">Regular</option>
                                                    <option value="INP">Inpatient</option>
                                                    <option value="OUT">Outpatient</option>
                                                    <option value="OTH">Other</option>
                                                    <option value="N/A">N/A</option>
                                                </select></td>
                                        </tr>

                                        <tr id="vac_id1" style="display: none;">
                                            <td><span class="details">Vaccine ID:</span></td>
                                            <td>
                                                <input type="number" class="pat_info" name="vac_id" id="vac_id" pattern="[0-9]{8}" placeholder="00000000" >
                                            </td>


                                        </tr>
                                        <tr id="man1" style="display: none;">
                                            <td><span class="details">Manufacturer</span>
                                                <input type="text" name="man" id="man" 
                                                       placeholder="Enter vaccine manufacturer here"
                                                       value="" pattern=""></td>
                                            <td> <select name="man" id="man" class="vac_info">
                                                    <option value="">Select</option>
                                                    <option value="Pfizer">Pfizer</option>
                                                    <option value="Johnson & Johnson">Johnson & Johnson</option>
                                                    <option value="Mederma">Mederma</option>
                                                </select></td>
                                        </tr>
                                        <tr class="sch"  style="display: none;">
                                            <td>
                                                <!--<i class="fas fa-magnifying-glass"></i>-->
                                                <input type="submit" id="action" value="">
                                            </td>
                                        </tr>
                                    </table>
                                </div>
                            </div>
                            <!--<span class="details">Sort By:</span>-->

                            <!--                            <div class="vac-details" style="display: none;">
                            
                                                            <div class="input-box" id="vac-info">
                                                                <table>
                                                                    <tr>
                                                                        <td><span class="details">Vaccine 1</span></td>
                                                                        <td></td>
                                                                    </tr>
                                                                    <tr>
                                                                        <td><input type="number" name="v1id" id="v1id" pattern="[0-9]{8}" min="0" placeholder="000000000"></td>
                                                                        <td style="width: 50px;">
                            <c:if test="${u.accesslevel=='MedicalStaff' || u.accesslevel=='Admin'}">
                                <i class="vac-btn fas fa-pen-square fa-2x" name="edit_v1" id="edit_v1" title="Edit Vaccine" value="Edit Vaccine" onclick="pageAction2('EditVaccine', 'v1id')"></i>
                                <input type="submit"  class="edit-btn" name="edit_v1" id="edit_v1" value="Edit Vaccine">
                                <td><input type="number" > </td>
                            </c:if>
                        </td>
                        <td>
                            <c:if test="${u.accesslevel=='MedicalStaff' || u.accesslevel=='Admin'}">
                                <i class="vac-btn fas fa-plus-square fa-2x" name="add" id="add_v1" title="Add Vaccine" value="Edit Vaccine" onclick="pageAction2('AddVaccine', 'v1id')"></i>
                            </c:if>
                        </td>
                         <td><i ></i></td> 
                    </tr>
                    
                    </table>
                </div>
                
            </div>-->

                        </div>
                        <div class="button">
                            <button type="reset" title="Clear Text Fields" >CLEAR </button>
                            <button type="button" id="resetForm" title="Reset Form" >Reset Form</button>
                            <i class="fas fa-2x fa-door-closed " id="Logout"  title="Logout" 
                               style=" cursor: pointer; "></i>
                        </div>
                        <input type="hidden" name="actiontype" id="actiontype" value="">
                    </form>
                </div>
            </div>
            <div id="results"></div>
            <!--                <div class="container" id="rs-form">
                                <div class="title">Results</div>
                                <div class="content" id="rs-content">
                                    <hr>
                                   
                                </div>
                            </div>-->

        </c:if>
    </body>
</html>