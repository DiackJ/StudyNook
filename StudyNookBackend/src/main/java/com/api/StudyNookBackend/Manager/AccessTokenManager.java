package com.api.StudyNookBackend.Manager;

import com.api.StudyNookBackend.Entity.User;
import com.api.StudyNookBackend.Util.JwtUtil;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseCookie;

import java.time.Duration;

public class AccessTokenManager {
    @Autowired
    private JwtUtil jwtUtil;

    public String accessTokenName = "access_token";
    public Long access_token_duration_in_days = 14L;
    private Long userId;
    private String userEmail;

    public AccessTokenManager(User user, JwtUtil jwtUtil) {
        this.userId = user.getId();
        this.userEmail = user.getEmail();
        this.jwtUtil = jwtUtil;
    }

    public String CreateToken() {
        System.out.println(this.userId);
        System.out.println(this.userEmail);
        return jwtUtil.createToken(this.userId, this.userEmail);
    }

    public ResponseCookie buildCookie() {
        String token = this.CreateToken();

        return ResponseCookie.from(this.accessTokenName, token)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(Duration.ofDays(this.access_token_duration_in_days))
                .sameSite("Lax")
                .build();
    }

    public void AddCookieToHeader(HttpServletResponse httpServletResponse) {
        ResponseCookie cookie = this.buildCookie();
        httpServletResponse.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
    }
}
