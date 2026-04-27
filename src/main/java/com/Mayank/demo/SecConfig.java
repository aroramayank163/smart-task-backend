package com.Mayank.demo;

import com.Mayank.demo.Security.AuthEntry;
import com.Mayank.demo.Security.AuthFilter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import com.Mayank.demo.Model.User;
import com.Mayank.demo.repo.UserRepo;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecConfig {
    @Autowired
    private AuthEntry entry;

    // Configure stateless JWT security and allow public access to login/signup endpoints
    @Bean
    public SecurityFilterChain defaultFilter(HttpSecurity http ,AuthFilter filter) {
        return http.csrf(csrf -> csrf.disable())
                .exceptionHandling(ex-> ex.authenticationEntryPoint(entry))
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(requests ->
                        requests
                                .requestMatchers( "/", "/login", "/signup",
                                        "/error",
                                        "/favicon.ico").permitAll()
                                .anyRequest().authenticated())
                .addFilterBefore(filter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    // Load user details from database using email for Spring Security authentication
    @Bean
    public UserDetailsService userDetailsService(UserRepo userRepo) {
        return email -> {
            User user = userRepo.findByEmail(email)
                    .orElseThrow(() -> new RuntimeException("User not found"));

            return
                    org.springframework.security.core.userdetails.User
                            .withUsername(user.getEmail())
                            .password(user.getPassword())
                            .roles("USER")
                            .build();
        };
    }

    // Encrypt user passwords before storing or comparing credentials
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    // Provide authentication manager for login authentication process
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration builder){
        return builder.getAuthenticationManager();
    }
}