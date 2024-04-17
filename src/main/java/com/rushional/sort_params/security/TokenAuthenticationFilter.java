package com.rushional.sort_params.security;

import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class TokenAuthenticationFilter extends OncePerRequestFilter {
    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        if (!requiresHeaderAuthentication(request)) {
            filterChain.doFilter(request, response);
            return;
        }

        String token = request.getHeader("Token");
        if (token == null || !isValidToken(token)) {
            response.setStatus(HttpStatus.FORBIDDEN.value());
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean requiresHeaderAuthentication(HttpServletRequest request) {
        return "/params".equals(request.getRequestURI());
    }

    private boolean isValidToken(String token) {
        // TODO: use env var here
        return "valid_token_value".equals(token);
    }
}