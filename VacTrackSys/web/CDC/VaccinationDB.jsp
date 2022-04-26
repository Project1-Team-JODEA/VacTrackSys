<%-- Vaccination Tracking System File name : VaccinationDB Date : Feb 18, 2022, 3:49:10 PM Author(s) : Elena Miller,
    DeShane` Sims Supporting File(s): --%>
<!DOCTYPE html>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title> Vaccination Database</title>
        <link rel="stylesheet" href="formstyle.css" type="text/css">
        <link rel="stylesheet" href="../css/all.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <!--<link rel="stylesheet" href="../.css" type="text/css"/>-->
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png">
        <!--<script src="../js/searchPatient.js" type="text/javascript"></script>-->
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <script src="../js/functions.js" type="text/javascript"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <script src="script.js" type="text/javascript">

        </script>
    </head>
    <c:if test="${!u.authenticated}">
            <script type="text/javascript">
                window.window.location = "/VacTrackSys/Redirect_Home.jsp";
            </script>
    </c:if>
    <body>
        <!-- Authentication -->
        <!-- 
For Searching through database
        -->
        <c:if test="${u.authenticated}">
        <%

        %>
        <div class="toggle-box" id="loading-box">
            <div class="toggle-content" id="loading-content" style="display: none;">
                <i class="fas fa-spin fa-spinner"
                   style="color: blue; font-size: 10em;
                   text-align: center;"></i>

            </div>
        </div>

        <!-- Message Box is for Viewing Database Error Messages-->
        <div class="toggle-box" id="msg-box">
            <div class="toggle-content" id="msg-content" style="display: none;">
                <span style="font-weight: bold ;">Database Messages</span> <br>
                <p>${msg}</p>
            </div>
        </div>
        <div class="toggle-box" id="loading-box">
            <div class="toggle-content" id="loading-content" style="display: none;">
                <i class="fas fa-spin fa-spinner"
                   style="color: blue; font-size: 10em;
                   text-align: center;"></i>
                <h2>Generating Report Please Wait</h2>
            </div>
        </div>
        <div class="toggle-box" id="help-box">
            <div class="toggle-content" id="help-content" style="display: none;">
                <span style="font-weight: bold ;">Help/Tips</span>
                <ul>
                    <li>Click on the Message icon on the database icon to
                        view any error messages then click on it again to close it.</li>
                    <li> Try not to refresh the page too many times at once.
                        Otherwise, your search input may not go through.</li>
                    <li></li>
                    <li></li>
                </ul>
                <!--<textarea readonly> </textarea>-->
            </div>
        </div>
        <div class="container" id="input-form">
            <i class="fas fa-user-circle fa-1-5x toggle-btn" class="vac-btn" id="prof-btn"
               title="User profile">${u.username} - ${u.accesslevel}</i>
            <div class="title">Vaccination Report
                <i class="fas fa-1-x fa-question-circle toggle-btn" id="help-btn" title="Click to open Help/Guide"
                   style="float: right;"></i>
                <i class="fa-1-x fas fa-database toggle-btn" onclick="" id="msg-btn" style="float: right;"></i>
            </div><br>

            <div class="content">
                <form name="dbaction" 
                      id="dbaction" action="CreateReport" method="post" onsubmit="toggleList('loading-content')">
                    <div class="info">
                        <div class="user-details">
                            <div class="input-box" id="pat-info">
                                <span class="details">Generate Report</span>
                                <table>
                                    <tr>
                                        <td>Location: </td>

                                        <td><select name="location" title="Location" id="location" value="">
                                                <option value="">Select</option>
                                                <c:forEach var="lc" items="${loc}">
                                                    <option value="${lc.id}">${lc.name}</option>
                                                </c:forEach>
                                            </select></td>

                                    </tr>


                                    <tr><td>Filters (Optional)</td></tr>
                                    <tr class="filter">
                                        <td>Vaccination Date</td>
                                        <td><input type="date" name="vac_date" id="vac_date" min="2021-11-30" max=""></td>
                                    </tr>
                                    <tr>
                                        <td><span class="details">Manufacture</span></td>
                                        <td><select name="man" id="man">
                                                <option value="">Select</option>
                                                <option value="Pfizer">Pfizer</option>
                                                <option value="Johnson & Johnson">Johnson & Johnson</option>
                                                <option value="Mederma">Mederma</option>
                                            </select></td>

                                    </tr>
                                </table>
                            </div>
                        </div>
                    </div> <input type="hidden" name="actiontype" id="actiontype" value="">

                    <div class="button">
                        <input type="submit" class="" id="report" value="Get Report"> 
                        &#8287; &#8287; &#8287; &#8287;
                        <!--<button></button>-->
                        <input type="reset" class="actionBtn" name="btnClear" id="btnClear" value="Clear"> &#8287; &#8287; &#8287; &#8287;
                        <i class="fas fa-2x fa-door-open toggle-btn" id="logout" title="Logout" 
                           style=" cursor: pointer;" ></i>
                    </div>
                </form>

            </div>

        </div>


        <!--</div>-->
        <!--                <div class="container" id="rs-form">
                            <div class="title">Results</div>
                            <div class="content" id="rs-content">
                                <div id="results"></div>
                            </div>
                        </div>-->
        <script type="text/javascript">

//        $("help-btn").style.float = "right";
        </script>
        </c:if>


    </body>

</html>