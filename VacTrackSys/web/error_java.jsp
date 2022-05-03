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
        <style>
            /*
Team Name: J.O.D.E.A.
Project:Vaccination Tracking System 
School: STLCC
Members: Elena Miller, Jaccob Stanton, Deshane Sims,
Alexander Breitnebach, and Osama Aater
            */

            /* 
                Created on : Mar 29, 2022, 1:13:24 PM
                Author     : eVmPr
            */

            *{
                margin: 0;
                padding: 0;
                font-family: sans-serif;
            }
            :root{
                --green:#16a085;
                --black:#444;
                --light-color:#777;
                --box-shadow:.5rem .5rem 0 rgba(22, 160, 133, .2);
                --text-shadow:.4rem .4rem 0 rgba(0, 0, 0, .2);
                --border:.2rem solid var(--green);
            }
            .btn{
                display: inline-block;
                margin-top: 1rem;
                padding: .5rem;
                padding-left: 1rem;
                /*padding-right: .5rem;*/
                border:var(--border);
                border-radius: .5rem;
                box-shadow: var(--box-shadow);
                color:var(--green);
                cursor: pointer;
                font-size: 1.5rem;
                background: #fff;
            }
            details summary{
                
            }
            .btn span{
                /*display: inline-block;*/
                padding:.7rem 1rem;
                border-radius: .5rem;
                background: var(--green);
                color:#fff;
                
            }

            .btn:hover{
                background: var(--green);
                color:#fff;
            }
            .btn:hover span{
                color: var(--green);
                background:#fff;
                margin-left: 1rem;
            }

            .toggle-btn{
                padding: 10px 30px;
                cursor: pointer;
                background: transparent;
                border: 0;
                outline: none;
                position: relative;
            }

          details summary{
                display: inline-block; 
                box-shadow: var(--box-shadow);
                color: var(--green);
                border-radius: .5rem;
                box-shadow: var(--box-shadow);
                cursor: pointer;
                font-size: 1em;
                background: #fff;
            }
            details li {
               
            }
            
            details summary:hover{
                background: var(--green);
                color:#fff;
            }
            #btn{
                top: 0;
                left: 0;
                position: absolute;
                width: 110px;
                height: 100%;
                background: linear-gradient(to right, #ff105f, #ffad06);
                border-radius: 30px;
                transition: .5s;
            }

            ul#rlist {
                display: block;
                float: left;
            }
            ul li {
                text-align: left;
                list-style: none;
            }
            .box{
                border:var(--border);
                box-shadow: var(--box-shadow);
                border-radius: .5rem;
                padding:2.0rem;
                background: #fff;
                text-align: center;
                position: relative;
                overflow: scroll;
                z-index: 0;
                width: 500px;
                margin: 4% auto;
            }
            
            .input-group{
                top: 180px;
                position: absolute;
                width: 280px;
                transition: .5s;
                max-height: 375px;
                overflow-y: auto;
            }
            .heading{
                text-align: center;
                padding-bottom: 2rem;
                text-shadow: var(--text-shadow);
                text-transform: uppercase;
                color:var(--black);
                font-size: 5rem;
                letter-spacing: .4rem;
            }
            

            span{
                color: #777;
                font-size: 12px;
                bottom: 68px;
                position: absolute;
            }


        </style>
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

                <details id="error">
                    <summary title="Click for Details">Error Details<i class="fas fa-chevron-right"></i></summary>
                    <div class="det">
                        <ul>
                            <li>Error Type: ${pageContext.exception["class"]}</li>
                            <li>Message: ${pageContext.exception.message}</li>
                            <li>Cause: ${pageContext.exception.cause.message}</li>

                            <li><details>
                                    <summary>StackTrace Cause</summary>
                                    <c:forEach  var="tc" items="${pageContext.exception.cause}">
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
