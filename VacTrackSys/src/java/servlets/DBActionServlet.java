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

@WebServlet(name = "DBActionServlet", urlPatterns = {"/CDC/DBAction", "/DoctorLogin/DBAction"})
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
        String msg = "", sql = "", sql_vac = "";
        String action = "", webloc = "",ssn="", fname = "", lname = "", mname = "", ptype = "";
        String[] vacs = {"", "", "", ""};
        
        ArrayList<Patient> pa;
        try {
            String m = (String) request.getAttribute("msg");
            if (!m.equals("")){
                
            }
            String x = String.valueOf(request.getRequestURL());
            if (x.contains("DoctorLogin")) {
                webloc = "DoctorLogin";

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
                sql = "UPDATE PATIENTS SET "
                        + "RecipientID = ?, "
                        + "SocSecNum = ?, "
                        + "FirstName = ?, "
                        + "MiddleName = ?, "
                        + "LastName = ?, "
                        + "DateOfBirth = ?, "
                        + "Vaccine1 = ?, "
                        + "Vaccine2 = ?, "
                        + "Vaccine3 = ?, "
                        + "Vaccine4 = ? ";

            } else if (action.equalsIgnoreCase("create")) {
                //TODO: Add Vaccine Objects for patient object
                vacs[0] = String.valueOf(request.getParameter("v1id"));
                vacs[1] = String.valueOf(request.getParameter("v2id"));
                vacs[2] = String.valueOf(request.getParameter("v3id"));
                vacs[3] = String.valueOf(request.getParameter("v4id"));
                Vaccine vac = new Vaccine();

                sql = "INSERT INTO PATIENTS(Social_Security, First_Name,Middle_Init, "
                        + "Last_Name, P_Type, Vaccine_ID, Vaccine_1, Vaccine_2, Vaccine_3, Vaccine_4,)"
                        + " VALUES (?,?,?,?,?,?,?,?,?,?);";
                Patient p = new Patient();
                PreparedStatement ps = conn.prepareStatement(sql);
                p.setFname(String.valueOf(request.getParameter("fname")));
                p.setLname(String.valueOf(request.getParameter("lname")));
//                p.setMname(request.getParameter("init"));
                p.setRid(Integer.parseInt(request.getParameter("")));
//                p.setDob(request.getParameter("dob"));

//                p.setVac1();
            } else if (action.equalsIgnoreCase("searchPatient")) {
                //Vaccine objects
                //Patient Objects
                vacs[0] = String.valueOf(request.getParameter("v1id"));
                vacs[1] = String.valueOf(request.getParameter("v2id"));
                vacs[2] = String.valueOf(request.getParameter("v3id"));
                vacs[3] = String.valueOf(request.getParameter("v4id"));
//                ptype = String.valueOf(request.getParameter("pat_type"));
                fname = request.getParameter("fname");
                lname = request.getParameter("lname");
                mname = request.getParameter("mname");
                ssn= request.getParameter("ssn");
                for (String vac : vacs) {
                    if (vac.isEmpty() || vac.equals("")) {
                        // set to N/A
                        vac = "N/A";
                    }                    
                }
                sql = "SELECT p.Social_Security, p.First_Name,p.Middle_Init, p.Last_Name, "
                        + "p.Vaccine_ID, v.Manufacturer"
                        + " FROM PATIENTS p INNER JOIN VACCINES v ON (PAT.Vaccine_ID = VACCINES.Vaccine_ID)"
                        + "WHERE p.Social_Security = ? ";
//                if (!fname.equals("")&& !fname.isEmpty()){
//                    sql+="OR p.FirstName = ?";
//                }if (!lname.equals("")&& !lname.isEmpty()){
//                    
//                }if (!mname.equals("")&& !mname.isEmpty()){
//                    
//                }
                if (!vacs[0].equals("N/A")) {
                    sql += "OR p.Vaccine_1 = ? ";
                }
                if (!vacs[1].equals("N/A")) {
                    sql += "OR p.Vaccine_2 = ? ";
                }
                if (!vacs[2].equals("N/A")) {
                    sql += "OR p.Vaccine_3 = ? ";
                }
                if (!vacs[3].equals("N/A")) {
                    sql += "OR p.Vaccine_4 = ? ";
                }
                sql += "ORDER BY p.Social_Security;";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, ssn);
                if (!vacs[0].equals("N/A")) {
                    ps.setString(2, vacs[0]);
                }
                if (!vacs[1].equals("N/A")) {
                    ps.setString(3, vacs[1]);
                }
                if (!vacs[2].equals("N/A")) {
                    ps.setString(4, vacs[2]);
                }
                if (!vacs[3].equals("N/A")) {
                    ps.setString(5, vacs[3]);
                }

//                ps.setString(2, request.getParameter("batnum"));
                //
                ResultSet rs = ps.executeQuery();
                pa = new ArrayList<>();
                while (rs.next()) {
                    //add to patient objects
                    Patient p = new Patient();
                    p.setSsn(rs.getString("Soial_Security"));
                    p.setFname(rs.getString("First_Name"));
                    p.setLname(rs.getString("Last_Name"));
                    p.setMname(rs.getString("Middle_Init"));
//                    p.setRid(rs.getInt("RID"));
                    Vaccine vac1 = new Vaccine();
                    vac1.setVid(rs.getString("Vaccine_1"));
                    
                    Vaccine vac2 = new Vaccine();
                    vac2.setVid(rs.getString("Vaccine_2"));
                    Vaccine vac3 = new Vaccine();
                    vac3.setVid(rs.getString("Vaccine_3"));
                    p.setVac3(vac3);
                    Vaccine vac4 = new Vaccine();
                    vac4.setVid(rs.getString("Vaccine_4"));
                    p.setVac4(vac4);
//                    p.setVac1(new Vaccine(rs.getString("Vaccine_ID"),
//                            String.valueOf(rs.getDate("Vaccine_Date")),
//                            rs.getString("Manufacturer"),
//                            String.valueOf(rs.getInt("BATCH_NUM"),
//                                    rs.getString("Vaccine_Location"),
//                                    rs.getString("Location_Type"),
//                                    
//                            "N/A"));
//                    vac1.setLocation(rs.getString("Vaccine_Site"));
                    pa.add(p);
                }
                request.setAttribute("pats", pa);
                rs.close();
                ps.close();
                request.getSession().setAttribute("patientset", pa);
                User u = (User) request.getSession().getAttribute("u");
                u.setSearched(true);
                request.getSession().setAttribute("u", u);
                URL = webloc + "/PatientRecords.jsp";
            } 

        } catch (ClassNotFoundException e) {
            msg = "Error: Class Not Found <br>";
        } catch (SQLException ex) {
            msg += "Error: " + ex + "<br>";
        } catch (Exception e){
            msg += "Servlet Error: " + e.getMessage()+"<br>";
                    
        }
        if (webloc.equals("")){
            URL = "/DoctorLogin/VaccinationDB.jsp";
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
