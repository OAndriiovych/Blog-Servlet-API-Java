<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 11.03.2019
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isErrorPage="true" %>
<%--<%@ page errorPage="error.jsp" %>--%>
<!doctype html>
<html lang="en">
<head>
    <title>Sorry((</title>
    <!-- Theme Style -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<section class="wrap">

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
                    <div class="col-3 search-top">
                        <!-- <a href="#"><span class="fa fa-search"></span></a> -->
                        <form action="#" class="search-top-form">
                            <span class="icon fa fa-search"></span>
                            <input type="text" id="s" placeholder="Type keyword to search...">
                        </form>
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
                            <a class="nav-link" href="about.html">About</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="contact.html">Contact</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/account">Account</a>
                        </li>
                    </ul>

                </div>
            </div>
        </nav>
    </header>
    <section class="site-section py-sm">
        <div class="container">
            <div class="row blog-entries" style="
                background-image: url('images/error.jpg');
                background-repeat: no-repeat;
                background-size: cover;
                padding-bottom: 250px;
                padding-top: 100px;">
                <div class="col-md-12 col-lg-12 main-content" >
                    <h1 class="mb-4">Something went wrong.</h1>
                    <div class="post-content-body">
                        <h2>We do not know what it was (((</h2>
                        <p>
                            If you see something strange, send us an email
                            <a class="category mb-5"  href="example@email.com">example@email.com</a>
                        </p>
                    </div>
                </div>
            </div>
        </div>
    </section>
</section>
</body>
</html>
