package com.api.StudyNookBackend.Util;

import com.nimbusds.jose.util.StandardCharset;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.util.Date;

//generate and validate tokens
@Component //tells spring this is an important file
public class JwtUtil {
    //our jwt secret key
    @Value("${JWT_SECRET}")
    private String key;


    //create token
    public String createToken(Long userId, String email) {
        return Jwts.builder()
                .setSubject(String.valueOf(userId))
                .claim("email", email)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + (1000 * 60 * 60 * 24 * 14))) // 14 days
                .signWith(Keys.hmacShaKeyFor(key.getBytes(StandardCharset.UTF_8)), SignatureAlgorithm.HS256)
                .compact();
    }

    //extract the userId
    public Long extractUserId(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token)
                .getPayload();

        return Long.parseLong(claims.getSubject());
    }

    //extract expiration

    public Date extractExpiration(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token)
                .getPayload();

        return claims.getExpiration();
    }

    //extract user's email
    public String extractEmail(String token) {
        Claims claims = Jwts.parser()
                .setSigningKey(Keys.hmacShaKeyFor(key.getBytes(StandardCharsets.UTF_8)))
                .build()
                .parseClaimsJws(token)
                .getPayload();
        return claims.get("email", String.class);
    }

    //check token expiration
    public boolean isTokenExpired(String token){
       return extractExpiration(token).before(new Date());
    }

    //validate token
    public boolean isTokenValid(String token, UserDetails userDetails){
        String email = extractEmail(token);
        return (!isTokenExpired(token) && email.equals(userDetails.getUsername()));
    }

    //extract the token from the cookie header
    public String extractTokenFromCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies(); //return all cookies from the current request
        if (cookies != null) { //if cookies exist
            for (Cookie cookie : cookies) { //loop through all cookies
                if ("access_token".equals(cookie.getName())) { //look for the one that matches "jwt"
                    return cookie.getValue(); //extract its payload
                }
            }
        }
        return null;
    }
}
