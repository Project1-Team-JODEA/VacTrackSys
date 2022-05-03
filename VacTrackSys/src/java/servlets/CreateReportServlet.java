/**
 *
 * @author Elena Miller
 *
 */
package servlets;

import business.Location;
import business.User;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.OutputStream;
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
                    loc = "All";
                }

                if (msg.isEmpty() || msg.equals("")) {
//                sql = "SELECT VACCINATIONS.PAT_ID, VACCINES"
//                        + " FROM VACCINATIONS INNER JOIN VACCINES ON VACCINATIONS.Vaccine_ID = VACCINES.Vaccine_ID"
//                        + " WHERE SITE_ID = ? AND "
//                        + "Dose_No = ?;";
                    Statement s = conn.createStatement();

                    ResultSet r;

                    String a = context.getRealPath("/WEB-INF/");
                    PrintWriter out = new PrintWriter(new FileWriter(a + "CDC_REPORT-" + u.getUsername() + ".txt", false));

                    out.println("-----------------VACCINATION REPORT-----------------");
                    Date today = new Date();
                    Calendar cal = Calendar.getInstance();
                    DateFormat df = DateFormat.getInstance();
                    out.println("Date: " + today);//date
                    String[] sqls = {"SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                        + "WHERE vn.SITE_ID=" + loc + " AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =1; ",
                        "SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                        + "WHERE vn.SITE_ID=" + loc + " AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =2;",
                        "SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                        + "WHERE vn.SITE_ID=" + loc + " AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =3;",
                        "SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                        + "WHERE vn.SITE_ID=" + loc + " AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =4;",
                        "SELECT  COUNT(PAT_ID) AS Total "
                        + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                        + "WHERE vn.SITE_ID=" + loc + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                        + "AND Manufacturer='Pfizer';",
                        "SELECT  COUNT(PAT_ID) AS Total "
                        + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                        + "WHERE vn.SITE_ID=" + loc + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                        + "AND Manufacturer='Mederma';",
                        "SELECT  COUNT(PAT_ID) AS Total "
                        + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                        + "WHERE vn.SITE_ID=" + loc + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                        + "AND Manufacturer='Mederma' AND vn.Dose_No=1;",
                        "SELECT  COUNT(PAT_ID) AS Total "
                        + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                        + "WHERE vn.SITE_ID=" + loc + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                        + "AND Manufacturer='Mederma' AND vn.Dose_No=2;",
                        "SELECT  COUNT(PAT_ID) AS Total "
                        + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                        + "WHERE vn.SITE_ID=" + loc + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                        + "AND Manufacturer='Johnson & Johnson';",
                        "SELECT  COUNT(PAT_ID) AS Total "
                        + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                        + "WHERE vn.SITE_ID=" + loc + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                        + "AND Manufacturer='Pfizer' AND vc.Vaccine_Type='REG';",
                        "SELECT  COUNT(PAT_ID) AS Total "
                        + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                        + "WHERE vn.SITE_ID=" + loc + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                        + "AND Manufacturer='Pfizer' AND vc.Vaccine_Type='BOS';"};
                    out.println("----------OVERVIEW----------");
                    if (loc.equals("All")) {//print report of all locations 

                        sql = "SELECT vn.SITE_ID, SITE_NAME,SITE_TYPE, COUNT(PAT_ID) AS Total "
                                + "FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                                + "WHERE vn.SITE_ID=vst.SITE_ID "
                                + "GROUP BY SITE_NAME, vn.SITE_ID, SITE_TYPE; ";

                        out.println("LOCATION: \tTOTAL: ");
                        r = s.executeQuery(sql);
                        ArrayList<Location> locs = new ArrayList<>();
                        ArrayList<String> locname = new ArrayList<>();
                        while (r.next()) {
                            Location location = new Location();
                            location.setId(r.getInt("SITE_ID"));
                            location.setName(r.getString("SITE_NAME"));
                            location.setLtype(r.getString("SITE_TYPE"));
                            out.println(location.getName() + " :\t" + r.getInt("Total"));
                            locs.add(location);

                        }
                        out.println("--------------------DETAILS--------------------");
                        if (locs.size() > 0) {
                            for (int i = 0; i < locs.size(); i++) {
                                Location location = locs.get(i);
                                String[] sqs = {"SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                                    + "WHERE vn.SITE_ID=" + location.getId() + " AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =1; ",
                                    "SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                                    + "WHERE vn.SITE_ID=" + location.getId() + " AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =2;",
                                    "SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                                    + "WHERE vn.SITE_ID=" + location.getId() + " AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =3;",
                                    "SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                                    + "WHERE vn.SITE_ID=" + location.getId() + " AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =4;",
                                    "SELECT  COUNT(PAT_ID) AS Total "
                                    + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                                    + "WHERE vn.SITE_ID=" + location.getId() + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                                    + "AND Manufacturer='Pfizer';",
                                    "SELECT  COUNT(PAT_ID) AS Total "
                                    + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                                    + "WHERE vn.SITE_ID=" + location.getId() + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                                    + "AND Manufacturer='Mederma';",
                                    "SELECT  COUNT(PAT_ID) AS Total "
                                    + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                                    + "WHERE vn.SITE_ID=" + location.getId() + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                                    + "AND Manufacturer='Mederma' AND vn.Dose_No=1;",
                                    "SELECT  COUNT(PAT_ID) AS Total "
                                    + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                                    + "WHERE vn.SITE_ID=" + location.getId() + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                                    + "AND Manufacturer='Mederma' AND vn.Dose_No=2;",
                                    "SELECT  COUNT(PAT_ID) AS Total "
                                    + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                                    + "WHERE vn.SITE_ID=" + location.getId() + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                                    + "AND Manufacturer='Johnson & Johnson';",
                                 "SELECT  COUNT(PAT_ID) AS Total "
                        + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                        + "WHERE vn.SITE_ID=" + location.getId() + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                        + "AND Manufacturer='Pfizer' AND vc.Vaccine_Type='REG';",
                        "SELECT  COUNT(PAT_ID) AS Total "
                        + "FROM VACCINATIONS AS vn, VAC_SITES AS vst, VACCINES AS vc "
                        + "WHERE vn.SITE_ID=" + location.getId() + " AND (vn.SITE_ID=vst.SITE_ID AND vn.Vaccine_ID=vc.Vaccine_ID) "
                        + "AND Manufacturer='Pfizer' AND vc.Vaccine_Type='BOS';"};

                                sql = "SELECT * FROM VAC_SITES WHERE SITE_ID=" + String.valueOf(location.getId());
//                                r = s.executeQuery(sql);

                                out.println("LOCATION: \t" + location.getName() + "LOCATION TYPE: \t" + location.getLtype());
                                out.println("Doses:");
                                r = s.executeQuery(sqs[0]);
                                if (r.next()) {
                                    out.println("\t- 1/4 vaccines: " + r.getInt("Total"));
                                }
                                r = s.executeQuery(sqs[1]);
                                if (r.next()) {
                                    out.println("\t- 2/4 vaccines: " + r.getInt("Total"));
                                }
                                r = s.executeQuery(sqs[2]);
                                if (r.next()) {
                                    out.println("\t- 3/4 vaccines: " + r.getInt("Total"));
                                }
                                r = s.executeQuery(sqs[3]);
                                if (r.next()) {
                                    out.println("\t- 4/4 vaccines: " + r.getInt("Total"));
                                }
                                out.println("----------------Manufacturer----------------");
                                r = s.executeQuery(sqs[4]);
                                if (r.next()) {
                                    out.println("\t -Pfizer: " + r.getInt("Total"));
                                }

                                r = s.executeQuery(sqs[5]);
                                if (r.next()) {
                                    out.println("\t -Mederma: " + r.getInt("Total"));
                                }
                                r = s.executeQuery(sqs[6]);
                                if (r.next()) {
                                    out.println("\t\t -Dose 1: " + r.getInt("Total"));
                                }
                                r = s.executeQuery(sqs[7]);
                                if (r.next()) {
                                    out.println("\t\t -Dose2: " + r.getInt("Total"));
                                }

                                r = s.executeQuery(sqs[8]);
                                if (r.next()) {
                                    out.println("\t -Johnson & Johnson: " + r.getInt("Total"));
                                }
                                 out.println("----------------Vaccine Type----------------");
                            r = s.executeQuery(sqls[9]);
                            if (r.next()) {
                                out.println("\t Regular: " + r.getInt("Total"));
                            }
                            r = s.executeQuery(sqls[10]);
                            if (r.next()) {
                                out.println("\t Booster: " + r.getInt("Total"));
                            }
                            }
                        }

                    } else {
                        sql = "SELECT SITE_NAME FROM VAC_SITES WHERE SITE_ID = ?;";
                        PreparedStatement ps = conn.prepareStatement(sql);
                        ps.setInt(1, Integer.parseInt(loc));
                        r = ps.executeQuery();
                        if (r.next()) {
                            out.println("Location: " + r.getString("SITE_NAME"));
                            //out.print("Total vaccinated patients: " + String.valueOf(r.getInt("TotalPatients")));
//                        sql = "SELECT";
                            out.println("----------OVERVIEW----------");

                            sql = "SELECT COUNT(PAT_ID) AS TotalPatients "
                                    + "FROM VACCINATIONS AS vn, VACCINES AS v, VAC_SITES AS vst "
                                    + "WHERE vn.SITE_ID=" + loc + " AND vn.Vaccine_ID=v.Vaccine_ID AND vn.SITE_ID=vst.SITE_ID;";
                            r = s.executeQuery(sql);
                            if (r.next()) {
                                out.println("Total People vaccinated: " + r.getInt("TotalPatients"));
                                out.println("--------DETAILS--------"
                                        + "\n Doses:");
                            }
                            //Array sqls if for details sql statements

                            r = s.executeQuery(sqls[0]);
                            if (r.next()) {
                                out.println("\t- 1/4 vaccines: " + r.getInt("Total"));
                            }
                            sql = "SELECT COUNT(PAT_ID) AS Total FROM VACCINATIONS AS vn, VAC_SITES AS vst "
                                    + "WHERE vn.SITE_ID=" + loc + " AND vn.SITE_ID=vst.SITE_ID AND vn.Dose_No =2; ";
                            r = s.executeQuery(sqls[1]);
                            if (r.next()) {
                                out.println("\t- 2/4 vaccines: " + r.getInt("Total"));
                            }
                            r = s.executeQuery(sqls[2]);
                            if (r.next()) {
                                out.println("\t- 3/4 vaccines: " + r.getInt("Total"));
                            }
                            r = s.executeQuery(sqls[3]);
                            if (r.next()) {
                                out.println("\t- 4/4 vaccines: " + r.getInt("Total"));
                            }
                            out.println("----------------Manufacturer----------------");
                            r = s.executeQuery(sqls[4]);
                            if (r.next()) {
                                out.println("\t- Pfizer: " + r.getInt("Total"));
                            }
                            r = s.executeQuery(sqls[5]);
                            if (r.next()) {
                                out.println("\t- Mederma: " + r.getInt("Total"));
                            }
                            r = s.executeQuery(sqls[6]);
                            if (r.next()) {
                                out.println("\t\t -Dose 1: " + r.getInt("Total"));
                            }
                            r = s.executeQuery(sqls[7]);
                            if (r.next()) {
                                out.println("\t\t -Dose2: " + r.getInt("Total"));
                            }
                            r = s.executeQuery(sqls[8]);
                            if (r.next()) {
                                out.println("\t -Johnson & Johnson: " + r.getInt("Total"));
                            }

                            out.println("----------------Vaccine Type----------------");
                            r = s.executeQuery(sqls[9]);
                            if (r.next()) {
                                out.println("\t Regular: " + r.getInt("Total"));
                            }
                            r = s.executeQuery(sqls[10]);
                            if (r.next()) {
                                out.println("\t Booster: " + r.getInt("Total"));
                            }
                        } else {
                            out.print("Total vaccinated Patients: 0");
                        }
                    }
                    sql = "SELECT COUNT(PAT_ID) AS TotalPatients"
                            + " FROM VACCINATIONS AS vn, VACCINES AS v, VAC_SITES AS vst"
                            + "WHERE vn.SITE_ID=" + loc + " AND vn.Vaccine_ID=v.Vaccine_ID AND vn.SITE_ID=vst.SITE_ID;";

                    out.flush();
                    out.close();
                    r.close();
                    s.close();

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
//        processRequest(request, response);
        ServletContext context = getServletContext();
        User u = (User) request.getSession().getAttribute("u");

        String a = context.getRealPath("/WEB-INF/CDC_REPORT-" + u.getUsername() + ".txt");
        String filename = "CDC_REPORT-" + u.getUsername() + ".txt";

        response.setContentType("application/txt");
        response.setHeader("Content-disposition", "attachment; filename=" + filename);
        File report = new File(a);
        if (report.exists()) {
            OutputStream out = response.getOutputStream();
            FileInputStream in = new FileInputStream(report);
            byte[] buffer = new byte[4096];
            int length;
            while ((length = in.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            in.close();
            out.flush();
        } else {

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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Creates Report From the input of the ";
    }// </editor-fold>

}
