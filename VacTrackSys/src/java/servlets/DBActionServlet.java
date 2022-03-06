
/**
 *
 * @author eVmPr
 * 
 * TODO: Add attributes to JSPs:
 * 
 */
package servlets;

import business.Patient;
import business.Vaccine;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
        String URL = "Member/VaccinationDB.jsp";
        String msg = "", sql = ""; String action = "";
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
//            String ur = context.getRealPath("/WEB-INF/MoVaxDB.accb");
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://"+ur);
             action = request.getParameter("actiontype");// for DB Action
            if  (action.equals("")){
                msg += "Error: Undable to Perform Action <br>";
                URL = "Member/VaccinationDB.jsp";
            } else if (action.equalsIgnoreCase("")){
                msg += "Error: Undable to Perform Action <br>";
                URL = "Member/VaccinationDB.jsp";
            } else if (action.equalsIgnoreCase("edit")){
                // code editing script
                sql="";
                
            }else if (action.equalsIgnoreCase("create")){
                //TODO: Add Vaccine Objects for patient object
                sql="INSERT INTO PATIENTS VALUES";
                Patient p = new Patient();
                p.setFname(request.getParameter("fname"));
                p.setLname(request.getParameter("lname"));
                p.setMname(request.getParameter("init"));
                p.setRid(Integer.parseInt(request.getParameter("")));
                p.setDob(request.getParameter("dob"));
                
//                p.setVac1();
            }
            else if (action.equalsIgnoreCase("view")){
                sql = "SELECT * FROM PERSONS "
                        + "WHERE Vaccine_ID = ?"
                        + "AND Batch_Number = ?;";
                ArrayList <Patient> p = new ArrayList<>();
                PreparedStatement ps = conn.prepareStatement(sql);
                ps.setString(1, request.getParameter("vid"));
                ps.setString(2, request.getParameter("batnum"));
                //
                
                
            }
        
        } catch (ClassNotFoundException e) {
                msg = "Error: Class Not Found <br>";
        } catch (SQLException ex) {
            msg+= "Error: " + ex + "<br>";
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