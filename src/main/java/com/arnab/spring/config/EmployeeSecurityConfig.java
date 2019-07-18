package com.arnab.spring.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;

@Configuration
@EnableWebSecurity	// This will enable Web Security or Spring Security
public class EmployeeSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	public void configure(WebSecurity web) throws Exception {
		// TODO Auto-generated method stub
		super.configure(web);
	}
	
	/*
	 * The below configure() method is used to configure the HTTP requests coming to this application.
	 * 1. First it applies that all requests must be authorized.
	 * 2. Then all requests to the root (/) must be authenticated.
	 * 3. Then it restricts the access to pages based on roles.
	 * 		a) Only EMPLOYEE, MANAGER, and ADMIN are permitted to access the path /office/employee
	 * 		b) Only ADMIN is permitted to access the path /office/admin
	 * 		c) Only MANAGER and ADMIN are permitted to access the path /office/manager
	 * 4. Then it applies that any request coming to this application must be authenticated.
	 * 5. Then it provides a way to login - a Login form and permits all requests via this login form.
	 * 6. Then it applies the logout logic and permits the session to logout.
	 */
	@Override
	protected void configure(HttpSecurity http) throws Exception { 
		http.authorizeRequests()
			.antMatchers("/").permitAll()
			.antMatchers("/office/employee").hasAnyRole("EMPLOYEE", "MANAGER", "ADMIN")
			.antMatchers("/office/admin").hasAnyRole("ADMIN")
			.antMatchers("/office/manager").hasAnyRole("MANAGER", "ADMIN")
			.anyRequest().authenticated()
			.and()
			.formLogin().permitAll()
			.and()
			.logout().permitAll();
	}
	
	/*
	 * The below configure() method is used to configure an in-memory authentication provider.
	 * 1. First it creates a UserBuilder which in-turn in used to create users with username, password, and roles.
	 * 2. Then it uses the AuthenticationManagerBuilder to create an in-memory authentication tool. 
	 * 3. Then it creates three users with username, password, and roles and attach them to the in-memory authentication tool.
	 */
	@SuppressWarnings("deprecation")
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		// Add users for in-memory authentication.
		UserBuilder users = User.withDefaultPasswordEncoder();
		auth.inMemoryAuthentication().withUser(users.username("admin").password("admin").roles("ADMIN"))
			.withUser(users.username("john").password("john123").roles("EMPLOYEE"))
			.withUser(users.username("mary").password("mary123").roles("MANAGER"))
			.withUser(users.username("kary").password("kary123").roles("ADMIN"));
		
	}
}
