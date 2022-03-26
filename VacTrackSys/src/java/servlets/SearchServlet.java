/**
 *
 * @author alexs
 */
package servlets;

import business.Patient;
import business.User;
import business.Vaccine;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "SearchServlet", urlPatterns = {"/Search", "/CDC/Search", "DoctorLogin/SearchServlet"})
public class SearchServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        String msg = "", sql = "", url = "", webloc = "";
        String ssn, fname, minit, lname, vac_date = "", dob = "", ptype, vsite, vid, v1id, v2id, v3id, v4id;
        String[] filters = new String[12];
        String[] info = {ssn = "", fname = "", minit = "", lname = "", dob = "", ptype = "", vid = "", vsite = "", v1id = "",
            v2id = "", v3id = "", v4id = ""};
        String[] fields = {"Social_Security", "First_Name", "Middle_Init", "Last_Name", "DOB", //"Vaccine_ID",
            "P_Type", "Vaccine_ID", "Vaccination_Site", "Vaccine_1", "Vaccine_2", "Vaccine_3", "Vaccine_4"};
        ArrayList<Patient> patientset = new ArrayList<>();
        ArrayList<String> newVal = new ArrayList<>();

//        String[] newVal = new String[0];
//        String[] vacs = {"", "", "", ""};
        String x = String.valueOf(request.getRequestURL());

        if (x.contains("DoctorLogin")) {
            webloc = "/DoctorLogin";

        } else if (x.contains("PatientLogin")) {
            webloc = "/PatientLogin";

        } else if (x.contains("AdminConsole")) {
            webloc = "/AdminConsole";

        } else if (x.contains("CDC")) {
            webloc = "/CDC";
        }
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            // at the moment, I am putting off the ability to search with criteria
            // logic for searches will go here
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
            int isE = 0, j = 0;
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
                        j++;//increment j
                    } else if (fields[i].equals("DOB")) {
                        //format date
                        DateTimeFormatter dob_format = DateTimeFormatter.ofPattern("dd-MMM-yy");
                        newV = fields[i] + "='" + String.valueOf(dob_format.format(LocalDate.parse(info[i]))) + "'";
                        filters[i] = newV;//String.valueOf(newV);
                        j++;//increment j

                    } else {
                        newV = fields[i] + "='" + info[i] + "'";
                        filters[i] = String.valueOf(newV);
                        j++;//increment j
                    }
                    newVal.add(filters[i]);
                }
            }// end of for-loop
            if (isE == info.length) {
                msg += "Please Enter a value in one of the fields. <br>";
            } else {
                //

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
                            System.out.println("value = " + val);
                            if (val.contains("\'")){
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
                request.getSession().setAttribute("pats", patientset);
                User u = (User) request.getSession().getAttribute("u");
                u.setSearched(true);
                request.getSession().setAttribute("u", u);
                url = webloc + "/PatientRecords.jsp";
            } else {
                url = webloc + "/VaccinationDB.jsp";
            }
        } catch (Exception e) {
            msg += "Error: " + e.getMessage() + "<br>TackTrace: ";
            // + "Trace: " + e.getStackTrace()+ "<br>"
            // + "Cause: " + e.getCause();
            for (StackTraceElement stackTrace : e.getStackTrace()) {
                msg +=stackTrace+"<br>";
            }
//            System.out.println(e.getCause());
            url = webloc + "/VaccinationDB.jsp";
        }
        request.setAttribute("msg", msg);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(url);
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(SearchServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Searches Patients From Database";
    }// </editor-fold>

}
