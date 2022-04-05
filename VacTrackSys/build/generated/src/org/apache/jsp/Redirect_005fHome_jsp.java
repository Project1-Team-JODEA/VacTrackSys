package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Redirect_005fHome_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Error</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/redirectstyle.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"css/all.css\">\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"image/favicon_16x16.png\" />\n");
      out.write("        <script src=\"https://kit.fontawesome.com/98e4c48f68.js\" crossorigin=\"anonymous\"></script>\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\n");
      out.write("    </head>\n");
      out.write("\n");
      out.write("    <body>\n");
      out.write("        <!--        <div class=\"hero\">\n");
      out.write("                    <div class=\"form-box\">\n");
      out.write("                        <form class=\"input-group\">\n");
      out.write("                                            </form>\n");
      out.write("        \n");
      out.write("                        <div class=\"input-group\">\n");
      out.write("        \n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                </div>-->\n");
      out.write("        <div class=\"box-container\">\n");
      out.write("            <div class=\"box\">\n");
      out.write("                <h1 style=\"color: red\"> Page Error  <i class=\"fas fa-exclamation-triangle\"></i></h1>\n");
      out.write("\n");
      out.write("                Uh oh! It looks like one of the following happened:\n");
      out.write("                <blockquote><ul>\n");
      out.write("                    <li>Your Session Had Expired.</li>\n");
      out.write("                    <li>Your User Account was not authenticated.</li>\n");
      out.write("                    <li>An Error occurred within the Server or Client.</li>\n");
      out.write("                    </ul></blockquote>\n");
      out.write("                You can return to the Home Page or \n");
      out.write("                Go to the 1 of the login pages:\n");
      out.write("                <br>\n");
      out.write("                <ul id=\"rlist\">\n");
      out.write("                    <li class=\"rlist-item\"><a href=\"CDC/index1.jsp\" class=\"btn\"><i class=\"fas fa-user-md\"></i>\n");
      out.write("                            CDC Login <i class=\"fas fa-chevron-right\"></i>\n");
      out.write("                        </a></li>\n");
      out.write("                    <li class=\"rlist-item\"><a href=\"DoctorLogin/index1.jsp\" class=\"btn\">\n");
      out.write("                            <i class=\"fas fa-ambulance\"></i> Healthcare <br> Provider\n");
      out.write("                            Login <i class=\"fas fa-chevron-right\"></i>\n");
      out.write("                        </a></li>\n");
      out.write("                    <li class=\"rlist-item\"><a href=\"PatientLogin/index1.jsp\" class=\"btn\">\n");
      out.write("                            <i class=\"fas fa-notes-medical\"></i> Patient Portal <i class=\"fas fa-chevron-right\"></i>\n");
      out.write("                        </a></li>\n");
      out.write("                    <li class=\"rlist-item\"><a href=\"AdminConsole/index1.jsp\" class=\"btn\">\n");
      out.write("                           <i class=\"fas fa-pills\"></i> Administrator <br>Login<i class=\"fas fa-chevron-right\"></i>\n");
      out.write("                        </a></li>\n");
      out.write("                    <li class=\"rlist-item\"><a href=\"index.html\" class=\"btn\">\n");
      out.write("                            <i class=\"fas fa-home\"></i>Home<i class=\"fas fa-chevron-right\"></i></a></li>   \n");
      out.write("                </ul>\n");
      out.write("            </div>\n");
      out.write("            \n");
      out.write("        </div>\n");
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
