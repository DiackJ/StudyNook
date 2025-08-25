package com.api.StudyNookBackend.Manager;

import com.api.StudyNookBackend.Entity.User;
import com.api.StudyNookBackend.Util.JwtUtil;
import jakarta.annotation.Nullable;
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

    public AccessTokenManager(
            @Nullable User user,
            JwtUtil jwtUtil
    ) {
        if (user != null) {
            this.userId = user.getId();
            this.userEmail = user.getEmail();
            this.jwtUtil = jwtUtil;
        }
    }

    public String CreateToken() {
        return jwtUtil.createToken(this.userId, this.userEmail);
    }

    public ResponseCookie buildCookie(Duration duration) {
        String token = this.CreateToken();

        return ResponseCookie.from(this.accessTokenName, token)
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(duration)
                .sameSite("Lax")
                .build();
    }

    public void addCookieToHeader(HttpServletResponse httpServletResponse) {
        ResponseCookie cookie = this.buildCookie(Duration.ofDays(this.access_token_duration_in_days));
        httpServletResponse.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
    }

    public void destroyCookie(HttpServletResponse httpServletResponse) {
        ResponseCookie cookie = ResponseCookie.from(this.accessTokenName, "")
                .httpOnly(true)
                .secure(false)
                .path("/")
                .maxAge(Duration.ofMillis(0))
                .sameSite("Lax")
                .build();

        httpServletResponse.addHeader(HttpHeaders.SET_COOKIE, cookie.toString());
    }
}
