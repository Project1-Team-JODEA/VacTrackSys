/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author alexs
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"Member/Login", "CDC/Login", "DoctorLogin/Login"})
public class LoginServlet extends HttpServlet {

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
        String URL = "", msg = "", sql = "", salt = "", username = "", pw = "", webloc = "", ac_lvl = "";
        User u;
//        Stringsalt = Optional.empty();

        String dbURL = "jdbc:ucanaccess://localhost:3306/MoVaxDB";
        String dbUSER = "root";
        String dbPWD = "sesame";
        try {
            // get Username and Passattempt from form

            // Check Location in web
            String x = String.valueOf(request.getRequestURL());
            if (x.contains("DoctorLogin")) {
                webloc = "/DoctorLogin";
                ac_lvl = "MedicalStaff";
            } else if (x.contains("PatientLogin")) {
                webloc = "/PatientLogin";
                ac_lvl = "Patient";
            } else if (x.contains("AdminConsole")) {
                webloc = "/AdminConsole";
                ac_lvl = "Administrator";
            } else if (x.contains("CDC")) {
                webloc = "/CDC";
                ac_lvl = "CDC";
            }

            username = String.valueOf(request.getParameter("userid").trim());
            pw = String.valueOf(request.getParameter("passwd"));
            if (username.isEmpty() || username.equals("")) {
                msg += "";
            }
            if (username.length() < 8) {
                msg += "Invalid Username <br>";
            }
            if (pw.equals("")) {
                msg += "Missing Password <br>";
            }

            if (!msg.isEmpty() || !msg.equalsIgnoreCase("")) {
                URL = webloc + "/index1.jsp";

            } else {
                String passattempt = request.getParameter("passwd").trim();
                // load and register JDBC driver for mySql
                Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                ServletContext context = getServletContext();
//            String p = request.getPathInfo();
//           System.out.print("Path: " + p);
                String ur = context.getRealPath("/Team_JODEA1.accdb");
                Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
//           
                Statement s = conn.createStatement();
                sql = "SELECT * FROM USERS WHERE Username = '" + username + "'";
                // + " AND Access_Level='"+ac_lvl+"'";
                ResultSet r = s.executeQuery(sql);
                if (r.next()) {
                    u = new User();
                    u.setUsername(username);
                    u.setPassword(r.getString("Password"));
                    salt = r.getString("SAV");
                    Optional<String> ps = AppSecurity.hashValue(passattempt, salt);
                    u.setPassattempt(ps.get());

                    if (u.isAuthenticated()) {

                        u.setAccesslevel(r.getString("Access_Level"));
                        //verify access level
                        if (!AppSecurity.verify(ps.get(), u.getPassword(), salt)) {
                            msg += "";
                        }
                        if (!u.getAccesslevel().equals(ac_lvl)) {
                            msg += "User" + username + "on file but not authenticated. <br>";
                            URL = webloc + "/index1.jsp";
                        } else {
                            u.setEmail("Email_Address");
                            u.setLocation("Location");
                            msg += "User " + username + " authenticated! <br>";
                            if (webloc.equals("Patient")) {
                                URL = webloc + "/";
                            } else {
                                URL = webloc + "/VaccinationDB.jsp";
                            }

                        }

                    } else {
                        msg += "User " + username + " on file but not authenticated. <br>";
                        URL = webloc + "/index1.jsp";
                    }
                    request.getSession().setAttribute("u", u);
                } else {
//                URL = "/DoctorLogin/index1.jsp";
                    URL = webloc + "/index1.jsp";
                    msg += "User " + username + " not found in db.<br>";
                }
                r.close();
                s.close();
                conn.close();
            }

        } catch (ClassNotFoundException e) {
            msg += "JDBC Driver not found in project.<br>";
            URL = webloc + "/index1.jsp";
        } catch (SQLException e) {
            msg += "Connection error: " + e.getMessage() + ".<br>";
            URL = webloc + "/index1.jsp";
        } catch (Exception e) {
            msg += "Servlet error: " + e.getMessage() + ".<br>";
            URL = webloc + "/index1.jsp";
        }
//        URL = "/DoctorLogin/VaccinationDB.jsp";
        Cookie uid = new Cookie("usid", username);
        uid.setMaxAge(120);
        uid.setPath("/");
        uid.setSecure(true);

        response.addCookie(uid);
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
