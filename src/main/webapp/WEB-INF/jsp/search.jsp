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
    <title>Search</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>


<div class="wrap">

    <jsp:include page="_header.jsp"></jsp:include>
    <!-- END header -->

    <section class="site-section pt-5">
        <div class="container">

            <div class="row blog-entries">
                <div class="col-md-12 col-lg-8 main-content">

                    <div class="row mb-5 mt-5">
                        <div class="col-md-12 mb-5">
                            <h2>Search like "<c:out value="${requestScope.like}"/>"</h2>
                        </div>
                        <c:if test="${requestScope.message==null}">
                            <div class="col-md-12">
                                <c:forEach var="post" items="${requestScope.postLessDTOList}">
                                    <div class="post-entry-horzontal">
                                        <a href="/poster?post=<c:out value="${post.id_post}"/>" style="width: 100%;">
                                            <div class="image" style="background-image: url(<c:out
                                                    value="${post.way_to_photo}"/>);"></div>
                                            <span class="text">
                                          <div class="post-meta">
                                            <span class="author mr-2"><img
                                                    src="<c:out value="${post.way_to_author_photo}"/>" alt="Colorlib">
                                                <c:out value="${post.author}"/></span>&bullet;
                                            <span class="mr-2"> <c:out value="${post.date_of_post}"/></span> &bullet;
                                          </div>
                                          <h2><c:out value="${post.topic}"/></h2>
                                    </span>
                                        </a>
                                    </div>
                                </c:forEach>
                                <!-- END post -->
                            </div>
                        </c:if>
                        <c:if test="${requestScope.message!=null}">
                            <h2><c:out value="${requestScope.message}"/></h2>
                        </c:if>
                    </div>


                </div>

            </div>
        </div>
    </section>
    <!-- END section -->

    <section class="site-section py-sm">
        <div class="container">

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
                                                                 href="/?page=<c:out value="/></a></li>
                                        </c:if>
                                    </c:if>
                                    <c:if test=" ${asd==0&&flag}">
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

<script src="../../js/jquery-3.2.1.min.js"></script>
<script src="../../js/jquery-migrate-3.0.0.js"></script>
<script src="../../js/popper.min.js"></script>
<script src="../../js/bootstrap.min.js"></script>
<script src="../../js/owl.carousel.min.js"></script>
<script src="../../js/jquery.waypoints.min.js"></script>
<script src="../../js/jquery.stellar.min.js"></script>

<script src="../../js/main.js"></script>
</body>
</html>
