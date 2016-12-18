package com.mask.interceptor;

import com.mask.exception.WebAuthException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpSession;
import java.util.List;

import static com.mask.utils.Util.out;

/**
 * Created by Mr丶周 on 2016/12/7.
 */
public class LoginInterceptor extends HandlerInterceptorAdapter {
    private final Log logger = LogFactory.getLog(LoginInterceptor.class);
    private List<String> excludedUrls;//不拦截的url集合

    public void setExcludeUrls(List<String> excludeUrls) {
        this.excludedUrls = excludeUrls;
    }

    @Override
    public boolean preHandle(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response, Object handler) throws Exception {
        logger.info("欢迎来到RoseOnly!");
        String uri = request.getRequestURI();
        for (String url : excludedUrls) {
            if (uri.endsWith(url)) {
                return true;
            }
        }
        HttpSession session = request.getSession();
        if (null != session.getAttribute("baseUser")) {
            return true;
        } else {
            out("进入loginInterceptor........");
            throw new WebAuthException();
        }
    }
}
