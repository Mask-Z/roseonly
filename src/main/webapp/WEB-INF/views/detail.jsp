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
<style type="text/css">
    body {
        background-color: #EEDDEE;
    }

</style>
<body>
<script src="/static/js/jquery-1.9.1.min.js"></script>
<!-- 引入头部导航 -->
<jsp:include flush="true" page="header.jsp"></jsp:include>
<a onclick="javscript: window.history.go(-1)" style="cursor: hand;" href="###">返回</a><br/>
<h4 align="center"> 商品详情</h4>

<ul align="center"><img src="/static/picture/${flower.id}.jpg" /></ul>
<ul>商品名称: ${flower.name}</ul>
<ul> 价 格 : ${flower.price}</ul>
<ul>剩余数量: ${flower.amount}</ul>
<%--提交实体类报错400--%>
<form action="/main/paying" method="post">
    <input type="hidden" value="${baseUser.id}" id="userByUserId" name="userByUserId"/>
    <input type="hidden" value="${flower.id}" id="flowerByFlowerId" name="flowerByFlowerId">
    <input type="hidden" value="${flower.price}" id="price" name="price">
    <input type="hidden" value="${flower.name}" id="name" name="name">
    <input type="hidden" value="${flowerList.get(0).name}" id="flowerP" name="flowerP">
    <input id="min" name="min" type="button" value="-"/>
    <input id="amount" name="amount"  type="text" value="0"/>
    <input id="add" name="add" type="button" value="+"/>
    <p>总价：<label id="total"></label></p>
    <br> <input type="submit" id="sub" name="sub" value="直接购买"/>
    <br> <input type="button" value="加入购物车" id="addCart" name="addCart" onclick="addToCart()">
</form>
<a href="/main/dealCart"><button>去购物车结算</button></a>
<script>
    $(function () {
        var t = $("#amount");
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
    });
</script>
<script type="text/javascript">
    function addToCart() {
        if ($.trim($("#amount").val())== '0') {
            alert("数量为0,不能加入购物车");
            return false;
        }else{
            var formData = new Object();
            var data = $(":input").each(function () {
                formData[this.name] = $("#" + this.name).val();
            });
            $.ajax({
                async: false,
                cache: false,
                type: 'POST',
                url: '/main/addCart',
                data: formData,
                error: function () {// 请求失败处理函数
                },
                success: function () {
                    alert("已成功添加到购物车!");
                }
            });
        }
    }
</script>
</body>

</html>
