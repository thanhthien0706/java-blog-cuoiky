package com.thanhthien.cuoiki.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.thanhthien.cuoiki.security.CustomUserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	CustomUserDetailsService userDetailsService;

	@Bean
	public static PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Bean
	@Override
	public AuthenticationManager authenticationManager() throws Exception {
		return super.authenticationManager();
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/admin/**").hasRole("ADMIN")
			.antMatchers("/**").permitAll().and()
			.formLogin().loginPage("/dang-nhap")
			.loginProcessingUrl("/dang-nhap")
			.defaultSuccessUrl("/trang-chu").and()
			.logout().logoutUrl("/dang-xuat").logoutSuccessUrl("/trang-chu").and()
			.csrf().disable();
	}

//	@SuppressWarnings("deprecation")
//	@Bean
//	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
//		http.csrf().disable().authorizeRequests().requestMatchers("/admin/**", "/web/**", "/auth/**").permitAll()
//				.requestMatchers(HttpMethod.DELETE).hasRole("ADMIN")
//
//				.requestMatchers("/**").permitAll().anyRequest().authenticated().and()
//				.formLogin(form -> form.loginPage("/dang-nhap").loginProcessingUrl("/dang-nhap")
//						.defaultSuccessUrl("/trang-chu").permitAll())
//				.logout(logout -> logout.logoutRequestMatcher(new AntPathRequestMatcher("/dang-xuat")).permitAll());
//		return http.build();
//	}
//	.requestMatchers("/admin/**").hasAnyRole("ADMIN")
}
