package com.karthick.springboot.rest.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
                .authorizeHttpRequests(requests -> requests
                        .requestMatchers("/my-account", "/my-balance", "/my-loans", "/my-cards").authenticated()
                        .requestMatchers("/contact", "/notices", "/register").permitAll())
                .formLogin(Customizer.withDefaults())
                .httpBasic(Customizer.withDefaults());
		return http.build();
	}
	
	/*
	@Bean
	InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.withDefaultPasswordEncoder()
			.username("admin")
			.password("1234")
			.authorities("admin")
			.build();
		
		UserDetails user = User.withDefaultPasswordEncoder()
			.username("user")
			.password("12345")
			.authorities("read")
			.build();
		
		return new InMemoryUserDetailsManager(admin, user);
	}
	*/
	
	/*@Bean
	InMemoryUserDetailsManager userDetailsService() {
		UserDetails admin = User.withUsername("admin")
			.password("1234")
			.authorities("admin")
			.build();
		
		UserDetails user = User.withUsername("user1")
			.password("12345")
			.authorities("read")
			.build();
		
		return new InMemoryUserDetailsManager(admin, user);
	}*/
	
	/*@Bean
	UserDetailsService userDetailsService(DataSource dataSource) {
		return new JdbcUserDetailsManager(dataSource);
	}*/
	
	@Bean
	PasswordEncoder noOpPasswordEncoder() {
		return NoOpPasswordEncoder.getInstance();
	}
}
