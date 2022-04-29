/**
 *
 * @author Elena Miller
 *
 */
package servlets;

import business.Location;
import business.User;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class CreateReportServlet extends HttpServlet {

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
        String msg = "", URL = "",
                webloc = "", sql = "",
                f_vacdate = "", dose = "", loc = "";
        int dose1 = 0, dose2 = 0, dose3 = 0, dose4 = 0, pf = 0, jj = 0, ma = 0;
        int[] doses = {dose1 = 0, dose2 = 0, dose3 = 0, dose4 = 0};

        String x = String.valueOf(request.getRequestURL());// URL Access Level

        User u = (User) request.getSession().getAttribute("u");
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
//            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);

            loc = request.getParameter("location");
            String action = request.getParameter("actiontype");

//            User u = (User) request.getSession().getAttribute("u");
            if (action.equals("CreateReport")) {
                if (loc.isEmpty() || loc.equals("")) {
                    msg += "Missing Location";
                }

                if (msg.isEmpty() || msg.equals("")) {
//                sql = "SELECT VACCINATIONS.PAT_ID, VACCINES"
//                        + " FROM VACCINATIONS INNER JOIN VACCINES ON VACCINATIONS.Vaccine_ID = VACCINES.Vaccine_ID"
//                        + " WHERE SITE_ID = ? AND "
//                        + "Dose_No = ?;";
                    sql = "SELECT SITE_NAME FROM VAC_SITES WHERE SITE_ID = ?;";
                    PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setInt(1, Integer.parseInt(loc));
                    ResultSet r = ps.executeQuery();

                    //int dose1 =0,dose2 =0,dose3 =0,dose4 =0;
                    String a = context.getRealPath("/WEB-INF/");
                    PrintWriter out = new PrintWriter(new FileWriter(a + "CDC REPORT-" + u.getUsername() + ".txt", false));
                    out.println("-----------------VACCINATION REPORT-----------------");
                    Date today = new Date();
                    Calendar cal = Calendar.getInstance();
                    DateFormat df = DateFormat.getInstance();
                    out.println("Date: " + today);//date

                    if (r.next()) {
                        out.println("Location: " + r.getString("SITE_NAME"));
                        //out.print("Total vaccinated patients: " + String.valueOf(r.getInt("TotalPatients")));
//                        sql = "SELECT";
                        sql = "SELECT COUNT(PAT_ID) AS TotalPatients "
                                + "FROM VACCINATIONS AS vn, VACCINES AS v, VAC_SITES AS vst "
                                + "WHERE vn.SITE_ID=? AND vn.Vaccine_ID=v.Vaccine_ID AND vn.SITE_ID=vst.SITE_ID;";
                        ps = conn.prepareStatement(sql);
                        ps.setInt(1, Integer.parseInt(loc));
                        r = ps.executeQuery();
                        if (r.next()) {
                            out.println("Total People vaccinated: " + r.getInt("TotalPatients"));

                        }
                        
                        sql = "SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                                + "WHERE vn.SITE_ID=? AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =4; ";
                       
                    } else {
                        out.print("Total vaccinated Patients: 0");

                    }
//                    sql = "SELECT COUNT(PAT_ID) AS TotalPatients"
//                            + "FROM VACCINATIONS AS vn, VACCINES AS v, VAC_SITES AS vst"
//                            + "WHERE vn.SITE_ID=? AND vn.Vaccine_ID=v.Vaccine_ID AND vn.SITE_ID=vst.SITE_ID;";
//                    if (r.next()) {
//
//                    }
                    out.flush();
                    out.close();
                    r.close();
                    ps.close();

                } else {
                    msg += "Processing Error: Unable to perform unknown action. <br>";
                }
                URL = webloc + "/Results.jsp";
            } else if (action.equals("NewReport")) {
                sql = "SELECT * FROM VAC_SITES";
                ArrayList<Location> l = new ArrayList<>();
                Statement s = conn.createStatement();
                ResultSet r = s.executeQuery(sql);
                while (r.next()) {
                    Location lo = new Location();
                    lo.setId(r.getInt("SITE_ID"));
                    lo.setName(r.getString("SITE_NAME"));
                    lo.setLtype(r.getString("SITE_TYPE"));
                    lo.setStreet1(r.getString("STREET"));
                    lo.setCity(r.getString("CITY"));
                    lo.setZip(r.getInt("ZIP"));
                    l.add(lo);
                }
                request.getSession().setAttribute("loc", l);
                URL = "/VacTrackSys/CDC/VaccinationDB.jsp";
            } else if (action.equals("download")) {
//              Cookie c = new Cookie("download", "downloadFIle");
                URL = "/download.jsp";

            } else if (action.equals("Logout")) {
                URL = webloc + "/index1.jsp";
            }

        } catch (ClassNotFoundException e) {
            msg += "Connection Error: Class Not Found <br>";
            URL = webloc + "/VaccinationDB.jsp";
        } catch (SQLException ex) {
            msg += "Database Error: " + ex + "<br>";
            URL = webloc + "/VaccinationDB.jsp";
        } catch (Exception e) {
            //msg += "Servlet Error: " + e.getMessage() + "<br>";
            msg += "Processing Error: " + e.getMessage() + "<br>TackTrace: ";
            for (StackTraceElement stackTrace : e.getStackTrace()) {
                msg += stackTrace + "<br>";
            }
            URL = webloc + "/VaccinationDB.jsp";
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
