<%-- Project JODEA File name : index1.jsp Date : Mar 6, 2022, 1:05:54 PM Author(s) : JaccobStanton, Elena Miller --%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Error</title>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
        <link rel="stylesheet" href="css/redirectstyle.css">
        <link rel="stylesheet" href="css/all.css">
        <link rel="icon" type="image/x-icon" href="image/favicon_16x16.png" />
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    </head>

    <body>
        <!--        <div class="hero">
                    <div class="form-box">
                        <form class="input-group">
                                            </form>
        
                        <div class="input-group">
        
                        </div>
                        
                        
                        
                    </div>
                </div>-->
        <div class="box-container">
            <div class="box">
                <h1 style="color: red"> Page Error  <i class="fas fa-exclamation-triangle"></i></h1>

                Uh oh! It looks like one of the following happened:
                <blockquote><ul>
                    <li>Your Session Had Expired.</li>
                    <li>Your User Account was not authenticated.</li>
                    <li>An Error occurred within the Server or Client.</li>
                    </ul></blockquote>
                You can return to the Home Page or 
                Go to the 1 of the login pages:
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