<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/12
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp" %>
<html>
<head>
    <title>更新用户</title>
</head>
<body>
<div class="container">
    <h1>RoseOnly修改用户信息</h1>
    <hr/>

    <form action="/users/updateP" method="post">
        <div class="form-group">
            <label for="name">用户名:</label>
            <input type="text" class="form-control" id="name" name="name"
                   value="${user.name}"/>
        </div>
        <div class="form-group">
            <label for="password">密码:</label>
            <input type="text" class="form-control" id="password" name="password"
                   value="${user.password}"/>
        </div>
        <div class="form-group">
            <label for="realname">真实姓名:</label>
            <input type="text" class="form-control" id="realname" name="realname"
                   value="${user.realname}"/>
        </div>
        <div class="form-group">
            <label for="number">手机号码:</label>
            <input type="text" class="form-control" id="number" name="number"
                   value="${user.number}"/>
        </div>
        <div class="form-group">
            <label for="city">地址:</label>
            <input type="text" class="form-control" id="city" name="city"
                   value="${user.city}"/>
        </div>

        <c:if test="${baseUser.role==1}">
            <div class="form-select-button">
                <label for="role">角色:</label>
                        <select name="role" id="role">
                            <option value="0" <c:if test="${user.role==0}" >selected</c:if> >普通用户</option>
                            <option value="1" <c:if test="${user.role==1}" >selected</c:if> >管理员</option>
                        </select>
            </div>
        </c:if>

        <!-- 把 id 一并写入 userP 中 -->
        <input type="hidden" id="id" name="id" value="${user.id}"/>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form>
</div>

</body>
</html>
