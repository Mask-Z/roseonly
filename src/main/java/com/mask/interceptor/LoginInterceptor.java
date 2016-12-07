package com.mask.interceptor;

import com.mask.exception.WebAuthException;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;
import org.springframework.web.servlet.support.SessionFlashMapManager;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.sun.org.apache.xml.internal.serialize.LineSeparator.Web;

/**
 * Created by Mr丶周 on 2016/12/7.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
	private List<String> excludedUrls;//不拦截的url集合

	public void setExcludeUrls(List<String> excludeUrls) {
		this.excludedUrls = excludeUrls;
	}

	@Override
	public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
		String uri=request.getRequestURI();
		for (String url:excludedUrls){
			if (uri.endsWith(url)){
				return true;
			}
		}
		HttpSession session=request.getSession();
		if (null!=session.getAttribute("login")){
			return true;
		}else
			throw new WebAuthException();

	}
}
