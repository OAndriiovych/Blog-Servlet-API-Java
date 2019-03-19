<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 19.03.2019
  Time: 16:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Registration page</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>

<div class="wrap">

    <jsp:include page="_header.jsp"></jsp:include>
    <section class="site-section pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form method="post" action="">
                        <div class="container">
                            <h1>Register</h1>
                            <p>Please fill in this form to create an account.</p>
                            <hr>
                            <label for="email"><b>Email</b></label>
                            <input type="text" placeholder="Enter Email" name="email"
                                   maxlength="26" pattern="^[a-z0-9._%+-]+@[a-z0-9.-]+\.[a-z]{2,4}$">

                            <label for="psw"><b>Password</b></label>
                            <input type="password" placeholder="Enter Password" name="psw" required minlength="8"
                                   maxlength="26">

                            <label for="lastname"><b>Lastname</b></label>
                            <input type="text" placeholder="Enter Your Lastname" name="lastname" required minlength="3"
                                   maxlength="30">
                            <hr>
                            <button type="submit" class="registerbtn">Register</button>
                        </div>
                        <div class="container signin">
                            <p>Already have an account? <a href="/account">Sign in</a>.</p>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </section>
    <jsp:include page="_footer.jsp"></jsp:include>
<!-- END footer -->
</div>
</body>
</html>
