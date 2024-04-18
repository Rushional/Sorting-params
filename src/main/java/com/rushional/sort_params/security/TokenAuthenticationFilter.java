package com.rushional.sort_params.security;

import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RequiredArgsConstructor
public class TokenAuthenticationFilter extends OncePerRequestFilter {

    private final Environment environment;

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
        return request.getRequestURI().startsWith("/params");
    }

    private boolean isValidToken(String token) {
        String paramsHashingHeaderToken = environment.getProperty("constants.params-hashing-header-token");
        return paramsHashingHeaderToken != null && paramsHashingHeaderToken.equals(token);
    }
}