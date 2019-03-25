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
    <title>List Of Users</title>

    <!-- Theme Style -->
    <link rel="stylesheet" href="../../css/style.css">
</head>
<body>


<div class="wrap">
    <jsp:include page="_header.jsp"></jsp:include>
    <!-- END header -->

    <section class="site-section py-lg">
        <div class="container">
            <h2 style="color: red"><c:out value="${requestScope.message}"/></h2>

            <form action="" method="post" style="border: red;border-bottom-width: 2px;
            border-bottom-style: solid;border-top-width: 2px;border-top-style: solid;border-right-width: 2px;
            border-right-style: solid;border-left-width: 2px;border-left-style: solid;margin-bottom: 20px;padding: 2%;">
                <label for="email"><b>Email</b></label>
                <input type="text" placeholder="Enter Email" name="email" required>
                <select style="height: 40px;" name="role">
                    <option>user</option>
                    <option>moderator</option>
                    <option>admin</option>
                </select>
                <button type="submit" class="registerbtn">Cahge</button>
            </form>

                <c:set var="person" value="${requestScope.person}"/>
                    <form action="" method="post" enctype="multipart/form-data">
                        <table border="1" style="width: 100%;">
                            <tr>
                            <th>login</th>
                            <th>lastname</th>
                            <th>date_of_reg</th>
                            <th>way_to_photo</th>
                            <th>role</th>
                            </tr>
                            <c:forEach var="user" items="${requestScope.userDTOList}">
                            <tr>
                                <td>
                                    <c:out value="${user.login}"/>
                                </td>
                                <td>
                                    <c:out value="${user.lastname}"/>
                                </td>
                                <td>
                                    <c:out value="${user.date_of_reg}"/>
                                </td>
                                <td>
                                    <c:out value="${user.way_to_photo}"/>
                                </td>
                                <td>
                                    <c:out value="${user.role}"/>
                                </td>
                            </tr>
                            </c:forEach>
                        </table>
                    </form>
                </div>
                <!-- END sidebar -->


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
