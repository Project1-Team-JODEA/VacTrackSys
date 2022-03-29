/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package servlets;

import business.User;
import business.Vaccine;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Alexander Breitenbach, ELena Miller
 */
public class EditVaccineServlet extends HttpServlet {

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
        String msg = "", action = "", url = "", webloc = "", sql = "", f_vacdate = "";
        String[] info = {};
        User u;
        Vaccine v = new Vaccine();
        try {
            String x = String.valueOf(request.getRequestURL());// URL Access Level
            if (x.contains("DoctorLogin")) {
                webloc = "/DoctorLogin";
            } else if (x.contains("AdminConsole")) {
                webloc = "/AdminConsole";
            }
            // Validate 
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            v.setVid(request.getParameter("vid").trim());
            v.setManufacturer(request.getParameter("man").trim());
            v.setVtype(request.getParameter("vac_type").trim());
            v.setDate(request.getParameter("vac_date").trim());
            v.setLocation(request.getParameter("loc").trim());
            v.setLotnum(request.getParameter("batnum").trim());
            action = request.getParameter("actiontype");
            u = (User) request.getSession().getAttribute("u");
            if (action.isEmpty() || action.equals("")) {
//                msg += "Unable to perform action <br>";
                throw new Exception("Unable to perform action.");
            } else {
                if (v.getVid().isEmpty() || v.getVid().equals("")) {
                    msg += "Missing Vaccine ID<br>";
                }else if (v.getVid().length() > 8){
                    msg+="Vaccination ID is 8 characters maximum. <br>";
                }
                if (v.getVtype().isEmpty() || v.getVtype().equals("")) {
                    msg += "Missing Vaccination type.<br>";
                }
                if (v.getLocation().isEmpty() || v.getLocation().equals("")) {
                    msg += "Missing Location Name<br>";
                }
                if (v.getDate().isEmpty() || v.getDate().equals("")) {
                    msg += "Missing Date<br>";
                } else {
                    DateTimeFormatter dob_format = DateTimeFormatter.ofPattern("dd-MMM-yy");
//                    f_vacdate = dob_format.format(LocalDate.parse(v.getDate()));
//                    v.setDate(String.valueOf(f_vacdate));
                }
                if (v.getLotnum().isEmpty() || v.getLotnum().equals("")) {
//                msg+="Missing Location Name<br>";
                }else if (v.getLotnum().length() > 8){
                  msg+="Batch Number is 8 characters maximum. <br>";   
                }
                if (v.getManufacturer().isEmpty() || v.getManufacturer().equals("")) {
                    msg += "Missing Manufacturer Name<br>";
                }

//            long d = Date.parse(v.getDate());
            }
            // Check for Date validation
            Date today = new Date();
            DateFormat df = DateFormat.getDateInstance();
//            Date vac_date = v.getDate();
            String vdate = "2021-11-30";
            // checks if date is before vdat of after today's date
//            Date v_date = df.parse(v.getDate());
//            
//            if (df.parse(v.getDate()).before(df.parse("2021-11-30"))
//                    || df.parse(v.getDate()).after(today)) {
//                msg += "Invalid Date <br>";
//            }
            // check if item exists
            PreparedStatement ps;
            ResultSet r;
            request.getSession().setAttribute("vac", v);
            if (action.equalsIgnoreCase("update")) {
//                PreparedStatement ps;
                if (msg.isEmpty() || msg.equals("")) {
                    sql = "SELECT * " //Vaccine_ID, Vaccine_Type, Vaccine_Location, Vaccine_Date, Manufacturer,  
                            + "FROM VACCINES WHERE Vaccine_ID = '" + v.getVid() + "';";
                    Statement s = conn.createStatement();
                    ps = conn.prepareStatement(sql);
                    r = s.executeQuery(sql);
                    if (!r.next()) {
                        msg = "Vaccine Does not exist <br>";
                    } else {
//                    Vaccine v2 = new Vaccine();
//                    v2.setLocation(r.getString(ur));

                        sql = "UPDATE VACCINES "
                                + "SET Vaccine_ID = ?, "
                                + "Vaccine_Type = ?, "
                                + "Vaccine_Location = ?, "
                                + "Vaccine_Date = ?, "
                                + "Manufacturer = ? "
                                + "WHERE Vaccine_ID = ?";
                        ps = conn.prepareStatement(sql);

                        ps.setString(1, v.getVid());
                        ps.setString(2, v.getVtype());
                        ps.setString(3, u.getLocation());
                        ps.setDate(4, java.sql.Date.valueOf(request.getParameter("vac_date")));
                        ps.setString(5, v.getManufacturer());
                        ps.setString(6, v.getVid());
                        int rc = ps.executeUpdate();
                        if (rc == 0) {
                            msg = "Error in Updating record <br>";
                            url = webloc + "VacView.jsp";
                        } else {
                            if (!v.getLotnum().equals("") || v.getLotnum().isEmpty()) {
                                //add vaccine batch to database
                                sql = "SELECT * FROM VAC_BATCHES WHERE BATCH_NUM=?";
                                ps = conn.prepareStatement(sql);
                                r = ps.executeQuery();
                                if (r.next()) {
                                    msg += "Batch already Exists <br>";
                                } else {
                                    String sql_batch = "INSERT INTO VAC_BATCHES(BATCH_NUM, Vaccine_ID)"
                                            + "VALUES (?,?);";
                                    ps = conn.prepareStatement(sql_batch);
                                    ps.setInt(1, Integer.parseInt(v.getLotnum()));
                                    ps.setString(2, v.getVid());
                                    rc = ps.executeUpdate();
                                    if (rc == 0) {
                                        msg += "Cannot add batch <br>";
                                        url = webloc + "/VacView.jsp";
                                    } else {
                                        msg += "Batch Successfully added <br>";
                                        url = webloc + "/VaccinationDB.jsp";
                                    }
                                }
                            }else{
                                msg+="Vaccine Added <br>";
                                 url = webloc + "/VaccinationDB.jsp";
                            }
                        }
                    }
                } else {
                    url = webloc + "/VacView.jsp";
                }
            } else if (action.equalsIgnoreCase("add")) {

                if (msg.isEmpty() || msg.equals("")) {
                    // check if item exists
                    sql = "SELECT * "
                            + "FROM VACCINES WHERE Vaccine_ID = ?;";
                    ps = conn.prepareStatement(sql);
                    ps.setString(1, v.getVid());
                    r = ps.executeQuery();

                    if (r.next()) {// if item exists return message
                        msg += "Vaccine item already exists";
                        url = webloc + "/VaccinationDB.jsp";
                    } else {//add vaccine to db

                        sql = "INSERT INTO VACCINES(Vaccine_ID,Vaccine_Type,"
                                + "Vaccine_Location, Vaccine_date, Manufacturer) "
                                + "VALUES (?,?,?,?,?);";
                        ps = conn.prepareStatement(sql);
                        // add 
                        ps.setString(1, v.getVid());
                        ps.setString(2, v.getVtype());
                        ps.setString(3, v.getLocation());
                        
                        ps.setDate(4,  java.sql.Date.valueOf(v.getDate()));
                        ps.setString(5, v.getManufacturer());
                        int rc = ps.executeUpdate();
                        if (rc == 0) {
                            msg = "Unable to update Record <br>";
                            url = webloc + "/VacView.jsp";
                        } else {
                            // if batch number field is not blank, then add batch
                            if (!v.getLotnum().equals("") || !v.getLotnum().isEmpty()) {
                                //add vaccine batch to database
                                sql = "SELECT * FROM VAC_BATCHES WHERE BATCH_NUM=?";
                                ps = conn.prepareStatement(sql);
                                r = ps.executeQuery();
                                if (r.next()) {
                                    msg += "Batch already Exists <br>";
                                } else {
                                    String sql_batch = "INSERT INTO VAC_BATCHES(BATCH_NUM, Vaccine_ID)"
                                            + "VALUES (?,?);";
                                    ps = conn.prepareStatement(sql_batch);
                                    ps.setInt(1, Integer.parseInt(v.getLotnum()));
                                    ps.setString(2, v.getVid());
                                    rc = ps.executeUpdate();
                                    if (rc == 0) {
                                        msg += "Cannot add batch <br>";
                                    } else {
                                        msg += "Batch Successfully added <br>";
                                        url = webloc + "/VaccinationDB.jsp";
                                    }
                                }
                            } else{
                                msg+="Vaccine Added <br>";
                                 url = webloc + "/VaccinationDB.jsp";
                            }
                        }
                    }
                } else {
                    url = webloc + "/VacView.jsp";
                }
            }else if (action.equalsIgnoreCase("cancel")){
                url = webloc + "/VaccinationDB.jsp";
            } else {
                msg += "Unknown action. <br>";
                url = webloc + "/VacView.jsp";
            }

        } catch (SQLException e) {
            msg += "SQL Error: " + e.getMessage() + " <br> StackTrace: ";
            for (StackTraceElement stackTrace : e.getStackTrace()) {
                msg += stackTrace + "<br>";
            }
            url = webloc + "/VacView.jsp";
        } catch (ClassNotFoundException e) {
            msg += "Class Error: " + e.getMessage() + " <br> StackTrace: ";
            for (StackTraceElement stackTrace : e.getStackTrace()) {
                msg += stackTrace + "<br>";
            }
            url = webloc + "/VacView.jsp";
        } catch (ParseException e) {
            msg += "Parse Error: " + e.getMessage() + " <br> StackTrace: ";
            for (StackTraceElement stackTrace : e.getStackTrace()) {
                msg += stackTrace + "<br>";
            }
            url = webloc + "/VacView.jsp";
        } catch (Exception e) {
            msg += "Servlet Error: " + e.getMessage() + " <br> StackTrace: ";
            for (StackTraceElement stackTrace : e.getStackTrace()) {
                msg += stackTrace + "<br>";
            }
            url = webloc + "/VacView.jsp";
//            Logger.getLogger(EditVaccineServlet.class.getName()).log(Level.SEVERE, null, ex);
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
