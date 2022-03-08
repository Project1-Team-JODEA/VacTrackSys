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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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

/**
 *
 * @author alexs
 */
@WebServlet(name = "SearchServlet", urlPatterns = {"/SearchServlet"})
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
        String msg = "", sql = "", url = "";
        String ssn, fname, minit, lname, ptype, vsite, v1id, v2id, v3id, v4id;
        ArrayList<Patient> patientset = new ArrayList<>();
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            // at the moment, I am putting off the ability to search with criteria
            // logic for searches will go here
            // in the meantime, searches will return the entire db
            sql = "SELECT * FROM PATIENTS";
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            while (r.next()){
                Patient pat = new Patient();
                pat.setSsn(r.getString("Social_Security"));
                pat.setFname(r.getString("First_Name"));
                pat.setMname(r.getString("Middle_Init"));
                pat.setLname(r.getString("Last_Name"));
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
            request.getSession().setAttribute("patientset", patientset);
            User u = (User) request.getSession().getAttribute("u");
            u.setSearched(true);
            request.getSession().setAttribute("u", u);
        } catch (Exception e) {
            msg += e.getMessage();
        }
        url = "/DoctorLogin/MainDBForm.jsp";
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
        return "Short description";
    }// </editor-fold>

}
