package com.zarmas.ninjabackend.component;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
    private final Log log = LogFactory.getLog(RequestTimeInterceptor.class);

    // Executes before controller's method
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        request.setAttribute("startTime", System.currentTimeMillis());
        return super.preHandle(request, response, handler);
    }

    // Executes before render templates
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long startTime = (long) request.getAttribute("startTime");
        long time = System.currentTimeMillis() - startTime;
        log.info("URL To: '" + request.getRequestURL().toString() + "' -- in: '" + time + "'ms");
        super.afterCompletion(request, response, handler, ex);
    }
}
