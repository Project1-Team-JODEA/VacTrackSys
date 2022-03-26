/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package servlets;

import business.Patient;
import business.User;
import business.Vaccine;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.Date;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexs
 */
@WebServlet(name = "EditPatientServlet")
public class EditPatientServlet extends HttpServlet {

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
        String msg = "", url = "", webloc = "", action;
        response.setContentType("text/html;charset=UTF-8");
        try {
            String x = String.valueOf(request.getRequestURL());// URL Access Level
            if (x.contains("DoctorLogin")) {
                webloc = "/DoctorLogin";
            } else if (x.contains("AdminConsole")) {
                webloc = "/AdminConsole";
            }
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            action = request.getParameter("actiontype");
            
            Patient p = new Patient();
            String sql = "SELECT * FROM PATIENTS WHERE Social_Security = '" + request.getParameter("ssnedit").trim() + "'";
            
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            User u = (User) request.getSession().getAttribute("u");
            // sql statement may update a 
            p.setSsn(request.getParameter("ssn"));
            p.setFname(request.getParameter("fname"));
            p.setMname(request.getParameter("fname"));
            p.setLname(request.getParameter("lname"));
            p.setPtype(request.getParameter("pat_type"));
           
            if (r.next()) {
//                Patient p = new Patient();

                request.getSession().setAttribute("selectedPatient", p);
                sql = "UPDATE PATIENTS SET "
                        //                        + "RecipientID = ?, "
                        + "Social_Security = ?, "
                        + "First_Name = ?, "
                        + "Middle_Init = ?, "
                        + "Last_Name = ?, "
                        + "DOB = ?, "
                        + "P_Type = ?, "
                        + "Vaccine_ID = ?, "
                        + "Vaccination_Sit e= ?, "
                        + "Vaccine_1 = ?, "
                        + "Vaccine_2 = ?, "
                        + "Vaccine_3 = ?, "
                        + "Vaccine_4 = ? "
                        + "WHERE Social_Security = ?";
                p.setSsn(request.getParameter("ssn"));
                p.setFname(request.getParameter("fname"));
                p.setLname(request.getParameter("lname"));
                p.setMname(request.getParameter("minit"));
                p.setDob(String.valueOf(request.getParameter("dob")));
                p.setPtype(String.valueOf(request.getParameter("pat_type")));
                Vaccine vac1 = new Vaccine();
                vac1.setVid(request.getParameter("v1id"));
                p.setVac1(vac1);
                Vaccine vac2 = new Vaccine();
                vac2.setVid(request.getParameter("v2id"));
                p.setVac2(vac2);
                Vaccine vac3 = new Vaccine();
                vac3.setVid(request.getParameter("v3id"));
                p.setVac3(vac3);
                Vaccine vac4 = new Vaccine();
                vac4.setVid(request.getParameter("v4id"));
                p.setVac4(vac4);
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, p.getSsn());
                ps.setString(2, p.getFname());
                ps.setString(3, p.getMname());
                ps.setString(4, p.getLname());
                ps.setDate(5, Date.valueOf(p.getDob()));
                ps.setString(6, p.getPtype());
                ps.setString(7, String.valueOf(request.getParameter("v1id")));
                ps.setString(8, u.getLocation());//request.getParameter("loc"));//.getSession().getAttribute("u")
                ps.setString(9, String.valueOf(request.getParameter("v1id")));
                ps.setString(10, String.valueOf(request.getParameter("v2id")));
                ps.setString(11, String.valueOf(request.getParameter("v3id")));
                ps.setString(12, String.valueOf(request.getParameter("v4id")));
                
                int rc = ps.executeUpdate();
                if (rc == 0) {
                    msg += "Record cannot update. <br>";
                    url = webloc + "/PatientView.jsp";
                } else {
                    msg += "Recorded Updated. <br>";
                    url = webloc + "/VaccinationDB.jsp";
                }
            } else {
                sql = "INSERT INTO PATIENTS (Social_Security, First_Name, Middle_Init, "
                        + "Last_Name,DOB, P_Type,Vaccine_ID,Vaccination_Site,"
                        + " Vaccine_1, Vaccine_2, Vaccine_3, Vaccine_4) "
                        + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?,?,?,?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, request.getParameter("ssnedit").trim());
////                ps.setString(2, );
//                ps.setString(3, "");
//                ps.setString(4, "");
//                ps.setString(5, "");
//                ps.setString(6, "");
//                ps.setString(7, "");
//                ps.setString(8, "");
//                ps.setString(9, "");
                p.setSsn(request.getParameter("ssn"));
                p.setFname(request.getParameter("fname"));
                p.setLname(request.getParameter("lname"));
                p.setMname(request.getParameter("minit"));
                p.setDob(String.valueOf(request.getParameter("dob")));
                p.setPtype(String.valueOf(request.getParameter("pat_type")));
                Vaccine vac1 = new Vaccine();
                vac1.setVid(request.getParameter("v1id"));
                p.setVac1(vac1);
                Vaccine vac2 = new Vaccine();
                vac2.setVid(request.getParameter("v2id"));
                p.setVac2(vac2);
                Vaccine vac3 = new Vaccine();
                vac3.setVid(request.getParameter("v3id"));
                p.setVac3(vac3);
                Vaccine vac4 = new Vaccine();
                vac4.setVid(request.getParameter("v4id"));
                p.setVac4(vac4);
//                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, p.getSsn());
                ps.setString(2, p.getFname());
                ps.setString(3, p.getMname());
                ps.setString(4, p.getLname());
                ps.setDate(5, Date.valueOf(p.getDob()));
                ps.setString(6, p.getPtype());
                ps.setString(7, String.valueOf(request.getParameter("v1id")));
                ps.setString(8, u.getLocation());//request.getParameter("loc"));
                ps.setString(9, String.valueOf(request.getParameter("v1id")));
                ps.setString(10, String.valueOf(request.getParameter("v2id")));
                ps.setString(11, String.valueOf(request.getParameter("v3id")));
                ps.setString(12, String.valueOf(request.getParameter("v4id")));
                
                int rc = ps.executeUpdate();
                if (rc == 0) {
                    msg += "Record cannot update. <br>";
                    url = webloc + "/PatientView.jsp";
                } else {
                    msg += "Recorded Updated. <br>";
                    url = webloc + "/VaccinationDB.jsp";
                }
//                int rc = ps.executeUpdate();
                
//                p.setSsn(request.getParameter("ssnedit").trim());
//                request.getSession().setAttribute("selectedPatient", p);
            }
            s.close();
            r.close();
//            url = "/DoctorLogin/EditPatient.jsp";

        } catch (ClassNotFoundException e) {
            msg += "Class Error: " + e.getMessage() + "<br>";
             url = webloc + "/PatientView.jsp";
        } catch (SQLException e) {
            msg += "SQL Error:" + e.getMessage() + " <br>"; 
            url = webloc + "/PatientView.jsp";
        }
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
