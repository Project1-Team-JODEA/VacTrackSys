/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater

 */
package servlets;

import business.User;
import java.util.*;
import javax.mail.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.internet.*;
import javax.activation.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Elena Miller
 *
 */
public class ResetPasswordServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     * Servlet will use Hint to reset user password - may come from email.
     * 
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        //
        String URL = "", msg = "", userid = "", email = "", code = "", webloc = "";
        String sql = "", hint="", host="";
        User u;
        try {
            String x = String.valueOf(request.getRequestURL());
            if (x.contains("DoctorLogin")) {
                webloc = "/DoctorLogin";
                // ac_lvl = "MedicalStaff";
            } else if (x.contains("PatientLogin")) {
                webloc = "/PatientLogin";
                // ac_lvl = "Patient";
            } else if (x.contains("AdminConsole")) {
                webloc = "/AdminConsole";
                // ac_lvl = "Administrator";
            } else if (x.contains("CDC")) {
                webloc = "/CDC";
                // ac_lvl = "CDC";
            }
            
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            sql = "SELECT * FROM USERS WHERE Username='" + String.valueOf(request.getParameter("userid")) + "'";
            userid = String.valueOf(request.getParameter("userid"));
            Statement s = conn.createStatement();
            ResultSet r = s.executeQuery(sql);
            if (r.next()) {
                u = new User();
                u.setUsername(userid);
                u.setPassword(r.getString("Password"));
                hint = r.getString("Hint");
                u.setAccesslevel(r.getString("Access_Level"));
                u.setEmail(r.getString("Email"));
                
            }
            /**/
//            Properties properties = System.getProperties();
//            host = "localhost";
//            properties.setProperty("mail.stmp.host", host);
//            Session session = Session.getDefaultInstance(properties);
//            MimeMessage message = new MimeMessage(session);
//            message.setFrom(new InternetAddress(from));
//            message.addRecipients(Message.RecipientType.TO, u.getEmail());
        } catch (ClassNotFoundException e) {
            msg += "Class Error: " + e.getMessage() + "<br>";
            URL = webloc + "/PatientView.jsp";
        } catch (SQLException e) {
            msg += "SQL Error:" + e.getMessage() + " <br>";
            URL = webloc + "/PatientView.jsp";
        }

        Properties properties = new Properties();
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
