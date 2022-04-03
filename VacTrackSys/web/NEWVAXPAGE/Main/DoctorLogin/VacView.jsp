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
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>
<script src="../js/ajax.js" type="text/javascript"></script>
<script type="text/javascript">
    function pageAction(action) {
        document.vacrecord.actiontype.value = action;
//        if (ajax && action === 'edit') {
//            
//        } else {
//           
//        }
        document.vacrecord.submit();
    }


</script>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vaccine Record - Create</title>
        <link rel="stylesheet" href="../css/formstyle.css" type="text/css"/>
        <link rel="stylesheet" href="../css/all.css" type="text/css"/>
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png">
        <script src="../js/functions.js" type="text/javascript"></script>
        <script type="text/javascript">
    window.onload = () => {
        $("vac_date").max = getTodayMaxDate();
    };
//            var $ = function (id) {
//                return document.getElementById(id);
//            };
    document.getElementById("vacrecord").onsubmit = () => {
        $("update").setAttribute("disabled", null);
        $("add").setAttribute("disabled", null);
        toggleList('loading-content');
    };
        </script>
    </head>
    <body>
        <!-- Authentication -->
        <%--  <c:if test="${!u.authenticated}">
              <script type="text/javascript">
                  window.window.location = "/VacTrackSys/DoctorLogin/index1.jsp";
              </script>
          </c:if> --%>
        <div class="toggle-box" id="loading-box">
            <div class="toggle-content" id="loading-content" style="display: none;">
                <i class="fas fa-spin fa-spinner"
                   style="color: blue; font-size: 10em;
                   text-align: center;"></i>

            </div>
        </div>
        <div class="toggle-box" id="msg-box">
            <div class="toggle-content" id="msg-content" style="display: none;">
                <span style="font-weight: bold ;">Database Messages</span> <br>
                <p>${msg}</p>
            </div>
        </div>
        <div class="container">
            <div class="title">New Vaccine Entry</div>
            <div class="content">
                <form name="vacrecord" id="vacrecord" action="EditVaccine" method="post"
                      onsubmit="">
                    <div class="user-details">
                        <div class="input-box">
                            <span class="details">Vaccination ID</span>
                            <input type="number" name="vid" id="vid" maxlength="8"
                                   placeholder="Enter Vaccine ID here"
                                   value="${vac.vid}" required>
                        </div>
                        <!--                        <div class="input-box">
                                                    <span class="details">Location</span>
                                                    <select></select> 
                                                    <datalist id="loc">
                                                        <data></data>
                                                    </datalist>
                                                  
                                                </div>-->
                        <div class="input-box">
                            <span class="details">Location</span>
                            <input type="text" name="loc" id="loc" placeholder="Location" 
                                   value="${vac.location}"required>
                        </div>

                        <div class="input-box">
                            <span class="details">Manufacturer</span>
                            <input type="text" name="man" id="man" 
                                   placeholder="Enter vaccine manufacturer here"
                                   value="${vac.manufacturer}"  required>
                            <select name="man" id="man">
                                <option value="">Select</option>
                                <option value="Pfizer">Pfizer</option>
                                <option value="Johnson & Johnson">Johnson & Johnson</option>
                                <option value="Mederma">Mederma</option>
                            </select>
                        </div>
                        <div class="input-box">
                            <span class="details">Date</span>
                            <input type="date" name="vac_date" id="vac_date"
                                   min="2021-11-30" max="" value="${vac.date}"
                                   required>
                        </div>
                        <div class="input-box">
                            <span class="details">Batch Number</span>
                            <input type="number" name="batnum" id="batnum" 
                                   placeholder="Enter batch # here" 
                                   maxlength="10" value="${vac.lotnum}">
                        </div>

                        <div class="input-box">
                            <span class="details">Vaccine Type</span>
                            <select name="vac_type" id="vac_type">
                                <option value="REG">Regular</option>
                                <option value="BOS">Booster</option>
                            </select>
                        </div>
                    </div>

                    <div class="button">
                        <input type="submit" id="update" value="Update" onclick="pageAction('update')">
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <input type="submit" id="add" value="Add" onclick="pageAction('add')">
                        &#8287;  &#8287;  &#8287;  &#8287; 
                        <input type="reset" value="Clear">
                        &#8287;  &#8287;  &#8287;  &#8287; 
                    </div>
                    <button type="submit" style="float: right;" onclick="document.location = 'DoctorLogin/VaccinationDB.jsp';">Go back<i class="fas fa-arrow-right"></i></button>
                    <input type="hidden" name="actiontype" id="actiontype" value="">
                </form>
                <!--                        <form action="DBAction">
                                            <button type="submit">Go back<i class="fas fa-arrow-right"></i></button>
                                        </form>-->
                <i class="fa-1-5x fas fa-exclamation-triangle" onclick="toggleList('msg-content')" id="msg-btn">Messages</i>
            </div>
        </div>

        <!--<div class="container"id="results"></div>-->
    </body>
</html>
