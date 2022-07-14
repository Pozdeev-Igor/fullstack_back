package com.example.dablin.filter;

import com.example.dablin.repos.UserRepo;
import com.example.dablin.utils.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

import static org.apache.logging.log4j.ThreadContext.isEmpty;

@Component
public class JwtFilter extends OncePerRequestFilter {

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private JwtUtil jwtUtil;


    @Override
    protected void doFilterInternal(HttpServletRequest request,
                                    HttpServletResponse response,
                                    FilterChain chain) throws ServletException, IOException {
        final String header = request.getHeader(HttpHeaders.AUTHORIZATION);

        // Get authorization header and validate
        if (!StringUtils.hasText(header) || (StringUtils.hasText(header) && !header.startsWith("Bearer "))) {
            chain.doFilter(request, response);
            return;
        }

        final String token = header.split(" ")[1].trim();

        //Get user identity and set it on the spring security context
        UserDetails userDetails =
                                    userRepo
                                            .findByUsername(jwtUtil
                                                    .getUsernameFromToken(token))
                                            .orElse(null);

        //Get jwt token and validate
        if (!jwtUtil.validateToken(token, userDetails)) {
            chain.doFilter(request, response);
            return;
        }

        UsernamePasswordAuthenticationToken
                authenticationToken = new UsernamePasswordAuthenticationToken(
                        userDetails, null,
                        userDetails == null ?
                                List.of() : userDetails.getAuthorities()
        );

        authenticationToken.setDetails(
                new WebAuthenticationDetailsSource().buildDetails(request)
        );

        SecurityContextHolder.getContext().setAuthentication(authenticationToken);
        chain.doFilter(request, response);

    }
}