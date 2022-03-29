/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 */
package servlets;

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
@WebServlet(name = "UpdateVaccineServlet", urlPatterns = {"/UpdateVaccineServlet"})
public class UpdateVaccineServlet extends HttpServlet {

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
        int selectedVaccine = (Integer) request.getSession().getAttribute("selectedVaccine");
        String msg = "", url = "", sql = "";
        String vacID = String.valueOf(request.getParameter("vid").trim());
        String vacLoc = String.valueOf(request.getParameter("loc").trim());
        String vacMan = String.valueOf(request.getParameter("man").trim());
        String vacDate = String.valueOf(request.getParameter("vac_date").trim());
        String vacBat = String.valueOf(request.getParameter("batnumb").trim());
        String vacTyp = String.valueOf(request.getParameter("vac_type").trim());
        if (vacID == null || vacID.equalsIgnoreCase("")){
            msg += "Vaccine ID field blank!";
        } else if (vacLoc == null || vacLoc.equalsIgnoreCase("")){
            msg += "Vaccine Location field blank!";
        } else if (vacMan == null || vacMan.equalsIgnoreCase("")){
            msg += "Vaccine Manufactuerer field blank!";
        } else if (vacBat == null || vacBat.equalsIgnoreCase("")){
            msg += "Vaccine Batch Number field blank!";
        } else {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            sql = "SELECT * FROM VACCINES WHERE Vaccine_ID = '" + vacID + "'";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if (r.next()){
                // Vaccine Already Exists!
                sql = "UPDATE VACCINES SET Batch_Number = ?, Vaccine_Type = ?, Vaccine_Location = ?, Manufacturer = ? WHERE Vaccine_ID = '" + vacID + "'";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, vacBat);
                ps.setString(2, vacTyp);
                ps.setString(3, vacLoc);
                //ps.setString(4, vacDate);
                ps.setString(4, vacMan);
                int rc = ps.executeUpdate();
                msg += "<br>" + Integer.toString(rc) + " records updated. <br>";
            } else {
                // Create New Vaccine
                sql = "INSERT INTO VACCINES (Batch_Number, Vaccine_Type, Vaccine_Location, Manufacturer, Vaccine_ID) VALUES (?, ?, ?, ?, ?)";
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, vacBat);
                ps.setString(2, vacTyp);
                ps.setString(3, vacLoc);
                //ps.setString(4, vacDate);
                ps.setString(4, vacMan);
                ps.setString(5, vacID);
                int rc = ps.executeUpdate();
                msg += "<br>" + Integer.toString(rc) + " records updated. <br>";
            }
            s.close();
            r.close();
            request.getSession().setAttribute("vaccineID", vacID);
            url = "/DoctorLogin/PatientView.jsp";
            RequestDispatcher disp = getServletContext().getRequestDispatcher(url);
            disp.forward(request, response);
        }
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
            Logger.getLogger(UpdateVaccineServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateVaccineServlet.class.getName()).log(Level.SEVERE, null, ex);
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
            Logger.getLogger(UpdateVaccineServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(UpdateVaccineServlet.class.getName()).log(Level.SEVERE, null, ex);
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
