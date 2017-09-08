package com.spring.config;

import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@EnableWebMvcSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/*@Bean
	public UserDetailsService getUser() throws Exception{
		Properties users=new Properties();
		users.put("user", "password,ROLE_ADMIN,enabled");
		return new InMemoryUserDetailsManager(users);
	}*/
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication()
                   .withUser("mkyong").password("123456").roles("USER");
	}
	
	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/greeting").hasRole("USER")
		.anyRequest().authenticated()
		.and()
		.formLogin()
		.and()
		.httpBasic();
	}
}
