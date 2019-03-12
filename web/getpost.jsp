<%@ page import="db.database.Posts" %>
<%@ page import="java.util.List" %>
<%@ page import="db.servises.PostServ" %><%--
  Created by IntelliJ IDEA.
  User: L
  Date: 11.03.2019
  Time: 19:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<%! PostServ postServ = new PostServ(); %>
<%! Posts p; %>


<%
    postServ.connect();
     p = postServ.last();
    System.out.println(p.getPost());
%>
<%=
p.getPost()
%>




</body>
</html>
