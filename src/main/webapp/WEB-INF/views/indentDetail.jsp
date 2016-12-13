<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/13
  Time: 21:43
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>订单详情</title>
</head>
<body>
<div class="container">
    <h1>${user.name}的订单</h1>
    <hr/>
    <c:if test="${! empty indentList}">
        <c:forEach items="${indentList}" var="indent">
            <table class="table table-bordered table-striped">
                <tr>
                    <th>ID</th>
                    <td>${indent.id}</td>
                </tr>
                <tr>
                    <th>商品信息</th>
                    <td>${indent.dealDetails}</td>
                </tr>
                <tr>
                    <th>实付款</th>
                    <td>${indent.totalMoney}</td>
                </tr>
                <tr>
                    <th>地址</th>
                    <td>${indent.address}</td>
                </tr>
                <tr>
                    <th>配送方式</th>
                    <td>
                        <c:if test="${indent.postStyle==1}">顺丰快递</c:if>
                        <c:if test="${indent.postStyle==2}">天天快递</c:if>
                    </td>
                </tr>
                <tr>
                    <th>支付方式</th>
                    <td>
                        <c:if test="${indent.payStyle==1}">在线支付</c:if>
                        <c:if test="${indent.payStyle==2}">货到付款</c:if>
                    </td>
                </tr>
                <tr>
                    <th>订单状态</th>
                    <c:if test="${baseUser.role==0}">
                    <td>
                        <c:if test="${indent.state==1}">未出库</c:if>
                        <c:if test="${indent.state==2}">已收货</c:if>
                    </td>
                    </c:if>
                    <%--管理员--%>
                    <c:if test="${baseUser.role==1}">
                        <td>
                            <c:if test="${indent.state==1}">未出库,<a href="#">确认出库</a></c:if>
                            <c:if test="${indent.state==2}">交易完成</c:if>
                        </td>
                    </c:if>
                </tr>

            </table><br/><hr/>
        </c:forEach>
    </c:if>
</div>
</body>
</html>
