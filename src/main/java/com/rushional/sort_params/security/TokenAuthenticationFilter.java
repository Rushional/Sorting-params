package com.rushional.sort_params.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import org.springframework.web.servlet.HandlerExceptionResolver;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    @Autowired
    private Environment environment;

    @Autowired
    @Qualifier("handlerExceptionResolver")
    private HandlerExceptionResolver resolver;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (!requiresHeaderAuthentication(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("Token");
        if (token == null || !isValidToken(token)) {
            resolver.resolveException(request, response, null, new BadCredentialsException("Wrong or missing header"));
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean requiresHeaderAuthentication(HttpServletRequest request) {
        return request.getRequestURI().startsWith("/params");
    }

    private boolean isValidToken(String token) {
        String paramsHashingHeaderToken = environment.getProperty("constants.params-hashing-header-token");
        return paramsHashingHeaderToken != null && paramsHashingHeaderToken.equals(token);
    }
}