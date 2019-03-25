<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 20.03.2019
  Time: 13:34
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>About Me</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<div class="wrap">
<jsp:include page="_header.jsp"></jsp:include>
<section class="site-section">
    <div class="container">
        <div class="row blog-entries">
            <div class="col-md-12 col-lg-12 main-content">
                <div class="row">
                    <div class="col-md-12 form-group">
                        <h3>About Me</h3>
                        <p class="col-lg-4 col-md-6">
                            <img src="../../images/me.jpg" alt="Image placeholder" class="img-fluid">
                        </p>
                        <p>I'm Andriiovych Oleksii. I'm from the group Lv-393.Java</p>
                        <p>This is my own blog. It was my the second task in SoftServe IT Academy.
                            This project have written with Java. If You want see source, <a
                                    href="https://github.com/narnanam/blog">follow this link</a></p>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<jsp:include page="_footer.jsp"></jsp:include>
</div>
</body>
</html>
