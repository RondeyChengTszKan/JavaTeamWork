<%@ page import="la.bean.CartBean" %>
<%@ page import="java.util.Map" %>
<%@ page import="la.servlet.model.OrderItem" %><%--
  Created by IntelliJ IDEA.
  User: masaya.okuda
  Date: 2019-05-23
  Time: 13:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>商品購入カートページ</title>
</head>
<body>

<jsp:include page="header.jsp"/>

<h1>現在のカートの中身</h1>

<% CartBean cart = (CartBean) session.getAttribute("cart"); %>
<% Map<Integer, OrderItem> items = cart.getItems(); %>

<% int totalPrice = 0; %>


<table border="1">
    <tr><td>商品名</td><td>サイズ</td><td>カラー</td><td>単価</td></tr>

    <% for (Map.Entry<Integer, OrderItem> entry : items.entrySet()) { %>
    <tr>
        <td><%=entry.getValue().getName()%></td>
        <td><%=entry.getValue().getSize()%></td>
        <td><%=entry.getValue().getColor()%></td>
        <td><%=entry.getValue().getPrice()%></td>
    </tr>
    <% totalPrice += entry.getValue().getPrice(); %>
    <% } %>

</table>

<p>合計金額：<%=totalPrice%></p>

<form action="/JavaTeamWork_war_exploded/buyCompleted.jsp" method="post">
    <input type="submit" value="購入する">
</form>

</body>
</html>
