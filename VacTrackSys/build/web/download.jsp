<%--
    Project Title
    File name  : download
    Date       : Apr 26, 2022, 2:41:18 PM
    Author(s)  : eVmPr
    Supporting File(s):
--%>

<%@page import="business.User"%>
<%@page import="java.io.FileInputStream"%>
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta http-equiv=""
              <title>Report Download</title>
    </head>
    <body>
        <%
            User u = (User) request.getSession().getAttribute("u");
            String filename = "CDC REPORT-" + u.getUsername() + " .txt";
            String filepath = getServletContext().getRealPath("/WEB-INF/");
            response.setContentType("APPLICATION/OCTET-STREAM");
            response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\"");
            java.io.FileInputStream fileInputStream = new java.io.FileInputStream(filepath + filename);
            int i;
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
            fileInputStream.close();
            while ((i = fileInputStream.read()) != -1) {
                out.write(i);
            }
            fileInputStream.close();
            out.close();
        %>
    </body>
</html>
