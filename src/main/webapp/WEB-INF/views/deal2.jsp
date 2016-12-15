<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/9
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>结算</title>
</head>

<body>

<div class="container">
    <c:if test="${empty map}">
        <h2>购物车没有商品</h2><br>
        <div class="row"><a class="btn btn-danger btn-lg col-sm-" href="/sysLogin">继续逛逛</a>
    </c:if>
    <c:if test="${not empty map}">
        <h1>交易详情</h1>
        <hr/>
        <form action="/indent/saveIndent" method="post" role="form">
            <div class="form-group">
                <label for="name">姓名:</label>
                <input type="text" class="form-control" id="name" name="name"
                       value="${baseUser.name}"/>
            </div>
            <div class="form-group">
                <label for="dealDetails">商品清单:</label>
                <c:forEach items="${map}" var="i">
                    <input type="text" class="form-control" id="dealDetails" name="dealDetails"
                           value="${i.key}*${i.value}"/>
                </c:forEach>
            </div>

            <div class="form-group">
                <label for="totalMoney">需支付:</label>
                <input type="text" class="form-control" id="totalMoney" name="totalMoney"
                       value="${count}" onfocus="this.blur()"/>
            </div>

            <div class="form-group">
                <label for="address">送货地址:</label>
                <input type="text" class="form-control" id="address" name="address"
                       value="${baseUser.city}"/>
            </div>
            <div class="form-group">
                <label for="mobile">联系方式:</label>
                <input type="text" class="form-control" id="mobile" name="mobile"
                       value="${baseUser.number}"/>
            </div>
            <div class="form-group">
                <label for="postStyle">配送方式:</label>
                <select class="form-select-button" id="postStyle" name="postStyle">
                    <option value="1">顺丰快递</option>
                    <option value="2">天天快递</option>
                </select>
            </div>

            <div class="form-group">
                <label for="payStyle">付款方式:</label>
                <select class="form-select-button" id="payStyle" name="payStyle">
                    <option value="1">在线支付</option>
                    <option value="2">货到付款</option>
                </select>
            </div>

            <div class="form-group">
                <button type="submit" class="btn btn-sm btn-success">付款</button>
            </div>
        </form>
    </c:if>
</div>
</div>
</body>
</html>
