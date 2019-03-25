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
    <title>Contact</title>
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>
<div class="wrap">
    <jsp:include page="_header.jsp"></jsp:include>
    <section class="site-section">
        <div class="container">

            <div class="row blog-entries">
                <div class="col-md-12 col-lg-12 main-content">
                    <div class="row mb-4">
                        <div class="col-md-6">
                            <h1>Contact Me</h1>
                        </div>
                    </div>
                    <p>My GitHub <a href="https://github.com/narnanam/">link</a></p>
                    <p>My LinkedIn <a href="https://www.linkedin.com/notifications/">link</a></p>
                    <p>My Gmail <a href="narnanam@gmail.com">link</a></p>

                    <table>
                        <tr>
                            <td>GitHub</td>
                            <td><img src="../../images/frameG.png"></td>
                        </tr>
                        <tr>
                            <td>LinkedIn</td>
                            <td><img src="../../images/frameL.png"></td>
                        </tr>
                        <tr>
                            <td>Gmail</td>
                            <td><img src="../../images/frameM.png"></td>
                        </tr>
                    </table>
                </div>
            </div>
        </div>
    </section>
    <jsp:include page="_footer.jsp"></jsp:include>
</div>
</body>
</html>
