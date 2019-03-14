
<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 13.03.2019
  Time: 19:32
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<c:forEach var="asd" items="${requestScope.myList}">
<div>
    <a href="blog-single.html" class="a-block d-flex align-items-center height-lg"
       style="background-image: url('images/img_1.jpg'); ">
        <div class="text half-to-full">
            <span class="category mb-5">
                <c:out value="${asd.category}"/>
            </span>
            <div class="post-meta">
                <span class="author mr-2"><img src="images/person_1.jpg" alt="Colorlib">
                    123
                </span>&bullet;
                <span class="mr-2">
                    <c:out value="${asd.date_of_post}"/>
                </span> &bullet;
                <!-- !!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!-->
                <span class="ml-2"><span class="fa fa-comments"></span> 3</span>
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
<div>
</c:forEach>

</body>
</html>
