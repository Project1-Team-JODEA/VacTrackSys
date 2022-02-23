/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.72
 * Generated at: 2022-01-24 01:17:35 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class template_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Assets/Styles/css/mainstyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Assets/Styles/css/tablestyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"Assets/Styles/css/formstyle.css\">\n");
      out.write("\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Caramel&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link href=\"https://fonts.googleapis.com/css2?family=Caramel&family=Dancing+Script&family=Lato&family=Lobster&display=swap\" rel=\"stylesheet\">\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"Assets/Images/icons/favicon16x16.png\" sizes=\"16x16\">\n");
      out.write("        <script src=\"Assets/Srcipts/navScript.js\" type=\"text/javascript\">\n");
      out.write("            function toggleMenu() {\n");
      out.write("                document.getElementById(\"navMenu\").classList.toggle(\"show\");\n");
      out.write("            }\n");
      out.write("\n");
      out.write("// Close the dropdown menu if the user clicks outside of it\n");
      out.write("            window.onclick = function (event) {\n");
      out.write("                if (!event.target.matches('.dropbtn')) {\n");
      out.write("                    var dropdowns = document.getElementsByClassName(\"nav-list\");\n");
      out.write("                    var i;\n");
      out.write("                    for (i = 0; i < dropdowns.length; i++) {\n");
      out.write("                        var openDropdown = dropdowns[i];\n");
      out.write("                        if (openDropdown.classList.contains('show')) {\n");
      out.write("                            openDropdown.classList.remove('show');\n");
      out.write("                        }\n");
      out.write("                    }\n");
      out.write("                }\n");
      out.write("            }\n");
      out.write("\n");
      out.write("        </script>\n");
      out.write("        <title>template</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <header>\n");
      out.write("            <img id=\"Logo\" src=\"Assets/Images/icons/BibleStudy.jpg\" alt=\"Logo\" width=\"20\">\n");
      out.write("\n");
      out.write("        </header>\n");
      out.write("        <div class=\"navbar\"> \n");
      out.write("            <div class=\"menu\">\n");
      out.write("                <button class=\"dropbtn\" onclick=\"toggleMenu()\">Dropdown List ▼</button>\n");
      out.write("                <div id=\"navMenu\" class=\"nav-list\">\n");
      out.write("                    <a href=\"#\">List Item #1</a>\n");
      out.write("                    <a href=\"#\">List Item #2</a>\n");
      out.write("                    <a href=\"#\">List Item #3</a>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("        <main>\n");
      out.write("            <h1>Template</h1>\n");
      out.write("            <h2>Template</h2>\n");
      out.write("            <h3>Template</h3>\n");
      out.write("            <p> This is a paragraph </p>\n");
      out.write("            <blockquote>This is a block quote.</blockquote>\n");
      out.write("            <article>\n");
      out.write("                <h2>Article</h2>\n");
      out.write("                <p>\n");
      out.write("                    This is a paragraph. \n");
      out.write("                    This is a <strong>Strong</strong> tag.\n");
      out.write("                </p>\n");
      out.write("                <section>\n");
      out.write("                    <h2>Article Section</h2>\n");
      out.write("                    <p>This is a <span>span tag</span>.</p>\n");
      out.write("\n");
      out.write("                </section>\n");
      out.write("            </article>\n");
      out.write("            <table>\n");
      out.write("                <tr>\n");
      out.write("                    <th>Row 1</th>\n");
      out.write("                    <th>Row 2</th>\n");
      out.write("                    <th>Row 3</th>\n");
      out.write("                    <th>Row 4</th>\n");
      out.write("                    <th>Row 5</th>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                </tr>\n");
      out.write("                <tr>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                    <td>Data</td>\n");
      out.write("                </tr>\n");
      out.write("            </table>\n");
      out.write("            <form action=\"Download\" method=\"post\">\n");
      out.write("                <input type=\"button\" name=\"\" value=\"Test Download\">\n");
      out.write("                <a href=\"/WEB-INF/Test_File\" >Test Download</a>\n");
      out.write("            </form>\n");
      out.write("        </main>\n");
      out.write("        <footer>\n");
      out.write("            <address>\n");
      out.write("                Address Here &#x2192;\n");
      out.write("            </address>\n");
      out.write("        </footer>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
