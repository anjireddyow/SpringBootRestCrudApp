package com.example.demo.security.config;

import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringSecurityConfig {
//	extends WebSecurityConfigurerAdapter{

//	// Authentication : User --> Roles
//		protected void configure(AuthenticationManagerBuilder auth)
//				throws Exception {
//			auth.inMemoryAuthentication().withUser("user1").password("secret1")
//					.roles("ROLE_S_USER").and().withUser("admin1").password("secret1")
//					.roles("ROLE_S_USER", "ROLE_S_ADMIN");
//		}
//
//		// Authorization : Role -> Access
//		protected void configure(HttpSecurity http) throws Exception {
//			http.httpBasic().and().authorizeRequests().antMatchers("/employees/**")
//					.hasRole("ROLE_S_USER").antMatchers("/**").hasRole("ROLE_S_ADMIN").and()
//					.csrf().disable().headers().frameOptions().disable();
//		}
//	
}
