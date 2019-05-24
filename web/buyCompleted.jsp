<%@ page import="la.bean.CartBean" %>
<%@ page import="la.servlet.model.OrderItem" %>
<%@ page import="java.util.Map" %><%--
  Created by IntelliJ IDEA.
  User: masaya.okuda
  Date: 2019-05-23
  Time: 13:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>購入完了ページ</title>
    <link rel="stylesheet" href="/JavaTeamWork_war_exploded/css/style.css" type="text/css">

</head>
<body>

<jsp:include page="header.jsp"/>

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

<h2>購入が完了しました！</h2>

</body>
</html>
