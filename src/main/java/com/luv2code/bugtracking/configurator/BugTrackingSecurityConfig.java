package com.luv2code.bugtracking.configurator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity
public class BugTrackingSecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private DataSource securityDataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		UserBuilder users = User.withDefaultPasswordEncoder();
		
		auth.inMemoryAuthentication()
			.withUser(users.username("Bao").roles("Manager").password("12345"))
			.withUser(users.username("Andy").roles("Manager").password("12345"))
			.withUser(users.username("Hua").roles("Employee").password("12345"));
		
		//auth.jdbcAuthentication().dataSource(securityDataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.authorizeRequests() // restrict access based on the HttpservletRequest
				.anyRequest().authenticated()	// Any request come in must be authenticate
			.and()
			.formLogin() // customize form login process
				.loginPage("/showMyLoginPage") // logging page
				.loginProcessingUrl("/authenticateTheUser") // login form should POST data to this URL for processing
				.permitAll() // Any one can see the login page without logging in first
			.and()
				.logout()
				.permitAll(); // add log out and any one can see
			
	}
}
