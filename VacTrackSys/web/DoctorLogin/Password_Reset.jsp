<%-- Project JODEA File name : index1.jsp Date : Mar 6, 2022, 1:05:54 PM Author(s) : JaccobStanton, Elena Miller --%>

<%@page import="java.util.Enumeration"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@page import="business.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta name="author" content="Team_JODEA"> 

        <title>Reset Password</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="style.css">
        <link rel="stylesheet" href="../css/all.css">
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png" />
        <script src="../js/validate.js" type="text/javascript"></script>
        <script src="../js/functions.js"></script>
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
        <style>.show{display: block;}</style>
        <script>
            // Add attribute events
//    var es = document.getElementsByClassName("rsmethod");

            function pageAction(action) {
                document.getElementById("step").value = action;
                if (action === 'method') {
                    document.getElementById("step").value = $("rsmethod").value;
                    document.passwdreset.submit();
                } else {
                    document.getElementById("passwdreset").submit();
                }

            }



            window.onload = () => {
//                if (document.getElementById("methodtype").value !== ' ') {
//                    let x = "." + document.getElementById("methodtype").value+' input';
//                    $( x).css("display", "block");
//                }

                try {
                    document.getElementById("methodtype").onchange = (evt) => {
                        let m = evt.currentTarget;
                        var method = document.getElementById("methodtype").value;
                        console.log("Method = " + method);
                        if (method === 'sendCode') {
                            if ($(".sendCode input").css("display") === 'none') {
                                $(".sendCode input").css("display", "block");
                                $(".sendCode input").attr("rquired", null);
                            }

                            if ($(".cquestion input").css("display") === 'block') {
                                $(".cquestion input").css("display", "none");
                                $(".cquestion input").removeAttr("required");
                            }

                        } else if (method === 'cquestion') {
                            if ($(".cquestion input").css("display") === 'none') {
                                $(".cquestion input").css("display", "block");
                                $(".cquestion input").attr("rquired", null);
                            }
                            if ($(".sendCode input").css("display") === 'block') {
                                $(".sendCode input").css("display", "none");
                                $(".sendCode input").removeAttr("required");
                            }
                        } else if (method === " ") {
                            if ($(".sendCode input").css("display") === 'block') {
                                $(".sendCode input").css("display", "none");
                                $(".sendCode input").removeAttr("required");
                            }
                            if ($(".cquestion input").css("display") === 'block') {
                                $(".cquestion input").css("display", "none");
                                $(".sendCode input").removeAttr("required");
                            }
                        }
                    };
                } catch (e) {
                }
            };
            $(document).ready(() => {
                $("#userid").attr("oninvalid", "setCustomValidity('Employee ID must contain only numbers and must be at least 8 characters long.');"
                        + "$('#valid').attr('value', 'false')");
//                $("#email").
//         document.getElementById("email").addEventListener('invalid', function(ev){
//             ev.target.setCustomValidity('Email is invalid.');
//         });
                $("#cancel").click(evt => {


                    var c = confirm("Are you sure you want to cancel? Your input data may be lost.");
                    if (c === true) {
                        // clear out all reset cookies from form if any
                        pageAction('cancel');
                        // document.getElementById("passwdreset").submit();
                    }
                });
                $("#searchbtn").click(() => {
                    let user = $("#userid").val();
                    let email = $("#email").val();
                    if (user === null || email === null) {

                    } else if (user === "" || email === "") {

                    } else if (user !== null && email !== null) {

                    }
                    alert("You will have a 5 minute time limit to reset your password.");
                    pageAction('search');
                });
            });
        </script>
    </head>

    <body>
        <%
            String acct = null, ver = "", act = null;
            Cookie[] c = request.getCookies();
            Cookie oldrcode = null, oldact = null;
