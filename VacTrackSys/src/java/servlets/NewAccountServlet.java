/**
 *
 * @author Elena Miller, Alexander Breitenbach
 */
package servlets;

import business.*;
//import business.AppSecurity;
import java.io.IOException;
import static java.lang.Math.random;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.security.*;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.crypto.*;
import javax.servlet.*;
import java.util.Random;
import javax.crypto.spec.PBEKeySpec;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "NewAccountServlet", urlPatterns = {"/CDC/NewAccount", "/Member/NewAccount", "/DoctorLogin/NewAccount"})
public class NewAccountServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOExcepti'on if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        String URL = "", confpasswd = "", //en_passwd = "",
                chars = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        Matcher m;
        Boolean pver = false;
        Optional<String> salt = Optional.empty(), saen_passwdlt = Optional.empty();
        String msg = "", sql = "", testmsg = "", webloc = "", ac_lvl = ""; //ac_lvl = access level
        // Check Location in web
        Pattern pattern;
        String hint = "";
        int isChar = 0, isDigit = 0;
        String x = String.valueOf(request.getRequestURL());
        if (x.contains("DoctorLogin")) {
            webloc = "/DoctorLogin";
            ac_lvl = "MedicalStaff";
        } else if (x.contains("PatientLogin")) {
            webloc = "/PatientLogin";
            ac_lvl = "Patient";
        } else if (x.contains("AdminConsole")) {
            webloc = "/AdminConsole";
            ac_lvl = "Admin";
        } else if (x.contains("CDC")) {
            webloc = "/CDC";
            ac_lvl = "CDC";
        }
        try {//Connecting to database
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            User u = new User();
            // set user object
            String uid = String.valueOf(request.getParameter("uid"));
            u.setUsername(String.valueOf(request.getParameter("uid")));
            String em = String.valueOf(request.getParameter("email"));
            u.setEmail(em);
            u.setQuestion(String.valueOf(request.getParameter("quest")));
            u.setAnswer(String.valueOf(request.getParameter("answer")));
            testmsg += u.getUsername();
            testmsg += u.getEmail();
            confpasswd = String.valueOf(request.getParameter("confpasswd").trim());
            hint = String.valueOf(request.getParameter("hint"));
            u.setPassword(String.valueOf(request.getParameter("upwd").trim()));
            if (x.contains("AdminConsole") || x.contains("DoctorLogin")) {
                if (request.getParameter("loc").equals("") || request.getParameter("loc").isEmpty()) {
                    msg += "Location Missing. <br>";
                } else {
                    u.setLocation(request.getParameter("loc"));
                }
            } else if (x.contains("PatientLogin") || x.contains("CDC")) {
                u.setLocation("online");
            } else {
                u.setLocation("First Hospital East");
            }
            u.setAccesslevel(ac_lvl);
            
//            Signature sign = Signature.getInstance("SHA256withDSA");
            if (u.getUsername().equals("")) {
                msg += "Please enter username. <br>";
            } else {
                if (u.getUsername().length() < 8) {
                    msg += "Username Must be at least 8 characters. <br>";
                }
            }
            if (u.getPassword().equals("")) {
                msg += "Please enter password. <br>";
            } else {//encrypt password by hashing
                if (u.getPassword().length() < 15) {
                    msg += "Password must be 15 characters long.<br>";
                } else {
                }
            }
            if (confpasswd.equals("")) {
                msg += "Password Invalid. Please Confirm Password <br>";
            }
            if (u.getEmail().equals("")) {
                msg += "Missing Email Address. <br>";
            } else {
                String regex_email = "^[A-Za-z0-9+_.-]+@(.+)*$";
                String reg_email = "(?=.{1,64}@)[A-Za-z0-9_-]+(\\\\.[A-Za-z0-9_-]+)*@[^-][A-Za-z0-9-]+(\\\\.[A-Za-z0-9-]+)*(\\\\.[A-Za-z]{2,})$";
                pattern = Pattern.compile(regex_email);
                m = pattern.matcher(u.getEmail());
                boolean ma = m.matches();
                boolean mf = m.find();
                if (!m.matches()) {
                    msg += "invalid email. <br>";
                }
            }
            if (hint.equals("") || hint.isEmpty()) {
                msg += "Missing Hint";
            }
            if (u.getQuestion().equals("")) {
                msg += "Missing Security Question. <br>";

            }
            if (u.getAnswer().equals("")) {
                msg += "Missing Security Question Answer. <br>";
            }
            /* check for password characters. */
//            
            if (webloc == "CDC" || webloc == "PatienLogin") {
                if (u.getPassword().length() < 10) {
                    msg += "Password must be at least 10 characters. <br>";
                }
            } else if (webloc == "DoctorLogin" || webloc == "AdminConsole") {
                if (u.getPassword().length() < 15) {
                    msg += "Password must be at least 15 characters. <br>";
                }

            }
            if (!webloc.equals("PatientLogin")) {
                // check

            }
            if (webloc.equals("DoctorLogin")) {
                // must be 12 chatacters
                if (u.getUsername().equals("")) {
                    msg += "Please enter username. <br>";
                }
                if (u.getPassword().equals("")) {
                    msg += "Please enter password. <br>";
                } else {
                    if (u.getPassword().length() < 15) {
                        msg += "Password must be 15 characters long.<br>";
                    } else {

                    }
                }
                if (confpasswd.equals("") || !confpasswd.matches(u.getPassword())) {
                    msg += "Password Invalid. Please Confirm Password <br>";
                } else {
                    if (confpasswd.equalsIgnoreCase(u.getPassword())) {
                        //encrypt passwd

//                        Optional<String> en_conf = AppSecurity.hashValue(u.getPassword(), salt.get());
                    }
                }
                if (u.getEmail().equals("")) {
                    msg += "Missing Email Address. <br>";
                } else {
                    // validate email
                }
                if (u.getLocation().equals("")) {
                    msg += "Missing Location. <br>";
                }

                char c;
                //  10 characters must be numbers
                for (int i = 0; i < u.getUsername().length(); i++) {
                    c = u.getUsername().charAt(i);
                    if (c < 2 && Character.isDigit(c)) {
                        isDigit++;
                    }//else if ()
                    if (isDigit < 10) {
                        msg += "Employee ID must be all digits. <br>";
                    }
                }
                //send security code

            }
//            String encryptedPasswd = AppSecurity.encrypt(u.getPassword());
            /* validate Email */
//            pattern = Pattern.compile("[a-zA-Z0-9]+?+@[a-zA-Z]\\p{\\}");
//            
            //pattern = Pattern.compile("(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*:(?:(?:\\r\\n)?[ \\t])*(?:(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*)(?:,\\s*(?:(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*|(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)*\\<(?:(?:\\r\\n)?[ \\t])*(?:@(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*(?:,@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*)*:(?:(?:\\r\\n)?[ \\t])*)?(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\"(?:[^\\\"\\r\\\\]|\\\\.|(?:(?:\\r\\n)?[ \\t]))*\"(?:(?:\\r\\n)?[ \\t])*))*@(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*)(?:\\.(?:(?:\\r\\n)?[ \\t])*(?:[^()<>@,;:\\\\\".\\[\\] \\000-\\031]+(?:(?:(?:\\r\\n)?[ \\t])+|\\Z|(?=[\\[\"()<>@,;:\\\\\".\\[\\]]))|\\[([^\\[\\]\\r\\\\]|\\\\.)*\\](?:(?:\\r\\n)?[ \\t])*))*\\>(?:(?:\\r\\n)?[ \\t])*))*)?;\\s*)");
            if (msg.isEmpty() || msg.equals("")) {
                //encrypt values
                salt = AppSecurity.generateSalt();
                Optional<String> en_p = AppSecurity.hashValue(u.getPassword(), salt.get());

                u.setPassword(en_p.get());
                Optional<String> salt2 = AppSecurity.generateSalt();//, salt3 =AppSecurity.generateSalt() ;
                Optional<String> ans = AppSecurity.hashValue(u.getAnswer(), salt2.get());
//                Optional<String> ques = AppSecurity.hashValue(u.getQuestion(), salt2.get());
//                u.setQuestion(ques.get());
                u.setAnswer(ans.get());
// Add validation to look for duplicate usernames (Primary Key)
                String sqlcheck = "SELECT Username FROM USERS WHERE Username='" + u.getUsername() + "';";
                Statement s = conn.createStatement();
                ResultSet rs = s.executeQuery(sqlcheck);
                if (rs.next()) {
                    msg += "Username already exists. <br>";
                    rs.close();
                    s.close();
                } else {
                    sql = "INSERT INTO USERS (Username, Password, "
                            + "Access_Level, Email_Address, Location, Hint,"
                            + " Question, Answer, SAV, SAV2)"
                            + " VALUES (?, ?, ?, ?, ?, ?,?,?, ?, ?)";
                    PreparedStatement ps = conn.prepareStatement(sql);

                    ps.setString(1, u.getUsername());
                    ps.setString(2, u.getPassword());
                    ps.setString(3, u.getAccesslevel());
                    ps.setString(4, u.getEmail());
                    ps.setString(5, u.getLocation());
                    ps.setString(6, hint);
                    ps.setString(7, u.getQuestion());
                    ps.setString(8, u.getAnswer());
                    ps.setString(9, salt.get());
                    ps.setString(10, salt2.get());
                    int rc = ps.executeUpdate();
                    if (rc == 0) {
                        msg += "User not added. <br>";
                    } else if (rc == 1) {
                        msg += "User added. <br>";
                        
                        request.getSession().setAttribute("UserLocation", u.getLocation());
                        request.getSession().setAttribute("UserAccessLevel", u.getAccesslevel());
                        
                    } else {
                        msg += "Warning: multiple records updated. <br>";
                    }
                    ps.close();
                }

            }

        } catch (ClassNotFoundException ex) {
            msg = "Error: Class Not Found. <br>";
        } catch (SQLException ex) {
            msg += "Connection Error: " + ex.getMessage() + "<br>";
        } catch (Exception e) {
            //Logger.getLogger(NewAccountServlet.class.getName()).log(Level.SEVERE, null, ex);
            msg += "Servlet Error: " + e.getMessage() + "<br>";
        }
        URL = webloc + "/index1.jsp";
        request.setAttribute("msg", msg);
        RequestDispatcher disp = getServletContext().getRequestDispatcher(URL);
        disp.forward(request, response);

    }

    /**
     * Takes Password, Encrypts it and returns encrypted password
     *
     * @param password
     * @return
     */
    private String getEncryptPasswd(String password) throws NoSuchAlgorithmException {
        String en_passwd = "", sha = "SHA";
        // create key pair
        //Creating KeyPair generator object
        KeyPairGenerator kpg = KeyPairGenerator.getInstance("DSA");
        // initialize keypairgeneraotr
        kpg.initialize(2048);
        KeyPair pair = kpg.generateKeyPair();
        PrivateKey pk = pair.getPrivate();
        PublicKey pubk = pair.getPublic();
        Signature sign = Signature.getInstance("");
        return en_passwd;
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
