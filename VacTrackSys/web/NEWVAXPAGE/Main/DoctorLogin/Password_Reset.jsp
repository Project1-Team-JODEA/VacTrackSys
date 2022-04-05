<%-- Project JODEA File name : index1.jsp Date : Mar 6, 2022, 1:05:54 PM Author(s) : JaccobStanton, Elena Miller --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html><script type="text/javascript">


    </script>

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Doctor Login and Registration Form</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="../css/all.css">
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png" />
        <script src="../js/validate.js" type="text/javascript"></script>
        <script src="../js/functions.js"></script>
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <script>
    // Add attribute events
    window.onload = () => {
        $("v-btn-p").setAttribute("onclick", "toggleV('upwd', 'v-btn-p')");
        $("v-btn-c").setAttribute("onclick", "toggleV('confpasswd', 'v-btn-c')");
        $("terms").setAttribute("onclick", "t()");
        $("validc").setAttribute("onchange", "validatePasswd('upwd', 'confpasswd')");
        $("email").setAttribute("onchange", "validatePattern('email','valide')");
        //                   $("uid").setAttribute("onchange", "validatePattern('uid','validid')");  
        //                       $("validp").setAttribute("onchange","validatePasswd('upwd', 'confpasswd')"); 
        //                $sel("")

    };
    function pageAction(action) {
        document.getElementById("step").value = action;
        if (action === 'cancel') {
            var c = confirm("Are you sure you want to cancel? Your input data may be lost.");
        }
        document.passwdreset.submit();
    }
    var cancel = function (form_id) {
//    var p = prompt();

        if (c === true) {
            $("step").value = "";
            $(form_id).submit();
        }

    }
//            if ($("email"))

        </script>
    </head>

    <body>
        <div class="hero">
            <div class="form-box">
                <div class="social-icons">
                    <a href="https://www.mypatientchart.org/MyChart/Authentication/Login?">
                        <img src="download.png">
                    </a>
                    <a href="https://physicians.wustl.edu/for-patients/mychart-patient-portal/">
                        <img src="washu2.png">
                    </a>
                    <a href="https://www.mymercy.net/login">
                        <img src="mercy.jpg">
                    </a>
                </div>

                <form id="passwdreset" class="input-group"
                      action="ResetPassword" method="post"  style="align-content: center;">
                    <table>
                        <tr>
                            <td style="width: 280px; ">
                                <input type="text" class="input-field" name="userid" id="userid"
                                       placeholder="UserID" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="text" class="input-field" name="email" id="email"
                                       placeholder="UserID" required>
                            </td>
                        </tr>
                        <c:if test="${found==true}">
                            <tr>
                                <td>Select</td>
                            </tr>
                            <tr>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                            </tr>
                        </c:if>
                        <c:if test="${ver != 'y-d'}">
                            <tr>
                                <td style="width: 280px; ">
                                    <input type="text" class="input-field" name="hint" id="hint"
                                           placeholder="Hint" required>
                                </td>
                            </tr>
                        </c:if>
                        <%--<c:if test="}">--%>
                        <c:if test="${ver== 'y-d'}">
                            <tr>
                                <td style="width: 240px;"><input type="password" name="upwd" class="input-field"
                                                                 id="upwd" value="" placeholder="Password" required>
                                </td>
                                <td style="width: 40px;">
                                    <i class="fas fa-1-5x fa-eye" id="v-btn-p"></i>
                                    <i id="validp" class="fas fa-check" style="color: green;"></i>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 240px;">
                                    <input type="password" name="confpasswd" class="input-field" name="confpasswd"
                                           id="confpasswd" placeholder="Confirm Password" required>
                                </td>
                                <td style="width: 40px;"><i class="fas fa-1-5x fa-eye" id="v-btn-c"></i>
                                    <i id="validc" class="fas fa-check" style="color: green;"></i>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 280px; ">
                                    <input type="text" class="input-field" name="newhint" id="newhint"
                                           placeholder="New Hint" required>
                                </td>
                            </tr>
                        </c:if>

                    </table>
                    <!--<input type="submit"  onclick="">Login</button>-->

                    <c:if test="${ver != 'y-d'}">
                        <button type="submit" class="submit-btn" onclick="pageAction('ResetPasswd')"> Reset </button>
                    </c:if>

                    <!--<input type="submit" name="" value="Reset">-->
                    <!--<a href="#">Forgot Password?</a>-->
                    <br>
                    <c:if test="${ver == 'y-d'}">
                        <button type="submit" onclick="pageAction('UpdatePasswd')">Update Account</button>
                    </c:if>
                    <!--<button  class="submit-btn" onclick="document.location = 'ForgotPassword.jsp'"><i class="fas fa-angle-right"> Forgot Password?</i></button>-->



                    <input type="hidden" name="step" id="step" value="" hidden="">
                    <!--<input type="hidden" name="ver" id="ver" value="${ver}">-->
                    <input type="button" value="Cancel" onclick="pageAction('cancel')">
                    <div id="message" style="padding: 
                         5px; background: white;">${msg}</div>
                </form>



            </div>

            <script>
                var x = document.getElementById("passwdreset");
                x.style.left = "50px";

            </script>

    </body>

</html>