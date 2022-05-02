package org.apache.jsp.DoctorLogin;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class VaccinationDB_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.apache.jasper.runtime.TagHandlerPool _jspx_tagPool_c_if_test;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspInit() {
    _jspx_tagPool_c_if_test = org.apache.jasper.runtime.TagHandlerPool.getTagHandlerPool(getServletConfig());
  }

  public void _jspDestroy() {
    _jspx_tagPool_c_if_test.release();
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

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<script src=\"../js/ajax.js\" lang=\"javascript\" type=\"text/javascript\"></script>\r\n");
      out.write("\r\n");
      out.write("<script>\r\n");
      out.write("\r\n");
      out.write("</script>\r\n");
      out.write("\r\n");
      out.write("<html lang=\"en\">\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n");
      out.write("        <meta name=\"author\" content=\"Team_JODEA\"> \r\n");
      out.write("        <title>Doctor - Patient Vaccination Database</title>\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"formstyle.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"../css/all.css\" type=\"text/css\">\r\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css\">\r\n");
      out.write("        <!--<link rel=\"stylesheet\" href=\"../.css\" type=\"text/css\"/>-->\r\n");
      out.write("        <link rel=\"icon\" type=\"image/x-icon\" href=\"../image/favicon_16x16.png\">\r\n");
      out.write("        <script src=\"https://kit.fontawesome.com/98e4c48f68.js\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("        <script src=\"../js/functions.js\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js\"></script>\r\n");
      out.write("        <script src=\"script.js\"  lang=\"javascript\" type=\"text/javascript\"></script>\r\n");
      out.write("        <script language=\"javascript\" type=\"text/javascript\">\r\n");
      out.write("\r\n");
      out.write("    function pageAction(action) {\r\n");
      out.write("        if (ajax && action === 'SearchPatient') {\r\n");
      out.write("            ajax.open('get', 'DBAction?type=SearchPatient', true);\r\n");
      out.write("\r\n");
      out.write("            ajax.send();\r\n");
      out.write("            /**  $.get('DBAction', 'actiontype=SearchPatient', function (data, status) {\r\n");
      out.write("             $.\r\n");
      out.write("             });*/\r\n");
      out.write("\r\n");
      out.write("        } else {\r\n");
      out.write("            document.dbaction.submit();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    function pageAction2(action, val_id) {\r\n");
      out.write("        //        var a = window\r\n");
      out.write("        //        console.log(val);\r\n");
      out.write("        //        document.getElementById(\"actiontype\").setAttribute(\"value\", action);\r\n");
      out.write("        document.dbaction.actiontype.value = action;\r\n");
      out.write("        console.log(document.dbaction.actiontype.value);\r\n");
      out.write("        if (action === 'SearchPatient') {\r\n");
      out.write("            pageAction(action);\r\n");
      out.write("            document.dbaction.vid.value = val;\r\n");
      out.write("            document.dbaction.submit();\r\n");
      out.write("        } else if (action == 'EditVaccine') {\r\n");
      out.write("            var val = $(val_id).value;\r\n");
      out.write("            document.dbaction.vid.value = val;\r\n");
      out.write("            document.dbaction.submit();\r\n");
      out.write("        }\r\n");
      out.write("        // else if (ajax && action == 'AddPatient'){\r\n");
      out.write("        //     ajax.open('get', 'RecordsSelection?actiontype=SearchPatient');\r\n");
      out.write("        //     ajax.send(null);\r\n");
      out.write("        // }\r\n");
      out.write("        else {\r\n");
      out.write("            document.dbaction.submit();\r\n");
      out.write("        }\r\n");
      out.write("    }\r\n");
      out.write("    window.onload = () => {\r\n");
      out.write("\r\n");
      out.write("    };\r\n");
      out.write("        </script>\r\n");
      out.write("\r\n");
      out.write("    </head>\r\n");
      out.write("    ");
      if (_jspx_meth_c_if_0(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    <body>\r\n");
      out.write("        <!-- Authentication -->\r\n");
      out.write("        <!-- \r\n");
      out.write("For Searching through database\r\n");
      out.write("        -->\r\n");
      out.write("        ");
      if (_jspx_meth_c_if_1(_jspx_page_context))
        return;
      out.write("\r\n");
      out.write("    </body>\r\n");
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

  private boolean _jspx_meth_c_if_0(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_0 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_0.setPageContext(_jspx_page_context);
    _jspx_th_c_if_0.setParent(null);
    _jspx_th_c_if_0.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${!u.authenticated}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_0 = _jspx_th_c_if_0.doStartTag();
    if (_jspx_eval_c_if_0 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("        <script type=\"text/javascript\">\r\n");
        out.write("            window.window.location = \"/VacTrackSys/Redirect_Home.jsp\";\r\n");
        out.write("            ``````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````````</script>\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_0.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_0.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_0);
    return false;
  }

  private boolean _jspx_meth_c_if_1(PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_1 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_1.setPageContext(_jspx_page_context);
    _jspx_th_c_if_1.setParent(null);
    _jspx_th_c_if_1.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.authenticated}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_1 = _jspx_th_c_if_1.doStartTag();
    if (_jspx_eval_c_if_1 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("\r\n");
        out.write("            <div class=\"toggle-box\" id=\"loading-box\">\r\n");
        out.write("                <div class=\"toggle-content\" id=\"loading-content\" style=\"display: none;\">\r\n");
        out.write("                    <i class=\"fas fa-spin fa-spinner\"\r\n");
        out.write("                       style=\"color: blue; font-size: 10em;\r\n");
        out.write("                       text-align: center;\"></i>\r\n");
        out.write("                </div>\r\n");
        out.write("            </div>\r\n");
        out.write("\r\n");
        out.write("            <!-- Message Box is for Viewing Database Error Messages-->\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("            <div class=\"container\" id=\"input-form\">\r\n");
        out.write("                <i class=\"fas fa-user-circle fa-1-5x toggle-btn\" class=\"vac-btn\" id=\"prof-btn\"\r\n");
        out.write("                   title=\"User profile\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write(" - ");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.accesslevel}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</i>\r\n");
        out.write("\r\n");
        out.write("                <div class=\"title\">Patient/Vaccine Records\r\n");
        out.write("                    <i class=\"fas fa-1-x fa-question-circle toggle-btn\" id=\"help-btn\" title=\"Click to open Help/Guide\"\r\n");
        out.write("                       style=\"float: right;\"></i>\r\n");
        out.write("                    <i class=\"fa-1-x fas fa-database toggle-btn\" title=\"Click to view Transaction Messages\" onclick=\"\" id=\"msg-btn\" style=\"float: right;\"></i>\r\n");
        out.write("                    <div class=\"toggle-box\" id=\"pro-box\">\r\n");
        out.write("                        <div class=\"toggle-content\" id=\"pro-content\" style=\"display: none;\">\r\n");
        out.write("                            <span style=\"font-weight: bold ;\">");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.username}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</span> <br>\r\n");
        out.write("                            <p></p>\r\n");
        out.write("                        </div>\r\n");
        out.write("                    </div>\r\n");
        out.write("                </div><br>\r\n");
        out.write("                <div class=\"toggle-box\" id=\"msg-box\">\r\n");
        out.write("                    <div class=\"toggle-content\" id=\"msg-content\" style=\"display: none;\">\r\n");
        out.write("                        <span style=\"font-weight: bold ;\">Database Messages</span> <br>\r\n");
        out.write("                        <p>");
        out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${msg}", java.lang.String.class, (PageContext)_jspx_page_context, null));
        out.write("</p>\r\n");
        out.write("                    </div>\r\n");
        out.write("                </div>\r\n");
        out.write("                <div class=\"toggle-box\" id=\"help-box\">\r\n");
        out.write("                    <div class=\"toggle-content\" id=\"help-content\" style=\"display: none;\">\r\n");
        out.write("                        <span style=\"font-weight: bold ;\">Help/Tips</span>\r\n");
        out.write("                        <ul>\r\n");
        out.write("                            <li>Click on the Message icon (<i class=\"fas fa-database\"></i>) to\r\n");
        out.write("                                view any error messages then click on it again to close it.</li>\r\n");
        out.write("                            <li> Try not to refresh the page too many times at once.\r\n");
        out.write("                                Otherwise, your search input may not go through.</li>\r\n");
        out.write("                            <li></li>\r\n");
        out.write("                            <li></li>\r\n");
        out.write("                        </ul>\r\n");
        out.write("                        <!--<textarea readonly> </textarea>-->\r\n");
        out.write("                    </div>\r\n");
        out.write("                </div> \r\n");
        out.write("                <div class=\"content\">\r\n");
        out.write("                    <form name=\"dbaction\" \r\n");
        out.write("                          id=\"dbaction\" action=\"DBAction\"  onsubmit=\"toggleList('loading-content')\">\r\n");
        out.write("                        <div class=\"info\">\r\n");
        out.write("\r\n");
        out.write("                            <div class=\"user-details\">\r\n");
        out.write("                                <div class=\"input-box\" id=\"pat-info\">\r\n");
        out.write("                                    <span class=\"details\">Select Record Action</span>\r\n");
        out.write("                                    <div class=\"button\" style=\"margin: 25px 0;\">\r\n");
        out.write("                                        <table class=\"actions\">\r\n");
        out.write("                                            <tr>\r\n");
        out.write("                                                <td><i class=\"fas fa-user fa-2x\" title=\"Patient Record Actions\">Patient</i></td>\r\n");
        out.write("\r\n");
        out.write("                                                <td> <button type=\"button\" class=\"fas fa-magnifying-glass\"  title=\"Search Patient\" value=\"SearchPatient\">\r\n");
        out.write("                                                    </button>\r\n");
        out.write("                                                </td>\r\n");
        out.write("                                                <td> <button type=\"button\" class=\"fas fa-user-edit\" title=\"Edit Patient\" value=\"EditPatient\">\r\n");
        out.write("                                                    </button>\r\n");
        out.write("                                                </td>\r\n");
        out.write("                                                <td> <button type=\"button\" class=\"fas fa-user-plus\" title=\"Add Patient\" value=\"AddPatient\" id=\"patadd\">\r\n");
        out.write("                                                    </button>\r\n");
        out.write("                                                </td>\r\n");
        out.write("                                            </tr>\r\n");
        out.write("                                            <tr>\r\n");
        out.write("                                                <td><i class=\"fas fa-syringe fa-2x\">Vaccine</i></td>\r\n");
        out.write("                                                <td><button type=\"button\"  class=\"fas fa-plus\" title=\"Add Vaccine\" value=\"AddVaccine\" >\r\n");
        out.write("                                                    n</button>\r\n");
        out.write("                                                </td>\r\n");
        out.write("                                                <td><button type=\"button\"  class=\"fas fa-pen fa-1x\" title=\"Edit Vaccine\"value=\"Edit Vaccine\" >\r\n");
        out.write("                                                    </button></td>\r\n");
        out.write("                                            </tr>\r\n");
        out.write("                                        </table>\r\n");
        out.write("                                        <!--&#8287; &#8287; &#8287; &#8287;-->\r\n");
        out.write("                                        <!-- &#8287; &#8287; &#8287; &#8287; -->\r\n");
        out.write("                                    </div>\r\n");
        out.write("\r\n");
        out.write("                                    <table>\r\n");
        out.write("                                        <tr class=\"sch\" style=\"display: none;\">\r\n");
        out.write("                                            <td>\r\n");
        out.write("                                                <input type=\"button\" name=\"list-btn\" class=\"sortbtn\"\r\n");
        out.write("                                                       id=\"list-btn\" value=\"Search By: \" onclick=\"toggleList('searchlist')\">\r\n");
        out.write("                                                <!--<span class=\"detailes\">Search By: </span>-->\r\n");
        out.write("                                            </td>\r\n");
        out.write("                                            <td><div name=\"list\" class=\"sort\">\r\n");
        out.write("                                                    <div class=\"items\" id=\"searchlist\" style=\"display: none;\">\r\n");
        out.write("                                                        <ul>\r\n");
        out.write("                                                            <li>\r\n");
        out.write("                                                                <input type=\"checkbox\" name=\"sortval\" class=\"sortval\" name=\"ssn1\" value=\"ssn1\">\r\n");
        out.write("                                                                <label for=\"ssn1\" class=\"details\">Social Security</label> \r\n");
        out.write("                                                            </li>\r\n");
        out.write("                                                            <li><input type=\"checkbox\" name=\"sortval\"  class=\"sortval\" name=\"fname1\" value=\"fname1\">\r\n");
        out.write("                                                                <label for=\"fname1\" class=\"details\">First Name</label>\r\n");
        out.write("                                                            </li>\r\n");
        out.write("                                                            <li><input type=\"checkbox\" name=\"sortval\" class=\"sortval\" name=\"lname1\" value=\"lname1\">\r\n");
        out.write("                                                                <label for=\"lname1\" class=\"details\">Last Name</label></li>\r\n");
        out.write("                                                            <li><input type=\"checkbox\" name=\"sortval\" class=\"sortval\" name=\"midinit1\"  value=\"midinit1\">\r\n");
        out.write("                                                                <label for=\"midinit1\" class=\"details\">Middle Initial</label></li>\r\n");
        out.write("                                                            <li><input type=\"checkbox\" name=\"sortval\" class=\"sortval\" name=\"dob1\" value=\"dob1\">\r\n");
        out.write("                                                                <label for=\"dob1\" class=\"details\">Date of Birth</label></li>\r\n");
        out.write("                                                            <li><input type=\"checkbox\" name=\"sortval\" class=\"sortval\" name=\"vac_id1\"  value=\"vac_id1\">\r\n");
        out.write("                                                                <label for=\"vac_id1\" class=\"details\">Vaccine (ID)</label></li>\r\n");
        out.write("                                                            <li><input type=\"checkbox\" name=\"sortval\" class=\"sortval\"  name=\"man1\" value=\"man1\">\r\n");
        out.write("                                                                <label for=\"man1\" class=\"details\">Vaccine (Manufacturer)</label></li>\r\n");
        out.write("                                                        </ul>\r\n");
        out.write("                                                    </div>\r\n");
        out.write("                                                </div></td>\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                        <tr id=\"ssn1\" style=\"display: none;\">\r\n");
        out.write("                                            <td><label class=\"details\">SSN: </label></td>\r\n");
        out.write("                                            <td><input class=\"pat_info\" type=\"text\" name=\"ssn\" id=\"ssn\" maxlength=\"11\" \r\n");
        out.write("                                                       placeholder=\"(###-##-####)\"  title=\"Nine digit social security code\"></td><!--  pattern=\"[0-9]{3}-[0-9]{2}-[0-9]{4}$\" pattern=\"^(?!666|000|9\\d{2})\\d{3}-(?!00{2})\\d{2}-(?!0000{4})\\d{4}$\"pattern=\"\\d{3}[\\-]\\d{2}[\\-]\\d{4}\"-->\r\n");
        out.write("\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                        <tr id=\"fname1\" style=\"display: none;\">\r\n");
        out.write("                                            <td><span class=\"details\">First Name:</span></td>\r\n");
        out.write("                                            <td><input class=\"pat_info\" type=\"text\"\r\n");
        out.write("                                                       name=\"fname\" id=\"fname\" pattern=\"[a-zA-z]\"></td>\r\n");
        out.write("                                            <!-- pattern=\"[A-Za-z].{1,}\"  -->\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                        <tr  id=\"midinit1\" style=\"display: none;\">\r\n");
        out.write("                                            <td><span class=\"details\">Middle Initial:</span></td>\r\n");
        out.write("                                            <td><input class=\"pat_info\" type=\"text\" name=\"midinit\" id=\"midinit\" maxlength=\"1\" pattern=\"[a-zA-Z]{1}\" width=\"5\"></td>\r\n");
        out.write("\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                        <tr id=\"lname1\" style=\"display: none;\">\r\n");
        out.write("                                            <td><span class=\"details\">Last Name:</span></td>\r\n");
        out.write("                                            <td><input  type=\"text\" class=\"pat_info\" name=\"lname\" id=\"lname\" pattern=\"[a-zA-z].{1,}\"></td>\r\n");
        out.write("\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                        <tr id=\"dob1\" style=\"display: none;\">\r\n");
        out.write("                                            <td><span class=\"details\">Birth Date: </span></td>\r\n");
        out.write("                                            <td><input type=\"date\" class=\"pat_info\" name=\"dob\" id=\"dob\" max=\"\"></td>\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                        <tr  class=\"vac_date\" style=\"display: none;\">\r\n");
        out.write("                                            <td><span class=\"details\">Vaccination Date: </span></td>\r\n");
        out.write("                                            <td><input type=\"date\" class=\"pat_info\" name=\"vac_date\" id=\"vac_date\" min=\"2021-11-30\" max=\"\"></td>\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                        <tr id=\"pat_type1\" style=\"display: none;\">\r\n");
        out.write("                                            <td><span class=\"details\">Patient Type</span></td>\r\n");
        out.write("                                            <td><select id=\"pat_type\" class=\"pat_info\">\r\n");
        out.write("                                                    <option value=\"\">Select</option>\r\n");
        out.write("                                                    <option svalue=\"PAT\">Regular</option>\r\n");
        out.write("                                                    <option value=\"INP\">Inpatient</option>\r\n");
        out.write("                                                    <option value=\"OUT\">Outpatient</option>\r\n");
        out.write("                                                    <option value=\"OTH\">Other</option>\r\n");
        out.write("                                                    <option value=\"N/A\">N/A</option>\r\n");
        out.write("                                                </select></td>\r\n");
        out.write("                                        </tr>\r\n");
        out.write("\r\n");
        out.write("                                        <tr id=\"vac_id1\" style=\"display: none;\">\r\n");
        out.write("                                            <td><span class=\"details\">Vaccine ID:</span></td>\r\n");
        out.write("                                            <td>\r\n");
        out.write("                                                <input type=\"number\" class=\"pat_info\" name=\"vac_id\" id=\"vac_id\" pattern=\"[0-9]{8}\" placeholder=\"00000000\" >\r\n");
        out.write("                                            </td>\r\n");
        out.write("\r\n");
        out.write("\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                        <tr id=\"man1\" style=\"display: none;\">\r\n");
        out.write("                                            <td><span class=\"details\">Manufacturer</span>\r\n");
        out.write("                                                <input type=\"text\" name=\"man\" id=\"man\" \r\n");
        out.write("                                                       placeholder=\"Enter vaccine manufacturer here\"\r\n");
        out.write("                                                       value=\"\" pattern=\"\"></td>\r\n");
        out.write("                                            <td> <select name=\"man\" id=\"man\" class=\"vac_info\">\r\n");
        out.write("                                                    <option value=\"\">Select</option>\r\n");
        out.write("                                                    <option value=\"Pfizer\">Pfizer</option>\r\n");
        out.write("                                                    <option value=\"Johnson & Johnson\">Johnson & Johnson</option>\r\n");
        out.write("                                                    <option value=\"Mederma\">Mederma</option>\r\n");
        out.write("                                                </select></td>\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                        <tr class=\"sch\"  style=\"display: none;\">\r\n");
        out.write("                                            <td>\r\n");
        out.write("                                                <!--<i class=\"fas fa-magnifying-glass\"></i>-->\r\n");
        out.write("                                                <input type=\"submit\" id=\"action\" value=\"\">\r\n");
        out.write("                                            </td>\r\n");
        out.write("                                        </tr>\r\n");
        out.write("                                    </table>\r\n");
        out.write("                                </div>\r\n");
        out.write("                            </div>\r\n");
        out.write("                            <!--<span class=\"details\">Sort By:</span>-->\r\n");
        out.write("\r\n");
        out.write("                            <!--                            <div class=\"vac-details\" style=\"display: none;\">\r\n");
        out.write("                            \r\n");
        out.write("                                                            <div class=\"input-box\" id=\"vac-info\">\r\n");
        out.write("                                                                <table>\r\n");
        out.write("                                                                    <tr>\r\n");
        out.write("                                                                        <td><span class=\"details\">Vaccine 1</span></td>\r\n");
        out.write("                                                                        <td></td>\r\n");
        out.write("                                                                    </tr>\r\n");
        out.write("                                                                    <tr>\r\n");
        out.write("                                                                        <td><input type=\"number\" name=\"v1id\" id=\"v1id\" pattern=\"[0-9]{8}\" min=\"0\" placeholder=\"000000000\"></td>\r\n");
        out.write("                                                                        <td style=\"width: 50px;\">\r\n");
        out.write("                            ");
        if (_jspx_meth_c_if_2((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                        </td>\r\n");
        out.write("                        <td>\r\n");
        out.write("                            ");
        if (_jspx_meth_c_if_3((javax.servlet.jsp.tagext.JspTag) _jspx_th_c_if_1, _jspx_page_context))
          return true;
        out.write("\r\n");
        out.write("                        </td>\r\n");
        out.write("                         <td><i ></i></td> \r\n");
        out.write("                    </tr>\r\n");
        out.write("                    \r\n");
        out.write("                    </table>\r\n");
        out.write("                </div>\r\n");
        out.write("                \r\n");
        out.write("            </div>-->\r\n");
        out.write("\r\n");
        out.write("                        </div>\r\n");
        out.write("                        <div class=\"button\">\r\n");
        out.write("                            <button type=\"reset\" title=\"clear form input\" >CLEAR</button>\r\n");
        out.write("                            <i class=\"fas fa-2x fa-door-closed \" id=\"Logout\"  title=\"Logout\" \r\n");
        out.write("                               style=\" cursor: pointer; \"></i>\r\n");
        out.write("                        </div>\r\n");
        out.write("                        <input type=\"hidden\" name=\"actiontype\" id=\"actiontype\" value=\"\">\r\n");
        out.write("                    </form>\r\n");
        out.write("                </div>\r\n");
        out.write("            </div>\r\n");
        out.write("            <div id=\"results\"></div>\r\n");
        out.write("            <!--                <div class=\"container\" id=\"rs-form\">\r\n");
        out.write("                                <div class=\"title\">Results</div>\r\n");
        out.write("                                <div class=\"content\" id=\"rs-content\">\r\n");
        out.write("                                    <hr>\r\n");
        out.write("                                   \r\n");
        out.write("                                </div>\r\n");
        out.write("                            </div>-->\r\n");
        out.write("\r\n");
        out.write("        ");
        int evalDoAfterBody = _jspx_th_c_if_1.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_1.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_1);
    return false;
  }

  private boolean _jspx_meth_c_if_2(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_2 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_2.setPageContext(_jspx_page_context);
    _jspx_th_c_if_2.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_2.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.accesslevel=='MedicalStaff' || u.accesslevel=='Admin'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_2 = _jspx_th_c_if_2.doStartTag();
    if (_jspx_eval_c_if_2 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <i class=\"vac-btn fas fa-pen-square fa-2x\" name=\"edit_v1\" id=\"edit_v1\" title=\"Edit Vaccine\" value=\"Edit Vaccine\" onclick=\"pageAction2('EditVaccine', 'v1id')\"></i>\r\n");
        out.write("                                <input type=\"submit\"  class=\"edit-btn\" name=\"edit_v1\" id=\"edit_v1\" value=\"Edit Vaccine\">\r\n");
        out.write("                                <td><input type=\"number\" > </td>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_2.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_2.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_2);
    return false;
  }

  private boolean _jspx_meth_c_if_3(javax.servlet.jsp.tagext.JspTag _jspx_th_c_if_1, PageContext _jspx_page_context)
          throws Throwable {
    PageContext pageContext = _jspx_page_context;
    JspWriter out = _jspx_page_context.getOut();
    //  c:if
    org.apache.taglibs.standard.tag.rt.core.IfTag _jspx_th_c_if_3 = (org.apache.taglibs.standard.tag.rt.core.IfTag) _jspx_tagPool_c_if_test.get(org.apache.taglibs.standard.tag.rt.core.IfTag.class);
    _jspx_th_c_if_3.setPageContext(_jspx_page_context);
    _jspx_th_c_if_3.setParent((javax.servlet.jsp.tagext.Tag) _jspx_th_c_if_1);
    _jspx_th_c_if_3.setTest(((java.lang.Boolean) org.apache.jasper.runtime.PageContextImpl.evaluateExpression("${u.accesslevel=='MedicalStaff' || u.accesslevel=='Admin'}", java.lang.Boolean.class, (PageContext)_jspx_page_context, null)).booleanValue());
    int _jspx_eval_c_if_3 = _jspx_th_c_if_3.doStartTag();
    if (_jspx_eval_c_if_3 != javax.servlet.jsp.tagext.Tag.SKIP_BODY) {
      do {
        out.write("\r\n");
        out.write("                                <i class=\"vac-btn fas fa-plus-square fa-2x\" name=\"add\" id=\"add_v1\" title=\"Add Vaccine\" value=\"Edit Vaccine\" onclick=\"pageAction2('AddVaccine', 'v1id')\"></i>\r\n");
        out.write("                            ");
        int evalDoAfterBody = _jspx_th_c_if_3.doAfterBody();
        if (evalDoAfterBody != javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_AGAIN)
          break;
      } while (true);
    }
    if (_jspx_th_c_if_3.doEndTag() == javax.servlet.jsp.tagext.Tag.SKIP_PAGE) {
      _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
      return true;
    }
    _jspx_tagPool_c_if_test.reuse(_jspx_th_c_if_3);
    return false;
  }
}
