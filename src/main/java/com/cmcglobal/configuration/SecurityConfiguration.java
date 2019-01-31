package com.cmcglobal.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter implements WebMvcConfigurer {
	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.csrf().disable();
		http.authorizeRequests()//
		.antMatchers(HttpMethod.GET, "/question/all").permitAll()//
		.antMatchers(HttpMethod.POST, "/question/add").permitAll()//
		.antMatchers(HttpMethod.PUT, "/question/edit/**").permitAll()//
		.antMatchers(HttpMethod.GET, "/questions/**").permitAll()//
		.antMatchers(HttpMethod.DELETE, "/question/delete/**").permitAll();
}
	@Override
	public void configure(WebSecurity web) throws Exception {
		// Allow swagger to be accessed without authentication
		web.ignoring().antMatchers("/v2/api-docs")//
				.antMatchers("/swagger-resources/**")//
				.antMatchers("/swagger-ui.html")//
				.antMatchers("/configuration/**")
				.antMatchers("/webjars/**")//
				.antMatchers("/public");//
	}
}
