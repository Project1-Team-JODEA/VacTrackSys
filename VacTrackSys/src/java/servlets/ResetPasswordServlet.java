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
import java.util.Enumeration;
import java.util.Optional;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
//import  javax.servlet.http.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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
        String sql = "", ac_lvl = "", hint = "", dir = "", salt = "";
        int step = 0;
        User u = new User();
        HttpSession session = request.getSession();
        try {
            String x = String.valueOf(request.getRequestURL());
            if (x.contains("DoctorLogin")) {
                webloc = "/DoctorLogin";
                ac_lvl = "MedicalStaff";
                dir = "DoctorLogin";
            } else if (x.contains("PatientLogin")) {
                webloc = "/PatientLogin";
                ac_lvl = "Patient";
                dir = "PatientLogin";
            } else if (x.contains("AdminConsole")) {
                webloc = "/AdminConsole";
                ac_lvl = "Administrator";
                dir = "PatientLogin";
            } else if (x.contains("CDC")) {
//                webloc = "/CDC";
                ac_lvl = "CDC";
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
            } else {
                u.setUsername(userid);

            }
            if (email.isEmpty() || email.equals("")) {
                msg += "Missing Email";
            } else {
                u.setEmail(email);
            }

            String stp = request.getParameter("step");
            if (stp.isEmpty() || stp.equalsIgnoreCase("")) {
                msg += "Error: unknown Aciton <br>";

            } else if (stp.equals("search")) {//

                Cookie[] cs = null;
                Cookie c = null, ac = null;
                cs = request.getCookies();

                if (cs != null) {
                    if (cs.length > 0) {
                        for (Cookie c1 : cs) {
                            if (c1.getName().equalsIgnoreCase("account")) {
                                c = c1;
                            }
                            if (c1.getName().equalsIgnoreCase("act")) {
                                ac = c1;
                            }
                        }
                    }
                } else {
                    c = new Cookie("account", null);
                }
                if (msg.isEmpty() || msg.equals("")) {
                    sql = "SELECT * FROM USERS WHERE Username='" + String.valueOf(request.getParameter("userid")) + "'"
                            + "AND Email_Address='" + String.valueOf(request.getParameter("email")) + "'";

                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery(sql);
                    User user = new User();
                    if (r.next()) {
//                        request.
                        user.setUsername(r.getString("Username"));
                        user.setEmail(r.getString("Email_Address"));
//                      u.setPassword(r.getString);
                        user.setSearched(true);
                        user.setLocation(r.getString("Location"));
                        user.setQuestion(r.getString("Question"));
                        user.setAccesslevel(r.getString("Access_Level"));

                        hint = r.getString("Hint");
                        if (c != null) {
                            c.setPath(x);
                            c.setValue(user.getUsername());
                            c.setMaxAge(5 * 100);
                            c.setSecure(true);
                            c.setComment("account");
                        } else {
                            c = new Cookie("account", user.getUsername());
                            c.setPath(x);
                            c.setMaxAge(180);
                            c.setSecure(true);
                            c.setComment("reset account");
                            response.setContentType("text/html");
                            response.addCookie(c);
                            c = new Cookie("act", "found");
                            c.setPath(x);
                            c.setMaxAge(5 * 100);
                            c.setSecure(true);
                            c.setComment("reset account action");
                        }
                        if (ac != null) {
                            if (!ac.getValue().contains("found")) {
                                ac.setValue("found");
                                ac.setMaxAge(5 * 100);
                            }
                        } else {
                            ac = new Cookie("act", "found");
                            ac.setComment("action");
                            ac.setPath(x);
                            ac.setMaxAge(5 * 100);
                            ac.setSecure(true);
                            ac.setHttpOnly(true);
                        }
                        response.setContentType("text/html");
                        response.addCookie(c);
                        response.addCookie(ac);
                        if (!u.getAccesslevel().equalsIgnoreCase(ac_lvl)) {// return message if account access level does not match location
                            msg += "This Existing account has a different access level. "
                                    + "You can re<br>";
                        } else {

                        }

                        msg = "User Found in database <br>";
                        request.getSession().setAttribute("u", user);
                    } else {
                        msg += "username not found in database <br>";
                    }
                } else {

                }
            } else if (stp.equalsIgnoreCase("sendCode")) {
                //send code to user using email
                u = (User) request.getSession().getAttribute("u");
                if (msg.isEmpty() || msg.equals("")) {
                    sql = "SELECT * FROM USERS WHERE Username='" + String.valueOf(request.getParameter("userid")) + "'";
                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery(sql);

                    if (r.next()) {
//                        request.
//                       u.getEmail();
//                        u.setEmail(r.getString("Email_Address"));
//                        u.setUsername(r.getString("Username"));
//                       u.set
                        int rcode = AppSecurity.getGenCode();

                        boolean sent = AppSecurity.sendEmail(u.getEmail(), "Security Code", "Your Reset Code is: " + String.valueOf(rcode));
                        if (sent == true) {
                            Cookie c = new Cookie("rcode", String.valueOf(rcode));
                            c.setMaxAge(180);
                            c.setPath(URL);
                            c.setSecure(sent);
                            response.addCookie(c);
                            msg += "Reset Code Sent. <br>";
                        } else {
                            msg += "Unable to send reset code. <br>";
                        }
                    }
                } else {

                }
            } else if (stp.equalsIgnoreCase("ResetPasswd")) {
                String method = request.getParameter("rsmethod");

                u = (User) request.getSession().getAttribute("u");
                String account = ""; String scode = "";
                Cookie c = null;
                Cookie[] cs = request.getCookies();
                if (cs.length > 0) {
                    for (Cookie cookie : cs) {
                        if (cookie.getName().equals("act")) {
                            account = cookie.getValue();
                            c = cookie;
                            
                        }else if (cookie.getName().equals("rcode")){
                            if (cookie.getPath().equals(webloc+"/Password_Reset.jsp")){
                                scode = cookie.getValue();
                            }
                        }
                    }
                }
                if (method.equals("")) {
                    msg += "missing reset method <br>";
                } else if (method.equalsIgnoreCase("sendCode")) {
                    String rcode = String.valueOf(request.getParameter("rcode"));
//                    String 
                    //String scode = String.valueOf(request.getSession().getAttribute("rcode"));
                    if (rcode.matches(scode)) {
                        if (c != null) {
                            c.setValue(account + "ver");
                            response.setContentType("text/html");
                            response.addCookie(c);
                        }

//                        request.getSession().setAttribute("ver", "y-d");
                    } else {
                        msg += "Code does not match";
                    }
                } else if (method.equalsIgnoreCase("cquestion")) {

                    String ans = request.getParameter("ans");
                    if (ans.equals("")) {
                        msg += "Missing Answer <br>";
                    }
                    if (msg.isEmpty() || msg.equals("")) {
                        sql = "SELECT * FROM USERS WHERE Username='" + u.getUsername() + "'";
                        Statement s = conn.createStatement();
                        ResultSet r = s.executeQuery(sql);

                        if (r.next()) {
                            String sav2 = r.getString("SAV2");
                            String a = r.getString("Answer");

                            Optional<String> en_ans = AppSecurity.hashValue(ans, sav2);

                            boolean v = AppSecurity.verify(en_ans.get(), a, sav2);
                            if (en_ans.get().equalsIgnoreCase(a)) {
                                if (c != null) {
                                    c.setValue(account + "ver");
                                    response.setContentType("text/html");
                                    response.addCookie(c);
                                } else {
                                    c = new Cookie("account", "foundver");
                                    c.setPath("/VacTrackSys" + webloc);
                                    c.setSecure(true);
                                    c.setMaxAge(5*100);
                                    c.setHttpOnly(true);
                                    response.setContentType("text/html");
                                    response.addCookie(c);

                                }
                            } else {
                                msg += "Unable to reset password. <br>";
                            }

                        }
                        r.close();
                        s.close();
                    }
                }
                if (msg.isEmpty() || msg.equals("")) {

                }
            } else if (stp.equalsIgnoreCase("updatePasswd")) {
                String newpasswd = request.getParameter("upwd");
                String confpasswd = request.getParameter("confpasswd");
                String newhint = request.getParameter("newhint");
                Cookie[] c = null;
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
                    Optional<String> sav = AppSecurity.generateSalt();
                    Optional<String> en_p = AppSecurity.hashValue(newpasswd, sav.get());
//                    u.setPassword(en_p.get());
//                    salt = AppSecurity.generateSalt();
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
                                        + "Hint = ?,"
                                        + "SAV = ?"
                                        + "WHERE Username = ?;";
                                PreparedStatement ps = conn.prepareStatement(sql);
                                ps.setString(1, en_p.get());
                                ps.setString(2, stp);
                                ps.setString(3, sav.get());
                                ps.setString(4, u.getUsername());
                                int rc = ps.executeUpdate();
                                if (rc == 0) {
                                    msg += "Error: Cannot update password <br>";

                                    URL = webloc + "/Password_Reset.jsp";

                                } else {
                                    msg += "password reset success<br>";
                                    URL = webloc + "/index1.jsp";
                                    c = request.getCookies();
                                    if (c != null) {
                                        if (c.length > 0) {
                                            for (Cookie c1 : c) {
                                                c1.setValue("");
                                                c1.setMaxAge(0);
                                                response.addCookie(c1);
                                            }
                                        }
                                    }
                                }
                                ps.close();
                            }
                        }

                    } else {
                        msg += "Username not found in Database. <br>";
                    }
                    r.close();
                    s.close();

                }

            } else if (stp.equalsIgnoreCase("cancel")) {
                Cookie[] c = null;
                c = request.getCookies();
                if (c != null) {
                    if (c.length > 0) {
                        for (Cookie c1 : c) {
                            if (c1.getName().equals("account") || c1.getName().equals("act")
                                    || c1.getName().equals("rcode") || c1.getName().equals("ver")) {
                                c1.setValue("");
                                c1.setMaxAge(0);
                                response.addCookie(c1);
                            }

                        }
                    }
                }
                URL = webloc + "/index1.jsp";
            }
        } catch (ClassNotFoundException e) {
            msg += "Connection Error: " + e.getMessage() + "<br>";
            URL = webloc + "/Password_Reset.jsp";
        } catch (SQLException e) {
            msg += "Database Error:" + e.getMessage() + " <br>";
            URL = webloc + "/Password_Reset.jsp";
        } catch (Exception e) {
            msg += "Web Processing Error: " + e.getMessage() + ". Please Try Again Later. <br>";
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
