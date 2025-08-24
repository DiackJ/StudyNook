package com.api.StudyNookBackend.Util;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import java.io.IOException;

//authentication filter parses tokens/cookies and check security context
@Component
public class AuthFilter extends OncePerRequestFilter {
    @Autowired
    private UserDetailsService userDetailsService;
    @Autowired
    private JwtUtil jwtUtil;

    public AuthFilter(){}

    @Override
    public void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain filterChain) throws IOException, ServletException{
        //logic to skip all auth points because logging in and signing up should be public
        //and without this step, sometimes the auth filter will block the request even if permitAll() == true
        String path = req.getServletPath();
        if(path.startsWith("/auth/signup") || path.startsWith("/auth/signin")){
            filterChain.doFilter(req, res);
        }

        String email = null;
        String token = null;

        //extract the token and email from the cookies of the request
        if(req.getCookies() != null){
            for(Cookie cookie : req.getCookies()){
                if(cookie.getName().equals("jwt")){
                    token = cookie.getValue();
                    email = jwtUtil.extractEmail(token);
                }
            }
        }

        //check if the user is already in our app context, if not add them
        if(email != null && SecurityContextHolder.getContext().getAuthentication() == null){
            UserDetails user = userDetailsService.loadUserByUsername(email);
            //validate token and authenticate the user
            if(jwtUtil.isTokenValid(token, user)){
                UsernamePasswordAuthenticationToken authenticationToken = new UsernamePasswordAuthenticationToken(
                        user,
                        null,
                        user.getAuthorities()
                );
                authenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(req));
                //add the user to the security context. basically tell spring "hey this user is good"
                SecurityContextHolder.getContext().setAuthentication(authenticationToken);

                System.out.println("Auth token: " + authenticationToken);
            }
            //move on to the next filter/stop running filter
            filterChain.doFilter(req, res);
        }
    }
}
