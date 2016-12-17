<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/8
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="base.jsp" %>
<%@page isELIgnored="false" %>
<html>
<head>
    <meta http-equiv="pragma" content="no-cache">
    <meta http-equiv="cache-control" content="no-cache">
    <meta http-equiv="expires" content="0">
    <meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
    <meta http-equiv="description" content="This is my page">
    <title>首页</title>

</head>
<style type="text/css">
    body {
        /*background-color: #419641;*/
        background-color: #${color};
    }

</style>
<style>
    .picutre_many img {
        width: 200px;
        height: 150px;
    }
</style>
<script src=""></script>
<script>
    function showMsg() {
        var msg = '<%=request.getAttribute("msg")%>';
        if (msg != null && msg != 'null' && msg != '') {
            alert(msg);
        }
    }
</script>
<style>
    #Layer1 {
        /*background-image: url("/static/picture/bgp.jpg");*/

        /*width: 200px;*/
        /*height: 100px;*/
        /*color: #fff;*/
        /*font-size: 12px;*/
        /*border: 10px dotted #333;*/
        /*padding: 10px;*/
        background: url("/static/picture/heise.jpg") no-repeat;
        width: inherit;
        height: 100%;

    }
</style>
<script>
   function updateColor() {
//       var color = $("#color").val();
////       var name = document.getElementById("color").value.trim();
//       var formData = new Object();
//           formData["color"] =color;

       var url="/updateColor";
//       alert(url);
       $.ajax({
           async: false,
           cache: false,
           type: 'POST',
           url: url,// 请求的action路径
           data:"color="+$("#color").val(),
           error: function () {// 请求失败处理函数
               alert("修改失败!!");
           },
           success: function (data) {
               alert("修改主题成功!");

           }
       });
   }
</script>
<body onload="showMsg()">

<c:if test="${baseUser.role==1}">
    <div id="Layer1" align="center">
        <br><br>
        <h4 style="color: #d9534f">首页主题:</h4>
        <select id="color" name="color">
            <option value="EEDDEE" <c:if test="${color=='EEDDEE'}">selected</c:if> >默认</option>
            <option value="419641" <c:if test="${color=='419641'}">selected</c:if> >草绿</option>
            <option value="f8d9ac" <c:if test="${color=='f8d9ac'}">selected</c:if> >鹅黄</option>
        </select><br>
        <a class="btn" href="###" onclick="updateColor()">确认</a>
        <br><br><br><br><br><br><br>
        <a id="user_center" href="userLists" title="用户管理"><h2>用户管理</h2>&nbsp;</a><br>
        <a id="logout" href="/main/logout" title="退出"><h2>退出</h2>&nbsp;</a>
            <%--<img src="/static/picture/bgm.jpg" height="100%" width="100%"/>--%>
    </div>

</c:if>
<c:if test="${baseUser.role==0}">
    <!-- 引入头部导航 -->
    <jsp:include flush="true" page="header.jsp"></jsp:include>
    <h3 align="center">本店热销</h3>
    <div id="list" class=" picutre_many"
         style="overflow: hidden; height: 250px; width: 800px; margin: 0 auto;">
        <table cellspacing="0" cellpadding="0"
               style="width: 680px; border: 0px;">
            <tr>
                <td id="list1">
                    <table style="border: 0px;" cellpadding="0" cellspacing="0">
                        <tr id="pic">
                            <td><a href="/main/detail?id=1"> <img style="border: 0px;" alt=""
                                                                  src="/static/picture/1.jpg"/><br>
                                <h2 align="center">白玫瑰</h2></a></td>
                            <td><a href="/main/detail?id=2"> <img style="border: 0px;" alt=""
                                                                  src="/static/picture/2.jpg"/><br>
                                <h2 align="center">黑玫瑰</h2></a></td>
                            <td><a href="/main/detail?id=3"> <img style="border: 0px;" alt=""
                                                                  src="/static/picture/3.jpg"/><br>
                                <h2 align="center">红玫瑰</h2></a></td>
                            <td><a href="/main/detail?id=1"> <img style="border: 0px;" alt=""
                                                                  src="/static/picture/1.jpg"/><br>
                                <h2 align="center">白玫瑰</h2></a></td>
                            <td><a href="/main/detail?id=2"> <img style="border: 0px;" alt=""
                                                                  src="/static/picture/2.jpg"/><br>
                                <h2 align="center">黑玫瑰</h2></a></td>
                            <td><a href="/main/detail?id=3"> <img style="border: 0px;" alt=""
                                                                  src="/static/picture/3.jpg"/><br>
                                <h2 align="center">红玫瑰</h2></a></td>
                            <td><a href="/main/detail?id=1"> <img style="border: 0px;" alt=""
                                                                  src="/static/picture/1.jpg"/><br>
                                <h2 align="center">白玫瑰</h2></a></td>
                            <td><a href="/main/detail?id=2"> <img style="border: 0px;" alt=""
                                                                  src="/static/picture/2.jpg"/><br>
                                <h2 align="center">黑玫瑰</h2></a></td>
                            <td><a href="/main/detail?id=3"> <img style="border: 0px;" alt=""
                                                                  src="/static/picture/3.jpg"/><br>
                                <h2 align="center">红玫瑰</h2></a></td>
                        </tr>
                    </table>
                </td>
                <td id="list2"></td>
            </tr>
        </table>
    </div>
    <form action="/flowerSearch" method="post">
        <input type="text" value="${search}" name="search" id="search" placeholder="搜索鲜花">
        <input type="submit" value="搜索">
    </form>
    <table class="table table-bordered table-striped" align="center">
        <tr>
            <th>名称</th>
            <th>价格</th>
            <th>数量</th>

        </tr>
        <c:forEach items="${flowerList}" var="flower">
            <tr>
                <td><a href="/main/detail?id=${flower.id}"> ${flower.name}</a></td>
                <td>${flower.price}</td>
                <td>${flower.amount}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<script type="text/javascript">
    /*图片滚动效果*/
    var speedpic = 20;//速度数值越大速度越慢
    document.getElementById("list2").innerHTML = document.getElementById("list1").innerHTML;
    function Marqueepic() {
        if (document.getElementById("list2").offsetWidth
                - document.getElementById("list").scrollLeft <= 0) {
            document.getElementById("list").scrollLeft -= document
                    .getElementById("list1").offsetWidth;
        } else {
            document.getElementById("list").scrollLeft++;
        }
    }
    var MyMarpic = setInterval(Marqueepic, speedpic);

    document.getElementById("list").onmouseover = function () {
        clearInterval(MyMarpic);
    }
    document.getElementById("list").onmouseout = function () {
        MyMarpic = setInterval(Marqueepic, speedpic);
    }
</script>
</body>
</html>
