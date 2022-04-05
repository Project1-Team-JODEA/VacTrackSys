package org.apache.jsp.DoctorLogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index1_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Doctor Login and Registration Form</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/all.css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"../image/favicon_16x16.png\" />\n");
      out.write("        <script src=\"../js/validate.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../js/functions.js\"></script>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/98e4c48f68.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script>\n");
      out.write("            // Add attribute events\n");
      out.write("            window.onload = () => {\n");
      out.write("                $(\"v-btn-p\").setAttribute(\"onclick\", \"toggleV('upwd', 'v-btn-p')\");\n");
      out.write("                $(\"v-btn-c\").setAttribute(\"onclick\", \"toggleV('confpasswd', 'v-btn-c')\");\n");
      out.write("                $(\"terms\").setAttribute(\"onclick\", \"t()\");\n");
      out.write("                $(\"validc\").setAttribute(\"onchange\", \"validatePasswd('upwd', 'confpasswd')\");\n");
      out.write("//                $(\"email\").setAttribute(\"onchange\", \"validatePattern('email','valide')\");\n");
      out.write("            };\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <div class=\"hero\">\n");
      out.write("            <div class=\"form-box\">\n");
      out.write("                <div class=\"button-box\">\n");
      out.write("                    <div id=\"btn\"></div>\n");
      out.write("                    <button type=\"button\" class=\"toggle-btn\" onclick=\"login()\">Log In</button>\n");
      out.write("                    <button type=\"button\" class=\"toggle-btn\" onclick=\"register()\">Register</button>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"social-icons\">\n");
      out.write("                    <a href=\"https://www.mypatientchart.org/MyChart/Authentication/Login?\">\n");
      out.write("                        <img src=\"../image/download.png\">\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"https://physicians.wustl.edu/for-patients/mychart-patient-portal/\">\n");
      out.write("                        <img src=\"../image/washu2.png\">\n");
      out.write("                    </a>\n");
      out.write("                    <a href=\"https://www.mymercy.net/login\">\n");
      out.write("\n");
      out.write("                        <img src=\"../image/mercy.jpg\">\n");
      out.write("                    </a>\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                <form id=\"login\" class=\"input-group\" action=\"Login\" method=\"post\">\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 280px; \">\n");
      out.write("                                <input type=\"text\" class=\"input-field\" name=\"userid\" id=\"userid\"\n");
      out.write("                                       placeholder=\"Employee ID\" oni required>\n");
      out.write("\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 280px; \">\n");
      out.write("                                <input type=\"password\" class=\"input-field\" name=\"passwd\" id=\"passwd\"\n");
      out.write("                                       placeholder=\"Enter Password\" required>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 280px; \">\n");
      out.write("                                <input type=\"checkbox\" class=\"check-box\">Remember Password\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    <input type=\"submit\" class=\"submit-btn\" value=\"Login\" onclick=\"\">\n");
      out.write("                    <a href=\"Password_Reset.jsp\">Forgot Password?</a>\n");
      out.write("                    <br>\n");
      out.write("                    <!--<button  class=\"submit-btn\" onclick=\"document.location = 'ForgotPassword.jsp'\"><i class=\"fas fa-angle-right\"> Forgot Password?</i></button>-->\n");
      out.write("                    <div id=\"message\" style=\"padding: \n");
      out.write("                         5px; background: white;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("</div>\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("                <form id=\"register\" class=\"input-group\" style=\"overflow-y: auto; max-height: 275px;\"\n");
      out.write("                      action=\"NewAccount\" method=\"post\">\n");
      out.write("                    <i class=\"fas fa-1-5x fa-circle-info\" id=\"req-btn\" style=\"color: blue;\"\n");
      out.write("                       title=\"Click for Requirements\"></i>\n");
      out.write("                    <!--                    <div class=\"help\" style=\"display: none;\">\n");
      out.write("                                            Password: At Least 15 Characters <br>\n");
      out.write("                                        </div>-->\n");
      out.write("                    <table>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 240px;\"><input type=\"text\" class=\"input-field\" name=\"uid\" id=\"uid\"\n");
      out.write("                                                             placeholder=\"Employee ID\"\n");
      out.write("                                                             pattern=\"\\d[0-9]\" required></td>\n");
      out.write("                            <td style=\"width: 40px;\"> <i id=\"validid\" class=\"fas \" style=\"color: green;\"></i></td>\n");
      out.write("                            \n");
      out.write("                            \n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 240px;\"><input type=\"email\" name=\"email\" id=\"email\"\n");
      out.write("                                                             class=\"input-field\" placeholder=\"characters@characters.domain\"\n");
      out.write("                                                             onchange=\"validatePattern('email','valide')\" oninvalid=\"this.setCustomValidity('Not Valid')\" required></td>\n");
      out.write("                                    <td style=\"width: 40px;\"> <i id=\"valide\" class=\"fas \" style=\"color: green;\">\n");
      out.write("                                \n");
      out.write("                                </i></td>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 240px;\"><input type=\"text\" name=\"loc\" id=\"loc\" class=\"input-field\"\n");
      out.write("                                                             placeholder=\"Location\" required></td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 240px;\"><input type=\"password\" name=\"upwd\" class=\"input-field\"\n");
      out.write("                                                             id=\"upwd\" placeholder=\"Password\"\n");
      out.write("                                                             onchange=\"validatePattern('upwd', 'validp')\" required>\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"width: 40px;\">\n");
      out.write("                                <i class=\"fas fa-1-5x fa-eye\" id=\"v-btn-p\"></i>\n");
      out.write("                                <i id=\"validp\" class=\"fas fa-check\" style=\"color: green;\"></i>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <!--<td id=\"msg\"></td>-->\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 240px;\">\n");
      out.write("                                <input type=\"password\" name=\"confpasswd\" class=\"input-field\" name=\"confpasswd\"\n");
      out.write("                                       id=\"confpasswd\" placeholder=\"Confirm Password\" pattern=\"{15)\"\n");
      out.write("                                       onchange=\"validatePattern('confpasswd', 'validc')\" oninput=\"this.setCustomValidity('Must Match Password')\" required>\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"width: 40px;\"><i class=\"fas fa-1-5x fa-eye\" id=\"v-btn-c\"></i>\n");
      out.write("                                <i id=\"validc\" class=\"fas fa-check\" style=\"color: green;\"></i>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><input type=\"text\" class=\"input-field\" name=\"hint\" id=\"hint\"\n");
      out.write("                                       title=\"hint for password\" placeholder=\"Hint\" required></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <select name=\"quest\" title=\"security question\" id=\"quest\">\n");
      out.write("                                    <option id=\"\" value=\"\">Select</option>\n");
      out.write("                                    <option id=\"\" value=\"\">Select</option>\n");
      out.write("                                    <option id=\"\" value=\"\">Select</option>\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"font-size: 12px;\"><input type=\"checkbox\" class=\"check-box\" id=\"terms\">\n");
      out.write("                                I agree to the terms & conditions</td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    <button type=\"submit\" id=\"newacct\" class=\"submit-btn\" disabled>Register</button>\n");
      out.write("                    <!--<input type=\"hidden\" id=\"isValid\" value=\"\">-->\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("\n");
      out.write("            </div>\n");
      out.write("            <!--<script src =\" ../js/functions\" type=\"text/javascript\"></script>-->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <script>\n");
      out.write("            var x = document.getElementById(\"login\");\n");
      out.write("            var y = document.getElementById(\"register\");\n");
      out.write("            var z = document.getElementById(\"btn\");\n");
      out.write("            function register() {\n");
      out.write("                x.style.left = \"-400px\";\n");
      out.write("                y.style.left = \"50px\";\n");
      out.write("                z.style.left = \"110px\";\n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function login() {\n");
      out.write("                x.style.left = \"50px\";\n");
      out.write("                y.style.left = \"450px\";\n");
      out.write("                z.style.left = \"0px\";\n");
      out.write("//                document.getElementById(\"\").setAttribute(\"focus\")\n");
      out.write("            }\n");
      out.write("\n");
      out.write("            function t() {\n");
      out.write("                var c = $(\"terms\").getAttribute(\"checked\");\n");
      out.write("                //            console.log(c);\n");
      out.write("                if (c === null) {\n");
      out.write("                    $(\"terms\").setAttribute(\"checked\", null);\n");
      out.write("                    $(\"newacct\").removeAttribute(\"disabled\");\n");
      out.write("                } else {\n");
      out.write("                    $(\"terms\").removeAttribute(\"checked\");\n");
      out.write("                    $(\"newacct\").setAttribute(\"disabled\", null);\n");
      out.write("                }\n");
      out.write("                //       if ($(\"terms\").checked){\n");
      out.write("                //            \n");
      out.write("                //        } \n");
      out.write("\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
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
