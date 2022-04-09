/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package servlets;

import business.Patient;
import business.SecLog;
import business.User;
import java.io.IOException;
import java.io.PrintWriter;
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
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexs
 */
@WebServlet(name = "EditPatientServlet", urlPatterns = {"/EditPatientServlet"})
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
            throws ServletException, IOException, ClassNotFoundException, SQLException {
        String msg="", url="";
        response.setContentType("text/html;charset=UTF-8");        
        Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
        ServletContext context = getServletContext();
        String ur = context.getRealPath("/Team_JODEA1.accdb");
        Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);   
        if (
                // This if checks if any fields are blank
                String.valueOf(request.getParameter("ssn").trim()) == null ||
                String.valueOf(request.getParameter("fname").trim()) == null ||
                String.valueOf(request.getParameter("midinit").trim()) == null ||
                String.valueOf(request.getParameter("lname").trim()) == null ||
                String.valueOf(request.getParameter("v1id").trim()) == null ||
                String.valueOf(request.getParameter("v2id").trim()) == null ||
                String.valueOf(request.getParameter("v3id").trim()) == null ||
                String.valueOf(request.getParameter("v4id").trim()) == null
                ){
            msg += "<br>" + "Field cannot be blank!" + "<br>";
        } else {
            // This else updates the record
            String sql = "UPDATE patients SET First_Name = ?, Middle_Init = ?, Last_Name = ?, P_Type = ?, Vaccine_1 = ?, Vaccine_2 = ?, Vaccine_3 = ?, Vaccine_4 = ? WHERE Social_Security = '" + request.getParameter("ssn").trim() + "'";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, String.valueOf(request.getParameter("fname".trim())));
            ps.setString(2, String.valueOf(request.getParameter("midinit".trim())));
            ps.setString(3, String.valueOf(request.getParameter("lname".trim())));
            ps.setString(4, String.valueOf(request.getParameter("pat_type".trim())));
            ps.setString(5, String.valueOf(request.getParameter("v1id".trim())));
            ps.setString(6, String.valueOf(request.getParameter("v2id".trim())));
            ps.setString(7, String.valueOf(request.getParameter("v3id".trim())));
            ps.setString(8, String.valueOf(request.getParameter("v4id".trim())));
            int rc = ps.executeUpdate();
            msg += "<br>" + Integer.toString(rc) + " records updated. <br>";
            
        }
        User u = (User) request.getSession().getAttribute("u");
        String fullname = request.getParameter("fname").trim() + " " + request.getParameter("minit") + " " + request.getParameter("lname");
        Patient p = new Patient();
        p.setSsn(request.getParameter("ssn").trim());
        SecLog.write(u, p, ur, "User updated patient record ");
        url = "/DoctorLogin/VaccinationDB.jsp";
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
            Logger.getLogger(EditPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(EditPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(EditPatientServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
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