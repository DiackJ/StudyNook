package com.api.StudyNookBackend.SecurityConfig;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

//define all the protected and public endpoints as well as password encoder and auth manager
@Configuration
@EnableWebSecurity
public class SecurityConfig {
}
