<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Mr丶周
  Date: 2016/12/8
  Time: 21:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>首页</title>
</head>
<style>
    .picutre_many img{width:200px; height:150px;}
</style>
<script src=""></script>
<script>
    function showMsg() {
        var msg='<%=request.getAttribute("msg")%>';
        if(msg!=null&&msg!='null'&&msg!=''){
            alert(msg);
        }
    }
</script>
<body onload="showMsg()">
<!-- 引入头部导航 -->
<jsp:include flush="true" page="header.jsp"></jsp:include>
<div id="list" class=" picutre_many"
     style="overflow: hidden; height: 250px; width: 800px; margin: 0 auto;">
    <table cellspacing="0" cellpadding="0"
           style="width: 680px; border: 0px;">
        <tr>
            <td id="list1">
                <table style="border: 0px;" cellpadding="0" cellspacing="0">
                    <tr id="pic">
                        <td><a href="/main/detail?id=1"> <img style="border: 0px;" alt="" src="/static/picture/1.jpg" /><br><h2 align="center">白玫瑰</h2></a></td>
                        <td><a href="/main/detail?id=2"> <img style="border: 0px;" alt="" src="/static/picture/2.jpg" /><br><h2 align="center">黑玫瑰</h2></a></td>
                        <td><a href="/main/detail?id=3"> <img style="border: 0px;" alt="" src="/static/picture/3.jpg" /><br><h2 align="center">红玫瑰</h2></a></td>
                        <td><a href="/main/detail?id=1"> <img style="border: 0px;" alt="" src="/static/picture/1.jpg" /><br><h2 align="center">白玫瑰</h2></a></td>
                        <td><a href="/main/detail?id=2"> <img style="border: 0px;" alt="" src="/static/picture/2.jpg" /><br><h2 align="center">黑玫瑰</h2></a></td>
                        <td><a href="/main/detail?id=3"> <img style="border: 0px;" alt="" src="/static/picture/3.jpg" /><br><h2 align="center">红玫瑰</h2></a></td>
                        <td><a href="/main/detail?id=1"> <img style="border: 0px;" alt="" src="/static/picture/1.jpg" /><br><h2 align="center">白玫瑰</h2></a></td>
                        <td><a href="/main/detail?id=2"> <img style="border: 0px;" alt="" src="/static/picture/2.jpg" /><br><h2 align="center">黑玫瑰</h2></a></td>
                        <td><a href="/main/detail?id=3"> <img style="border: 0px;" alt="" src="/static/picture/3.jpg" /><br><h2 align="center">红玫瑰</h2></a></td>
                    </tr>
                </table>
            </td>
            <td id="list2"></td>
        </tr>
    </table>
</div>



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

    document.getElementById("list").onmouseover = function() {
        clearInterval(MyMarpic);
    }
    document.getElementById("list").onmouseout = function() {
        MyMarpic = setInterval(Marqueepic, speedpic);
    }
</script>
</body>
</html>
