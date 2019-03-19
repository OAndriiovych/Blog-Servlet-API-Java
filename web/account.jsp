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
    <!-- Theme Style -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>


<div class="wrap">
    <jsp:include page="_header.jsp"></jsp:include>
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
