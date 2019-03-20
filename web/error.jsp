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
<div class="wrap">

    <jsp:include page="_header.jsp"></jsp:include>
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
    <jsp:include page="_footer.jsp"></jsp:include>
</div>
</body>
</html>
