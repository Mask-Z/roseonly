<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/8
  Time: 22:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<html>

<head>
    <title>商品详情</title>
</head>

<body>
<script src="/static/js/jquery-1.9.1.min.js"></script>
商品详情

<ul><img src="/static/picture/${flower.id}.jpg"/></ul>
<ul>商品名称: ${flower.name}</ul>
<ul> 价 格 : ${flower.price}</ul>
<ul>剩余数量: ${flower.amount}</ul>
<%--提交实体类报错400--%>
<form action="/main/paying" method="post">
    <input type="hidden" value="${baseUser.id}" id="userByUserId" name="userByUserId"/>
    <input type="hidden" value="${flower.id}" id="flowerByFlowerId" name="flowerByFlowerId">
    <input id="min" name="" type="button" value="-"/>
    <input id="text_box" name="number" id="number" type="text" value="0"/>
    <input id="add" name="" type="button" value="+"/>
    <p>总价：<label id="total"></label></p>
    <br> <input type="submit" value="购买"/>
</form>
<script>
    $(function () {
        var t = $("#text_box");
        $("#add").click(function () {
            t.val(parseInt(t.val()) + 1)
            setTotal();
        })
        $("#min").click(function () {
            t.val(parseInt(t.val()) - 1)
            setTotal();
        })
        function setTotal() {
            $("#total").html((parseInt(t.val()) *${flower.price}).toFixed(2));
        }

        setTotal();
    })
</script>
</body>

</html>
