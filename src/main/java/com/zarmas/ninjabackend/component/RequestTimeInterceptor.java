package com.zarmas.ninjabackend.component;

import com.zarmas.ninjabackend.repository.LogRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;

@Component("requestTimeInterceptor")
public class RequestTimeInterceptor extends HandlerInterceptorAdapter {
    private final Log log = LogFactory.getLog(RequestTimeInterceptor.class);

    @Autowired
    @Qualifier("LogRepository")
    private LogRepository logRepository;

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
        String url = request.getRequestURL().toString();
        log.info("URL To: '" + url + "' -- in: '" + time + "'ms");

        String username = "";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication != null && authentication.isAuthenticated())
            username = authentication.getName();

        com.zarmas.ninjabackend.entity.Log ownLog =
                new com.zarmas.ninjabackend.entity.Log(
                        new Date(),
                        authentication.getDetails().toString(),
                        username,
                        url);

        logRepository.save(ownLog);

        super.afterCompletion(request, response, handler, ex);
    }
}
