<%--
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


<h1>JavaScript Tシャツ</h1>

<div>f
    <img src="${pageContext.request.contextPath}/image/1.jpeg" alt="">
    <p>価格：3000yen</p>
</div>
<div>
    <form action="/CartServlet" method="post">
        <input type="radio" name="size" value="S">S
        <input type="radio" name="size" value="M">M
        <input type="radio" name="size" value="L">L
        <br><br>
        <input type="radio" name="color" value="yellow">yellow
        <input type="radio" name="color" value="white">white
        <br><br>
        <input type="submit" value="カートに追加する">
    </form>
</div>

</body>
</html>
