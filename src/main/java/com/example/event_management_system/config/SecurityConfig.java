package com.example.event_management_system.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	    http
	        .csrf().disable()  // Disable CSRF protection (not recommended for production)
	        .authorizeHttpRequests(auth -> auth
	            .requestMatchers("/events/new", "/events/edit/**", "/events/delete/**", "/events/save").hasRole("ADMIN")
	            .requestMatchers("/events", "/events/details/**").permitAll()
	            .anyRequest().authenticated()
	        )
	        .formLogin()
	        .and()
	        .logout().logoutSuccessUrl("/events");

	    return http.build();
	}


    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
    
    public class PasswordEncoderUtil {
        public static void main(String[] args) {
            BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
            String rawPassword = "admin123";
            String encodedPassword = encoder.encode(rawPassword);
            System.out.println("Encoded Password: " + encodedPassword);
        }
    }
    
}