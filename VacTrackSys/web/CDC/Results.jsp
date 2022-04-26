<%--
    Project Title
    File name  : Update
    Date       : Mar 6, 2022, 2:11:34 PM
    Author(s)  : Elena Miller
    Supporting File(s): DBAction Servlet
--%>

<%@page import="business.User"%>
<%@page import="java.util.Scanner"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.io.FileReader"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html lang="en">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>CDC Report</title>
        <link rel="stylesheet" href="formstyle.css">
        <link rel="stylesheet" href="../css/all.css" type="text/css" />
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="icon" type="image/x-icon" href="../image/favicon_16x16.png"/>
        <link rel="stylesheet" href="../css/tablestyle.css" type="text/css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <script>
            $(document).ready(() => {
                $("#newReport").click(evt => {
                    $("#actiontype").val("NewReport");
                    document.reportaction.submit();
                    evt.preventDefault();
                });
            });
        </script>
    </head>
    <body>
        <div class="container" id="rs-form">
            <div class="title">Vaccination Report</div>
            <%
                User u = (User) request.getSession().getAttribute("u");
                String filename = "CDC REPORT-" + u.getUsername() + " .txt";
                String filepath = getServletContext().getRealPath("/WEB-INF/");
                BufferedReader br = new BufferedReader(new FileReader(getServletContext().getRealPath("/WEB-INF/CDC REPORT.txt")));
                String st = "";
                try {
                    while ((st = br.readLine()) != null) {
//                    x = br.
            %>
            <p><%= st%> <br></p>
                <%}
                        br.close();
                    } catch (Exception e) {
                    }%>

            <form action="CreateReport" id="reportaction" method="post">
                <div class="button">
                    <input type="submit" id="newreport" value="New Report">
                    &#8287;  &#8287;  &#8287;  &#8287; 
                    &#8287;  &#8287;  &#8287;  &#8287; 
                </div>

                <input type="hidden" name="actiontype" id="actiontype" value=""> 
                <a href="../download.jsp">Download Report</a>
                <br /><br />
                <a href="#Vaccination Report">Back To Top</a>

            </form>

        </div>


        <!--        <div class="container">
                    <span class="title">Patient Records</span>
                    <div class="content">
                        
                    </div>
                </div>-->

        <%--<c:if test="${u.access_level}"--%>

    </body>
</html>
