<%--
  Created by IntelliJ IDEA.
  User: L
  Date: 19.03.2019
  Time: 13:29
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page errorPage="error.jsp" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<div class="wrap">
    <jsp:include page="_header.jsp"></jsp:include>
    <section class="site-section pt-5 pb-5">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <form method="post" action="" enctype="multipart/form-data">
                        <div class="container">
                            <h1>Create a new post</h1>
                            <h2 style="color: red"><c:out value="${requestScope.message}"/></h2>
                            <hr>
                            <input class="ion-android-radio-button-off" name="image_uploads" type="file"
                                   accept=".jpg, .jpeg, .png" style="margin: 5%;margin-left: 0;"><br>
                            <label for="topic"><b>Topic</b></label>
                            <input type="text" placeholder="Enter topic" name="topic" required
                                   maxlength="40">

                            <label for="category"><b>Category</b></label>
                            <input type="text" placeholder="Enter category" name="category" required
                                   maxlength="15">

                            <label for="post"><b>Post</b></label>
                            <textarea style="width: 100%;height: 250px;background-color: #ddd;border: 0;padding: 1%;"
                                      type="text" placeholder="Enter Your post" name="post" required></textarea>
                            <hr>

                            <button type="submit" class="registerbtn">Create a new post</button>
                        </div>
                    </form>
                </div>
            </div>

        </div>
    </section>
    <jsp:include page="_footer.jsp"></jsp:include>
</div>
</body>
</html>
