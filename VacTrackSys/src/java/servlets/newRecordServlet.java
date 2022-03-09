/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
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
import java.sql.Statement;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author eVmPr
 */
public class newRecordServlet extends HttpServlet {

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
        String msg = "", sql = "", url = "", webloc = "";
        String ssn, fname, minit, lname, ptype, vsite, v1id, v2id, v3id, v4id;
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
//            vacs[0] = String.valueOf(request.getParameter("v1id"));
//            vacs[1] = String.valueOf(request.getParameter("v2id"));
//            vacs[2] = String.valueOf(request.getParameter("v3id"));
//            vacs[3] = String.valueOf(request.getParameter("v4id"));
//            for (int i=0; i < vacs.length; i++){
//                if (vacs[i].isEmpty() || vacs[i].equals("")){
//                    vacs[i] = "N/A";
//                }
//            }
//            for (String vac : vacs) {
//                if (vac.isEmpty() || vac.equals("")) {
//                    // set to N/A
//                    vacs[vac] = "N/A";
//                }
//            }
            // in the meantime, searches will return the entire db
            fname = String.valueOf(request.getParameter("fname"));
            lname = String.valueOf(request.getParameter("lname"));
            minit = String.valueOf(request.getParameter("midinit"));
            ssn = String.valueOf(request.getParameter("ssn"));
            ptype = String.valueOf(request.getParameter("pat_type"));
            v1id = String.valueOf(request.getParameter("v1id"));
            v2id = String.valueOf(request.getParameter("v2id"));
            v3id = String.valueOf(request.getParameter("v3id"));
            v4id = String.valueOf(request.getParameter("v4id"));
            
            sql = "INSERT INTO PATIENTS(Social_Security, First_Name, Middle_Init,Last_Name,P_Type,"
                    + "Vaccine_ID, Vaccination_Site, Vaccine_1, Vaccine_2, Vaccine_3, Vaccine_4)"
                    + "VALUES (?,?,?,?,?,'1234565', ?, ?, ?,?, ?);"
                ;

            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(ssn));
            ps.setString(2, fname);
            ps.setString(3, minit);
            ps.setString(4, ptype);
            Patient pat = new Patient();
                pat.setSsn(String.valueOf(ssn));
                //
                pat.setFname(fname);
                pat.setMname(minit);
                pat.setLname(lname);
                pat.setPtype(ptype); 
                 Vaccine vac1 = new Vaccine();
                vac1.setVid(v1id);
                pat.setVac1(vac1);
                Vaccine vac2 = new Vaccine();
                vac2.setVid(v2id);
                pat.setVac2(vac2);
                Vaccine vac3 = new Vaccine();
                vac3.setVid(v3id);
                pat.setVac3(vac3);
                Vaccine vac4 = new Vaccine();
                vac4.setVid(v4id);
                pat.setVac4(vac4);
//            
//         Statement s = conn.createStatement();
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
            int r = ps.executeUpdate(sql);
           if (r == 0){
                msg = "Error: Unable to Add Record <br>";
                
           } else{ 
               msg = "Record Added! <br>";
           }
//            r.close();
            ps.close();
            
            User u = (User) request.getSession().getAttribute("u");
            u.setSearched(true);
            request.getSession().setAttribute("u", u);
            url = webloc + "/VaccinationDB.jsp";
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
