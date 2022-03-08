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
        if (ajax && action === 'search') {
            ajax.open('get', 'RecordsSelection?actiontype=view');
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
        
        <script type="text/javascript">
            var $ = function (id) {
                return document.getElementById(id);
            };
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
      <form name="RecordCreate" id="newrecord" action="addRecord" method="post">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Vaccination ID</span>
            <input type="text" placeholder="Enter Vaccine ID here" required>
          </div>
          <div class="input-box">
            <span class="details">Location</span>
            <input type="text" placeholder="Enter vaccination location here" required>
          </div>
          <div class="input-box">
            <span class="details">Manufacturer</span>
            <input type="text" placeholder="Enter vaccine manufacturer here" required>
          </div>
          <div class="input-box">
            <span class="details">Date</span>
            <input type="text" name="" id="" placeholder="Enter date here">
          </div>
          <div class="input-box">
            <span class="details">Batch Number</span>
            <input type="text" placeholder="Enter batch # here" required>
          </div>
            
        </div>
        <div class="gender-details">
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
        </div>
        <div class="button">
          <input type="submit" value="Create" onclick="pageAction('update')">
          &#8287;  &#8287;  &#8287;  &#8287; 
          <input type="submit" value="Clear" onclick="clrscrn()">
          &#8287;  &#8287;  &#8287;  &#8287; 
          <input type="submit" value="Cancel" onclick="document.location='VaccinationDB.jsp';">
        </div>
      </form>
    </div>
  </div>
     
    <!--<div class="container"id="results"></div>-->
</body>
</html>
