<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/7
  Time: 22:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>Title</title>

    <link href="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet">
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/css/bootstrap-theme.min.css"></script>
    <script src="http://apps.bdimg.com/libs/jquery/2.0.0/jquery.min.js"></script>
    <script src="http://apps.bdimg.com/libs/bootstrap/3.3.0/js/bootstrap.min.js"></script>
</head>
<body>

<div class="panel panel-default">
    <div class="panel-heading">欢迎来到RoseOnly登陆界面</div>
    <div class="panel-body">
        <form role="form">
            <div class="form-group">
                <label for="username">用户名:</label>
                <input id="username" type="email" class="form-control" placeholder="请输入邮箱">
            </div>
            <div class="form-group">
                <label for="password">密码:</label>
                <input type="password" id="password" class="form-control" placeholder="请输入密码">
            </div>
            <div class="checkbox">
                <label>
                    <input type="checkbox" id="checkbox" class="checkbox">记住密码
                </label>
            </div>
            <%--<div class="img">--%>
                <%--<input type="text" placeholder="请输入验证码">--%>
                <%--<img>--%>
            <%--</div>--%>
            <button class="btn btn-block btn-primary">
                登录系统
            </button>
        </form>
    </div>
    <div class="panel-footer">常州大学</div>
</div>

</body>
<script type="text/javascript">
    $(function () {
        var $btn = $(".btn");
        var $username = $("#username");
        var $password = $("#password");
        $btn.on(
                "click", function () {
                    $.ajax({
                        url: "",
                        data: "$username+$password",
                        dataType: "jason",
                        type: "post",
                        success: function () {
                            if (data == Fail) {
                                alert("登陆失败！请重新输入")
                            } else {
                                alert("登陆成功！")
                            }
                        }
                    })
                })
    })
</script>
</html>
