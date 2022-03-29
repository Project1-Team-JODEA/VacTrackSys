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
<script src="../js/ajax.js"></script>
<script type="text/javascript">
    function pageAction(action) {
        document.dbform.actiontype.value = action;
        if (ajax && action === 'edit') {
            ajax.open('get', 'PatientRecords?actiontype=searchPatient');
            ajax.send(null);
        } else {
            document.dbform.submit();
        }
    }


</script>
<html lang="en" dir="ltr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vaccine Record - Create</title>
        <link rel="stylesheet" href="formstyle.css" type="text/css"/>
        <script src="../js/functions.js"></script>
        <script type="text/javascript">
            window.onload = function(){
                $("vac_date").max = getTodayMaxDate();
            };
//            var $ = function (id) {
//                return document.getElementById(id);
//            };
            function clrscrn() {
                $("Records").reset();
                $("rid").focus();
            }
        </script>
    </head>
    <body>
        <!-- Authentication -->
      <%--  <c:if test="${!u.authenticated}">
            <script type="text/javascript">
                window.window.location = "/VacTrackSys/DoctorLogin/index1.jsp";
            </script>
        </c:if> --%>
     <div class="container">
    <div class="title">New Vaccine Entry</div>
    <div class="content">
      <form name="RecordCreate" id="newrecord" action="UpdateVaccine" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Vaccination ID</span>
            <input type="text" id="vid" name="vid"
                   placeholder="Enter Vaccine ID here">
          </div>
          <div class="input-box">
            <span class="details">Location</span>
            <input type="text" id="loc" name="loc" placeholder="Enter vaccination location here" required>
          </div>
          <div class="input-box">
            <span class="details">Manufacturer</span>
            <input type="text" id="man" name="man" placeholder="Enter vaccine manufacturer here" required>
          </div>
          <div class="input-box">
            <span class="details">Date</span>
            <input type="date" name="vac_date" id="vac_date"
                  min="2021-11-30" max="">
          </div>
          <div class="input-box">
            <span class="details">Batch Number</span>
            <input type="text" id="batnumb" name="batnumb" placeholder="Enter batch # here" required>
          </div>
            <div class="input-box">
                            <span class="details">Vaccine Type</span>
                            <select id="vac_type" name="vac_type">
                                <option value="REG">Regular</option>
                                <option value="BOS">Booster</option>
                            </select>
            </div>
            
        </div>
<!--        <div class="gender-details">
          <input type="radio" name="gender" id="dot-1">
          <input type="radio" name="gender" id="dot-2">
          <input type="radio" name="gender" id="dot-3">
          <span class="gender-title">Vaccine Type</span>
          <div class="category">
            <label for="dot-1">
            <span class="dot one"></span>
            <span class="gender">Male</span>
          </label>
          <label for="dot-2">
            <span class="dot two"></span>
            <span class="gender">Female</span>
          </label>
          <label for="dot-3">
            <span class="dot three"></span>
            <span class="gender">Prefer not to say</span>
            </label>
          </div>
        </div>-->
        <div class="button">
          <input type="submit" value="Create" onclick="pageAction('UpdateVaccine')">
          &#8287;  &#8287;  &#8287;  &#8287; 
          <input type="reset" value="Clear">
          &#8287;  &#8287;  &#8287;  &#8287; 
          <input type="submit" value="Cancel" onclick="document.location='VaccinationDB.jsp';">
        </div>
      </form>
    </div>
  </div>
     
    <!--<div class="container"id="results"></div>-->
</body>
</html>
