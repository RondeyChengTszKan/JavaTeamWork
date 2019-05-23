<%--
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

<div>
    <img src="${pageContext.request.contextPath}/image/testImage.jpeg" alt="">
    <p>商品名：Javascript Tシャツ</p>
    <p>価格：800yen</p>
    <a href="/ItemServlet">商品詳細</a>
</div>

</body>
</html>
