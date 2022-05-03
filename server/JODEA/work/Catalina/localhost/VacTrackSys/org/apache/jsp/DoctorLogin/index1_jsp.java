/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.72
 * Generated at: 2022-05-03 22:49:27 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.DoctorLogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class index1_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET, POST or HEAD. Jasper also permits OPTIONS");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n");
      out.write("        <meta name=\"author\" content=\"Team_JODEA\"> \n");
      out.write("\n");
      out.write("        <title>Doctor Login and Registration Form</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"style.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/all.css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"../image/favicon_16x16.png\" />\n");
      out.write("        <script src=\"../js/validate.js\" type=\"text/javascript\"></script>\n");
      out.write("        <script src=\"../js/functions.js\"></script>\n");
      out.write("        <script src=\"https://kit.fontawesome.com/98e4c48f68.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\n");
      out.write("        <script src=\"../js/index1.js\" type=\"text/javascript\"> </script>\n");
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
      out.write("                                       placeholder=\"Enter Password\" pattern=\".{15,}\" required>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 280px; \">\n");
      out.write("                                <input type=\"checkbox\" class=\"check-box\" onclick=\"t()\">Remember Password\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                    </table>\n");
      out.write("                    <input type=\"submit\" class=\"submit-btn\" value=\"Login\" onclick=\"\">\n");
      out.write("                    <a href=\"./Password_Reset.jsp\">Forgot Password?</a>\n");
      out.write("                    <br /><br />\n");
      out.write("                    <a href=\"../index.html\">Return Home</a>\n");
      out.write("                    <br>\n");
      out.write("                    <!--<button  class=\"submit-btn\" onclick=\"document.location = 'ForgotPassword.jsp'\"><i class=\"fas fa-angle-right\"> Forgot Password?</i></button>-->\n");
      out.write("                    <div id=\"message\" style=\"padding: \n");
      out.write("                         5px; background: white;\">");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
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
      out.write("                                                             placeholder=\"Employee ID\" pattern=\"[0-9]*.{8,}\"\n");
      out.write("                                                             required></td>\n");
      out.write("                            <td style=\"width: 40px;\"> <i id=\"validid\" class=\"fas \" style=\"color: green;\"></i></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 240px;\"><input type=\"email\" name=\"email\" id=\"email\"\n");
      out.write("                                                             class=\"input-field\" placeholder=\"Email: characters@characters.domain\"\n");
      out.write("                                                             pattern=\"^[a-zA-Z0-9.!#$%&’*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$\"\n");
      out.write("                                                             onchange=\"validatePattern('email', 'valide')\" required></td>\n");
      out.write("                            <td style=\"width: 40px;\"> <i id=\"valide\" class=\"fas \" style=\"color: green;\">\n");
      out.write("\n");
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
      out.write("                                                             id=\"upwd\" placeholder=\"Password\" pattern=\".{15,}\"\n");
      out.write("                                                             oninput=\"\"\n");
      out.write("                                                              required>\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"width: 40px;\">\n");
      out.write("                                <i class=\"fas fa-1-5x fa-eye\" id=\"v-btn-p\"></i>\n");
      out.write("                                <i id=\"validp\" class=\"fas fa-check\" style=\"color: green;\"></i>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td id=\"msg\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"width: 240px;\">\n");
      out.write("                                <input type=\"password\" name=\"confpasswd\" class=\"input-field\" name=\"confpasswd\"\n");
      out.write("                                       id=\"confpasswd\" placeholder=\"Confirm Password\" \n");
      out.write("                                       onchange=\"validatePattern('confpasswd', 'validc')\" required>\n");
      out.write("                            </td>\n");
      out.write("                            <td style=\"width: 40px;\"><i class=\"fas fa-1-5x fa-eye\" id=\"v-btn-c\"></i>\n");
      out.write("                                <i id=\"validc\" class=\"fas fa-check\" style=\"color: green;\"></i>\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td id=\"msgc\"></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td><input type=\"text\" class=\"input-field\" name=\"hint\" id=\"hint\"\n");
      out.write("                                       title=\"hint for password\" placeholder=\"Hint\" required></td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <select name=\"quest\" class=\"input-field\" id=\"quest\" title=\"security question\" id=\"quest\">\n");
      out.write("                                    <option value=\"\">Select</option>\n");
      out.write("                                    <option title=\"What is your Mother's Maiden Name?\" value=\"What is your Mother's Maiden Name?\">What is your Mother's Maiden Name</option>\n");
      out.write("                                    <option value=\"Whats your favorite College?\">Whats your favorite College? </option>\n");
      out.write("                                    <option value=\"What City were you born in?\">What City were you born in?</option>\n");
      out.write("                                    <option value=\"What is your childhood nickname?\">What is your childhood nickname?</option>\n");
      out.write("                                    <option value=\"What street did you live on in 3rd grade?\">What street did you live on in 3rd grade?</option>\n");
      out.write("                                    <option value=\"In what city did you meet your spouse/significant other?\">In what city did you meet your spouse/significant other?</option>\n");
      out.write("                                    <!--                                    <option id=\"\" value=\"\">Select</option>-->\n");
      out.write("                                </select>\n");
      out.write("                            </td>\n");
      out.write("\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td>\n");
      out.write("                                <input type=\"text\" class=\"input-field\" name=\"answer\" id=\"answer\"\n");
      out.write("                                       placeholder=\"Answer\" disabled=\"\">\n");
      out.write("                            </td>\n");
      out.write("                        </tr>\n");
      out.write("                        <tr>\n");
      out.write("                            <td style=\"font-size: 12px;\"><input type=\"checkbox\" class=\"check-box\" id=\"terms\"\n");
      out.write("                                                                onclick=\"\">\n");
      out.write("                                I agree to the terms & conditions</td>\n");
      out.write("                        </tr>\n");
      out.write("\n");
      out.write("                    </table>\n");
      out.write("                    <!--<button type=\"button\" id=\"check\" class=\"submit-btn\" onclick=\"validateUserReg('newacct')\">Check</button>-->\n");
      out.write("                    <button type=\"submit\" id=\"newacct\" class=\"submit-btn\">Register</button>\n");
      out.write("                    <!--<input type=\"hidden\" id=\"isValid\" value=\"\">-->\n");
      out.write("\n");
      out.write("                </form>\n");
      out.write("                <!--                <form id=\"register-p\" class=\"input-group\" style=\"overflow-y: auto; max-height: 275px;\"\n");
      out.write("                                      action=\"NewAccount\" method=\"post\">\n");
      out.write("                                    <table>\n");
      out.write("                                        <tr><td><input type=\"text\" name=\"\" id=\"\" value=\"\" ></td>\n");
      out.write("                                        </tr>\n");
      out.write("                                    </table>\n");
      out.write("                                </form>-->\n");
      out.write("            </div>\n");
      out.write("            <!--<script src =\" ../js/functions\" type=\"text/javascript\"></script>-->\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("        <input type=\"hidden\" name=\"step\" id=\"step\" value=\"\" onchange=\"\">\n");
      out.write("        <script>\n");
      out.write("            var x = document.getElementById(\"login\");\n");
      out.write("            var y = document.getElementById(\"register\");\n");
      out.write("            var y2 = document.getElementById(\"register-p\");\n");
      out.write("            var z = document.getElementById(\"btn\");\n");
      out.write("            function register() {\n");
      out.write("                x.style.left = \"-400px\";\n");
      out.write("                y.style.left = \"50px\";\n");
      out.write("//                y2.style.left = \"-690px\";\n");
      out.write("                z.style.left = \"110px\";\n");
      out.write("\n");
      out.write("            }\n");
      out.write("//            function newInfo() {\n");
      out.write("////                x.style.left = \"\";\n");
      out.write("//                x.style.left = \"-800px\";\n");
      out.write("//                y.style.left = \"50px\";\n");
      out.write("//                y2.style.left = \"-690px\";\n");
      out.write("//                z.style.left = \"110px\";\n");
      out.write("//            }\n");
      out.write("            function login() {\n");
      out.write("                x.style.left = \"50px\";\n");
      out.write("                y.style.left = \"450px\";\n");
      out.write("//                y2.style.left = \"-690px\";\n");
      out.write("                z.style.left = \"0px\";\n");
      out.write("//                document.getElementById(\"\").setAttribute(\"focus\")\n");
      out.write("            }\n");
      out.write("\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("\n");
      out.write("    </body>\n");
      out.write("\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
