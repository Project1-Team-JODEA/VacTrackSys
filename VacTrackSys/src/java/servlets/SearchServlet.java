/**
 *
 * @author alexs
 */
package servlets;

import business.Patient;
import business.User;
import business.Vaccine;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
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
        String msg = "", sql = "", url = "", webloc = "";
        String ssn, fname, minit, lname, ptype, vsite, v1id, v2id, v3id, v4id;
        String vac_date="", dob="";
        ArrayList<Patient> patientset = new ArrayList<>();
        String[] vacs = {"", "", "", ""};
        String x = String.valueOf(request.getRequestURL());
        
        if (x.contains("DoctorLogin")) {
            webloc = "/DoctorLogin";

        } else if (x.contains("PatientLogin")) {
            webloc = "/PatientLogin";

        } else if (x.contains("AdminConsole")) {
            webloc = "/AdminConsole";

        }else if (x.contains("CDC")){
                webloc = "/CDC";
               }
        try {
            Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
            ServletContext context = getServletContext();
            String ur = context.getRealPath("/Team_JODEA1.accdb");
            Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
            // at the moment, I am putting off the ability to search with criteria
            // logic for searches will go here
            vacs[0] = String.valueOf(request.getParameter("v1id"));
            vacs[1] = String.valueOf(request.getParameter("v2id"));
            vacs[2] = String.valueOf(request.getParameter("v3id"));
            vacs[3] = String.valueOf(request.getParameter("v4id"));
            fname = String.valueOf(request.getParameter("fname"));
            lname = String.valueOf(request.getParameter("lname"));
            minit = String.valueOf(request.getParameter("midinit"));
            ssn = String.valueOf(request.getParameter("ssn"));
            dob = String.valueOf(request.getParameter("dob"));
            
            for (int i=0; i < vacs.length; i++){
                if (vacs[i].isEmpty() || vacs[i].equals("")){
                    vacs[i] = "N/A";
                }
            }
//            for (String vac : vacs) {
//                if (vac.isEmpty() || vac.equals("")) {
//                    // set to N/A
//                    vacs[vac] = "N/A";
//                }
//            }
            // in the meantime, searches will return the entire db
            // return 
            
            sql = "SELECT * FROM PATIENTS";
//                    + " WHERE Social_Security ='"+Integer.parseInt(ssn)+"'";
//            sql = "SELECT * FROM PATIENTS";
//            if (!vacs[0].equals("N/A")) {
//                sql += " OR Vaccine_1 = '"+vacs[0]+"'";
//            }
//            if (!vacs[1].equals("N/A")) {
//                sql += " OR Vaccine_2 ='"+vacs[1]+"'";
//            }
//            if (!vacs[2].equals("N/A")) {
//                sql += " OR Vaccine_3 ='"+vacs[2]+"'";
//            }
//            if (!vacs[3].equals("N/A")) {
//                sql += " OR Vaccine_4 ='"+vacs[3]+"'";
//            }
//                sql+="ORDER BY Social_Security;";

//            PreparedStatement ps = conn.prepareStatement(sql);
//            
         Statement s = conn.createStatement();
//            if (!vacs[0].equals("N/A")) {
//                ps.setString(2, vacs[0]);
//            }
//            if (!vacs[1].equals("N/A")) {
//                ps.setString(3, vacs[1]);
//            }
//            if (!vacs[2].equals("N/A")) {
//                ps.setString(4, vacs[2]);
//            }
//            if (!vacs[3].equals("N/A")) {
//                ps.setString(5, vacs[3]);
//            }ment();
            ResultSet r = s.executeQuery(sql);
            while (r.next()) {
                Patient pat = new Patient();
                pat.setSsn(String.valueOf(r.getInt("Social_Security")));
                //
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
            // Declaring variables to be used as search criteria
            String sssn = String.valueOf(request.getParameter("ssn"));
            String sfname = String.valueOf(request.getParameter("fname"));
            String sminit = String.valueOf(request.getParameter("midinit"));
            String slname = String.valueOf(request.getParameter("lname"));
            String sptype = String.valueOf(request.getParameter("pat_type"));
            String sdob = String.valueOf(request.getParameter("dob"));
            
            ArrayList<Patient> searchset = new ArrayList<>();
            // Each element of the patientset will be inspected to see if they
            // match the search criteria.  If they pass, they will be added to
            // a new patient set.  The new set will override the old one.
            
            for (int i = 0; i < patientset.size();  i++){
                Boolean match = true;
                if (sssn != null && !sssn.trim().equals("")){
                    if (!patientset.get(i).getSsn().equalsIgnoreCase(sssn.trim())){
                        match = false;
                    }
                }
                if (sfname != null && !sfname.trim().equals("")){
                    if (!patientset.get(i).getFname().equalsIgnoreCase(sfname.trim())){
                        match = false;
                    }
                }
                if (sminit != null && !sminit.trim().equals("")){
                    if (!patientset.get(i).getMname().equalsIgnoreCase(sminit.trim())){
                        match = false;
                    }
                }
                if (slname != null && !slname.trim().equals("")){
                    if (!patientset.get(i).getLname().equalsIgnoreCase(slname.trim())){
                        match = false;
                    }
                }
//                if (sptype != null && !sptype.trim().equals("Select")){
//                    if (!patientset.get(i).getPtype().equalsIgnoreCase(sptype.trim())){
//                        match = false;
//                    }
//                }
//                if (sdob != null && !sdob.trim().equals("")){
//                    if (!patientset.get(i).getDob().equalsIgnoreCase(sdob.trim())){
//                        match = false;
//                    }
//                }
                if (match){
                    searchset.add(patientset.get(i));
                }
            }
            
            // Overwrite the patientset with the filtered results
            patientset = searchset;
            
            request.getSession().setAttribute("patientset", patientset);
            User u = (User) request.getSession().getAttribute("u");
            u.setSearched(true);
            request.getSession().setAttribute("u", u);
            url = webloc + "/PatientRecords.jsp";
        } catch (Exception e) {
            msg += "Error: " + e.getMessage()+"<br>";
            url = webloc + "/VaccinationDB.jsp";
        }
 request.setAttribute("msg", msg);
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
