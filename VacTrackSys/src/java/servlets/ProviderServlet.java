/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater
 * Author: Elena Miller
    
 */
package servlets;

import business.Provider;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eVmPr
 */
public class ProviderServlet extends HttpServlet {

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
        String URL = "", msg = "", sql = "", action = "", webloc = "";
        String fname = "", lname = "", minit = "", dob = "", etype = "";
        Provider pr;
        try {
            
            String x = String.valueOf(request.getRequestURL());

            if (x.contains("DoctorLogin")) {
                webloc = "/DoctorLogin";
            } else if (x.contains("AdminConsole")) {
                webloc = "/AdminConsole";
            }
            URL=webloc+"";
           
            if (action.equalsIgnoreCase("newProvider")) {
                sql = "SELECT * FROM PROVIDERS WHERE Username=?;";
                // if found
                sql="INSERT INTO PROVIDERS(Provider_ID, Username,First_Name, Middle_Init, Last_Name, DOB,Employee_Type)"
                        + " VALUES(?,?,?,?,?,?);";
            } else if (action.equalsIgnoreCase("update")) {
                
            } else {
                msg += "Unable to perform action <br>";
            }
        } catch (Exception e) {
            msg += e.getMessage() + "<br>";
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
