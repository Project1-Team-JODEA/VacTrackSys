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
<script src="../js/functions.js"></script>
<script type="text/javascript">

    function pageAction(action) {
        document.RecordsSelection.actiontype.value = action;
        $("actiontype").value = action;
        if (ajax && action === 'searchPatient') {
            ajax.open('get', 'RecordsSelection?actiontype=searchPatient');
            ajax.send(null);
        } else if (ajax && action === 'EditVaccine') {
            ajax.open('post', 'RecordsSelection?actiontype=editVacccine');
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
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png"/>
        <script type="text/javascript">
//            $("")
//            const toggleList = () => {
//           document.getElementById("sortlist").classList.toggle("show");



//            $("list-btn").addEventListener();
//            window.onload = function(){
////            $("list-btn").onclick = toggleList;
//            };

//            $_("#list-btn").addEventListener("click", toggleList);
            const toggleSortValue = () => {
                const sort_items = document.getElementsByClassName("sortval");
            };
            // add events to html
//            document.addEventListener("DOMContentLoaded", () => {
//                $_('#list-btn').addEventListener("click", toggleList);
//            });

//            window.onclick = function (event) {
//            if (!event.target.matches('.sortbtn')) {
//                const sortList = document.getElementById('sort');
////            const sort_items = document.getElementsByClassName("sortval");
//            if (sortList.style.display === 'block') {
//            sortList.style.display = 'block';
//            }
//            $("sortlist").style.display = 'none';
//            }
//            }
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
                                <span class="details">Patient Info</span>
                                <table>
                                    <tr>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span class="details">SSN</span></td>
                                        <td><input type="number" name="ssn" id="ssn" 
                                                   pattern="[0-9]{9,}" maxlength="9" placeholder="(000-00-0000)"></td>
                                        <td>DOB</td>
                                        <td><input type="date" name="dob" id="dob"
                                                   max=""></td>
                                    </tr>            
                                    <tr>
                                        <td><span class="details">First Name:</span></td>
                                        <td><input type="text" name="fname" id="fname"  size=""
                                                   pattern="[A-Za-z]{100}"  ></td>
                                        <td>Vaccination Date</td>
                                        <td><input type="date" name="vac_date" id="vac_date"
                                                   min="2021-11-30"  max="2022-3-10" ></td><!--onclick="setTodayMaxDate('vac_date')"-->
                                    </tr>

                                    <tr>
                                        <td><span class="details">Middle Init:</span></td>
                                        <td><input type="text" name="midinit" id="midinit"  
                                                   pattern="[A-Za-z].{2}" maxlength="1" width="5"></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span class="details">Last Name:</span></td>
                                        <td><input type="text" name="lname" id="lname"  size=""
                                                   pattern="[A-Za-z].{100}" ></td>

                                    </tr>

                                    <tr>
                                        <td><span class="details">Patient Type</span></td>
                                        <td><select id="pat_type">
                                                <option value="">Select</option>
                                                <option svalue="PAT">Regular</option>
                                                <option value="INP">Inpatient</option>
                                                <option value="OUT">Outpatient</option>
                                                <option value="OTH">Other</option>
                                                <option value="N/A">N/A</option>
                                            </select></td>
                                        <!--                                        <td><span class="details">Sort by:</span></td>
                                                                                <td>
                                                                                </td>-->
                                        <!--
                                        -->

                                    </tr>
                                    <tr>
                                        <td><span class="details">Order</span></td>
                                        <td><select name="order">
                                                <option value="ASC">Ascending</option>
                                                <option value="DESC">Descending</option>
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
                        <!--<span class="details">Sort By:</span>-->
                        <input type="button" name="list-btn" class="sortbtn" id="list-btn" 
                               value="Sort By" onclick="toggleList('sortlist')">
                        <div name="list" class="sort"  >
                            <div class="items" id="sortlist" style="display: none;" > 

                                <!--<label for="sort_type">Patient Type</label>-->
                                
                                <input type="checkbox" name="sortval" class="sortval" 
                                       id="sort_ptype" value="Patient Type">
                                <!--<span class="details"></span>-->
                                <input type="checkbox" name="sortval" class="sortval" 
                                       id="sort_fname" value="First Name" >
                                <input type="checkbox" name="sortval" class="sortval" 
                                       id="sort_lname" value="Last Name" >
                                <input type="checkbox" name="sortval" class="sortval" 
                                       id="sort_v1id" value="Vaccine 1" >
                                <input type="checkbox" name="sortval" class="sortval" 
                                       id="sort_v2id" value="Vaccine 2" >
<!--                                <ul>
                                    <li>
                                        hi
                                    </li>
                                    <li>hi</li>
                                    <li>hi</li>
                                    <li>hi</li>
                                    <li></li>
                                    
                                </ul>-->
                            </div>

                        </div>
                        <input type="text" name="txtsort" id="sort" value="" 
                               readonly>
                        <div class="input-box">

                        </div>
                        <input type="checkbox" name="sortval" class="sortval" 
                                       id="sort_ptype"  value="Patient Type">
                        <!--                            <table>
                          <tr>
                                                    <td><span class="details">Sort</span></td>
                                                     <td><select id="sort">
                                                            <option value="N/A">
                                                            <input type="checkbox" value="example"></option>
                                                            <option value="pat_type">Patient Type</option>
                                                            
                                                            <option value="ssn">ssn</option>
                                                                        <option value="OUT">Outpatient</option>
                                                            <option value="OTH">Other</option>
                                                        </select></td>
                                                </tr>
                                    </table>-->
                        <div class="vac-details">

                            <div class="input-box" id="vac-info">
                                <table>
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
                                        <td style="width: 100px;"><input type="submit"  class="edit-btn" value="Edit Vaccine"></td>
                                    </tr>
                                    <tr>
                                        <td><span class="details">Vaccine 3</span></td>                                        
                                    </tr>
                                    <tr>
                                        <td><input type="text" name="v3id" id="v3id"  
                                                   pattern="[0-9]{8}" placeholder="00000000"></td>
                                        <td style=""><input type="submit"  class="edit-btn" name="edit_v3" 
                                                            id="edit_v3" value="Edit Vaccine"></td>
                                    </tr>
                                    <tr>
                                        <td><span class="details">Vaccine 4</span></td>                                        
                                    </tr>
                                    <tr>
                                        <td> <input type="text" name="v4id" id="v4id" 
                                                    pattern="[0-9]{8}" placeholder="00000000"></td>
                                        <td style=""><input type="submit"  class="edit-btn" name="edit_v4" 
                                                            id="edit_v4" value="Edit Vaccine"></td>
                                    </tr>
                                </table>

                            </div>


                        </div>
                    </div>

                    <!--                    <div class="button">
                                            
                                                                    <inp                                            ut type="submit" name="search" id="search"                                        value="Search Vaccine" onclick="pageActio                                    n('searchVaccine')">
              &#8287;                            &#8287;  &#8287;  &#8287; 
                                                                                        </div>-->
                    <br>
                    <!--                    <div id="button">
<input type="reset" class="actionBtn" name="btnClear"  id="btnClear" value="C                                                                            lear" onclick="clrscrn()">
<input type="submit" class="actio                                                nBtn" name="view" id="view" onclick="pageAction('v                            iew')" value="Search">
<input type="submit"                                                    class="actionBtn" name="create" id="create" onclick="pageAction('create')" value="create">
<br>
<input type="button" class="actionBtn" name="Form 2">
<input type="su                                                    bmit" class="actionBtn" name="report" id="report" onclick="pageAction('report')" value="Create Report">
</div>-->

                    <div class="button">
                        <input type="submit" name="search" id="search" value="Search Patient">
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <!--<input type="button" name="btnClear" id="add" value="Add" onclick="document.location =                                                 'VacRecordCreate.jsp';" >-->
                        <!--&#8287;  &#8287;  &#8287;  &#8287;-                                -> 
                           <input type="reset" name="clear" id="btnClear" value="Clear">
                                        &#8287;  &#8287;  &#8287;  &#8287; 
                                        </div>
   
                       <input type="hidden" name="actiontype" id="actiontype" value="" > 
   
                   </form>
                        <!--                <form id="editSSN" action="DBAction" met                                hod="post">
                   

                                   </form>-->
                        <input type="button"                             name="logout" id="logout" va                            lue="Logout" onclick="document.location = 'index1.jsp';">

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
