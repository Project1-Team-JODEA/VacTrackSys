package org.apache.jsp.DoctorLogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Enumeration;
import business.User;

public final class Password_005fReset_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"author\" content=\"Team_JODEA\"> \n");
      out.write("\n");
      out.write("        <title>Reset Password</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/all.css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"../image/favicon_16x16.png\" />\n");
      out.write("        <script src=\"../js/validate.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../js/functions.js\"></script>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/98e4c48f68.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("        <style>.show{display: block;}</style>\n");
      out.write("        <script>\n");
      out.write("            // Add attribute events\n");
      out.write("//    var es = document.getElementsByClassName(\"rsmethod\");\n");
      out.write("            function pageAction(action) {\n");
      out.write("                document.getElementById(\"step\").value = action;\n");
      out.write("                if (action === 'method') {\n");
      out.write("                    document.getElementById(\"step\").value = $(\"rsmethod\").value;\n");
      out.write("                    document.passwdreset.submit();\n");
      out.write("                } else {\n");
      out.write("                    document.getElementById(\"passwdreset\").submit();\n");
      out.write("                }\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            window.onload = () => {\n");
      out.write("//                if (document.getElementById(\"methodtype\").value !== ' ') {\n");
      out.write("//                    let x = \".\" + document.getElementById(\"methodtype\").value+' input';\n");
      out.write("//                    $( x).css(\"display\", \"block\");\n");
      out.write("//                }\n");
      out.write("\n");
      out.write("                try {\n");
      out.write("                    document.getElementById(\"methodtype\").onchange = (evt) => {\n");
      out.write("                        let m = evt.currentTarget;\n");
      out.write("                        var method = document.getElementById(\"methodtype\").value;\n");
      out.write("                        console.log(\"Method = \" + method);\n");
      out.write("                        if (method === 'sendCode') {\n");
      out.write("                            if ($(\".sendCode input\").css(\"display\") === 'none') {\n");
      out.write("                                $(\".sendCode input\").css(\"display\", \"block\");\n");
      out.write("                                $(\".sendCode input\").attr(\"rquired\", null);\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                            if ($(\".cquestion input\").css(\"display\") === 'block') {\n");
      out.write("                                $(\".cquestion input\").css(\"display\", \"none\");\n");
      out.write("                                $(\".cquestion input\").removeAttr(\"required\");\n");
      out.write("                            }\n");
      out.write("\n");
      out.write("                        } else if (method === 'cquestion') {\n");
      out.write("                            if ($(\".cquestion input\").css(\"display\") === 'none') {\n");
      out.write("                                $(\".cquestion input\").css(\"display\", \"block\");\n");
      out.write("                                $(\".cquestion input\").attr(\"rquired\", null);\n");
      out.write("                            }\n");
      out.write("                            if ($(\".sendCode input\").css(\"display\") === 'block') {\n");
      out.write("                                $(\".sendCode input\").css(\"display\", \"none\");\n");
      out.write("                                $(\".sendCode input\").removeAttr(\"required\");\n");
      out.write("                            }\n");
      out.write("                        } else if (method === \" \") {\n");
      out.write("                            if ($(\".sendCode input\").css(\"display\") === 'block') {\n");
      out.write("                                $(\".sendCode input\").css(\"display\", \"none\");\n");
      out.write("                                $(\".sendCode input\").removeAttr(\"required\");\n");
      out.write("                            }\n");
      out.write("                            if ($(\".cquestion input\").css(\"display\") === 'block') {\n");
      out.write("                                $(\".cquestion input\").css(\"display\", \"none\");\n");
      out.write("                                $(\".sendCode input\").removeAttr(\"required\");\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    };\n");
      out.write("                } catch (e) {\n");
      out.write("                }\n");
      out.write("            };\n");
      out.write("            $(document).ready(() => {\n");
      out.write("                $(\"#userid\").attr(\"oninvalid\",  \"setCustomValidity('Employee ID must contain only numbers and must be at least 8 characters long.');\"\n");
      out.write("                        +\"$('#valid').attr('value', 'false')\");\n");
      out.write("//                $(\"#email\").\n");
      out.write("//         document.getElementById(\"email\").addEventListener('invalid', function(ev){\n");
      out.write("//             ev.target.setCustomValidity('Email is invalid.');\n");
      out.write("//         });\n");
      out.write("                $(\"#cancel\").click(evt => {\n");
      out.write("\n");
      out.write("\n");
      out.write("                    var c = confirm(\"Are you sure you want to cancel? Your input data may be lost.\");\n");
      out.write("                    if (c === true) {\n");
      out.write("                        // clear out all reset cookies from form if any\n");
      out.write("                        var cookie = document.cookie;\n");
      out.write("                        window.window.location = './index1.jsp';\n");
      out.write("                    }\n");
      out.write("                });\n");
      out.write("                $(\"#searchbtn\").click(() => {\n");
      out.write("                    let user = $(\"#userid\").val();\n");
      out.write("                    let email = $(\"#email\").val();\n");
      out.write("                    if (user === null || email === null){\n");
      out.write("                        \n");
      out.write("                    }else if (user === \"\" || email === \"\"){\n");
      out.write("                        \n");
      out.write("                    }else if (user !== null && email !== null){\n");
      out.write("                        \n");
      out.write("                    }\n");
      out.write("                    alert(\"You will have a 5 minute time limit to reset your password.\");\n");
      out.write("                    pageAction('search');\n");
      out.write("                });\n");
      out.write("//                $(\"#update-btn\").click((evt) => {\n");
      out.write("//                    pageAction('UpdatePasswd');\n");
      out.write("//                });\n");
      out.write("\n");
      out.write("            });\n");
      out.write("            var c = document.cookie;\n");
      out.write("\n");
      out.write("//    document.getElementById(\"email\").addEventListener(\"input\", function (e) {\n");
      out.write("//        //clear old status\n");
      out.write("//        if (this.rangeOverflow) {\n");
      out.write("//            this.setCustomValidity(\"\");\n");
      out.write("//        } else if (this.rangeUnderflow) {\n");
      out.write("//            this.setCustomValidity(\"\");\n");
      out.write("//        }\n");
      out.write("//\n");
      out.write("//    });\n");
      out.write("//    window.onload = () => {\n");
      out.write("//        document.getElementById(\"methodtype\").setAttribute(\"onchange\", \"toggleMethod();\");\n");
      out.write("////document.getElementById(\"cancel\").\n");
      out.write("//    };\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        ");

            String acct = null, ver = "", act = null;
            Cookie[] c = request.getCookies();
            Cookie oldrcode = null, oldact = null;
//  clear old cookies

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

        
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div class=\"hero\">\n");
      out.write("            <div class=\"form-box\">\n");
      out.write("                <div class=\"social-icons\">\n");
      out.write("                    <a href=\"https://www.mypatientchart.org/MyChart/Authentication/Login?\">\n");
      out.write("                        <img src=\"../image/download.png\">\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"https://physicians.wustl.edu/for-patients/mychart-patient-portal/\">\n");
      out.write("                        <img src=\"../image/washu2.png\">\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"https://www.mymercy.net/login\">\n");
      out.write("                        <img src=\"../image/mercy.jpg\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <form id=\"passwdreset\" class=\"input-group\"\n");
      out.write("                      action=\"ResetPassword\" method=\"post\"  style=\"align-content: center;\">\n");
      out.write("                    <table>\n");
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 280px; \">\n");
      out.write("                                <input type=\"text\" class=\"input-field\" name=\"userid\" id=\"userid\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                       placeholder=\"UserID\" title=\"Enter User id\"  required>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"email\" class=\"input-field\" name=\"email\" id=\"email\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.email}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\"\n");
      out.write("                                       placeholder=\"email (character@character.domain)\" \n");
      out.write("                                       title=\"Email Address\" required> <!-- pattern=\"[a-zA-z0-1_]+[]@[]{}.{2,}$\" -->\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
if (act == null) {
                                act = "";
                            }
                            if (acct == null) {
                                acct = "";
                            }
                            if (act.contains("found")) { 
      out.write("                        \n");
      out.write("                        <tr>\n");
      out.write("                            <td>Select Reset Method</td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><select title=\"Select Reset Method\" name=\"rsmethod\" id=\"methodtype\" onchange=\"\" value=\"\">\n");
      out.write("                                    <option title=\"none\" value=\" \" selected>Select</option>\n");
      out.write("                                    <option title=\"send code via email\" value=\"sendCode\">Reset Code via Email</option>\n");
      out.write("                                    <option title=\"challenge question\" value=\"cquestion\">Challenge Question</option>\n");
      out.write("                                    <!--<option value=\"Hint\"></option>-->\n");
      out.write("                                </select></td>\n");
      out.write("                            <!--<td><button type=\"submit\" onclick=\"pageAction('method')\">Submit</button></td>-->\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                        <tr><td class=\"sendCode\" ><input class=\"submit-btn\" style=\"display: none;\" title=\"click send code\" type=\"submit\"\n");
      out.write("                                                         name=\"sendCode\" value=\"Send Code to email\" onclick=\"pageAction('sendCode')\">\n");
      out.write("                            </td></tr>\n");
      out.write("                        <tr><td class=\"sendCode\"><input style=\"display: none;\" title=\"type 6 digit code\" type=\"number\" maxlength=\"6\" \n");
      out.write("                                                        class=\"input-field \" name=\"rcode\" \n");
      out.write("                                                        id=\"rcode\" value=\"\" placeholder=\"6-digit code\"></td></tr>\n");
      out.write("                        <tr><td class=\"cquestion\"><input type=\"text\" style=\"display: none;\" class=\"input-field\" \n");
      out.write("                                                         name=\"ques\" id=\"ques\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.question}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\" readonly></td></tr>\n");
      out.write("                        <tr><td class=\"cquestion\"><input type=\"text\" style=\"display: none;\" class=\"input-field\" name=\"ans\" \n");
      out.write("                                                         id=\"ans\" value=\"\" placeholder=\"Answer\"></td></tr>\n");
      out.write("                        <tr><td></td></tr>\n");
      out.write("                        ");
}
                            if (act.contains("found") && act.contains("ver")) {
                        
      out.write("\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 240px;\"><input type=\"password\" name=\"upwd\" class=\"input-field\"\n");
      out.write("                                                             id=\"upwd\" value=\"\" placeholder=\"Password\" required>\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"width: 40px;\">\n");
      out.write("                                <i class=\"fas fa-1-5x fa-eye\" id=\"v-btn-p\" onclick=\"toggleV('upwd', 'v-btn-p')\"></i>\n");
      out.write("                                <i id=\"validp\" class=\"fas fa-check\" style=\"color: green;\"></i>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 240px;\">\n");
      out.write("                                <input type=\"password\" name=\"confpasswd\" class=\"input-field\" name=\"confpasswd\"\n");
      out.write("                                       id=\"confpasswd\" placeholder=\"Confirm Password\" required>\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"width: 40px;\"><i class=\"fas fa-1-5x fa-eye\" id=\"v-btn-c\" onclick=\"toggleV('upwd', 'v-btn-c')\"></i>\n");
      out.write("                                <i id=\"validc\" class=\"fas fa-check\" style=\"color: green;\"\n");
      out.write("                                   onchange=\"validatePasswd('upwd', 'confpasswd')\"></i>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 280px; \">\n");
      out.write("                                <input type=\"text\" class=\"input-field\" name=\"newhint\" id=\"newhint\"\n");
      out.write("                                       placeholder=\"New Hint\" required>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        ");
}
                        
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                    <!--<input type=\"submit\"  onclick=\"\">Login</button>-->\n");
      out.write("                    \n");
      out.write("                    ");
 if (!act.contains("ver") && !act.contains("found")) { 
      out.write("\n");
      out.write("                    <button type=\"button\" class=\"submit-btn\" id=\"searchbtn\"> Continue </button>\n");
      out.write("                    ");
} else if (!act.contains("ver") && act.contains("found")) { 
      out.write("\n");
      out.write("                    <button type=\"submit\" class=\"submit-btn\" id=\"reset-btn\" onclick=\"pageAction('ResetPasswd')\"> Reset Password </button>\n");
      out.write("                    ");
} else if (act.contains("ver") && act.contains("found")) { 
      out.write("\n");
      out.write("                    <button type=\"submit\" class=\"submit-btn\" id=\"update-btn\">Update Account</button>\n");
      out.write("                    ");
}
      out.write("<br>\n");
      out.write("                    <button type=\"button\" class=\"submit-btn\" id=\"cancel\">Cancel</button>\n");
      out.write("                    \n");
      out.write("                    <!--<input type=\"submit\" name=\"\" value=\"Reset\">-->\n");
      out.write("                    <!--<a href=\"#\">Forgot Password?</a>-->\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                    <!--<button  class=\"submit-btn\" onclick=\"document.location = 'ForgotPassword.jsp'\"><i class=\"fas fa-angle-right\"> Forgot Password?</i></button>-->\n");
      out.write("\n");
      out.write("                    <!--                    <div class=\"toggle-box\">\n");
      out.write("                                            <div id=\"Qustions\" class=\"toggle-content\">\n");
      out.write("                                                \n");
      out.write("                                            </div>\n");
      out.write("                                        </div>-->\n");
      out.write("\n");
      out.write("                    <input type=\"hidden\" name=\"step\" id=\"step\" value=\"\" hidden=\"\">\n");
      out.write("                    <!--<input type=\"hidden\" name=\"ver\" id=\"ver\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${ver}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\">-->\n");
      out.write("                    <data id=\"valid\" value=\"\" hidden=\"\"></data>\n");
      out.write("                    <div id=\"message\" style=\"padding: \n");
      out.write("                         5px; background: white;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("                <!--<input type=\"submit\" id=\"cancel\" value=\"Cancel\">-->\n");
      out.write("            </div>\n");
      out.write("            <!--<script src=\"https://code.jquery.com/jquery-3.4.1.min.js\"></script>-->\n");
      out.write("            <script>\n");
      out.write("                var x = document.getElementById(\"passwdreset\");\n");
      out.write("                x.style.left = \"50px\";\n");
      out.write("                function toggle() {// toggle methods\n");
      out.write("                    var element = document.getElementById(\"methodtype\");\n");
      out.write("                    var val = element.value;\n");
      out.write("                    if (val === 'Hint') {\n");
      out.write("                        var es = document.getElementsByClassName(\"Hint\");\n");
      out.write("                        for (var i = 0; i < es.length; i++) {\n");
      out.write("                            //                es[i]\n");
      out.write("                            if (es[i].classList.contains(\"show\")) {\n");
      out.write("                                es[i].classList.remove('show');\n");
      out.write("                            } else if (!es[i].classList.contains(\"show\")) {\n");
      out.write("                                es[i].classList.toggle('show');\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    } else {\n");
      out.write("                        var es = document.getElementsByClassName(val);\n");
      out.write("                        for (var i = 0; i < es.length; i++) {\n");
      out.write("                            if (es[i].style.display === 'none') {\n");
      out.write("                                es[i].style.display = 'block';\n");
      out.write("                            } else if (es[i].style.display === 'block') {\n");
      out.write("                                es[i].style.display = 'none';\n");
      out.write("                            }\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("                document.getElementById(\"passwdreset\").onsubmit = function () {\n");
      out.write("                    var e = document.getElementsByClassName(\"submit-btn\");\n");
      out.write("                    for (var i = 0; i < e.length; i++) {\n");
      out.write("                        if (!e[i].hasAttribute(\"disabled\")) {\n");
      out.write("                            e[i].setAttribute(\"disabled\", null);\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                   \n");
      out.write("                };\n");
      out.write("//                let toggleMethod = function () {\n");
      out.write("//                    var method = document.getElementById(\"methodtype\").value;\n");
      out.write("//                    let codein = document.getElementById(\"rcode\");\n");
      out.write("//                    let ans = document.getElementById(\"ans\");\n");
      out.write("//                    if (method === 'cquestion') {\n");
      out.write("//                        if (!ans.hasAttribute(\"required\")) {\n");
      out.write("//                            ans.setAttribute(\"required\", null);\n");
      out.write("//                        }\n");
      out.write("//                        if (codein.hasAttribute(\"required\")) {\n");
      out.write("//                            codein.removeAttribute(\"required\");\n");
      out.write("//                        }\n");
      out.write("//                    } else if (method === 'sendCode') {\n");
      out.write("//                        if (!codein.hasgetAttribute(\"required\")) {\n");
      out.write("//                            codein.setAttribute(\"required\", null);\n");
      out.write("//                        }\n");
      out.write("//                        if (ans.hasAttribute(\"required\")) {\n");
      out.write("//                            ans.removeAttribute(\"required\");\n");
      out.write("//                        }\n");
      out.write("//                        document.querySelector(\"#rcode\")[0].setAttribute(\"required\", null);\n");
      out.write("//                    }\n");
      out.write("//                };\n");
      out.write("            </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
