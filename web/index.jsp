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
  </head>
  <body>
  <jsp:include page="header.jsp"/>

  <h1>商品一覧</h1>

<% List<Clothes> items = (List<Clothes>) application.getAttribute("clothes"); %>

<% for (Clothes item : items) { %>
<div>
    <img src="${pageContext.request.contextPath}/image/<%=item.getImage()%>" alt="">
    <p>商品名：<%= item.getName()%></p>
    <p>価格：<%=item.getPrice()%></p>
    <a href="/ItemServlet?action=show&id=<%=item.getId()%>">商品詳細</a>
</div>
<% } %>

  </body>
</html>
