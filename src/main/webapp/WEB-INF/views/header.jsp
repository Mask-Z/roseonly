<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- 头部导航 -->
<div class="header">
	<div class="head">
		<a href="./" class="roseonly-logo"></a>
		<div class="right">
			<c:if test="${baseUser!= null}">
				<a id="user_center" href="/main/userManage" title="个人中心">个人中心&nbsp;|</a>
				<a id="logout" href="/main/logout" title="注销">&nbsp;注销</a>
				<a href="shopping?method=seeMyCart" title="购物车" class="right-shop"><span id="cartNum">购物车</span></a>
			</c:if>
			<%--<c:if test="${user.userId == null}">--%>
				<%--<a id="login" href="javascript:void(0);" title="登录">登录&nbsp;|</a>--%>
				<%--<a id="register" href="register" title="注册" >&nbsp;注册</a>--%>
			<%--</c:if>--%>
			<a class="left">热线电话 123-456-7890&nbsp;</a>
			<a href="javascript:void(0);" title="收藏夹" class="collect" onclick="addToFavorite('roseonly玫瑰礼盒_多色玫瑰花_roseonly优惠券_玫瑰花礼盒_roseonly诺誓官网 ','http://www.roseonly.com.cn/');">收藏夹</a>
		</div>
	</div>
</div>



