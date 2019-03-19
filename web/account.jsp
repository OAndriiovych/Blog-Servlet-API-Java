<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 17.03.2019
  Time: 16:11
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>My Account</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <link href="https://fonts.googleapis.com/css?family=Josefin+Sans:300, 400,700|Inconsolata:400,700" rel="stylesheet">

    <link rel="stylesheet" href="css/bootstrap.css">
    <link rel="stylesheet" href="css/animate.css">
    <link rel="stylesheet" href="css/owl.carousel.min.css">

    <link rel="stylesheet" href="fonts/ionicons/css/ionicons.min.css">
    <link rel="stylesheet" href="fonts/fontawesome/css/font-awesome.min.css">
    <link rel="stylesheet" href="fonts/flaticon/font/flaticon.css">

    <!-- Theme Style -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<div class="wrap">
    <header role="banner">
        <div class="top-bar">
            <div class="container">
                <div class="row">
                    <div class="col-9 social">
                        <a href="#"><span class="fa fa-twitter"></span></a>
                        <a href="#"><span class="fa fa-facebook"></span></a>
                        <a href="#"><span class="fa fa-instagram"></span></a>
                        <a href="#"><span class="fa fa-youtube-play"></span></a>
                    </div>
                </div>
            </div>
        </div>

        <div class="container logo-wrap">
            <div class="row pt-5">
                <div class="col-12 text-center">
                    <a class="absolute-toggle d-block d-md-none" data-toggle="collapse" href="#navbarMenu" role="button"
                       aria-expanded="false" aria-controls="navbarMenu"><span class="burger-lines"></span></a>
                    <h1 class="site-logo"><a href="/">Wordify</a></h1>
                </div>
            </div>
        </div>

        <nav class="navbar navbar-expand-md  navbar-light bg-light">
            <div class="container">


                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item">
                            <a class="nav-link" href="/">Home</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="#">Business</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="category.html" id="dropdown04"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Travel</a>
                            <div class="dropdown-menu" aria-labelledby="dropdown04">
                                <a class="dropdown-item" href="category.html">Asia</a>
                                <a class="dropdown-item" href="category.html">Europe</a>
                                <a class="dropdown-item" href="category.html">Dubai</a>
                                <a class="dropdown-item" href="category.html">Africa</a>
                                <a class="dropdown-item" href="category.html">South America</a>
                            </div>

                        </li>

                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="category.html" id="dropdown05"
                               data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Categories</a>
                            <div class="dropdown-menu" aria-labelledby="dropdown05">
                                <a class="dropdown-item" href="category.html">Lifestyle</a>
                                <a class="dropdown-item" href="category.html">Food</a>
                                <a class="dropdown-item" href="category.html">Adventure</a>
                                <a class="dropdown-item" href="category.html">Travel</a>
                                <a class="dropdown-item" href="category.html">Business</a>
                            </div>

                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="about.html">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contact.html">Contact</a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
    </header>
    <!-- END header -->

    <section class="site-section py-lg">
        <div class="container">

            <div class="row blog-entries element-animate">
                <c:set var="person" value="${requestScope.person}"/>
                <div class="col-md-12 col-lg-8 main-content" style="padding-left: 0px;">
                    <form action="" method="post" enctype="multipart/form-data">
                        <h1 class="mb-4">Your account</h1>
                        <div class="col-md-8 col-lg-6 main-content">
                            <img src="<c:out value="${person.way_to_photo}"/>" alt="Image" class="img-fluid mb-5">

                            <input class="ion-android-radio-button-off" name="image_uploads" type="file"
                                   accept=".jpg, .jpeg, .png" style="margin: 5%;margin-left: 0;"><br>
                            <p >*File have to be less than 3 MB</p>
                            <c:set var="size" value="${requestScope.size}"/>
                            <c:if test="${size}">
                                <h3 style="color: red;">File to long!</h3>
                            </c:if>
                        </div>
                        <table style="width: 100%;">
                            <tr>
                                <td><h2>
                                    Lastname
                                </h2></td>
                                <td><h4>
                                    <c:out value="${person.lastname}"/>
                                </h4></td>
                            </tr>
                            <tr>
                                <td><h2>
                                    Email
                                </h2></td>
                                <td><h4>
                                    <c:out value="${person.login}"/>
                                </h4></td>
                            </tr>
                            <tr>
                                <td><h2>
                                    Date of registration
                                </h2></td>
                                <td><h4>
                                    <c:out value="${person.date_of_reg}"/>
                                </h4></td>
                            </tr>
                        </table>

                        <table style="width: 100%;margin-top: 5%;">
                            <tr>
                                <td><h4>
                                    New Lastname
                                </h4></td>
                                <td>
                                    <input type="text" placeholder="Enter Password" name="lastname"
                                           maxlength="26"></td>
                            </tr>
                            <tr>
                                <td><h4>
                                    New Email
                                </h4></td>
                                <td>
                                    <input type="text" placeholder="Enter Email" name="email"
                                           maxlength="26"></td>
                            </tr>
                            <tr>
                                <td><h4>
                                    New password
                                </h4></td>
                                <td>
                                    <input type="password" placeholder="Repeat Password" name="psw"></td>
                            </tr>
                        </table>
                        <input class="category" style="padding: 1%;margin-top: 5%;font-size: 90%;margin-bottom: 30px;"
                               type="submit"
                               value="Save Changes"><br>
                    </form>
                    <c:if test="${person.role=='MODERATOR'||person.role=='ADMIN'}">
                        <h2>You are <c:out value="${person.role}"/></h2>
                        <a class="category mb-5" href="#" style="padding: 1%; margin-top: 5%;">Create new post</a><br>
                        <c:if test="${person.role=='ADMIN'}">
                            <a class="category mb-5" href="/listofusers" style="padding: 1%; margin-top: 5%;">Change roles</a>
                        </c:if>
                    </c:if>
                </div>

                <!-- END main-content -->

                <div class="col-md-12 col-lg-4 sidebar">
                    <div class="sidebar-box search-form-wrap">
                        <a class="category mb-5" href="/logout" style="padding: 5%; font-size: 16px;">LOGUOT</a>
                    </div>
                    <!-- END sidebar-box -->
                </div>
                <!-- END sidebar -->
            </div>
        </div>
    </section>

    <!-- END section -->
    <footer class="site-footer">
        <div class="container">
            <div class="row mb-5">
                <div class="col-md-4">
                    <h3>About Me</h3>
                    <p class="mb-4">
                        <img src="images/me.jpg" alt="Image placeholder" class="img-fluid">
                    </p>
                    <p>I'm Andriiovych Oleksii. I'm from the group Lv-393.Java</p>
                    <p>This is my own blog. It was my the second task in SoftServe IT Academy.
                        This project have written with Java. If You want see source, <a
                                href="https://github.com/narnanam/blog">follow this link</a></p>
                </div>
                <div class="col-md-6 ml-auto">
                    <div class="row">
                        <div class="col-md-7">

                        </div>
                        <div class="col-md-1"></div>

                        <div class="col-md-4">

                            <div class="mb-5">
                                <h3>Quick Links</h3>
                                <ul class="list-unstyled">
                                    <li><a href="#">About Us</a></li>
                                    <li><a href="#">Travel</a></li>
                                    <li><a href="#">Adventure</a></li>
                                    <li><a href="#">Courses</a></li>
                                    <li><a href="#">Categories</a></li>
                                </ul>
                            </div>

                            <div class="mb-5">
                                <h3>Social</h3>
                                <ul class="list-unstyled footer-social">
                                    <li><a href="#"><span class="fa fa-twitter"></span> Twitter</a></li>
                                    <li><a href="#"><span class="fa fa-facebook"></span> Facebook</a></li>
                                    <li><a href="#"><span class="fa fa-instagram"></span> Instagram</a></li>
                                    <li><a href="#"><span class="fa fa-vimeo"></span> Vimeo</a></li>
                                    <li><a href="#"><span class="fa fa-youtube-play"></span> Youtube</a></li>
                                    <li><a href="#"><span class="fa fa-snapchat"></span> Snapshot</a></li>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="row">
                <div class="col-md-12 text-center">
                    <p class="small">
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;
                        <script data-cfasync="false"
                                src="/cdn-cgi/scripts/5c5dd728/cloudflare-static/email-decode.min.js"></script>
                        <script>document.write(new Date().getFullYear());</script>
                        All Rights Reserved | This template is made with <i class="fa fa-heart text-danger"
                                                                            aria-hidden="true"></i> by <a
                            href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </p>
                </div>
            </div>
        </div>
    </footer>
    <!-- END footer -->

</div>

<!-- loader -->
<div id="loader" class="show fullscreen">
    <svg class="circular" width="48px" height="48px">
        <circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/>
        <circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10"
                stroke="#f4b214"/>
    </svg>
</div>

<script src="js/jquery-3.2.1.min.js"></script>
<script src="js/jquery-migrate-3.0.0.js"></script>
<script src="js/popper.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/owl.carousel.min.js"></script>
<script src="js/jquery.waypoints.min.js"></script>
<script src="js/jquery.stellar.min.js"></script>


<script src="js/main.js"></script>
</body>
</html>
