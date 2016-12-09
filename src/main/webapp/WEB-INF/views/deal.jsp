<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/9
  Time: 23:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="base.jsp"%>
<%@ page isELIgnored="false" %>
<html>
<head>
    <title>结算</title>
</head>
<body>

<div class="container">
    <h1>交易详情</h1>
    <hr/>

    <form:form action="#" method="post" commandName="deal" role="form">
        <div class="form-group">
            <label for="name">姓名:</label>
            <input type="text" class="form-control" id="name" name="name"
                   value="${indent.userByUserId.realname}"/>
        </div>
        <div class="form-group">
            <label for="dealDetails">商品清单:</label>
            <input type="text" class="form-control" id="dealDetails" name="dealDetails" placeholder="Enter FirstName:"
                   value="${indent.dealDetails}"/>
        </div>
        <div class="form-group">
            <label for="address">送货地址:</label>
            <input type="text" class="form-control" id="address" name="address" placeholder="Enter LastName:"
                   value="${indent.address}"/>
        </div>

        <!-- 把 id 一并写入 userP 中 -->
        <%--<input type="hidden" id="id" name="id" value="${user.id}"/>--%>

        <div class="form-group">
            <button type="submit" class="btn btn-sm btn-success">提交</button>
        </div>
    </form:form>
</div>

</body>
</html>
