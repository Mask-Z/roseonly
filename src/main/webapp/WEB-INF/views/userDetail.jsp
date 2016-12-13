<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/12
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp"%>
<html>
<head>
    <title>用户详情</title>
</head>
<body>
<div class="container">
    <h1>RoseOnly 用户详情</h1>
    <hr/>

    <table class="table table-bordered table-striped">
        <tr>
            <th>ID</th>
            <td>${user.id}</td>
        </tr>
        <tr>
            <th>用户名</th>
            <td>${user.name}</td>
        </tr>
        <tr>
            <th>密码</th>
            <td>${user.password}</td>
        </tr>
        <tr>
            <th>真实姓名</th>
            <td>${user.realname}</td>
        </tr>
        <tr>
            <th>手机号码</th>
            <td>${user.number}</td>
        </tr>
        <tr>
        <th>地址</th>
        <td>${user.city}</td>
        </tr>

    </table>

</div>
</body>
</html>
