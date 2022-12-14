package com.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http)throws Exception
	{
		http
		.authorizeRequests()
		.antMatchers("/list**")
		.hasAnyRole("USER")
		.anyRequest()
		.authenticated()
		.and()
		.formLogin()
		.and()
		.exceptionHandling().accessDeniedPage("/WEB-INF/views/denied.jsp")
		.and()
		.csrf().disable();
		
	}
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder builder)throws Exception
	{
		builder.inMemoryAuthentication()
		.withUser("nandhu").password("{noop}nandhu@123").roles("MANAGER")
		.and()
		.withUser("abhi").password("{noop}abhi123").roles("USER");
		
	}


}
	
