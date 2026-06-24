package com.ipn.mx.miniinventario.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            // 1. Deshabilita CSRF para que permita peticiones POST, PUT y DELETE
            .csrf(csrf -> csrf.disable())
            
            // 2. Deja pasar libremente todas las peticiones a tus rutas de la API
            .authorizeHttpRequests(auth -> auth
                .requestMatchers("/api/v1/**").permitAll()
                .anyRequest().permitAll()
            );

        return http.build();
    }
}