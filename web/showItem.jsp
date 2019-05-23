<%@ page import="la.servlet.model.Clothes" %><%--
  Created by IntelliJ IDEA.
  User: masaya.okuda
  Date: 2019-05-23
  Time: 13:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>商品個別ページ</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<% Clothes clothes = (Clothes) request.getAttribute("item"); %>


<h1><%= clothes.getName() %></h1>

<%  String[] size = clothes.getSize().split(" "); %>
<%  String[] color = clothes.getColor().split(" "); %>

<div>
    <img src="${pageContext.request.contextPath}/image/<%= clothes.getImage() %>" alt="">
    <p>価格：3000yen</p>
</div>
<div>
    <form action="/CartServlet" method="post">
        <input type="radio" name="size" value="S"><%= size[0] %>
        <input type="radio" name="size" value="M"><%= size[1] %>
        <input type="radio" name="size" value="L"><%= size[2] %>
        <br><br>
        <input type="radio" name="color" value="yellow"><%= color[0] %>
        <input type="radio" name="color" value="white"><%= color[1] %>
        <br><br>
        <input type="submit" value="カートに追加する">
    </form>
</div>

</body>
</html>
