package com.lp4.moviebook.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
private static final String[] PUBLIC_URLS = {"/api/v1/health"};
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf().disable().
		authorizeHttpRequests().
		requestMatchers(PUBLIC_URLS).permitAll().
		anyRequest().authenticated().
		and().
		httpBasic();
		
		return http.build();
		
	}

}
