<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: zyl
  Date: 2016/12/8
  Time: 9:52
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp" %>
<%@ page isELIgnored="false" %>
<html>
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<head>
    <title>Login</title>
</head>

<body>
<div class="container">
    <h1 class="page-header">登录界面</h1>
    <c:if test="${!empty msg}">
        <div class="row"><input type="submit" class="btn btn-success btn-lg col-sm-3" value="${msg}" align="center">
        </div>
        <% session.removeAttribute("msg");%>
    </c:if>

    <form action="/sysLogin" check="/checkUser" method="post">
        <div class="row">
            <div class="form-group col-sm-7">
                <label for="name">账号</label>
                <input type="text" class="form-control" id="name" name="name" placeholder="请输入账号">
            </div>
        </div>
        <div class="row">
            <div class="form-group col-sm-7">
                <label for="password">密码</label>
                <input type="password" class="form-control" id="password" name="password" placeholder="请输入密码">
            </div>
        </div>
        <div class="row"><a class="btn btn-info btn-lg col-sm-3" onclick="checkUser()">登录</a>
        </div>
        <br>
        <div class="row"><a class="btn btn-danger btn-lg col-sm-3" href="/register">注册</a>
        </div>
    </form>
<br><br><br><br>
    <div class="footer">
           <div >
            <a href="#"> 关于我们&nbsp</a>
            |&nbsp
            <a href="#">常见问题&nbsp</a>
            |&nbsp
            <a href="#">加入我们&nbsp</a>
            |&nbsp
            <a href="#">退换条例&nbsp</a>
            |&nbsp
            <a href="#">新浪微博</a>
</div><br>
        <div ><h4>常州大学信息科学与工程学院</h4></div>
    </div>
</div>

<script type="text/javascript">
    //验证用户信息
    function checkUser() {
        if (!validForm()) {
            return false;
        }else {
        newLogin();
        }
    }
    //表单验证
    function validForm() {
        if ($.trim($("#name").val()).length == 0) {
            alert("请输入用户名");
            return false;
        }

        if ($.trim($("#password").val()).length == 0) {
            alert("请输入密码");
            return false;
        }
        return true;
    }

    //登录处理函数
    function newLogin() {
        var actionurl = $('form').attr('action');//提交路径
        var checkurl = $('form').attr('check');//验证路径
        var formData = new Object();
        var data = $(":input").each(function () {
            formData[this.name] = $("#" + this.name).val();
        });
        $.ajax({
            async: false,
            cache: false,
            type: 'POST',
            url: checkurl,// 请求的action路径
            data: formData,
            error: function () {// 请求失败处理函数
            },
            success: function (data) {
                if (data=="success"){
                    window.location.href = actionurl;
                } else {
                    alert(data);
                }
            }
        });
    }
</script>

</body>
</html>