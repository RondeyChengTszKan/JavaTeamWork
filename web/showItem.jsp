<%@ page import="la.servlet.model.Clothes" %>
<%@ page import="java.util.List" %><%--
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


<% List<String> size = clothes.getSizelist(); %>
<% List<String> color = clothes.getColorlist(); %>

<div>
    <img src="${pageContext.request.contextPath}/image/<%= clothes.getImagelist().get(0) %>" alt="">
    <p>価格：3000yen</p>
</div>
<div>
    <form action="/JavaTeamWork_war_exploded/CartServlet?action=add" method="post">
        <input type="hidden" name="item_id" value=<%=clothes.getId()%>>
        <input type="hidden" name="name" value=<%=clothes.getName()%>>
        <input type="hidden" name="price" value=<%=clothes.getPrice()%>>
        <% for (String s : size) { %>
            <input type="radio" name="size" value=<%= s %>><%= s %>
        <% } %>
        <br><br>
        <% for (String c : color) { %>
            <input type="radio" name="color" value=<%= c %>><%= c %>
        <% } %>
        <br><br>
        <input type="submit" value="カートに追加する">
    </form>
</div>

</body>
</html>
