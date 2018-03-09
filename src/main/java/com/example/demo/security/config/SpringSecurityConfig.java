package com.example.demo.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	
	 private static String REALM="MY_TEST_REALM";
     
//	    @Autowired
//	    public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
//	        auth.inMemoryAuthentication().withUser("bill").password("abc123").roles("ADMIN");
//	        auth.inMemoryAuthentication().withUser("tom").password("abc123").roles("USER");
//	    }
//	     
//	    @Override
//	    protected void configure(HttpSecurity http) throws Exception {
//	  
//	      http.csrf().disable()
//	        .authorizeRequests()
//	        .antMatchers("/**").hasRole("ADMIN")
//	        .and().httpBasic().realmName(REALM).authenticationEntryPoint(getBasicAuthEntryPoint())
//	        .and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);//We don't need sessions to be created.
//	    }
//	     
//	    @Bean
//	    public CustomBasicAuthenticationEntryPoint getBasicAuthEntryPoint(){
//	        return new CustomBasicAuthenticationEntryPoint();
//	    }
//	     
//	    /* To allow Pre-flight [OPTIONS] request from browser */
//	    @Override
//	    public void configure(WebSecurity web) throws Exception {
//	        web.ignoring().antMatchers(HttpMethod.OPTIONS, "/**");
//	    }
	    
	// Authentication : User --> Roles
		protected void configure(AuthenticationManagerBuilder auth)
				throws Exception {
//			auth.inMemoryAuthentication().withUser("user1").password("secret1").roles("USER").
//			and().withUser("admin1").password("secret1").roles("USER", "ADMIN");
		}

		// Authorization : Role -> Access
		protected void configure(HttpSecurity http) throws Exception {
			
			// Below line will ignore the spring security for all the urls start after / (backward slash)
			http.csrf().ignoringAntMatchers("/**");
//			http.httpBasic().and().authorizeRequests().antMatchers("/**")
//					.hasRole("USER").antMatchers("/**").hasRole("ADMIN").and()
//					.csrf().disable().headers().frameOptions().disable();
			
		}
	
}
