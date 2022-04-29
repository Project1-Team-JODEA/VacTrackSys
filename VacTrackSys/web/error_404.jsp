<%--
    Project Title
    File name  : error_404
    Date       : Apr 27, 2022, 2:45:52 PM
    Author(s)  : eVmPr
    Supporting File(s):
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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

        <title>ERROR 404</title>
    </head>
    <body>
        <div class="box-container">
            <div class="box">
                <h1 style="color: red"> Error 404 <i class="fas fa-exclamation-triangle"></i></h1>
                    Sorry! The page/file you requested does not 
                    
                <br>
                <ul id="rlist">
                    <li class="rlist-item"><a href="CDC/index1.jsp" class="btn"><i class="fas fa-user-md"></i>
                            CDC Login <i class="fas fa-chevron-right"></i>
                        </a></li>
                    <li class="rlist-item"><a href="DoctorLogin/index1.jsp" class="btn">
                            <i class="fas fa-ambulance"></i> Healthcare <br> Provider
                            Login <i class="fas fa-chevron-right"></i>
                        </a></li>
                    <li class="rlist-item"><a href="PatientLogin/index1.jsp" class="btn">
                            <i class="fas fa-notes-medical"></i> Patient Portal <i class="fas fa-chevron-right"></i>
                        </a></li>
                    <li class="rlist-item"><a href="AdminConsole/index1.jsp" class="btn">
                            <i class="fas fa-pills"></i> Administrator <br>Login<i class="fas fa-chevron-right"></i>
                        </a></li>
                    <li class="rlist-item"><a href="index.html" class="btn">
                            <i class="fas fa-home"></i>Home<i class="fas fa-chevron-right"></i></a></li>   
                </ul>
            </div>

        </div>
    </body>
</html>
