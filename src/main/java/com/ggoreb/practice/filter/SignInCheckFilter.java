package com.ggoreb.practice.filter;

import com.ggoreb.practice.model.User;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
@Slf4j
public class SignInCheckFilter implements Filter {
    public void doFilter(
            ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        log.debug("filter begin");
        HttpServletRequest req = (HttpServletRequest) request;
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            ((HttpServletResponse)response).sendRedirect("/signin");
        }

        chain.doFilter(req, response);
        log.debug("filter end");
    }
}

