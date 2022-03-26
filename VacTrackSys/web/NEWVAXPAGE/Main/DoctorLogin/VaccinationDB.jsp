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
<script src ="../js/dbaction.js"></script>
<script type="text/javascript">
   

</script>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vaccination Database</title>
        <link rel="stylesheet" href="formstyle.css" type="text/css"/>
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png"/>
        <script type="text/javascript">
//            const toggleSortValue = () => {
//                const sort_items = document.getElementsByClassName("sortval");
//            };
//            var input = document.getElementsByName("sortval");
//            var i=0;
//            
//            $("sort_ptype").
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
<!--                                    <tr>
                                        <td></td>
                                        <td></td>
                                    </tr>-->
                                    <tr>
                                        <td><span class="details">SSN</span></td>
                                        <td><input type="number" name="ssn" id="ssn" 
                                                   placeholder="(000-00-0000)"></td>
                                        <td>DOB</td>
                                        <td><input type="date" name="dob" id="dob"
                                                   max=""></td>
                                    </tr>            
                                    <tr>
                                        <td><span class="details">First Name:</span></td>
                                        <td><input type="text" name="fname" id="fname"  size=""
                                                   ></td>
                                        <td>Vaccination Date</td>
                                        <td><input type="date" name="vac_date" id="vac_date"
                                                   min="2021-11-30"  max="2022-3-10" ></td><!--onclick="setTodayMaxDate('vac_date')"-->
                                    </tr>

                                    <tr>
                                        <td><span class="details">Middle Init:</span></td>
                                        <td><input type="text" name="midinit" id="midinit"  
                                                   width="5"></td>
                                        <td></td>
                                        <td></td>
                                    </tr>
                                    <tr>
                                        <td><span class="details">Last Name:</span></td>
                                        <td><input type="text" name="lname" id="lname"  size=""
                                                   ></td>

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
                                <!--<span class="details"></span>-->

                                <!--<span>Last Name</span>-->
                                <!--<span>Vaccine 1</span>-->
                                <!--<span>Vaccine 2</span>-->
                                <ul>
                                    <li>
                                        <input type="checkbox" name="sortval" class="sortval" 
                                               id="sort_ptype" value="P_Type" onclick="sort_ptype">Patient Type
                                        <!--                                        <span class="details">Patient Name</span> -->
                                    </li>

                                    <li><input type="checkbox" name="sortval" class="sortval" 
                                               id="sort_fname" value="First_Name" onclick="toggleSortVal('p_type')" >First Name
                                        <!--<span class="details">First Name</span>-->
                                    </li>
                                    <li><input type="checkbox" name="sortval" class="sortval" 
                                               id="sort_lname" value="Last_Name" >Last Name</li>
                                    <li><input type="checkbox" name="sortval" class="sortval" 
                                               id="sort_v1id" value="Vaccine_1" >Vaccine #1</li>
                                    <li><input type="checkbox" name="sortval" class="sortval" 
                                               id="sort_v2id" value="Vaccine_2" > Vaccine #2</li>
                                    <li><input type="checkbox" name="sortval" class="sortval" 
                                               id="sort_v3id" value="Vaccine_3" > Vaccine #3</li>
                                    <li><input type="checkbox" name="sortval" class="sortval" 
                                               id="sort_v4id" value="Vaccine_4" > Vaccine #4</li>
                                    <li></li>
                                    <li></li>
                                    <li></li>
                                </ul>
                            </div>

                        </div>

                        <input type="text" name="txtsort" id="sort" value="" 
                               readonly>
                        <!--                        <div class="input-box">
                        
                                                </div>-->
                        <!--                        <input type="checkbox" name="sortval" class="sortval" 
                                                               id="sort_ptype"  value="Patient Type">-->
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
                                                            id="edit_v3" value="Edit Vaccine" onclick="pageAction('EditVaccine')"></td>
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

                    <!--                    <div id="button">
                    
                                            <input type="submit" class="actionBtn" name="view" id="view" onclick="pageAction('view')" value="Search">
                                            <input type="submit"class="actionBtn" name="create" id="create" onclick="pageAction('create')" value="create">
                                            <br>
                                            <input type="button" class="actionBtn" name="Form 2">
                                            <input type="submit" class="actionBtn" name="report" id="report" onclick="pageAction('report')" value="Create Report">
                                        </div>-->

                    <div class="button">
                        <input type="submit" name="search" id="search" value="Search Patient">
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <input type="button" name="btnClear" id="btnClear" value="Add" onclick="document.location = 'PatientRecordCreate.jsp';" >
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <input type="reset" class="actionBtn" name="btnClear"  id="btnClear" value="Clear">

                    </div>
                    <!--&#8287;  &#8287;  &#8287;  &#8287;-                                -> 
                       <input type="reset" name="clear" id="btnClear" value="Clear">
                                    &#8287;  &#8287;  &#8287;  &#8287; 
                                    </div>
                    
                   <input type="hidden" name="actiontype" id="actiontype" value="" > 


                    <input type="button"name="logout" id="logout" value="Logout" 
                           onclick="document.location = 'index1.jsp';">

                    
                </div>-->

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
