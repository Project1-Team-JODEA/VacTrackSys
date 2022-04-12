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
//    var es = document.getElementsByClassName("rsmethod");
    function toggle() {// toggle methods
        var element = this;
        var val = this.value;
        if (value === 'hint'){
            var es = document.getElementsByClassName("Hint");
            for (var i=0; i < es.length; i++){
                if (es[i].style.display === 'none'){
                    es[i].style.display = 'block';
                }else if (es[i].style.display === 'block'){
                    es[i].style.display = 'none';
                }
            }
        }
        else{
            var es = document.getElementsByClassName(val);
            for (var i=0; i < es.length; i++){
                 if (es[i].style.display === 'none'){
                    es[i].style.display = 'block';
                }else if (es[i].style.display === 'block'){
                    es[i].style.display = 'none';
                }
            }
        }
    }
    var $ = function (id) {
        return document.getElementById(id);
    };
    function pageAction(action) {
        document.getElementById("step").value = action;
        if (action === 'cancel') {
            var c = confirm("Are you sure you want to cancel? Your input data may be lost.");
            if (c === true) {
                document.passwdreset.submit();
            } else if (c === false) {

            }
        } else if (action === 'method') {
            document.getElementById("step").value = $("rsmethod").value;
            document.passwdreset.submit();
        } else {
            document.passwdreset.submit();
        }

    }
    window.onload = () => {
//       
//        $("terms").setAttribute("onclick", "t()");
//        $("validc").setAttribute("onchange", "");
//        $("email").setAttribute("onchange", "validatePattern('email','valide')");
        //                   $("uid").setAttribute("onchange", "validatePattern('uid','validid')");  
        //                       $("validp").setAttribute("onchange","validatePasswd('upwd', 'confpasswd')"); 
        //                $sel("")
//        $("rsmethod").onchange = () => {//toggle methods
//            var id = $("rsmethod").id;
//            var val = $("rsmethod").value;
//            console.log(val);
//        };
    };


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
                                       placeholder="UserID" value="${u.username}" required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="email" class="input-field" name="email" id="email" value="${u.email}"
                                       placeholder="email (character@character.domain)" required>
                            </td>
                        </tr>
                        <c:if test="${searched && searched == 'true'&& ver != 'y-d'}">
                            <tr>
                                <td>Select Reset Method</td>
                            </tr>
                            <tr>
                                <td><select name="rsmethod" id="methodtype" onchange="toggle()">
                                        <option value="">Select</option>
                                        <option value="sendCode">Reset Code via Email</option>
                                        <option value="Challenge Question">Challenge Question</option>
                                        <!--<option value="Hint"></option>-->

                                    </select></td>
                                <!--<td><button type="submit" onclick="pageAction('method')">Submit</button></td>-->
                            </tr>
                            <tr name="methodtype" class="Hint" id="out" style="display: none;">
                                <td></td>
                            </tr>
                            <tr name="methodtype" class="Hint" id="passwd_1" style="display: none;">
                                <td></td>
                            </tr>
                            <!--                            <tr><button type="button" class="rsmethod">Challenge</button> <br>
                                                        <input type="text" class="in" name="ques" id="" value="${u.question}"></tr>
                                                        <tr>-->
                            <td></td>
                            </tr>
                        </c:if>

                        <!--                            <tr>
                                                        <td>Select a Method to reset your password:</td>
                                                    </tr>
                                                    <tr id="reset-m">
                                                        <td><button type="button" class="rsmethod">Code</button>
                                                            <input type="button"   value="">
                                                            <input type="text" class="in" name="rcode" id="rcode"value="">
                                                        </td>
                                                                                        <td><input type="text" class="in" name="" id="" value=""></td>
                                                    </tr>
                        
                                                    <tr>
                                                        <td></td>
                                                    </tr>
                                                    <var>c</var>-->


                        <%--<c:if test="}">--%>
                        <c:if test="${searched =='true' && ver== 'y-d'}">
                            <tr>
                                <td style="width: 240px;"><input type="password" name="upwd" class="input-field"
                                                                 id="upwd" value="" placeholder="Password" required>
                                </td>
                                <td style="width: 40px;">
                                    <i class="fas fa-1-5x fa-eye" id="v-btn-p" onclick="toggleV('upwd', 'v-btn-p')"></i>
                                    <i id="validp" class="fas fa-check" style="color: green;"></i>
                                </td>
                            </tr>
                            <tr>
                                <td style="width: 240px;">
                                    <input type="password" name="confpasswd" class="input-field" name="confpasswd"
                                           id="confpasswd" placeholder="Confirm Password" required>
                                </td>
                                <td style="width: 40px;"><i class="fas fa-1-5x fa-eye" id="v-btn-c" onclick="toggleV('upwd', 'v-btn-c')"></i>
                                    <i id="validc" class="fas fa-check" style="color: green;"
                                       onchange="validatePasswd('upwd', 'confpasswd')"></i>
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
                        <button type="submit" class="submit-btn" onclick="pageAction('search')"> Continue </button>
                    </c:if>

                    <!--<input type="submit" name="" value="Reset">-->
                    <!--<a href="#">Forgot Password?</a>-->
                    <br>
                    <c:if test="${ver == 'y-d'}">
                        <button type="submit" onclick="pageAction('UpdatePasswd')">Update Account</button>
                    </c:if>
                    <!--<button  class="submit-btn" onclick="document.location = 'ForgotPassword.jsp'"><i class="fas fa-angle-right"> Forgot Password?</i></button>-->

                    <!--                    <div class="toggle-box">
                                            <div id="Qustions" class="toggle-content">
                                                
                                            </div>
                                        </div>-->

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