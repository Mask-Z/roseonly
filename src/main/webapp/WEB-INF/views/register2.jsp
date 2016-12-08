<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: zyl
  Date: 2016/12/8
  Time: 13:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%--<%@include file="base.jsp"%>--%>
<html>
<head>
    <title>注册</title>
</head>
<script src="/WEB-INF/js/checkCity.js"/>
<body >
<%--<form:form action="#" modelAttribute="User" method="post" id="form1">--%>
<h1>人呢</h1>
<%--<form action="#"  method="post" id="form1">--%>
    <%--&lt;%&ndash;<form:input path="name" />&ndash;%&gt;--%>
    <%--&lt;%&ndash;<form:password path="password"/>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<form:input path="realname"/>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<form:input path="number"/>&ndash;%&gt;--%>
    <%--&lt;%&ndash;<form:checkbox path="gender" value="男"/>男&ndash;%&gt;--%>
    <%--&lt;%&ndash;<form:checkbox path="gender" value="女"/>女&ndash;%&gt;--%>

    <%--<select name="sf" onchange="cityName(this.selectedIndex)">--%>
        <%--<option value="">--%>
            <%--选择省份--%>
        <%--</option>--%>
    <%--</select>--%>

    <%--<select name="sq" >--%>
        <%--<option value="">--%>
            <%--选择市区--%>
        <%--</option>--%>
    <%--</select>--%>
    <%--<input type="submit" value="注册">--%>
<%--</form>--%>

<form name=form1>
    <select name=province onchange="cityName(this.selectedIndex)">
        <option value="">
            请选择省名
        </option>
    </select>

    <select name=city>
        <option value="">
            请选择城名
        </option>
    </select>
</form>
</body>
</html>
