package org.apache.jsp.DoctorLogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class PatientView_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");
      out.write("\n");
      out.write("<script src=\"../js/ajax.js\" type=\"text/javascript\"></script>\n");
      out.write("<script src=\"../js/searchPatient.js\" type=\"text/javascript\"></script>\n");
      out.write("<link rel=\"icon\" type=\"image/x-icon\" href=\"../image/favicon_16x16.png\"/>\n");
      out.write("<script type=\"text/javascript\">\n");
      out.write("    var $ = function (id) {\n");
      out.write("        return document.getElementById(id);\n");
      out.write("    };\n");
      out.write("    function pageAction(action) {\n");
      out.write("        document.RecordsSelection.actiontype.value = action;\n");
      out.write("        $(\"actiontype\").value = action;\n");
      out.write("        if (ajax && action === 'searchPatient') {\n");
      out.write("            ajax.open('get', '?actiontype=searchPatient');\n");
      out.write("            ajax.send(null);\n");
      out.write("        } else if (ajax && action === 'Edit') {\n");
      out.write("            ajax.open('get', '?actiontype=AddPatient');\n");
      out.write("            ajax.send(null);\n");
      out.write("        } else {\n");
      out.write("            document.RecordsSelection.submit();\n");
      out.write("        }\n");
      out.write("    }\n");
      out.write("\n");
      out.write("\n");
      out.write("</script>\n");
      out.write("<html lang=\"en\">\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title> Vaccination Database - Existing Patient</title>\n");
      out.write("        <link rel=\"stylesheet\" href=\"formstyle.css\" type=\"text/css\"/>\n");
      out.write("\n");
      out.write("        <script type=\"text/javascript\">\n");
      out.write("            var $ = function (id) {\n");
      out.write("                return document.getElementById(id);\n");
      out.write("            };\n");
      out.write("            function clrscrn() {\n");
      out.write("                //$(\"Records\").reset();\n");
      out.write("//                $(\"rid\").focus();\n");
      out.write("            }\n");
      out.write("        </script>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!-- Authentication -->\n");
      out.write("        ");
      out.write("\n");
      out.write("\n");
      out.write("        <!-- \n");
      out.write("                For Searching through database\n");
      out.write("        -->\n");
      out.write("        <p>\n");
      out.write("            ");
      out.write("\n");
      out.write("        </p>\n");
      out.write("        <div class=\"container\">\n");
      out.write("            <div class=\"title\">Patient Database Records - Update Entry</div>\n");
      out.write("            <div class=\"content\">\n");
      out.write("\n");
      out.write("                <form name=\"NewRecord\" id=\"NewRecord\" action=\"EditVaccine\" method=\"post\">\n");
      out.write("                    <div class=\"user-details\">\n");
      out.write("\n");
      out.write("                        <div class=\"input-box\">\n");
      out.write("                            <span class=\"details\">Patient Info</span>\n");
      out.write("                            <input type=\"text\" name=\"ssn\" id=\"ssn\" value=\"\" placeholder=\"SSN\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"input-box\">\n");
      out.write("                            <span class=\"details\">Vaccines</span>\n");
      out.write("                            <input type=\"text\" name=\"v1id\" id=\"v1id\" value=\"\" \n");
      out.write("                                   placeholder=\"Vaccine #1 ID\"></div>\n");
      out.write("                        <input type=\"submit\" name=\"vaccine1\" id=\"vaccine1\" value=\"Edit Vaccine\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"input-box\"><input type=\"text\" name=\"fname\" id=\"fname\" value=\"\" size=\"\"\n");
      out.write("                                                      placeholder=\"First Name\"></div>\n");
      out.write("                        <div class=\"input-box\"><input type=\"text\" name=\"v2id\" id=\"v2id\" value=\"\" \n");
      out.write("                                                      placeholder=\"Vaccine #2 ID\"></div>\n");
      out.write("                        <input type=\"submit\" name=\"vaccine1\" id=\"vaccine1\" value=\"Edit Vaccine\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"input-box\"><input type=\"text\" name=\"lname\" id=\"lname\" value=\"\" size=\"\"\n");
      out.write("                                                      placeholder=\"Last Name\" > </div>\n");
      out.write("                        <div class=\"input-box\"><input type=\"text\" name=\"v3id\" id=\"v3id\" value=\"\" \n");
      out.write("                                                      placeholder=\"Vaccine #3 ID\"></div>\n");
      out.write("                        <input type=\"submit\" name=\"vaccine1\" id=\"vaccine1\" value=\"Edit Vaccine\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"input-box\"> <input type=\"text\" name=\"midinit\" id=\"midinit\" value=\"\" \n");
      out.write("                                                       placeholder=\"Middle Init\" ></div>\n");
      out.write("                        <div class=\"input-box\"><input type=\"text\" name=\"v4id\" id=\"v4id\" value=\"\" \n");
      out.write("                                                      placeholder=\"Vaccine #4 ID\"></div>\n");
      out.write("                        <input type=\"submit\" name=\"vaccine1\" id=\"vaccine1\" value=\"Edit Vaccine\">\n");
      out.write("                        \n");
      out.write("                        <div class=\"input-box\">\n");
      out.write("                            <span class=\"details\">Patient Type</span>\n");
      out.write("                            <select id=\"pat_type\">\n");
      out.write("                                <option id=\"reg-patient\" value=\"PAT\">Regular</option>\n");
      out.write("                                <option id=\"Inpatient\" value=\"IN\">Inpatient</option>\n");
      out.write("                                <option name=\"outpatient\" value=\"OUT\">Outpatient</option>\n");
      out.write("                                <option name=\"other\" id=\"other\" value=\"OTH\">Other</option>\n");
      out.write("                                <option name=\"unknown\" id=\"unknown\" value=\"N/A\">Other</option>\n");
      out.write("                            </select>\n");
      out.write("                        </div>\n");
      out.write("                        \n");
      out.write("                    </div>\n");
      out.write("                    <div></div>\n");
      out.write("                        \n");
      out.write("\n");
      out.write("\n");
      out.write("                    <!--                    <div class=\"button\">\n");
      out.write("                                            \n");
      out.write("                                                                    <input type=\"submit\" name=\"search\" id=\"search\" value=\"Search Vaccine\" onclick=\"pageAction('searchVaccine')\">\n");
      out.write("                                                                    &#8287;  &#8287;  &#8287;  &#8287; \n");
      out.write("                                        </div>-->\n");
      out.write("                    <br>\n");
      out.write("                    <!--                    <div id=\"button\">\n");
      out.write("                                            <input type=\"reset\" class=\"actionBtn\" name=\"btnClear\"  id=\"btnClear\" value=\"Clear\" onclick=\"clrscrn()\">\n");
      out.write("                                            <input type=\"submit\" class=\"actionBtn\" name=\"view\" id=\"view\" onclick=\"pageAction('view')\" value=\"Search\">\n");
      out.write("                                            <input type=\"submit\" class=\"actionBtn\" name=\"create\" id=\"create\" onclick=\"pageAction('create')\" value=\"create\">\n");
      out.write("                                            <br>\n");
      out.write("                                            <input type=\"button\" class=\"actionBtn\" name=\"Form 2\">\n");
      out.write("                                            <input type=\"submit\" class=\"actionBtn\" name=\"report\" id=\"report\" onclick=\"pageAction('report')\" value=\"Create Report\">\n");
      out.write("                                        </div>-->\n");
      out.write("\n");
      out.write("                    <div class=\"button\">\n");
      out.write("                        <input type=\"submit\" name=\"add\" id=\"add\" value=\"Update\" action=\"EditVaccine\">\n");
      out.write("                        &#8287;  &#8287;  &#8287;  &#8287; \n");
      out.write("                        <!--<input type=\"button\" name=\"btnClear\" id=\"add\" value=\"Add\" onclick=\"document.location = 'VacRecordCreate.jsp';\" >-->\n");
      out.write("                        <!--&#8287;  &#8287;  &#8287;  &#8287;--> \n");
      out.write("                        <input type=\"reset\" name=\"clear\" id=\"btnClear\" value=\"Clear\">\n");
      out.write("                        &#8287;  &#8287;  &#8287;  &#8287; \n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                    <input type=\"hidden\" name=\"actiontype\" id=\"actiontype\" value=\"\" > \n");
      out.write("                </form>\n");
      out.write("<!--                <form id=\"editSSN\" action=\"DBAction\" method=\"post\">\n");
      out.write("                    \n");
      out.write("\n");
      out.write("                </form>-->\n");
      out.write("                 <input type=\"button\" name=\"logout\" id=\"logout\" value=\"Logout\" onclick=\"document.location = 'index1.jsp';\">\n");
      out.write("                \n");
      out.write("                ");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
      out.write("\n");
      out.write("            </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        </div>\n");
      out.write("\n");
      out.write("\n");
      out.write("        <div id=\"results\"></div>\n");
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
