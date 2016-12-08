<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/8
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="true" %>
<html>
<head>
    <title>商品详情</title>
</head>
<body>
商品详情
<form>
    <input type="text" value="${flower}">
</form>
<h2>${flower.name}</h2>
<c:if test="${not empty flower}" var="f">
    <ul>${f.name}</ul>
    <ul>f.amount</ul>
    <ul>f.price</ul>
</c:if>
</body>
</html>
