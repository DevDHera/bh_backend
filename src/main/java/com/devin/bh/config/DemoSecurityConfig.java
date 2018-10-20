package com.devin.bh.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class DemoSecurityConfig extends WebSecurityConfigurerAdapter {
	
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// add users for in memory authentication
		UserBuilder users = User.withDefaultPasswordEncoder();
				
		auth.inMemoryAuthentication()
			.withUser(users.username("chamal").password("test123").roles("EMPLOYEE"))
			.withUser(users.username("kalana").password("test123").roles("EMPLOYEE", "MANAGER"))
			.withUser(users.username("devin").password("test123").roles("EMPLOYEE", "ADMIN"));
		
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		// Secure all endpoints under "/api/customers"
//		http.authorizeRequests()
//			.antMatchers("/api/customers/**").authenticated()
//			.and()
//			.httpBasic()
//			.and()
//			.csrf().disable()
//			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
		http.authorizeRequests()
			.antMatchers(HttpMethod.GET, "/api/customers").hasRole("EMPLOYEE")
			.antMatchers(HttpMethod.GET, "/api/customers/*").hasRole("EMPLOYEE")
			.antMatchers(HttpMethod.POST, "/api/customers").hasAnyRole("MANAGER", "ADMIN")
			.antMatchers(HttpMethod.PUT, "/api/customers").hasAnyRole("MANAGER", "ADMINmary")
			.antMatchers(HttpMethod.DELETE, "/api/customers/*").hasRole("ADMIN")
			.and()
			.httpBasic()
			.and()
			.csrf().disable()
			.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
 }
