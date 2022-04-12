/*
 * Team Name: J.O.D.E.A.
 * Project:Vaccination Tracking System 
 * School: STLCC
 * Members: Elena Miller, Jaccob Stanton, Deshane Sims,
 * Alexander Breitnebach, and Osama Aater

 */
package servlets;

import business.*;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
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
     * methods. <br>
     * Servlet will perform actions/steps to reset password. when step value
     * from jsp if set to "search" then Servlet will search Users table using
     * the provided username and password. If user is found in database, the
     * servlet sets a temporary attribute called <code>found </code> which is
     * set to a boolean value. if user is not found in database, then
     * <code>found = false</code>. on the jsp page if the <code>found </code>
     * attribute if not true then user cannot proceed. otherwise, the user will
     * proceed with verifying their identity.
     *
     * when step value = "verify" the servlet will take the verification
     * information and
     *
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
        String sql = "", hint = "", dir = "", salt = "";
        int step = 0;
        User u = new User();
        try {
            String x = String.valueOf(request.getRequestURL());
            if (x.contains("DoctorLogin")) {
                webloc = "/DoctorLogin";
                // ac_lvl = "MedicalStaff";
                dir = "DoctorLogin";
            } else if (x.contains("PatientLogin")) {
                webloc = "/PatientLogin";
                // ac_lvl = "Patient";
                dir = "PatientLogin";
            } else if (x.contains("AdminConsole")) {
                webloc = "/AdminConsole";
                // ac_lvl = "Administrator";
                dir = "PatientLogin";
            } else if (x.contains("CDC")) {
                webloc = "/CDC";
                // ac_lvl = "CDC";
                dir = "CDC";
                webloc = "/CDC";
            }
            URL = webloc + "/Password_Reset.jsp";

            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            userid = String.valueOf(request.getParameter("userid"));
            email = String.valueOf(request.getParameter("email"));
            if (userid.isEmpty() || userid.equals("")) {
                msg += "Missing Username <br>";
            }
            if (email.isEmpty() || email.equals("")) {
                msg += "Missing Email";
            }
            String stp = request.getParameter("step");
            if (stp.isEmpty() || stp.equalsIgnoreCase("")) {
                msg += "Error: unknown Aciton <br>";

            } else if (stp.equals("search")) {//

                if (msg.isEmpty() || msg.equals("")) {
                    sql = "SELECT * FROM USERS WHERE Username='" + String.valueOf(request.getParameter("userid")) + "'"
                            + "AND Email_Address='" + String.valueOf(request.getParameter("email")) + "'";

                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery(sql);
                    u = new User();
                    if (r.next()) {
//                        request.
                        u.setUsername(r.getString("Username"));
                        u.setEmail(r.getString("Email_Address"));
//                      u.setPassword(r.getString);
                        u.setSearched(true);
                        u.setLocation(r.getString("Location"));
                        u.setQuestion(r.getString("Question"));
//                        Cookie res = new Cookie("re", u.getUsername());
//                        res.setHttpOnly(true);
//                        res.setPath(ur);

                        request.getSession().setAttribute("searched", "true");
                      request.getSession().setAttribute("u", u);
                    } else {
                        msg += "username not found in database <br>";
                    }
                } else {

                }
            } else if (stp.equalsIgnoreCase("sendCode")) {
                //send code to user using email
                if (msg.isEmpty() || msg.equals("")) {
                    sql = "SELECT * FROM USERS WHERE Username='" + String.valueOf(request.getParameter("userid")) + "'";
                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery(sql);
                    u = new User();
                    if (r.next()) {
//                        request.
//                       u.getEmail();
//                        u.setEmail(r.getString("Email_Address"));
//                        u.setUsername(r.getString("Username"));
//                       u.set
                    }
                } else {

                }
            } else if (stp.equalsIgnoreCase("ResetPasswd")) {
                if (msg.isEmpty() || msg.equals("")) {
                    sql = "SELECT * FROM USERS WHERE Username='" + String.valueOf(request.getParameter("userid")) + "'";
                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery(sql);

                    if (r.next()) {

                        u.setUsername(userid);
                        u.setPassword(r.getString("Password"));
                        hint = r.getString("Hint");
                        u.setAccesslevel(r.getString("Access_Level"));
                        u.setEmail(r.getString("Email_Address"));
                        u.setLocation(r.getString("Location"));

                    }
                    if (!u.getLocation().equals(dir)) {// return message if account access level does not match location
                        msg += "Cannot Reset Account <br>";
                        URL = webloc + "/Password_Reset.jsp";

                    } else {
                        if (hint.equals(request.getParameter("hint"))) {
                            boolean reset = true;

//                            AppSecurity.sendEmail(u.getEmail(), "Password Reset", "");
                            request.getSession().setAttribute("found", true);
                            request.getSession().setAttribute("ver", "y-d");
                            msg += "Password Reset <br>";

                            URL = webloc + "/Password_Reset.jsp";
//                    Cookie res = new Cookie("ver", );

                        } else {
                            boolean reset = false;
                            request.setAttribute("found", false);
                            msg += "Hint Does Not Match <br>";
                            request.getSession().setAttribute("ver", "x-v");
//                    request.setAttribute("resetu", u);
                        }
                    }

                    r.close();
                    s.close();
                }
            } else if (stp.equalsIgnoreCase("updatePasswd")) {
                String newpasswd = request.getParameter("upwd");
                String confpasswd = request.getParameter("confpasswd");
                String newhint = request.getParameter("newhint");
                if (newpasswd.isEmpty() || newpasswd.equalsIgnoreCase("")) {
                    msg += "Missing new Password <br>";
                } else if (newpasswd.length() < 10) {
                    msg += "Password must be at least 10 characters <br>";
                }
                if (confpasswd.isEmpty() || confpasswd.equalsIgnoreCase("")) {
                    msg += "Missing confirming Password <br>";
                } else if (!confpasswd.equalsIgnoreCase(newpasswd)) {
                    msg += "confirming password does not match <br>";
                }
                if (newhint.isEmpty() || newhint.equalsIgnoreCase("")) {
                    msg += "missing new hint";
                }
                if (msg.isEmpty() || msg.equalsIgnoreCase("")) {
                    sql = "SELECT * FROM USERS WHERE Username='" + String.valueOf(request.getParameter("userid")) + "'";
                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery(sql);

                    if (r.next()) {

                        u.setUsername(userid);
                        u.setPassword(r.getString("Password"));
                        hint = r.getString("Hint");
                        u.setAccesslevel(r.getString("Access_Level"));
                        u.setEmail(r.getString("Email_Address"));
                        u.setLocation(r.getString("Location"));
                        if (u.getPassword().equals(request.getParameter("newpasswd"))) {
                            msg += "Old Password cannot be reused.<br>";
                            URL = webloc + "/Password_Reset.jsp";
                        } else {
                            if (newhint.equalsIgnoreCase(r.getString("Hint"))) {
                                msg += "Old Hint cannot be reused.<br>";
                                URL = webloc + "/Password_Reset.jsp";
                            } else {
                                sql = "UPDATE USERS "
                                        + "SET Password = ?,"
                                        + "Hint = ?"
                                        + "WHERE Username = ?;";
                                PreparedStatement ps = conn.prepareStatement(sql);
                                ps.setString(1, newpasswd);
                                ps.setString(2, stp);
                                ps.setString(3, u.getUsername());
                                int rc = ps.executeUpdate();
                                if (rc == 0) {
                                    msg += "Error: Cannot update password <br>";
                                    URL = webloc + "/Password_Reset.jsp";

                                } else {
                                    msg += "password reset success<br>";
                                    URL = webloc + "/index1.jsp";
                                    request.removeAttribute("ver");
                                }
                                ps.close();
                            }
                        }

                    } else {
                        msg += "Username not found in db. <br>";
                    }
                    r.close();
                    s.close();

                }

            } else if (stp.equalsIgnoreCase("cancel")) {
                String ver_1 = (String) request.getAttribute("ver");
                String v_2 = (String) request.getAttribute("found");
                if (!ver_1.isEmpty() || !ver_1.equalsIgnoreCase("")) {
                    request.removeAttribute("ver");

                }
                URL = webloc + "/index1.jsp";
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
            URL = webloc + "/Password_Reset.jsp";
        } catch (SQLException e) {
            msg += "SQL Error:" + e.getMessage() + " <br>";
            URL = webloc + "/Password_Reset.jsp";
        }
        request.setAttribute("msg", msg);
//        Properties properties = new Properties();
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
