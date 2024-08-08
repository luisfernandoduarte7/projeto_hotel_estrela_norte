package com.hotel.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SpringSecurityConfig {

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.csrf().disable()
		.authorizeHttpRequests((requests)-> requests

				.requestMatchers(
						"/v3/api-docs/**",
						"/swagger-ui/**",
						"/swagger-ui/index.html")
				.permitAll()

				.requestMatchers(
						HttpMethod.POST,"/hospede/","/quarto/","/reserva/")
				.authenticated() //Somente autenticados

				.requestMatchers(
						HttpMethod.GET,"/hospede/","/quarto/","/reserva/","/hospede/nome/{nome}","/quarto/numero/{numero}","/reserva/data/{data}")
				.permitAll() //Sem autenticação

				.requestMatchers(
						HttpMethod.PUT,"/hospede/{id}","/quarto/{id}","/reserva/{id}")
				.authenticated() //Somente autenticados

				.requestMatchers(
						HttpMethod.DELETE,"/hospede/{id}","/quarto/{id}","/reserva/{id}")
				.authenticated() //Somente autenticados

				.anyRequest()
				.denyAll()

				)
		.httpBasic();
		return http.build();
	}
	@Bean
	public InMemoryUserDetailsManager userDetailsService() {
		UserDetails user = User.withDefaultPasswordEncoder()
				.username("Adriano")
				.password("P@ssw0rd")
				.roles("USER")
				.build();
		return new InMemoryUserDetailsManager(user);
	}
}
