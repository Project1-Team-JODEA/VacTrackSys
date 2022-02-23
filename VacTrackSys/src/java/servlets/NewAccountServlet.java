/**
 *
 * @author Elena Miller
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class NewAccountServlet extends HttpServlet {

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

        String URL = "Member/NewAccount.jsp";
        String msg = "", sql = "";

        String email = "", userid = "", passwd = "", confpasswd="";

        try {//Connecting to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String dbURL = context.getRealPath("/WEB-INF/MoVaxDB.accb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://"+dbURL);
            userid = request.getParameter("userid");
            email = request.getParameter("email"); 
            passwd = request.getParameter("passwd");
            confpasswd = request.getParameter("confpasswd"); 
            /* check for empty strings in  input */
            if (userid.equals("")){
                msg += "Please enter username. <br>";
            } else if (passwd.equals("")){
                msg += "Please enter password. <br>";
            } else if (confpasswd.equals("")){
                msg += "Password Invalid. Please Confirm Password <br>";
            }else if (email.equals("")){
                msg += "Missing Email Address. <br>";
            }
            else {
                //Check Username, Password and Confirmation Password, 
                //if 
                if (userid.length() > 6){//
                    msg = "";
                } if (passwd.length() > 8){
                    msg = "";
                } 
                if (passwd.equalsIgnoreCase(userid)){
                    msg = "Password Cannot be the same as your username.";
                }
                if (!confpasswd.matches(passwd)){
                    msg = "Password Invalid <br>";
                }
                //Create User Account
                
                sql = "INSERT INTO Users (Username, Password, Email_Address) "
                        + "VALUES ("+ " ) ";
            }
        
        } catch (ClassNotFoundException ex) {
            msg = "Error: Class Not Found. <br>";
        } catch (SQLException ex) {
            msg += "Connection Error: " + ex + "<br>";
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
