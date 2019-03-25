<%@ page import="java.util.List" %>
<%@ page import="db.database.Post" %>
<%@ page import="db.servises.PostServ" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: L
  Date: 11.03.2019
  Time: 12:18
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<%--<%@ page errorPage="error.jsp" %>--%>
<html lang="en">
<head>
    <title>Welcome to my blog</title>

</head>
<body>


<div class="wrap">

    <jsp:include page="_header.jsp"></jsp:include>
    <!-- END header -->

    <section class="site-section pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="owl-carousel owl-theme home-slider">
                        <c:forEach var="asd" items="${requestScope.bigPosts}">
                            <div>
                                <a href="/poster?post=<c:out value="${asd.id_post}"/>"
                                   class="a-block d-flex align-items-center height-lg"
                                   style="background-image: url('<c:out value="${asd.way_to_photo}"/>')">
                                    <div class="text half-to-full">
                                        <span class="category mb-5">
                                            <c:out value="${asd.category}"/>
                                        </span>
                                        <div class="post-meta">
                                            <span class="author mr-2"><img
                                                    src="<c:out value="${asd.way_to_author_photo}"/>" alt="Colorlib">
                                                <c:out value="${asd.author}"/>
                                            </span>&bullet;
                                            <span class="mr-2">
                                                 <c:out value="${asd.date_of_post}"/>
                                            </span> &bullet;
                                            <c:if test="${asd.countComment>0}">
                                                <span class="ml-2"><span class="fa fa-comments"></span>
                                                    <c:out value="${asd.countComment}"/>
                                                </span>
                                            </c:if>
                                        </div>
                                        <h3>

                                            <c:out value="${asd.topic}"/>
                                        </h3>
                                        <p>
                                            <c:out value="${asd.post}"/>
                                        </p>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <!-- END section -->

    <section class="site-section py-sm">
        <div class="container">
            <div class="row">
                <div class="col-md-6">
                    <h2 class="mb-4">Latest Posts</h2>
                </div>
            </div>
            <div class="row blog-entries">
                <div class="col-md-12 col-lg-12 main-content">
                    <div class="row">
                        <c:forEach var="asd" items="${requestScope.littlePosts}">
                            <div class="col-md-4">
                                <a href="/poster?post=<c:out value="${asd.id_post}"/>"
                                   class="blog-entry element-animate"
                                   data-animate-effect="fadeIn">
                                    <img src="<c:out value="${asd.way_to_photo}"/>" alt="Image placeholder">
                                    <div class="blog-content-body">
                                        <div class="post-meta">
                                            <span class="author mr-2"><img
                                                    src=" <c:out value="${asd.way_to_author_photo}"/>"
                                                    alt="Colorlib"> <c:out value="${asd.author}"/></span>&bullet;
                                            <span class="mr-2"><c:out value="${asd.date_of_post}"/> </span> &bullet;
                                        </div>
                                        <h2><c:out value="${asd.topic}"/></h2>
                                    </div>
                                </a>
                            </div>
                        </c:forEach>
                    </div>
                </div>

                <div class="row mt-5" style="width: 100%;">
                    <div class="col-md-12 text-center">
                        <nav aria-label="Page navigation" class="text-center">
                            <ul class="pagination">
                                <c:set var="flag" value="${true}"/>
                                <c:set var="page" value="${presentpage}"/>
                                <c:forEach var="asd" items="${requestScope.pages}">
                                    <c:if test="${asd>0}">
                                        <c:if test="${asd==page}">
                                            <li class="page-item"><a class="page-link" href="" style="color: #fff;
                                            background-color: #6610f2;"><c:out value="${asd}"/></a></li>
                                        </c:if>
                                        <c:if test="${asd!=page}">
                                            <li class="page-item"><a class="page-link"
                                                                     href="/?page=<c:out value="${asd}"/>"> <c:out
                                                    value="${asd}"/></a></li>
                                        </c:if>
                                    </c:if>
                                    <c:if test="${asd==0&&flag}">
                                        <c:set var="flag" value="${false}"/>
                                        <li class="page-item"><a class="page-link" href="#">&gt;</a></li>
                                    </c:if>
                                </c:forEach>
                            </ul>
                        </nav>
                    </div>
                </div>
            </div>

        </div>
    </section>

    <jsp:include page="_footer.jsp"></jsp:include>
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

<script src="../js/jquery-3.2.1.min.js"></script>
<script src="../js/jquery-migrate-3.0.0.js"></script>
<script src="../js/popper.min.js"></script>
<script src="../js/bootstrap.min.js"></script>
<script src="../js/owl.carousel.min.js"></script>
<script src="../js/jquery.waypoints.min.js"></script>
<script src="../js/jquery.stellar.min.js"></script>

<script src="../js/main.js"></script>
</body>
</html>
