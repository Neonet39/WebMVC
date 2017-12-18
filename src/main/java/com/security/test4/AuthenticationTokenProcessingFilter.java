package com.security.test4;


import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;


public class AuthenticationTokenProcessingFilter extends UsernamePasswordAuthenticationFilter {

    private UserDetailsService userDetailsService;

    public AuthenticationTokenProcessingFilter(UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = this.getAsHttpRequest(request);

       // "user:1513553969491:56abc11d0f906fd34722bbf830ba78a1";
        String authToken = this.extractAuthTokenFromRequest(httpRequest);

        // httpServletRequest.setHeader("X-Auth-Token:",authToken);

        String userName = TokenUtils.getUserNameFromToken(authToken);

        if (userName != null && SecurityContextHolder.getContext().getAuthentication() == null) {

            UserDetails userDetails = userDetailsService.loadUserByUsername(userName);

            if (TokenUtils.validateToken(authToken, userDetails)) {
                TokenAuthentication authentication =
                        new TokenAuthentication(userDetails, null, userDetails.getAuthorities());
                authentication.setToken(authToken);
                SecurityContextHolder.getContext().setAuthentication(authentication);
            }
        }

        chain.doFilter(request, response);
    }


    private HttpServletRequest getAsHttpRequest(ServletRequest request) {
        if (!(request instanceof HttpServletRequest)) {
            throw new RuntimeException("Expecting an HTTP request");
        }

        return (HttpServletRequest) request;
    }


    private String extractAuthTokenFromRequest(HttpServletRequest httpRequest) {

        String authToken = httpRequest.getHeader("X-Auth-Token");

        if (authToken == null) {
            authToken = httpRequest.getParameter("token");
        }
        return authToken;
    }
}

