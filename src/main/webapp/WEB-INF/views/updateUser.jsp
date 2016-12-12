<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/12
  Time: 22:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>更新用户</title>
</head>
<body>
<div class="container">
    <h1>SpringMVC 更新用户信息</h1>
    <hr/>

    <form:form action="users/updateP" method="post" commandName="userP" role="form">
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
        <!-- 把 id 一并写入 userP 中 -->
        <input type="hidden" id="id" name="id" value="${user.id}"/>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>
</div>

</body>
</html>