//  clear old cookies
            User u = (User) request.getSession().getAttribute("u");

            if (c.length > 0) {
                for (Cookie c1 : c) {
                    String name = c1.getName();
                    if (c1.getName().contains("account")) {
//                                request.getSession().
                        request.getSession().setAttribute("acct", c1.getValue());
                        acct = c1.getValue();
                    } else if (c1.getName().equals("act")) {
                        c1.setMaxAge(5 * 100);
                        response.addCookie(c1);
                        act = c1.getValue();
                        oldact = c1;
                    } else if (c1.getName().equals("reset")) {
                        if (c1.getValue().equals("success")) {

                        }
                    } else if (c1.getName().equals("rcode")) {
                        oldrcode = c1;
                        if (acct == null || act == null) {
                            // delete cookies
                            oldrcode.setMaxAge(1);
                            oldact.setMaxAge(1);
                            response.addCookie(oldrcode);
                            response.addCookie(oldact);

                        }
                    }
                }
            }

        %>


        <div class="hero">
            <div class="form-box">
                <div class="social-icons">
                    <a href="https://www.mypatientchart.org/MyChart/Authentication/Login?">
                        <img src="../image/download.png">
                    </a>
                    <a href="https://physicians.wustl.edu/for-patients/mychart-patient-portal/">
                        <img src="../image/washu2.png">
                    </a>
                    <a href="https://www.mymercy.net/login">
                        <img src="../image/mercy.jpg">
                    </a>
                </div>

                <form id="passwdreset" class="input-group"
                      action="ResetPassword" method="post"  style="align-content: center;">
                    <table>

                        <tr>
                            <td style="width: 280px; ">
                                <input type="text" class="input-field" name="userid" id="userid" value="${u.username}"
                                       placeholder="UserID" title="Enter User id"  required>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                <input type="email" class="input-field" name="email" id="email" value="${u.email}"
                                       placeholder="email (character@character.domain)" 
                                       title="Email Address" required> <!-- pattern="[a-zA-z0-1_]+[]@[]{}.{2,}$" -->
                            </td>
                        </tr>
                        <%if (act == null) {
                                act = "";
                            }
                            if (acct == null) {
                                acct = "";
                            }
                            if (u == null) {
                                u = new User();
                            }
                            if (act.contains("found") && !u.getUsername().equals("")) { %>                        
                        <tr>
                            <td>Select Reset Method</td>
                        </tr>
                        <tr>
                            <td><select title="Select Reset Method" name="rsmethod" id="methodtype" onchange="" value="">
                                    <option title="none" value=" " selected>Select</option>
                                    <option title="send code via email" value="sendCode">Reset Code via Email</option>
                                    <option title="challenge question" value="cquestion">Challenge Question</option>
                                    <!--<option value="Hint"></option>-->
                                </select></td>
                            <!--<td><button type="submit" onclick="pageAction('method')">Submit</button></td>-->
                        </tr>

                        <tr><td class="sendCode" ><input class="submit-btn" style="display: none;" title="click send code" type="submit"
                                                         name="sendCode" value="Send Code to email" onclick="pageAction('sendCode')">
                            </td></tr>
                        <tr><td class="sendCode"><input style="display: none;" title="type 6 digit code" type="number" maxlength="6" 
                                                        class="input-field " name="rcode" 
                                                        id="rcode" value="" placeholder="6-digit code"></td></tr>
                        <tr><td class="cquestion"><input type="text" style="display: none;" class="input-field" 
                                                         name="ques" id="ques" value="${u.question}" readonly></td></tr>
                        <tr><td class="cquestion"><input type="text" style="display: none;" class="input-field" name="ans" 
                                                         id="ans" value="" placeholder="Answer"></td></tr>
                        <tr><td></td></tr>
                        <%}
                            if (act.contains("found") && act.contains("ver")) {
                        %>
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
                        <%}
                        %>
                    </table>
                    <!--<input type="submit"  onclick="">Login</button>-->

                    <% if (!act.contains("ver") && !act.contains("found") || u.getUsername().equals("")) { %>
                    <button type="button" class="submit-btn" id="searchbtn"> Continue </button>
                    <% if (u.getUsername().equals("")) {%>
                    <%}%>
                    <%  } else if (!act.contains("ver") && act.contains("found") && !u.getUsername().equals("")) { %>
                    <button type="submit" class="submit-btn" id="reset-btn" onclick="pageAction('ResetPasswd')"> Reset Password </button>
                    <%} else if (act.contains("ver") && act.contains("found") && !u.getUsername().equals("")) { %>
                    <button type="submit" class="submit-btn" id="update-btn" onclick="pageAction('updatePasswd')">Update Account</button>
                    <%}%><br>
                    <button type="button" class="submit-btn" id="cancel">Cancel</button>

                    <!--<input type="submit" name="" value="Reset">-->
                    <!--<a href="#">Forgot Password?</a>-->


                    <!--<button  class="submit-btn" onclick="document.location = 'ForgotPassword.jsp'"><i class="fas fa-angle-right"> Forgot Password?</i></button>-->

                    <!--                    <div class="toggle-box">
                                            <div id="Qustions" class="toggle-content">
                                                
                                            </div>
                                        </div>-->

                    <input type="hidden" name="step" id="step" value="" hidden="">
                    <!--<input type="hidden" name="ver" id="ver" value="${ver}">-->
                    <data id="valid" value="" hidden=""></data>
                    <div id="message" style="padding: 
                         5px; background: white;">${msg}</div>
                </form>

                <!--<input type="submit" id="cancel" value="Cancel">-->
            </div>
            <!--<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>-->
            <script>
                var x = document.getElementById("passwdreset");
                x.style.left = "50px";
                function toggle() {// toggle methods
                    var element = document.getElementById("methodtype");
                    var val = element.value;
                    if (val === 'Hint') {
                        var es = document.getElementsByClassName("Hint");
                        for (var i = 0; i < es.length; i++) {
                            //                es[i]
                            if (es[i].classList.contains("show")) {
                                es[i].classList.remove('show');
                            } else if (!es[i].classList.contains("show")) {
                                es[i].classList.toggle('show');
                            }
                        }
                    } else {
                        var es = document.getElementsByClassName(val);
                        for (var i = 0; i < es.length; i++) {
                            if (es[i].style.display === 'none') {
                                es[i].style.display = 'block';
                            } else if (es[i].style.display === 'block') {
                                es[i].style.display = 'none';
                            }
                        }
                    }
                }
                document.getElementById("passwdreset").onsubmit = function () {
                    var e = document.getElementsByClassName("submit-btn");
                    for (var i = 0; i < e.length; i++) {
                        if (!e[i].hasAttribute("disabled")) {
                            e[i].setAttribute("disabled", null);
                        }
                    }

                };
//                let toggleMethod = function () {
//                    var method = document.getElementById("methodtype").value;
//                    let codein = document.getElementById("rcode");
//                    let ans = document.getElementById("ans");
//                    if (method === 'cquestion') {
//                        if (!ans.hasAttribute("required")) {
//                            ans.setAttribute("required", null);
//                        }
//                        if (codein.hasAttribute("required")) {
//                            codein.removeAttribute("required");
//                        }
//                    } else if (method === 'sendCode') {
//                        if (!codein.hasgetAttribute("required")) {
//                            codein.setAttribute("required", null);
//                        }
//                        if (ans.hasAttribute("required")) {
//                            ans.removeAttribute("required");
//                        }
//                        document.querySelector("#rcode")[0].setAttribute("required", null);
//                    }
//                };
            </script>

    </body>

</html>