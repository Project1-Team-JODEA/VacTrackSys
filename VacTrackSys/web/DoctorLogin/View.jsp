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
        <title> Vaccination Database</title>
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
    <div class="title">Vaccination Entry</div>
    <div class="content">
      <form action="#">
        <div class="user-details">
          <div class="input-box">
            <span class="details">Social Security</span>
            <input type="text" placeholder="Enter the SSN here" required>
          </div>
          <div class="input-box">
            <span class="details">Vaccination #1</span>
            <input type="text" name="" id="" value="" placeholder="Enter vaccination information">
          </div>
          <div class="input-box">
            <span class="details">First Name</span>
            <input type="text" name="" id="" value="" placeholder="Enter the first name " required>
          </div>
          <div class="input-box">
            <span class="details">Vaccination #2</span>
            <input type="text" name="" id="" value="" placeholder="Enter vaccination information">
          </div>
            
          <div class="input-box">
            <span class="details">Last Name</span>
            <input type="text" name="" id="" value="" placeholder="Enter the last name" required>
          </div>
            <div class="input-box">
            <span class="details">Vaccination #3</span>
            <input type="text" name="" id="" value="" placeholder="Enter vaccination information">
          </div>
          <div class="input-box">
            <span class="details">Booster Information</span>
            <input type="text" placeholder="Enter booster information">
          </div>
            <div class="input-box">
            <span class="details">Vaccination #4</span>
            <input type="text" name="" id="" value="" placeholder="Enter vaccination information">
          </div>
        </div>
        <div class="gender-details">
          <input type="radio" name="gender" id="dot-1">
          <input type="radio" name="gender" id="dot-2">
          <input type="radio" name="gender" id="dot-3">
          <span class="gender-title">Gender</span>
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
          <input type="submit" value="Update" onclick="pageAction('update')">
          &#8287;  &#8287;  &#8287;  &#8287; 
          <input type="submit" value="Clear">
          &#8287;  &#8287;  &#8287;  &#8287; 
          <input type="submit" value="Cancel">
        </div>
      </form>
    </div>
  </div>
     
    <div id="results"></div>
</body>
</html>
