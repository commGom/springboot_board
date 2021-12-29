package com.ggoreb.practice.aop;

import com.ggoreb.practice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Aspect
@Component
@Slf4j
public class LoginControlAspect {

    @Before(value = "execution (* com.ggoreb.practice.controller.QuestionController.*(..))")
    public void onBeforeHandler(JoinPoint joinPoint) throws IOException {
        log.debug("@Before run");
        HttpServletRequest request=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response=((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getResponse();
        HttpSession session =((HttpServletRequest) request).getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("/signin");
        }
    }
    @After(value = "execution (* com.ggoreb.practice.controller.QuestionController.*(..))")
    public void onAfterHandler(JoinPoint joinPoint) {
        log.debug("@After run");
    }
    @AfterReturning(value = "execution (* com.ggoreb.practice.controller.QuestionController.*(..)))",
            returning = "data")
    public void onAfterReturningHandler(JoinPoint joinPoint, Object data) {
        if (data != null) {
            log.debug(data.toString());
        }
        log.debug("@AfterReturning run");
    }
}
