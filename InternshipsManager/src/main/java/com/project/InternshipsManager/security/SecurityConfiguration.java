package com.project.InternshipsManager.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableMethodSecurity
public class SecurityConfiguration  {
	
	@Bean
	public SecurityFilterChain configuration(HttpSecurity http) throws Exception {
		http.csrf().disable();
		return http.build();
	}


}
