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
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "DBActionServlet", urlPatterns = {"/DBAction"})
public class DBActionServlet extends HttpServlet {

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
        String msg = "", sql = "";
        String action = "", webloc = "";
        String[] vacs = {"", "", "", ""};
        ArrayList<Patient> pa;
        try {
            String x = String.valueOf(request.getRequestURL());
            if (x.contains("DoctorLogin")) {
                webloc = "/DoctorLogin";

            } else if (x.contains("PatientLogin")) {
                webloc = "/PatientLogin";

            } else if (x.contains("AdminConsole")) {
                webloc = "/AdminConsole";

            }
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
//            String ur = context.getRealPath("/WEB-INF/MoVaxDB.accb");
            String ur = context.getRealPath("/Team_JODEA1.accdb");

            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            action = request.getParameter("actiontype");// for DB Action
            if (action.equals("")) {
                msg += "Error: Undable to Perform Action <br>";
                URL = webloc + "/VaccinationDB.jsp";
            } else if (action.equalsIgnoreCase("")) {
                msg += "Error: Undable to Perform Action <br>";
                URL = webloc + "/VaccinationDB.jsp";
            } else if (action.equalsIgnoreCase("edit")) {
                // code editing script
                sql = "UPDATE";

            } else if (action.equalsIgnoreCase("create")) {
                //TODO: Add Vaccine Objects for patient object
                Vaccine vac = new Vaccine();
                sql = "INSERT INTO PATIENTS(Social_Security, First_Name,Middle_Init, "
                        + "Last_Name, P_Type, Vaccine_ID,  "
                        + " Last_Name, Vaccine_ID, P) VALUES (?,?,?,?)";
                Patient p = new Patient();
                p.setFname(String.valueOf(request.getParameter("fname")));
                p.setLname(String.valueOf(request.getParameter("lname")));
//                p.setMname(request.getParameter("init"));
                p.setRid(Integer.parseInt(request.getParameter("")));
                p.setDob(request.getParameter("dob"));

//                p.setVac1();
            } else if (action.equalsIgnoreCase("view")) {
                //Vaccine objects
                //Patient Objects
                vacs[0] = String.valueOf(request.getParameter("vac1"));
                vacs[1] = String.valueOf(request.getParameter("vac2"));
                vacs[2] = String.valueOf(request.getParameter("vac3"));
                vacs[3] = String.valueOf(request.getParameter("vac4"));
                
                sql = "SELECT p.First_Name,p.Middle_Init, p.Last_Name, "
                        + "p.Vaccine_ID, v.Manufacturer"
                        + " FROM PATIENTS p INNER JOIN VACCINES v ON (PAT.Vaccine_ID = VACCINES.Vaccine_ID)"
                        + "WHERE v.Vaccine_ID = ?"
                        + "OR p.Vaccine_1 = ? "
                        + "OR p.Vaccine_2= ?"
                        + "OR p.Vaccine_3 = ?"
                        + "OR p.Vaccine_4 = ?"
                        + "ORDER BY p.Social_Security;";

                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, String.valueOf(request.getParameter("vac1")));
                ps.setString(2, ur);
                ps.setString(3, ur);
                ps.setString(4, ur);
                ps.setString(5, ur);
//                ps.setString(2, request.getParameter("batnum"));
                //
                ResultSet rs = ps.executeQuery();
                pa = new ArrayList<>();
                while (rs.next()) {
                    //add to patient objects
                    Patient p = new Patient();
                    p.setSsn(rs.getString("SSN"));
                    p.setFname(rs.getString("First_Name"));
                    p.setLname(rs.getString("Last_Name"));
                    p.setMname(rs.getString("Middle_Init"));
//                    p.setRid(rs.getInt("RID"));
                    Vaccine vac1 = new Vaccine();
                    vac1.setVid(rs.getString("Vaccine_ID"));
                    p.setVac1(new Vaccine(rs.getString("Vaccine_ID"),
                            String.valueOf(rs.getDate("Vaccine_Date")),
                            rs.getString("Manufacturer"),
                            String.valueOf(rs.getInt("BATCH_NUM"),
                                    rs.getString("Vaccine_Location"),
                                    rs.getString("Location_Type"),
                                    
                            ));
//                    vac1.setLocation(rs.getString("Vaccine_Site"));
                    vac1.setLocatype("N/A");
                    vac1.setLocation("West Hospital");
                    vac1.setLotnum("");
                }
                request.setAttribute("pats", pa);
            }

        } catch (ClassNotFoundException e) {
            msg = "Error: Class Not Found <br>";
        } catch (SQLException ex) {
            msg += "Error: " + ex + "<br>";
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
