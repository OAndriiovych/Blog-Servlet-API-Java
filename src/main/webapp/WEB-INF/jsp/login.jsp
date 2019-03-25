<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 18.03.2019
  Time: 11:47
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<!doctype html>
<html lang="en">
<head>
    <title>Login page</title>

    <!-- Theme Style -->
    <link rel="stylesheet" href="../../css/style.css">

</head>
<body>


<div class="wrap">

    <jsp:include page="_header.jsp"></jsp:include>
    <!-- END header -->

    <section class="site-section pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">

                    <form method="post" action="">
                        <div class="container">
                            <h1>Login</h1>
                            <p>Please fill in this form to login an account.</p>
                            <hr>
                            <c:set var="login" value="${requestScope.login}"/>
                            <c:if test="${login}">
                                <h4 style="color: red;">
                                    Password or email is wrong
                                </h4>
                            </c:if>

                            <label for="email"><b>Email</b></label>
                           <input type="text" placeholder="Enter Email" name="email" required minlength="8"
                                   maxlength="26" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">


                            <label for="psw"><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="psw" required minlength="8"
                                   maxlength="26">
                            <label for="cookies"><b>Remember me</b></label>
                            <input type="checkbox" placeholder="Enter Password" name="cookies" style="transform: scale(1.3);-ms-transform: scale(1.3);/ -webkit-transform: scale(1.3);">

                            <hr>
                            <button type="submit" class="registerbtn">Login</button>
                        </div>

                        <div class="container signin">
                            <p>Have not already an account? <a href="/registration">Create account</a>.</p>
                        </div>
                    </form>


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