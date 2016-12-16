<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	response.setHeader("Cache-Control","no-store");
	response.setHeader("Pragrma","no-cache");
	response.setDateHeader("Expires",0);
%>
<!-- 头部导航 -->
<div class="header">
	<div class="head">
		<a href="./" class="roseonly-logo"></a>
		<div class="right">
			<c:if test="${baseUser!= null}">
				<a id="user_center" href="userLists" title="个人中心">个人中心&nbsp;|</a>
				<a id="logout" href="/main/logout" title="注销">注销&nbsp;|</a>
				<a href="/main/dealCart" title="购物车" class="right-shop"><span id="cartNum">购物车</span></a>
			</c:if>
			<%--<c:if test="${user.userId == null}">--%>
				<%--<a id="login" href="javascript:void(0);" title="登录">登录&nbsp;|</a>--%>
				<%--<a id="register" href="register" title="注册" >&nbsp;注册</a>--%>
			<%--</c:if>--%>
			<a class="left">热线电话 123-456-7890&nbsp;</a>
			<%--<a href="javascript:void(0);" title="收藏夹" class="collect">收藏夹</a>--%>
		</div>
	</div>
</div>



