package com.example.demo.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * From Spring security 5 onwards. It is required to provide default password encoder for spring security
 * 
 * @author 
 *
 */
@Configuration
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter{

	/**
	 * This method will indicate there is no password encoder
	 * 
	 * @return
	 */
//	@Bean
//	public static NoOpPasswordEncoder passwordEncoder() {
//	return (NoOpPasswordEncoder) NoOpPasswordEncoder.getInstance();
//	}
//	
	
	/**
	 * This method will indicate the BCrypt Password Encoder
	 * @return
	 */
	@Bean
    public PasswordEncoder bCryptPasswordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
//        BcryptPasswordEncoder unit test or encoding as password
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(16);
//        String result = encoder.encode("myPassword");
//        assertTrue(encoder.matches("myPassword", result));
    }
	
//	@Bean
//	public PasswordEncoder md5PasswordEncoder(){
//	    //implements PasswordEncoder and overide encode method with the MD5 protocol
//	    return new MD5PasswordEncoder();
//	}
	
	
	public void configure(AuthenticationManagerBuilder amb) throws Exception {
		amb.inMemoryAuthentication().withUser("admin").password("admin").roles("USER");
	}
	
	public void configure (HttpSecurity httpSecurity) throws Exception{
		// Allow all urls without spring security
//			httpSecurity.authorizeRequests().anyRequest().permitAll().and().httpBasic().and().csrf().disable();
		
		// Authorize all the urls with spring security
//		httpSecurity.authorizeRequests().antMatchers("/**").hasRole("USER").and().httpBasic().and().csrf().disable();
		
		httpSecurity.authorizeRequests().antMatchers("/**").permitAll().anyRequest().authenticated();
		
		httpSecurity.formLogin().loginPage("/login").permitAll().and().logout().permitAll();
		
		// Disables CSRF protection
		httpSecurity.csrf().disable();
		
		// Disables X-Frame-Options in Spring Security for access to H2 database console. By default, Spring Security will protect against CRSF attacks.
		httpSecurity.headers().frameOptions().disable();
	}
}
