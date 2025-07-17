package com.example.legal.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import static org.springframework.security.config.Customizer.withDefaults;


@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                // Wyłącz zabezpieczenie CSRF, które nie jest potrzebne dla bezstanowego API
                .csrf(csrf -> csrf.disable())
                // Zastosuj konfigurację CORS, którą już masz w WebConfig
                .cors(withDefaults())
                // Skonfiguruj reguły autoryzacji HTTP
                .authorizeHttpRequests(auth -> auth
                        // Zezwól na wszystkie zapytania do /api/** bez logowania
                        .requestMatchers("/api/**").permitAll()
                        // Każde inne zapytanie wymaga uwierzytelnienia (np. do panelu admina Springa)
                        .anyRequest().authenticated()
                )
                // Użyj domyślnego formularza logowania, jeśli ktoś wejdzie na niezabezpieczony zasób
                .formLogin(withDefaults());

        return http.build();
    }
}