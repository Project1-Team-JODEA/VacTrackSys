/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.72
 * Generated at: 2022-05-03 22:50:45 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.DoctorLogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class VacView_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  static {
    _jspx_dependants = new java.util.HashMap<java.lang.String,java.lang.Long>(3);
    _jspx_dependants.put("jar:file:/C:/Users/eVmPr/Documents/IS240/JODEA_Project/VacTrackSys/build/web/WEB-INF/lib/jstl-impl.jar!/META-INF/fmt.tld", Long.valueOf(1343837818000L));
    _jspx_dependants.put("/WEB-INF/lib/jstl-impl.jar", Long.valueOf(1651618131646L));
    _jspx_dependants.put("jar:file:/C:/Users/eVmPr/Documents/IS240/JODEA_Project/VacTrackSys/build/web/WEB-INF/lib/jstl-impl.jar!/META-INF/c.tld", Long.valueOf(1343837818000L));
  }

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private org.apache.jasper.runtime.TagHandlerPool _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems;

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
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.release();
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

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title> Vaccine Record - Create</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/formstyle.css\" type=\"text/css\"/>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/all.css\" type=\"text/css\"/>\r\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"../image/favicon_16x16.png\">\r\n");
      out.write("        <script src=\"../js/functions.js\" type=\"text/javascript\"></script>\r\n");
      out.write("         <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("        <script type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("            function pageAction(action) {\r\n");
      out.write("                document.getElementById(\"actiontype\").value = action;\r\n");
      out.write("                document.getElementById(\"vacrecord\").submit();\r\n");
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            window.onload = () => {\r\n");
      out.write("                $(\"#vac_date\").max = getTodayMaxDate();\r\n");
      out.write("            };\r\n");
      out.write("//            var $ = function (id) {\r\n");
      out.write("//                return document.getElementById(id);\r\n");
      out.write("//            };\r\n");
      out.write("            document.getElementById(\"vacrecord\").onsubmit = () => {\r\n");
      out.write("                $(\"update\").setAttribute(\"disabled\", null);\r\n");
      out.write("                $(\"add\").setAttribute(\"disabled\", null);\r\n");
      out.write("                toggleList('loading-content');\r\n");
      out.write("            };\r\n");
      out.write("            $(document).ready(()=>{\r\n");
      out.write("                \r\n");
      out.write("            })\r\n");
      out.write("        </script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Authentication -->\r\n");
      out.write("        ");
      out.write("\r\n");
      out.write("        <div class=\"toggle-box\" id=\"loading-box\">\r\n");
      out.write("            <div class=\"toggle-content\" id=\"loading-content\" style=\"display: none;\">\r\n");
      out.write("                <i class=\"fas fa-spin fa-spinner\"\r\n");
      out.write("                   style=\"color: blue; font-size: 10em;\r\n");
      out.write("                   text-align: center;\"></i>\r\n");
      out.write("\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"toggle-box\" id=\"msg-box\">\r\n");
      out.write("            <div class=\"toggle-content\" id=\"msg-content\" style=\"display: none;\">\r\n");
      out.write("                <span style=\"font-weight: bold ;\">Database Messages</span> <br>\r\n");
      out.write("                <p>");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${msg}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("</p>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <div class=\"title\">New Vaccine Entry</div>\r\n");
      out.write("            <div class=\"content\">\r\n");
      out.write("                <form name=\"vacrecord\" id=\"vacrecord\" action=\"EditVaccine\" method=\"post\"\r\n");
      out.write("                      onsubmit=\"\">\r\n");
      out.write("                    <div class=\"user-details\">\r\n");
      out.write("                        <div class=\"input-box\">\r\n");
      out.write("                            <span class=\"details\">Vaccine_ID</span>\r\n");
      out.write("                            <input type=\"number\" name=\"vid\" id=\"vid\" min=\"0\" maxlength=\"8\"\r\n");
      out.write("                                   placeholder=\"Enter Vaccine ID here\"\r\n");
      out.write("                                   value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vac.vid}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"input-box\">\r\n");
      out.write("                            <span class=\"details\">Location</span>\r\n");
      out.write("                            <select name=\"loc\" title=\"Location\" id=\"loc\">\r\n");
      out.write("                                <option value=\"\">Select</option>\r\n");
      out.write("                                ");
      if (_jspx_meth_c_005fforEach_005f0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"input-box\">\r\n");
      out.write("                            <span class=\"details\">Manufacturer</span>\r\n");
      out.write("\r\n");
      out.write("                            <select name=\"man\" id=\"man\">\r\n");
      out.write("                                <option value=\"\">Select</option>\r\n");
      out.write("                                <option value=\"Pfizer\">Pfizer</option>\r\n");
      out.write("                                <option value=\"Johnson & Johnson\">Johnson & Johnson</option>\r\n");
      out.write("                                <option value=\"Mederma\">Mederma</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"input-box\">\r\n");
      out.write("                            <span class=\"details\">Date</span>\r\n");
      out.write("                            <input type=\"date\" name=\"vac_date\" id=\"vac_date\"\r\n");
      out.write("                                   min=\"2021-11-30\" max=\"\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vac.date}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"\r\n");
      out.write("                                   required>\r\n");
      out.write("                        </div>\r\n");
      out.write("                        <div class=\"input-box\">\r\n");
      out.write("                            <span class=\"details\">Batch Number</span>\r\n");
      out.write("                            <input type=\"number\" name=\"batnum\" id=\"batnum\" \r\n");
      out.write("                                   placeholder=\"Enter batch # here\" \r\n");
      out.write("                                   maxlength=\"10\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${vac.lotnum}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\">\r\n");
      out.write("                        </div>\r\n");
      out.write("\r\n");
      out.write("                        <div class=\"input-box\">\r\n");
      out.write("                            <span class=\"details\">Vaccine Type</span>\r\n");
      out.write("                            <select name=\"vac_type\" id=\"vac_type\">\r\n");
      out.write("                                <option value=\"REG\">Regular</option>\r\n");
      out.write("                                <option value=\"BOS\">Booster</option>\r\n");
      out.write("                            </select>\r\n");
      out.write("                        </div>\r\n");
      out.write("                    </div>\r\n");
      out.write("\r\n");
      out.write("                    <div class=\"button\">\r\n");
      out.write("                        <input type=\"submit\" id=\"update\" value=\"Update\" onclick=\"pageAction('update')\">\r\n");
      out.write("                        &#8287;  &#8287;  &#8287;  &#8287; \r\n");
      out.write("                        <input type=\"submit\" id=\"add\" value=\"Add\" onclick=\"pageAction('add')\">\r\n");
      out.write("                        &#8287;  &#8287;  &#8287;  &#8287; \r\n");
      out.write("                        <input type=\"reset\" value=\"Clear\">\r\n");
      out.write("                        &#8287;  &#8287;  &#8287;  &#8287; \r\n");
      out.write("                    </div>\r\n");
      out.write("                    <button type=\"submit\" style=\"float: right;\" onclick=\"window.location = './VaccinationDB.jsp';\">Go back<i class=\"fas fa-arrow-right\"></i></button>\r\n");
      out.write("                    <input type=\"hidden\" name=\"actiontype\" id=\"actiontype\" value=\"\">\r\n");
      out.write("                </form>\r\n");
      out.write("                <!--                        <form action=\"DBAction\">\r\n");
      out.write("                                            <button type=\"submit\">Go back<i class=\"fas fa-arrow-right\"></i></button>\r\n");
      out.write("                                        </form>-->\r\n");
      out.write("                <i class=\"fa-1-5x fas fa-exclamation-triangle\" onclick=\"toggleList('msg-content')\" id=\"msg-btn\">Messages</i>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("\r\n");
      out.write("        <!--<div class=\"container\"id=\"results\"></div>-->\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
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

  private boolean _jspx_meth_c_005fforEach_005f0(javax.servlet.jsp.PageContext _jspx_page_context)
          throws java.lang.Throwable {
    javax.servlet.jsp.PageContext pageContext = _jspx_page_context;
    javax.servlet.jsp.JspWriter out = _jspx_page_context.getOut();
    //  c:forEach
    org.apache.taglibs.standard.tag.rt.core.ForEachTag _jspx_th_c_005fforEach_005f0 = (org.apache.taglibs.standard.tag.rt.core.ForEachTag) _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.get(org.apache.taglibs.standard.tag.rt.core.ForEachTag.class);
    boolean _jspx_th_c_005fforEach_005f0_reused = false;
    try {
      _jspx_th_c_005fforEach_005f0.setPageContext(_jspx_page_context);
      _jspx_th_c_005fforEach_005f0.setParent(null);
      // /DoctorLogin/VacView.jsp(84,32) name = var type = java.lang.String reqTime = false required = false fragment = false deferredValue = false expectedTypeName = null deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setVar("lc");
      // /DoctorLogin/VacView.jsp(84,32) name = items type = javax.el.ValueExpression reqTime = true required = false fragment = false deferredValue = true expectedTypeName = java.lang.Object deferredMethod = false methodSignature = null
      _jspx_th_c_005fforEach_005f0.setItems(new org.apache.jasper.el.JspValueExpression("/DoctorLogin/VacView.jsp(84,32) '${loc}'",_jsp_getExpressionFactory().createValueExpression(_jspx_page_context.getELContext(),"${loc}",java.lang.Object.class)).getValue(_jspx_page_context.getELContext()));
      int[] _jspx_push_body_count_c_005fforEach_005f0 = new int[] { 0 };
      try {
        int _jspx_eval_c_005fforEach_005f0 = _jspx_th_c_005fforEach_005f0.doStartTag();
        if (_jspx_eval_c_005fforEach_005f0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
          do {
            out.write("\r\n");
            out.write("                                    <option value=\"");
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lc.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write('"');
            out.write('>');
            out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${lc.name}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
            out.write("</option>\r\n");
            out.write("                                ");
            int evalDoAfterBody = _jspx_th_c_005fforEach_005f0.doAfterBody();
            if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
              break;
          } while (true);
        }
        if (_jspx_th_c_005fforEach_005f0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
          return true;
        }
      } catch (java.lang.Throwable _jspx_exception) {
        while (_jspx_push_body_count_c_005fforEach_005f0[0]-- > 0)
          out = _jspx_page_context.popBody();
        _jspx_th_c_005fforEach_005f0.doCatch(_jspx_exception);
      } finally {
        _jspx_th_c_005fforEach_005f0.doFinally();
      }
      _005fjspx_005ftagPool_005fc_005fforEach_0026_005fvar_005fitems.reuse(_jspx_th_c_005fforEach_005f0);
      _jspx_th_c_005fforEach_005f0_reused = true;
    } finally {
      org.apache.jasper.runtime.JspRuntimeLibrary.releaseTag(_jspx_th_c_005fforEach_005f0, _jsp_getInstanceManager(), _jspx_th_c_005fforEach_005f0_reused);
    }
    return false;
  }
}
