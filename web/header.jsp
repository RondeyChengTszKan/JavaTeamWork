<%--
  Created by IntelliJ IDEA.
  User: masaya.okuda
  Date: 2019-05-23
  Time: 13:35
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header class="header">
    <a href="/JavaTeamWork_war_exploded/ItemServlet">
        商品リスト
    </a>

    <a href="/JavaTeamWork_war_exploded/CartServlet?action=show">
        カート
    </a>

    <% Object sObject =  session.getAttribute("Login"); %>
    <c:if test="{empty sObject}">
    <a href=“/JavaTeamWork_war_exploded/LoginServlet”>
        サインイン
    </a>
    </c:if>
</header>
