<%--
    Project Title
    File name  : error_404
    Date       : Apr 27, 2022, 2:45:52 PM
    Author(s)  : eVmPr
    Supporting File(s):
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.User" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="css/redirectstyle.css">
        <link rel="stylesheet" href="css/all.css">
        <link rel="icon" type="image/x-icon" href="image/favicon_16x16.png" />
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>

        <title>ERROR 500</title>
        <script>
            $(document).ready(() => {

            });
        </script>
    </head>
    <body>
        <div class="box-container">
            <div class="box">
                <%

                %>

                <h1 style="color: red"> Error 500 <i class="fas fa-exclamation-triangle"></i></h1>
                <p> Sorry. It Seems that an error occured while the webpage was proccessing your request.
                </p>
                <p>To Continue, click the Back button.</p>
                <br>

                <details style="float: left;" id="error">
                    <summary title="Click for Details">Error Details<i class="fas fa-chevron-right"></i></summary>
                    <div>
                        <ul>
                            <li>Error Type: ${pageContext.exception["class"]}</li>
                            <li>Message: ${pageContext.exception.message}</li>
                            <li>Cause: ${pageContext.exception.cause.message}</li>

                            <li><details>
                                    <summary>StackTrace Cause</summary>
                                        <c:forEach  var="tc" items="${pageContext.exception.cause.stackTrace}">
                                            ${tc}
                                        </c:forEach>
                                </details></li>
                            <li>  <details>
                                    <summary>StackTrace Exception</summary>
                                        <c:forEach  var="tx" items="${pageContext.exception.stackTrace}">
                                            ${tx}
                                        </c:forEach>
                                </details></li>
                        </ul>





                    </div>

                </details>
            </div>

        </div>
    </body>
</html>
