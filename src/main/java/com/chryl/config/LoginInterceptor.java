package com.chryl.config;

import com.chryl.service.model.sso.SsoConf;
import com.chryl.utils.CookieUtil;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 登录拦截器
 * <p>
 * Created By Chr on 2019/7/16.
 */
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    /**
     * 在请求处理之前进行调用（Controller方法调用之前）
     */
    // 目标方法执行之前
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURI();
        log.debug("访问拦截地址:{}", url);
        /**
         * 验证是否登录
         * (1):验证cookie
         * (2):验证session
         */
        //验证cookie是否存在
        String cookieValue = CookieUtil.getCookieValue(request, SsoConf.SSO_COOKIE_NAME, true);
//        Object user = request.getSession().getAttribute("loginUser");
        // 如果获取的request的session中的loginUser参数为空（未登录），就返回登录页，否则放行访问
//        if (user == null) {
        if (StringUtils.isEmpty(cookieValue)) {
            // 未登录，给出错误信息，
            request.setAttribute("msg", "无权限请先登录");
            // 获取request返回页面到登录页
            request.getRequestDispatcher("/index.html").forward(request, response);
            return false;
        } else {
            // 已登录，放行
            return true;
        }
    }

    /**
     * 请求处理之后进行调用，但是在视图被渲染之前（Controller方法调用之后）
     */
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    /**
     * 在整个请求结束之后被调用，也就是在DispatcherServlet 渲染了对应的视图之后执行（主要是用于进行资源清理工作）
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
