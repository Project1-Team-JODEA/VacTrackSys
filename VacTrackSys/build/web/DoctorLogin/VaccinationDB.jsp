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
<html>
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
        <c:if test="${!u.authenticated}">
            <script type="text/javascript">
                window.window.location = "/VacTrackSys/DoctorLogin/index1.jsp";
            </script>
        </c:if>
    <legend> Vaccination Database View/Update </legend>
    <!-- 
            For Searching through database
    -->
    <p>
        <%--User: ${u.userid}, ${u.access_level} Level--%>
    </p>
    <form name="RecordsSelection" id="Records" action="DBAction" method="post">

        <div id="info">
            <fieldset id="person">
                <input type="text" name="ssn" id="ssn" value="" placeholder="SSN" required> 
                <input type="text" name="fname" id="fname" value="" size=""
                       placeholder="First Name"required>
                <input type="text" name="lname" id="lname" value="" size=""
                       placeholder="Last Name" required>
                <input type="text" name="midinit" id="midinit" value="" 
                       placeholder="Middle Name" required> 
            </fieldset>
            <br>
            <br>
            <fieldset class="vaccines">
                <!--            <input type="date" name="" id="vac_date" value=""
                                   required>-->
                <!--            <input type="text" name="vaccinator" id="vaccinator"
                                   placeholder="Vaccinator" required>-->
                <input type="text" name="vac1" id="vac1" value="" 
                       placeholder="Vaccine #1">
                <input type="text" name="vac1" id="vac2" value="" 
                       placeholder="Vaccine #2">
                <input type="text" name="vac2" id="vac3" value="" 
                       placeholder="Vaccine #3">

            </fieldset>
<!--            <label for="sort">Sort By: </label>
            <select id="sort">
                <option id="name"></option>
            </select>
            <input type="radio" value="">-->
        </div>
        <br>
        <div id="actions">
            <input type="reset" class="actionBtn" name="btnClear"  id="btnClear" value="Clear" onclick="clrscrn()">
            <input type="submit" class="actionBtn" name="view" id="view" onclick="pageAction('view')" value="Search">
            <input type="submit" class="actionBtn" name="create" id="create" onclick="pageAction('create')" value="create">
            <br>
            <input type="button" class="actionBtn" name="Form 2"
            <input type="submit" class="actionBtn" name="report" id="report" onclick="pageAction('report')" value="Create Report">
        </div>
        <br>
        


        <!--        <select id="vac_loc" name="" value="">
                    <option></option>
                </select>
                <input type="text" name="loc" id="loc" required> -->

        <!--        <table id="vac_items">
                    <tr><td>Vaccines</td></tr>
                    <tr>
                        <td>Vaccine #1 </td>
        
                        <td><input type="text" name="manuf" id="manuf1" value="" placeholder="Manufacturer" ></td>
                        <td><input type="number" name="batchNo" id="batchNo1" value="" placeholder="BatchNo."></td>
                    </tr>
                    
                </table>-->
        <!-- For Searching for 'person' object in database -->


        <input type="hidden" name="actiontype" id="actiontype" value="" > 
    </form>
<!--    <form id="" action="" method="">
        <div id="Create-Form">

        </div>
    </form>-->
    <form action="/Logout">
        <input type="submit" name="logout" id="logout" value="Logout">
    </form>
    <div id="results"></div>
</body>
</html>
