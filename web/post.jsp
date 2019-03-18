<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 16.03.2019
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<!doctype html>
<html lang="en">

<head>
    <c:set var="mainPost" value="${requestScope.postAllLong}"/>
    <title>Poster <c:out value="${mainPost.topic}"/></title>
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
    <link rel="stylesheet" href="css/forPage.css">
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
                    <a class="absolute-toggle d-block d-md-none" data-toggle="collapse" href="#navbarMenu"
                       role="button" aria-expanded="false" aria-controls="navbarMenu"><span
                            class="burger-lines"></span></a>
                    <h1 class="site-logo"><a href="/">Wordify</a></h1>
                </div>
            </div>
        </div>

        <nav class="navbar navbar-expand-md  navbar-light bg-light">
            <div class="container">


                <div class="collapse navbar-collapse" id="navbarMenu">
                    <ul class="navbar-nav mx-auto">
                        <li class="nav-item">
                            <a class="nav-link active" href="/">Home</a>
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
    <!-- END header -->

    <section class="site-section py-sm">
        <div class="container">
            <div class="row blog-entries">
                <div class="col-md-12 col-lg-8 main-content">
                    <img src="<c:out value="${mainPost.way_to_photo}"/>" alt="Image" class="img-fluid mb-5">
                    <div class="post-meta">
                        <span class="author mr-2"><img src="images/person_1.jpg" alt="Colorlib" class="mr-2"> <c:out
                                value="${mainPost.author}"/></span>&bullet;
                        <span class="mr-2"><c:out value="${mainPost.date_of_post}"/></span> &bullet;
                        <c:if test="${mainPost.countComment>0}">
                            <span class="ml-2"><span class="fa fa-comments"></span> <c:out
                                    value="${mainPost.countComment}"/></span>
                        </c:if>
                    </div>
                    <h1 class="mb-4"><c:out value="${mainPost.topic}"/></h1>
                    <a class="category mb-5" href="#"><c:out value="${mainPost.category}"/></a>
                    <div class="post-content-body">
                        <c:out value="${mainPost.post}"/>
                    </div>
                    <div class="pt-5">
                        <c:if test="${mainPost.countComment>1}">
                            <h3 class="mb-5"><c:out value="${mainPost.countComment}"/> Comments</h3>
                        </c:if>
                        <c:if test="${mainPost.countComment==1}">
                            <h3 class="mb-5"><c:out value="${mainPost.countComment}"/> Comment</h3>
                        </c:if>
                        <c:if test="${mainPost.countComment<1}">
                            <h3 class="mb-5"> Still no comment. You will be first.</h3>
                        </c:if>

                        <ul class="comment-list">
                            <c:forEach var="asd" items="${requestScope.listOfComments}">
                                <li class="comment">
                                    <div class="vcard">
                                        <img src="<c:out value="${asd.way_to_author_photo}"/>" alt="Image placeholder">
                                    </div>
                                    <div class="comment-body">
                                        <h3><c:out value="${asd.lastname}"/></h3>
                                        <div class="meta"><c:out value="${asd.date_of_coment}"/></div>
                                        <p><c:out value="${asd.user_comment}"/></p>
                                        <p><a href="#" class="reply rounded"><c:out value="${asd.lastname}"/></a></p>
                                    </div>
                                </li>
                            </c:forEach>
                        </ul>
                        <!-- END comment-list -->
                        <c:set var="login" value="${requestScope.login}"/>
                        <c:if test="${login}">
                            <div class="comment-form-wrap pt-5">
                                <h3 class="mb-5">Leave a comment</h3>
                                <form action="" class="p-5 bg-light" method="post">

                                    <div class="form-group">
                                        <label for="message">Message</label>
                                        <textarea name="comment" id="message" cols="30" rows="10" class="form-control"
                                                  required minlength="8" maxlength="26"></textarea>
                                    </div>
                                    <div class="form-group">
                                        <input type="submit" value="Post Comment" class="btn btn-primary">
                                    </div>
                                </form>
                            </div>
                        </c:if>
                    </div>
                </div>
                <!-- END main-content -->
                <div class="col-md-12 col-lg-4 sidebar">
                    <!-- END sidebar-box -->
                    <div class="sidebar-box">
                        <h3 class="heading">Latest Posts</h3>
                        <div class="post-entry-sidebar">
                            <ul>
                                <c:forEach var="asd" items="${requestScope.postList}">
                                    <li>
                                        <a href="/poster?post=<c:out value="${asd.id_post}"/>">
                                            <img src="<c:out value="${asd.way_to_photo}"/>" alt="Image placeholder"
                                                 class="mr-4">
                                            <div class="text">
                                                <h4><c:out value="${asd.topic}"/></h4>
                                                <div class="post-meta">
                                                    <span class="mr-2"><c:out value="${asd.date_of_post}"/> </span>
                                                </div>
                                            </div>
                                        </a>
                                    </li>
                                </c:forEach>
                            </ul>
                        </div>
                    </div>
                    <!-- END sidebar-box -->
                </div>
                <!-- END sidebar -->
            </div>
        </div>
    </section>

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
                            <div class="post-entry-sidebar"></div>
                        </div>
                        <div class="col-md-1"></div>
                        <div class="col-md-4">
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
                        All Rights Reserved | This
                        template is made with <i class="fa fa-heart text-danger" aria-hidden="true"></i> by <a
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
