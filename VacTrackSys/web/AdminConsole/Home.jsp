<%--
    Project Title
    File name  : Home
    Date       : Mar 6, 2022, 2:37:18 PM
    Author(s)  : eVmPr
    Supporting File(s):
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta http-equiv="X-UA-Compatible" contents="IE=edge">
        <link rel="stylesheet" href="styles.css">
        <script src="https://kit.fontawesome.com/926f93a20f.js" crossorigin="anonymous"></script>
        <title>Admin View</title>
    </head>
    <body>
        <div class="container">
            <div class="sidebar">
                <ul>
                    <li>
                        <a href="#">
                            <i class="fa-solid fa-house-medical"></i>
                            <div class="title">ADMINISTRATION </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-th-large"></i>
                            <div class="title">Dashboard </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-stethoscope"></i>
                            <div class="title">Appointments </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-user-md"></i>
                            <div class="title">Doctors on Staff </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-puzzle-piece"></i>
                            <div class="title">Departments </div>
                        </a>
                    </li> <li>
                        <a href="#">
                            <i class="fas fa-hand-holding-usd"></i>
                            <div class="title">Payments </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-cog"></i>
                            <div class="title">Settings </div>
                        </a>
                    </li>
                    <li>
                        <a href="#">
                            <i class="fas fa-question"></i>
                            <div class="title">Help </div>
                        </a>
                    </li>
                </ul>
            </div>
            <div class="main">
                <div class="top-bar">
                    <div class="search">
                        <input type="text" name="search" placeholder="search here">
                        <label for="search"><i class="fas fa-search"></i></label>
                    </div>
                    <i class="fas fa-bell"></i>
                    <div class="user">
                        <img src="doctor1.jpg" alt="">
                    </div>
                </div>
                <div class="cards">
                    <div class="card">
                        <div class="card-content">
                            <div class="number">67</div>
                            <div class="card-name">Appointments</div>
                        </div>
                        <div class="icon-box">
                            <i class="fas fa-briefcase-medical"></i>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-content">
                            <div class="number">105</div>
                            <div class="card-name">New Patients</div>
                        </div>
                        <div class="icon-box">
                            <i class="fas fa-wheelchair"></i>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-content">
                            <div class="number">8</div>
                            <div class="card-name">Operations</div>
                        </div>
                        <div class="icon-box">
                            <i class="fas fa-bed"></i>
                        </div>
                    </div>
                    <div class="card">
                        <div class="card-content">
                            <div class="number">$4500</div>
                            <div class="card-name">Earnings</div>
                        </div>
                        <div class="icon-box">
                            <i class="fas fa-dollar-sign"></i>
                        </div>
                    </div>
                </div>
                <div class="tables">
                    <div class="last-appointments">
                        <div class="heading">
                            <h2>Last Appointments</h2>
                            <a href="#" class="btn">View All</a>
                        </div>
                        <table class="appointments">
                            <thead>
                            <td>Name</td>
                            <td>Doctor</td>
                            <td>Condition</td>
                            <td>Actions</td>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Liam Smith Doe</td>
                                    <td>Dr. Benjamin</td>
                                    <td>Fracture</td>
                                    <td>
                                        <i class="far fa-eye"></i>
                                        <i class="far fa-edit"></i>
                                        <i class="far fa-trash-alt"></i>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Liam Smith Doe</td>
                                    <td>Dr. Benjamin</td>
                                    <td>Fracture</td>
                                    <td>
                                        <i class="far fa-eye"></i>
                                        <i class="far fa-edit"></i>
                                        <i class="far fa-trash-alt"></i>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Liam Smith Doe</td>
                                    <td>Dr. Benjamin</td>
                                    <td>Fracture</td>
                                    <td>
                                        <i class="far fa-eye"></i>
                                        <i class="far fa-edit"></i>
                                        <i class="far fa-trash-alt"></i>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Liam Smith Doe</td>
                                    <td>Dr. Benjamin</td>
                                    <td>Fracture</td>
                                    <td>
                                        <i class="far fa-eye"></i>
                                        <i class="far fa-edit"></i>
                                        <i class="far fa-trash-alt"></i>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Liam Smith Doe</td>
                                    <td>Dr. Benjamin</td>
                                    <td>Fracture</td>
                                    <td>
                                        <i class="far fa-eye"></i>
                                        <i class="far fa-edit"></i>
                                        <i class="far fa-trash-alt"></i>
                                    </td>
                                </tr>
                                <tr>
                                    <td>Liam Smith Doe</td>
                                    <td>Dr. Benjamin</td>
                                    <td>Fracture</td>
                                    <td>
                                        <i class="far fa-eye"></i>
                                        <i class="far fa-edit"></i>
                                        <i class="far fa-trash-alt"></i>
                                    </td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                    <div class="doctor-visiting">
                        <div class="heading">
                            <h2>Doctor Visiting</h2>
                            <a href="#" class="btn">View All</a>
                        </div>
                        <table class="visiting">
                            <thead>
                            <td>Photo</td>
                            <td>Name</td>
                            <td>Visit time</td>
                            <td>Detail</td>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>
                                        <div class="img-box-small">
                                            <img src="doctor1.jpg" alt="">
                                        </div>
                                    </td>
                                    <td>Benjamin</td>
                                    <td>14:00</td>
                                    <td><i class="far fa-eye"></i></td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="img-box-small">
                                            <img src="doctor1.jpg" alt="">
                                        </div>
                                    </td>
                                    <td>Benjamin</td>
                                    <td>14:00</td>
                                    <td><i class="far fa-eye"></i></td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="img-box-small">
                                            <img src="doctor1.jpg" alt="">
                                        </div>
                                    </td>
                                    <td>Benjamin</td>
                                    <td>14:00</td>
                                    <td><i class="far fa-eye"></i></td>
                                </tr>
                                <tr>
                                    <td>
                                        <div class="img-box-small">
                                            <img src="doctor1.jpg" alt="">
                                        </div>
                                    </td>
                                    <td>Benjamin</td>
                                    <td>14:00</td>
                                    <td><i class="far fa-eye"></i></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
