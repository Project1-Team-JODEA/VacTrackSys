/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.Patient;
import business.User;
import business.Vaccine;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexs
 */
public class addRecordServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String URL = "";
        String ssn, fname, minit, lname, ptype, vsite, v1id, v2id, v3id, v4id;
        String msg = "", sql = "";
        String dbURL = "jdbc:mysql://localhost:3306/MoVax";
        String dbUSER = "root";
        String dbPWD = "sesame";
        Boolean updatePatient = false;
        Boolean updateVaccine = false;
        Boolean updateUser = false;

        // below are "methods" that can be used to update specific tables in the database.  If used as a servlet,
        // pass update booleans via the session object
        String x = String.valueOf(request.getRequestURL());
        String webloc = "";
        if (x.contains("DoctorLogin")) {
            webloc = "/DoctorLogin";

        } else if (x.contains("AdminConsole")) {
            webloc = "/AdminConsole";

        }
        URL = webloc+"/View.jsp";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            String action = String.valueOf(request.getParameter("actiontype"));

            if (action.equals("")) {
                msg += "Unable to perform action <br>";
            } else if (action.equals("add")) {
                int doseNo=0;
                ssn = String.valueOf(request.getParameter("ssn"));
                String vid = String.valueOf(request.getParameter("vid"));
                String dose = String.valueOf(request.getParameter("doseno"));
                String pv = String.valueOf(request.getParameter("provider"));
                String loc = String.valueOf(request.getParameter("loc"));
                String ssn2 = "";
                Statement s = conn.createStatement();
                // search parameters in database
                if (ssn.equals("")) {
                    msg += "Missing Social Security Number <br>";
                } else {
                    String[] ssn1 = ssn.split("-");
                    ssn2 = ssn1[0] + ssn1[1] + ssn1[2];
                    sql = "SELECT Social_Security FROM PATIENTS WHERE Social_Security=" + ssn2 + ";";
                    ResultSet r = s.executeQuery(sql);
                    if (r.next()) {
                        r = s.executeQuery(sql);
                    } else {
                        msg += "Patient Not found in database <br>";
                    }
                    r.close();
                }
                if (vid.equals("")) {
                    msg += "Missing Vaccine ID <br>";
                } else {
                 
                }
                if (dose.equals("")) {
                    msg += "Missing Dose number <br>";
                }else {
                    if (dose.equals("1")){
                        doseNo =1;
                    }
                     if (dose.equals("2")){
                        doseNo =2;
                    }
                      if (dose.equals("3")){
                        doseNo = 3;
                    }
                       if (dose.equals("4")){
                        doseNo=4;
                    }
                }
                if (pv.equals("")) {
                    msg += "Missing provider id <br>";
                } else {
                    sql = "SELECT Provider_ID FROM PROVIDERS WHERE Provider_ID='" + pv + "';";
                    ResultSet r = s.executeQuery(sql);
                    if (r.next()) {
                       
                    } else {
                        msg += "Vaccine Item Not found in database <br>";
                    }
                    r.close();
                }
                s.close();
                if (msg.equals("") || msg.isEmpty()) {
                //add record to database
                    sql = "INSERT INTO VACCINATIONS (PAT_ID, Vaccine_ID, Dose_No, SITE_ID, Provider_ID)"
                            + "VALUES (?,?,?,?,?);";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(ssn2));
                    ps.setString(2, vid);
                    ps.setInt(3, doseNo);
                    ps.setInt(4, Integer.parseInt(loc));
                    ps.setString(5, pv);

                    int rc = ps.executeUpdate();
                    if (rc == 0) {

                    } else {
                        URL = webloc + "/VaccinationDB.jsp";
                        request.getSession().removeAttribute("loc");
                        msg += "Vaccination Record Added <br>";
                    }
                    ps.close();
                }else{//if message variable is not empty 
                     URL = webloc+"/View.jsp";
                }
            } else if (action.equals("cancel")) {
                URL = webloc + "/VaccinationDB.jsp";
            }
            conn.close();
        } catch (ClassNotFoundException e) {
            msg += "Connection Error: " + e.getMessage();
             URL = "/DoctorLogin/View.jsp";
        } catch (SQLException e) {
            msg += "Database Error: " + e.getMessage();
             URL = webloc+"/View.jsp";
        } catch (Exception e) {
            msg += "Processing Error: " + e.getMessage();
            URL = webloc+"/View.jsp";
        }
        request.setAttribute("msg", msg);
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
