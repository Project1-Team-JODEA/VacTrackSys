<%--
    Project Title
    File name  : records
    Date       : Apr 27, 2022, 2:36:48 PM
    Author(s)  : eVmPr
    Supporting File(s):
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.time.LocalDate"%>
<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.Connection"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "x" uri="http://java.sun.com/jsp/jstl/xml" %>
<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page import="business.*" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="formstyle.css" type="text/css">
        <link rel="stylesheet" href="../css/all.css" type="text/css">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png">

        <title>Records</title>
    </head>
    <body>
        
        <div class="container" id="rs-form">
            <div class="title">Results</div>
            <div class="content" id="rs-content">


                <%
                    String sql = "", ssn, fname, minit, lname, vac_date = "", dob = "", ptype = "";
                    String[] fields = {"Social_Security", "First_Name", "Middle_Init", "Last_Name", "DOB", "P_Type"};
                    String[] filters = new String[6];
                    Class.forName("net.ucanaccess.jdbc.UcanaccessDriver");
                    ServletContext context = getServletContext();
                    String ur = context.getRealPath("/Team_JODEA1.accdb");
                    Connection conn = DriverManager.getConnection("jdbc:ucanaccess://" + ur);
                    String[] info = {ssn = "", fname = "", minit = "", lname = "", dob = "", ptype = ""};
                    //            ArrayList<Patient> patientset = new ArrayList<>();
                    ArrayList<String> newVal = new ArrayList<>();
                    ArrayList<Patient> pa;
                    info[0] = String.valueOf(request.getParameter("ssn"));
                    info[1] = String.valueOf(request.getParameter("fname"));
                    info[2] = String.valueOf(request.getParameter("lname"));
                    info[3] = String.valueOf(request.getParameter("midinit"));
                    info[4] = String.valueOf(request.getParameter("dob"));
                    info[5] = String.valueOf(request.getParameter("pat_type"));
                    
                    int isE = 0;
                    String newV = "";
                    for (int i = 0; i < info.length - 1; i++) {
                        if (info[i].isEmpty() || info[i].equals("") || info[i].equals("null")) {
                            info[i] = "N/A";
                            isE++;
                            filters[i] = info[i];
                        } else {
                            // adds a new condition clause for WHERE clause
                            if (fields[i].equals("Social_Security")) {
                                String[] nums = info[i].split("-");
                                newV = fields[i] + "=" + info[i];
                                filters[i] = newV; //String.valueOf(newV);

                            } else if (fields[i].equals("DOB")) {
                                //format date
                                DateTimeFormatter dob_format = DateTimeFormatter.ofPattern("dd-MMM-yy");
                                newV = fields[i] + "='" + String.valueOf(dob_format.format(LocalDate.parse(info[i]))) + "'";
                                filters[i] = newV;//
                            } else {
                                newV = fields[i] + "='" + info[i] + "'";
                                filters[i] = String.valueOf(newV);
                            }
                            newVal.add(filters[i]);// add value to array list

                        }
                    }
                    sql = "SELECT * FROM PATIENTS";//SELECT 
                    //                        + " WHERE Social_Security='" + ssn + "';";
                    String sqlw = " WHERE ";
                    newVal.remove("");
                    newVal.remove("null");
                    // Create a new Array from ArrayList
                    String[] rs = newVal.toArray(new String[newVal.size()]);
                    String val = "";
                    if (rs.length == 1) {
                        val = rs[0];
                        sqlw += val;
                    } else {//Add 'AND' if more than one condition
                        for (int i = 0; i < rs.length; i++) {
                            if (!rs[i].equalsIgnoreCase("N/A") && !rs[i].equalsIgnoreCase("null")
                                    && !rs[i].equalsIgnoreCase(null)) {
                                val = rs[i];
                                //                                System.out.println("value = " + val);

                                if (i < rs.length - 1 && !rs[i].equalsIgnoreCase("N/A")) {//&& !filters[i].equalsIgnoreCase("N/A")
                                    sqlw += val + " AND ";//Adds 'AND' in between each condition 
                                } else {
                                    sqlw += val;
                                }
                            }
                        }
                    }
                    //add sqlw to sql variable
                    sql += sqlw;// + ";";
                    Statement s = conn.createStatement();
                    ResultSet r = s.executeQuery(sql);
                %>

                <table>
                    <thead>
                    <th>Social Security Number (SSN)</th>
                    <th>First Name</th>
                    <th>Middle Initial</th>
                    <th>Last Name</th>
                    <th>Date of Birth</th>
                    <th>Patient Type</th>
                    </thead>
                    <tbody>
                        <%    if (r.next()) {
                                String s1 = String.valueOf(r.getInt("Social_Security"));
                                String ssn2 = "***-**" + s1.substring(5, s1.length() - 1);

                        %>
                    <td><%= ssn2%></td>
                    <td><%= r.getString("First_Name")%></td>
                    <td><%= r.getString("Middle_Init")%></td>
                    <td><%= r.getString("Last_Name")%></td>
                    <td><%= String.valueOf(r.getDate("DOB"))%></td>
                    <td><%= r.getString("P_Type")%></td>
                    <%while (r.next()) {
                            s1 = String.valueOf(r.getInt("Social_Security"));
                            ssn2 = "***-**" + s1.substring(5, s1.length() - 1);

                    %>

                    <td><%= ssn2%></td>
                    <td><%= r.getString("First_Name")%></td>
                    <td><%= r.getString("Middle_Init")%></td>
                    <td><%= r.getString("Last_Name")%></td>
                    <td><%= String.valueOf(r.getDate("DOB"))%></td>
                    <td><%= r.getString("P_Type")%></td>
                    </tbody>
                </table>
                <% }
                    }else{
%><p>Could not find the request record.</p>
                <%
}
                    r.close();
                    s.close();
                %>

            </div>
        </div>
    </body>
</html>
