package com.example.demo.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
public class SecurityConfig  extends WebSecurityConfigurerAdapter{
	
	/*
	 * Authentication
	 */
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		auth.inMemoryAuthentication().withUser("admin").password("{noop}admin").authorities("ADMIN");
		auth.inMemoryAuthentication().withUser("employee").password("{noop}employee").authorities("EMPLOYEE");
		auth.inMemoryAuthentication().withUser("student").password("{noop}student").authorities("STUDENT");
		
	}
	
	
	/*
	 * Authorization
	 */
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests()
		    .antMatchers("/home").permitAll()
		    .antMatchers("/services").authenticated()
		    .antMatchers("/admin").hasAuthority("ADMIN")
		    .antMatchers("/student").hasAuthority("STUDENT")
		    .antMatchers("/employee").hasAuthority("EMPLOYEE")
		    .and()
		    .formLogin()
		    .defaultSuccessUrl("/welcome", true)
		    .and()
		    .logout()
		    .logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		    .and()
		    .exceptionHandling()
		    .accessDeniedPage("/access-denied")
		    ;

	}

}
