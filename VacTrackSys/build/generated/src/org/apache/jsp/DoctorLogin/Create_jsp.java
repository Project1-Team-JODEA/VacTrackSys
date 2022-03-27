package org.apache.jsp.DoctorLogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class Create_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>Record Entry - Patient</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"vac_db.css\">\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <div class=\"container\">\n");
      out.write("    <div class=\"title\">New Record Entry - Patient </div>\n");
      out.write("    <div class=\"content\">\n");
      out.write("      <form name=\"CreateRecord\" id=\"newrecord\" action=\"/addRecords\" method=\"post\">\n");
      out.write("        <div class=\"user-details\">\n");
      out.write("          <div class=\"input-box\">\n");
      out.write("            <span class=\"details\">Vaccination ID</span>\n");
      out.write("            <input type=\"text\" placeholder=\"Enter Vaccine ID here\" required>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"input-box\">\n");
      out.write("            <span class=\"details\">Location</span>\n");
      out.write("            <input type=\"text\" placeholder=\"Enter vaccination location here\" required>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"input-box\">\n");
      out.write("            <span class=\"details\">Manufacturer</span>\n");
      out.write("            <input type=\"text\" placeholder=\"Enter vaccine manufacturer here\" required>\n");
      out.write("          </div>\n");
      out.write("          <div class=\"input-box\">\n");
      out.write("            <span class=\"details\">Date</span>\n");
      out.write("            <input type=\"text\" placeholder=\"Enter date here\">\n");
      out.write("          </div>\n");
      out.write("          <div class=\"input-box\">\n");
      out.write("            <span class=\"details\">Batch Number</span>\n");
      out.write("            <input type=\"text\" placeholder=\"Enter batch # here\" required>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("         \n");
      out.write("          \n");
      out.write("          \n");
      out.write("        <div class=\"gender-details\">\n");
      out.write("          <input type=\"radio\" name=\"gender\" id=\"dot-1\">\n");
      out.write("          <input type=\"radio\" name=\"gender\" id=\"dot-2\">\n");
      out.write("          <input type=\"radio\" name=\"gender\" id=\"dot-3\">\n");
      out.write("          <span class=\"gender-title\">Location</span>\n");
      out.write("          <div class=\"category\">\n");
      out.write("            <label for=\"dot-1\">\n");
      out.write("            <span class=\"dot one\"></span>\n");
      out.write("            <span class=\"gender\">Hospital</span>\n");
      out.write("          </label>\n");
      out.write("          <label for=\"dot-2\">\n");
      out.write("            <span class=\"dot two\"></span>\n");
      out.write("            <span class=\"gender\">Clinic</span>\n");
      out.write("          </label>\n");
      out.write("          <label for=\"dot-3\">\n");
      out.write("            <span class=\"dot three\"></span>\n");
      out.write("            <span class=\"gender\">Other</span>\n");
      out.write("            </label>\n");
      out.write("          </div>\n");
      out.write("        </div>\n");
      out.write("        <div class=\"button\">\n");
      out.write("          <input type=\"submit\" value=\"Update\">\n");
      out.write("          &#8287;  &#8287;  &#8287;  &#8287; \n");
      out.write("          <input type=\"submit\" value=\"Clear\">\n");
      out.write("          &#8287;  &#8287;  &#8287;  &#8287; \n");
      out.write("          <input type=\"submit\" value=\"Cancel\">\n");
      out.write("        </div>\n");
      out.write("      </form>\n");
      out.write("    </div>\n");
      out.write("  </div>\n");
      out.write("    </body>\n");
      out.write("</html>\n");
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
