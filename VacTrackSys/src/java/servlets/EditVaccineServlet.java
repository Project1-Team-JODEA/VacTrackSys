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
import java.util.HashSet;
import java.util.Set;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexs
 */
@WebServlet(name = "EditVaccineServlet", urlPatterns = {"/EditVaccineServlet"})
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
        // Servlet determines which button was pressed
        int selectedVaccine = 0;
        String msg = "", url = "";
        if (request.getParameter("vaccine1") != null){
            selectedVaccine = 1;
        } else if (request.getParameter("vaccine2") != null){
            selectedVaccine = 2;
        } else if (request.getParameter("vaccine3") != null){
            selectedVaccine = 3;
        } else if (request.getParameter("vaccine4") != null){
            selectedVaccine = 4;
        } else if (request.getParameter("add") != null) {
            // Patient Update button was pressed!
            selectedVaccine = -1;
        } else {
            selectedVaccine = 0;
        }
        if (selectedVaccine == 0){
            msg += "<br> Servlet cannot determine which Vaccine button was pressed. <br>";
            url = "/DoctorLogin/PatientView.jsp";
            RequestDispatcher disp = getServletContext().getRequestDispatcher(url);
            disp.forward(request, response);
        } else if ( selectedVaccine == -1) {
            // Call EditPatient servlet!
            url = "/DoctorLogin/EditPatient";
            RequestDispatcher disp = getServletContext().getRequestDispatcher(url);
            disp.forward(request, response);
        } else {
            request.getSession().setAttribute("selectedVaccine", selectedVaccine);
            url = "/DoctorLogin/VacRecordCreate.jsp";
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
