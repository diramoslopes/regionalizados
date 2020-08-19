package com.regionalizados.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.regionalizados.service.UsuarioService;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http.csrf().disable().authorizeRequests()
		.antMatchers("/css/**", "/fonts/**", "/js/**").permitAll()
		.antMatchers("/apoiador/login").permitAll()	
		
		.anyRequest().authenticated()
		.and()
			.formLogin()
			.loginPage("/apoiador/login")
			.defaultSuccessUrl("/apoiador/novo", true)
			.failureUrl("/apoiador/login-error")
			.permitAll()
		.and()
			.logout()
			.logoutSuccessUrl("/apoiador/login");
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(usuarioService).passwordEncoder(new BCryptPasswordEncoder());
		
	}
}