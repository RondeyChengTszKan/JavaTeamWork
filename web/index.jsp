<%@ page import="java.util.List" %>
<%@ page import="la.servlet.model.Clothes" %><%--
  Created by IntelliJ IDEA.
  User: keita.kishida
  Date: 2019-05-23
  Time: 13:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>$Title$</title>
    <link rel="stylesheet" href="/JavaTeamWork_war_exploded/css/style.css" type="text/css">
</head>
<body>

<div class="container">

<jsp:include page="header.jsp"/>

<h1>商品一覧</h1>

<% List<Clothes> items = (List<Clothes>) application.getAttribute("clothes"); %>

<% for (Clothes item : items) { %>
    <hr>
  
<div class="items">
    <img src="${pageContext.request.contextPath}/image/<%=item.getImagelist().get(0)%>" alt="">
    <div class="itemInfo">
        <p><%= item.getName()%></p>
        <p>Price：<%=item.getPrice()%>yen</p>
        <a href="/JavaTeamWork_war_exploded/ItemServlet?action=show&id=<%=item.getId()%>">商品詳細</a>
    </div>
</div>
  
    <hr>
<% } %>

</div>

</body>
</html>
