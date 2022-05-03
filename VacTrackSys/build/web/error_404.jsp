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
        <!--<link rel="stylesheet" href="css/redirectstyle.css">-->
        <link rel="stylesheet" href="css/all.css">
        <link rel="icon" type="image/x-icon" href="image/favicon_16x16.png" />
        <script src="https://kit.fontawesome.com/98e4c48f68.js" crossorigin="anonymous"></script>
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">

        <style>
            *{
                margin: 0;
                padding: 0;
                font-family: sans-serif;
            }

            :root{
                --green: #16a085;
                --black: #444;
                --light-color:#777;
                --box-shadow:.5rem .5rem 0 rgba(22, 160, 133, .2);
                --text-shadow:.4rem .4rem 0 rgba(0, 0, 0, .2);
                --border:.2rem solid var(--green);
            }
            html{ 
                font-size: 62.5%;

                  /*overflow-x: hidden;*/
                  scroll-padding-top: 7rem;
                  scroll-behavior: smooth;
                  padding:2rem 9%;

            }
            section {
                padding: 2rem 9%;
                height: 100vh; 
            }
            .box-container{
                display: grid;
                grid-template-columns: repeat(auto-fit, minmax(27rem, 1fr));
                gap:2rem;
                
            }


            #heading{

                text-align: center;

            }
            #heading h1{
                text-transform: uppercase;
                font-size: 3em;
                color: red;
            }
            #heading p{
                font-size: 1.25em; 
            }
            .box-container .box{
                background:#fff;
                border-radius: .5rem;
                box-shadow: var(--box-shadow);
                border: var(--border);
                padding: 2.5rem;
                /*                width: 50%;
                                height: 50%;*/
                border-radius: .5rem;
                /*padding:2.0rem;*/
                /*text-align: center;*/
                /*position: relative;*/
                /*overflow: hidden;*/
                z-index: 0;
                /*width: 500px;*/
                /*margin: 4% auto;*/
            }
            .box-container .box i{
                color: var(--green);
                font-size: 5rem;
                padding-bottom: .5rem;
            }

            .box-container .box h3{
                color: var(--black);
                font-size: 2.5rem;
                padding:1rem 0;
            }

            .box-container .box p{
                color: var(--light-color);
                font-size: 1.4rem;
                line-height: 2;
            }

            .btn{
                display: inline-block;
                margin-top: 1rem;
                padding: .5rem;
                padding-left: 1rem;
                padding-right: .5rem;
                border:var(--border);
                border-radius: .5rem;
                box-shadow: var(--box-shadow);
                color:var(--green);
                cursor: pointer;
                font-size: 1.5rem;
                background: #fff;
            }
            .btn span{
                /*display: inline-block;*/
                padding:.7rem 1rem;
                border-radius: .5rem;
                background: var(--green);
                color:#fff;
                margin-left: .5rem;
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

            #error summary{
                display: inline-block; 
                box-shadow: var(--box-shadow);
                color: var(--green);
                border-radius: .5rem;
                box-shadow: var(--box-shadow);
                cursor: pointer;
                font-size: 1rem;
                background: #fff;
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
            .box{
              
            }
           
            span{
                color: #777;
                font-size: 12px;
                bottom: 68px;
                /*position: absolute;*/
            }
            .btn{
                display: inline-block;
                margin-top: 1rem;
                padding: .5rem;
                padding-left: 1rem;
                border:var(--border);
                border-radius: .5rem;
                box-shadow: var(--box-shadow);
                color:var(--green);
                cursor: pointer;
                font-size: 1.7rem;
                background: #fff;
            }
            .btn span{
                padding:.7rem 1rem;
                border-radius: .5rem;
                background: var(--green);
                color:#fff;
                margin-left: .5rem;
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
            /* media queries  */
            @media (max-width:991px){

                html{
                    font-size: 55%;
                }

                .header{
                    padding: 2rem;
                }

                section{
                    padding:2rem;
                }

            }
            @media (max-width:450px){
                html{
                    font-size: 50%;
                }

            }

        </style>
        <title>ERROR 404</title>
    </head>
    <body>
        <section id="error">
            <div id="heading">
                <h1> Error 404 <i class="fas fa-exclamation-triangle"></i>
                </h1>
                <p style="font-size: 1.5em; padding: 1% 0;">
                    Sorry. The page/file you requested does not exist. 
                    
                </p>  
            </div>
            <div class="box-container">
                
             
<!--                <div class="box">
                    <i class="fas fa-home"></i>
                    <h3>Home</h3>
                    <p>Return to Home page</p>
                    <a href="index.html" class="btn"> Home <span class="fas fa-chevron-right"></span> </a>
                </div>

                <div class="box">
                    <i class="fas fa-ambulance"></i>
                    <h3>Healthcare <br> Provider Login</h3>
                    <p>Healthcare Provider Sign In with your hospital credentials</p>
                    <a href="DoctorLogin/index1.jsp" target="_blank" class="btn"> login <span class="fas fa-chevron-right"></span> </a>
                </div>

                <div class="box">
                    <i class="fas fa-user-md"></i>
                    <h3>CDC Tracking</h3>
                    <p>View the dataset the CDC has on vaccine doses.</p>
                    <a href="https://covid.cdc.gov/covid-data-tracker/#datatracker-home" target="_blank"  class="btn"> learn more <span class="fas fa-chevron-right"></span> </a>
                </div>
                <div class="box">
                    <i class="fas fa-user-md"></i>
                    <h3>CDC Login</h3>
                    <p>Sign in to view Report (For CDC Employees).</p>
                    <a href="CDC/index1.jsp" class="btn"> Login <span class="fas fa-chevron-right"></span> </a>
                </div>
                <div class="box">
                    <i class="fas fa-pills"></i>
                    <h3>Administrative Login</h3>
                    <p>Administrative access only.</p>
                    <a href="AdminConsole/INDEX.html" class="btn"> login <span class="fas fa-chevron-right"></span> </a>
                </div>-->

                
            </div>
        </section>
    </body>
</html>
