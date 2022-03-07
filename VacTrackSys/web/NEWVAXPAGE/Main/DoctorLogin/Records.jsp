<%--
    Project Title
    File name  : Update
    Date       : Mar 6, 2022, 2:11:34 PM
    Author(s)  : Elena Miller
    Supporting File(s): DBAction Servlet
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt"  uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Records</title>
    </head>
    <body>
        <h1>Records</h1>
        <p>
          Location:
          
        </p>
        <%--<c:if test="${u.access_level}"--%>
        <table>
            <tr>
                <th>SSN</th>
                <th>First Name</th>
                <th>Middle Init:</th>
                <th>Last Name:</th>
                <th>Vaccines:</th>
            </tr>
        </table>
    </body>
</html>
