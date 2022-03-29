/**
 *
 * @author eVmPr
 *
 * TODO: Add attributes to JSPs:
 *
 */
package servlets;

import business.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DBActionServlet", urlPatterns = {"/CDC/DBAction", "/DoctorLogin/DBAction"})
public class DBActionServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * Takes actiontype parameter from request and performs action depending on
     * the action. <br>
     * Actions: 'SearchPatient' line - ,'EditPatient': , 'EditVaccine': 'Logout'
     *
     * ,etc
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String URL = "";
        String msg = "", action = "", sql = "", sql_vac = "", webloc = "";
        String ssn, fname, minit, lname, vac_date = "", dob = "", ptype, vsite, vid, v1id, v2id, v3id, v4id;
        String[] filters = new String[12];

        String[] msg_html = {"<div class=\"toggle-box\" id=\"msg-box\">", "", "", ""};
        String[] info = {ssn = "", fname = "", minit = "", lname = "", dob = "", ptype = "", vid = "", vsite = "", v1id = "",
            v2id = "", v3id = "", v4id = ""};
        String[] fields = {"Social_Security", "First_Name", "Middle_Init", "Last_Name", "DOB", //"Vaccine_ID",
            "P_Type", "Vaccine_ID", "Vaccination_Site", "Vaccine_1", "Vaccine_2", "Vaccine_3", "Vaccine_4"};
        ArrayList<Patient> patientset = new ArrayList<>();
        ArrayList<String> newVal = new ArrayList<>();
        ArrayList<Patient> pa;
        try {
            String x = String.valueOf(request.getRequestURL());// URL Access Level
            User u = (User) request.getSession().getAttribute("u");
            if (x.contains("DoctorLogin")) {
                webloc = "/DoctorLogin";
            } else if (x.contains("PatientLogin")) {
                webloc = "/PatientLogin";
            } else if (x.contains("AdminConsole")) {
                webloc = "/AdminConsole";
            }
//            String h_request = reque
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            action = request.getParameter("actiontype");// for DB Action
            if (action.equals("") || action.equalsIgnoreCase("")) {
                msg += "Error: Unable to Perform Action <br>";
                URL = webloc + "/VaccinationDB.jsp";
            } else if (action.equalsIgnoreCase("SearchPatient")) {
                info[0] = String.valueOf(request.getParameter("ssn"));
                info[1] = String.valueOf(request.getParameter("fname"));
                info[2] = String.valueOf(request.getParameter("lname"));
                info[3] = String.valueOf(request.getParameter("midinit"));
                // vid will remain empty / blank
                info[5] = String.valueOf(request.getParameter("dob"));
                info[6] = String.valueOf(request.getParameter("pat_type"));
                info[7] = "";//Vaccine_ID will remain blank;
                info[8] = String.valueOf(request.getParameter("v1id"));
                info[9] = String.valueOf(request.getParameter("v2id"));
                info[10] = String.valueOf(request.getParameter("v3id"));
                info[11] = String.valueOf(request.getParameter("v4id"));
                //N/A will be used to filter out the empty input params
                int isE = 0;
                String newV = "";
                for (int i = 0; i < info.length; i++) {
                    if (info[i].isEmpty() || info[i].equals("") || info[i].equals("null")) {
                        info[i] = "N/A";
                        isE++;
                        filters[i] = info[i];
                    } else {
                        // adds a new condition clause for WHERE clause
                        if (fields[i].equals("Social_Security")) {
                            newV = fields[i] + "=" + info[i];
                            filters[i] = newV; //String.valueOf(newV);

                        } else if (fields[i].equals("DOB")) {
                            //format date
                            DateTimeFormatter dob_format = DateTimeFormatter.ofPattern("dd-MMM-yy");
                            newV = fields[i] + "='" + String.valueOf(dob_format.format(LocalDate.parse(info[i]))) + "'";
                            filters[i] = newV;//
                        } else {
                            newV = fields[i] + "='" + info[i] + "'";
                            filters[i] = String.valueOf(newV);
                        }
                        newVal.add(filters[i]);// add value to array list
                    }
                }// end of for-loop
                if (isE == info.length) {
                    msg += "Please Enter a value in one of the fields. <br>";
                }
                // info array will be used for filter criteria
                if (msg.isEmpty() || msg.equals("")) {
                    // continue with transaction
                    sql = "SELECT * FROM PATIENTS";
//                        + " WHERE Social_Security='" + ssn + "';";
                    String sqlw = " WHERE ";
                    newVal.remove("");
                    newVal.remove("null");
                    // Create a new Array from ArrayList
                    String[] rs = newVal.toArray(new String[newVal.size()]);
                    String val = "";
                    if (rs.length == 1) {
                        val = rs[0];
                        sqlw += val;
                    } else {//Add 'AND' if more than one condition
                        for (int i = 0; i < rs.length; i++) {
                            if (!rs[i].equalsIgnoreCase("N/A") && !rs[i].equalsIgnoreCase("null")
                                    && !rs[i].equalsIgnoreCase(null)) {
                                val = rs[i];
//                                System.out.println("value = " + val);
                                if (val.contains("\'")) {
                                }
                                if (i < rs.length - 1 && !rs[i].equalsIgnoreCase("N/A")) {//&& !filters[i].equalsIgnoreCase("N/A")
                                    sqlw += val + " AND ";//Adds 'AND' in between each condition 
                                } else {
                                    sqlw += val;
                                }
                            }
                        }
                    }
                    //add sqlw to sql variable
                    sql += sqlw;// + ";";
                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery(sql);
                    while (r.next()) {
                        Patient pat = new Patient();
                        pat.setSsn(String.valueOf(r.getInt("Social_Security")));
                        //
                        pat.setFname(r.getString("First_Name"));
                        pat.setMname(r.getString("Middle_Init"));
                        pat.setLname(r.getString("Last_Name"));
                        pat.setDob(String.valueOf(r.getDate("DOB")));
                        pat.setPtype(r.getString("P_Type"));
                        // adding temporary dummy vaccines
                        Vaccine vac1 = new Vaccine();
                        vac1.setVid(r.getString("Vaccine_1"));
                        pat.setVac1(vac1);
                        Vaccine vac2 = new Vaccine();
                        vac2.setVid(r.getString("Vaccine_2"));
                        pat.setVac2(vac2);
                        Vaccine vac3 = new Vaccine();
                        vac3.setVid(r.getString("Vaccine_3"));
                        pat.setVac3(vac3);
                        Vaccine vac4 = new Vaccine();
                        vac4.setVid(r.getString("Vaccine_4"));
                        pat.setVac4(vac4);
                        patientset.add(pat);
                    }
                    r.close();
                    s.close();
                    request.getSession().setAttribute("patientset", patientset);
//                    User u = (User) request.getSession().getAttribute("u");
                    u.setSearched(true);
                    request.getSession().setAttribute("u", u);
                    URL = webloc + "/PatientRecords.jsp";
                } else {
                    URL = webloc + "/VaccinationDB.jsp";
                }
            } else if (action.equalsIgnoreCase("EditPatient")) {
                // code editing script
//                sql = "SELECT SITE_NAME FROM VAC_SITES";
//                Statement s = conn.createStatement();
//                ResultSet r = s.executeQuery(sql);
//                ArrayList<Location> loc= new ArrayList<>();
//                
//                //create a locations list
//                while (r.next()){
//                   Location l = new Location();
//                l.setId(r.getInt("SITE_ID"));
//                l.setName(r.getString("SITE_NAME"));
//                l.setLtype(r.getString("SITE_TYPE"));
//                loc.add(l);
//                
//                }
//                request.getSession().setAttribute("vloc", loc);
                sql = "SELECT * FROM PATIENTS WHERE Social_Security = '" + request.getParameter("ssn").trim() + "'";
                Statement s = conn.createStatement();
                s.clearBatch();
                ResultSet r = s.executeQuery(sql);

                if (r.next()) {
                    Patient pat = new Patient();
                    pat.setSsn(r.getString("Social_Security"));
                    pat.setFname(r.getString("First_Name"));
                    pat.setMname(r.getString("Middle_Init"));
                    pat.setLname(r.getString("Last_Name"));
                    pat.setDob(String.valueOf(r.getDate("DOB")));
                    pat.setPtype(r.getString("P_Type"));
                    // adding temporary dummy vaccines
                    Vaccine vac1 = new Vaccine();
                    vac1.setVid(r.getString("Vaccine_1"));
                    pat.setVac1(vac1);
                    Vaccine vac2 = new Vaccine();
                    vac2.setVid(r.getString("Vaccine_2"));
                    pat.setVac2(vac2);
                    Vaccine vac3 = new Vaccine();
                    vac3.setVid(r.getString("Vaccine_3"));
                    pat.setVac3(vac3);
                    Vaccine vac4 = new Vaccine();
                    vac4.setVid(r.getString("Vaccine_4"));
                    pat.setVac4(vac4);
                    patientset.add(pat);
                    // 
                    request.getSession().setAttribute("selectedPatient", pat);
                    URL = webloc + "/PatientView.jsp";

                } else {
                    msg += "Error: <br>";
                }
                r.close();
                s.close();
            } else if (action.equalsIgnoreCase("EditVaccine")) {
                //Edit Vaccine
                vid = String.valueOf(request.getParameter("vid"));
//                request.getSession().getAttribute(lname)
                if (vid.isEmpty() || vid.equals("")) {
                    msg += "Missing Vaccination ID <br>";
                } else {

                }
                if (msg.equals("") || msg.isEmpty()) {
//                    sql = "SELECT v.Vaccine_ID, Vaccine_Type, Vaccine_Location, Vaccine_Date, Manufacturer, b.BATCH_NUM\n"
//                            + "FROM VACCINES AS v LEFT JOIN VAC_BATCHES AS b ON v.Vaccine_ID = b.Vaccine_ID\n"
//                            + "WHERE v.Vaccine_ID=?";
                    sql = "SELECT * " //Vaccine_ID, Vaccine_Type, Vaccine_Location, Vaccine_Date, Manufacturer,  
                            + "FROM VACCINES WHERE Vaccine_ID = ?;";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1, vid);
                    ResultSet rs = ps.executeQuery();
                    if (rs.next()) {
//                        while (rs.next()) {
//                        }
                        Vaccine vac = new Vaccine();
                        vac.setVid(rs.getString("Vaccine_ID"));
//                        vac.setManufacturer(rs.getString("Manufacturer"));
                        vac.setVtype(rs.getString("Vaccine_Type"));
                        vac.setLocation(rs.getString("Vaccine_Location"));
                        vac.setDate(String.valueOf(rs.getDate("Vaccine_Date")));
                        vac.setManufacturer(rs.getString("Manufacturer"));
                        if (vac.getLocation().equals(u.getLocation())) {
                            request.getSession().setAttribute("vac", vac);

                        } else {
                            msg += "Vaccine: " + vac.getVid() + "";
                        }

                        URL = webloc + "/VacView.jsp";

                    } else {
                        msg += "Error: Vaccine Not Found.<br>";
                        URL = webloc += "/VaccinationDB.jsp";
                    }

                    rs.close();
                    ps.close();
                } else {
                    URL = webloc += "/VaccinationDB.jsp";
                }

//           
            } else if (action.equalsIgnoreCase("AddVaccine")) {
                Vaccine v = new Vaccine();
                // Use Default
                v.setVid(request.getParameter("vid"));
                Date today = new Date();
                System.out.println(today);
//                User u = (User) request.getSession().getAttribute("u");
                DateTimeFormatter d_format = DateTimeFormatter.ofPattern("yyyy-MM-dd");
//                 d_format.parse(Lo)                
                String t = String.valueOf(today);

                v.setLocation(u.getLocation());
                v.setManufacturer("Company X");
               
//                String v.date = String.format("yyyy-MM-dd", today);
                
//                v.setDate(d_format.format(LocalDate.parse(t)));
//                v.setLotnum("00000000");
                v.setVtype("REG");

                request.getSession().setAttribute("vac", v);
                URL = webloc + "/VacView.jsp";
            } else if (action.equalsIgnoreCase("SearchVaccinations")) {

            } else if (action.equalsIgnoreCase("Cancel")) {
                URL = webloc + "Vaccination.jsp";

            } else if (action.equalsIgnoreCase("Logout")) {
                // Get Patient using SSN
                URL = webloc + "/index1.jsp";
                //
                request.getSession().removeAttribute("u");

            }
        } catch (ClassNotFoundException e) {
            msg = "Error: Class Not Found <br>";
            URL = webloc + "/VaccinationDB.jsp";
        } catch (SQLException ex) {
            msg += "Error: " + ex + "<br>";
            URL = webloc + "/VaccinationDB.jsp";
        } catch (Exception e) {
            //msg += "Servlet Error: " + e.getMessage() + "<br>";
            msg += "Error: " + e.getMessage() + "<br>TackTrace: ";
            for (StackTraceElement stackTrace : e.getStackTrace()) {
                msg += stackTrace + "<br>";
            }
            URL = webloc + "/VaccinationDB.jsp";
        }
//        if (webloc.equals("")) {
//            URL = "DoctorLogin/VaccinationDB.jsp";
//        }
        request.setAttribute("msg", msg);
//response.setHeader(lname, vsite);
//request.getHeader(lname)
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);

    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
