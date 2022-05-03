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

<html lang="en" dir="ltr">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vaccination Database</title>
        <link rel="stylesheet" href="formstyle.css" type="text/css"/>
        <script src="../js/functions.js" type="text/javascript"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png">
        <script type="text/javascript">
            function pageAction(action) {
                document.getElementById("actiontype").value = action;
                document.getElementById("dbform").submit();
//        document.dbform.submit();

            }




            $(document).ready(() => {

                $("#cancel").click(evt => {
                    let c = confirm("Are you sure you want to Cancel? (All input data will be lost)")
                    if (c === true) {
                        pageAction("cancel");
                    }
                });
            });
        </script>
    </head>
    <body>
        <!-- Authentication -->
        <c:if test="${!u.authenticated}">
            <script type="text/javascript">
                window.window.location = "./index1.jsp";
            </script>
        </c:if> 
        <c:if test="${u.authenticated}">
            <div class="toggle-box" id="msg-box">
                <div class="toggle-content" id="msg-content" style="display: none;">
                    <span style="font-weight: bold ;">Database Messages</span> <br>
                    <p>${msg}</p>
                </div>
            </div>
            <div class="container">
                <div class="title">Patient Vaccination Entry</div>
                <div class="content">
                    <form id="dbform" action="addRecord" method="post">
                        <div class="user-details">
                            <div class="input-box">
                                <span class="details">Social Security</span>
                                <input type="text" name="ssn" id="ssn" maxlength="11" 
                                       placeholder="(###-##-####)" oninvalid=" document.getElementById('ssn').setCustomValidity('Social Security Number must be in thie format: 123-45-6789'
                                       + ' First 3 digits cannot start with 000, 666 or between 900 and 999.'
                                       + ' Next 2 digits should be any digit between 01-99. '
                                       + ' Last 4 digits should not be 0000.');
                                       " title="Nine digit social security code"required>
                            </div>
                            <div class="input-box">
                                <span class="details">Vaccination ID</span>
                                <input type="number" name="vid" id="vid"
                                       pattern="[0-9].{6,}" oninvalid="this.setCustomValidity('Vaccine ID must be at least 6 numbers long');"
                                       placeholder="Enter vaccination information" required>
                            </div>

                            <div class="input-box">
                                <span class="details">Dose</span>
                                <!--<input type="text" name="" id="" value="" placeholder="Enter vaccination information">-->
                                <select name="doesno" id="doseno" required>
                                    <option value="1">1</option>
                                    <option value="2">2</option>
                                    <option value="3">3</option>
                                    <option value="4">4</option>
                                </select>
                            </div>

                            <div class="input-box">
                                <span class="details">Provider</span>
                                <input type="number" name="provider" id="provider"
                                       min="0" value="" placeholder="Enter Provider ID"
                                       pattern="[0-9].{8,}" title="Provider ID (##########)" oninvalid="this.setCustomValidity('Provider ID must be at least 8-10 numbers long')"required>
                            </div>

                            <div class="input-box">
                                <span class="details">Location</span>
                                <select name="loc" title="Vaccination Location" id="loc">
                                    <option value="">Select</option>
                                    <c:forEach var="lc" items="${loc}">
                                        <option value="${lc.id}">${lc.name}</option>
                                    </c:forEach>
                                </select>
                            </div>

                        </div>

                        <div class="button">
                            <input type="submit" value="Add Record" onclick="pageAction('add')">
                            &#8287;  &#8287;  &#8287;  &#8287; 
                            <input type="reset" value="Clear">
                            &#8287;  &#8287;  &#8287;  &#8287; 
                        </div>
                        <i class="fa-1-5x fas fa-database"
                           title="Click to view Message Box"onclick="toggleList('msg-content')" id="msg-btn">Messages</i>

                        <script>

                        </script>
                        <div id="msg">

                        </div>
                        <input type="hidden" id="actiontype" name="actiontype" value="">
                    </form>
                    <button id="cancel">Cancel</button>

                </div>
            </div>
        </c:if>
    </body>
</html>
