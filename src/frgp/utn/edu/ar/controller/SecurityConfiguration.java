package frgp.utn.edu.ar.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	
	@Autowired
    private PasswordEncoder passwordEncoder;
	
	/* tipo de encriptado de seguridad, encargado de hasear las passwords, utilizamos BCRYPt */
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
		
	/* se cargan los usuarios en memoria, no se usa base de datos, ya tienen las passwords encodeadas a BCRYPT*/
	 
	 @Bean
	 public UserDetailsService userDetailsService() {
	     UserDetails admin = User.builder()
	         .username("admin")
	         .password(passwordEncoder.encode("admin"))
	         .roles("ADMIN")
	         .build();

	     UserDetails client = User.builder()
	         .username("cliente")
	         .password(passwordEncoder.encode("1234"))
	         .roles("CLIENT")
	         .build();

	     return new InMemoryUserDetailsManager(admin, client);
	 }
	 
	 /* es el responsable de configurar la seguridad HTTP, incluyendo login, logout y reglas de authorization.
	   
	  .authorizeRequests(): Configures URL-based authorization.
		.antMatchers("/admin/**").hasRole("ADMIN"): Restricts access to URLs starting with /admin to users with the "ADMIN" role.
			.antMatchers("/client/**").hasRole("CLIENT"): Restricts access to URLs starting with /client to users with the "CLIENT" role.
				.antMatchers("/login").permitAll(): Allows access to the login page without authentication.
					.formLogin(): Configures the login page and behavior.
						.logout(): Configures logout behavior.*/
	 
	 @Bean
	 public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
	     http
	         .authorizeRequests()
	             .antMatchers("/Admin/**").hasRole("ADMIN")
	             .antMatchers("/Cliente/**").hasRole("CLIENT")
	             .antMatchers("/Login").permitAll()
	             .anyRequest().authenticated()
	             .and()
	         .formLogin()
	             .loginPage("/Login")
	             .successHandler(customAuthenticationSuccessHandler())
	             .permitAll()
	             .and()
	         .logout()
	             .permitAll();
	     return http.build();
	 }
	 
	 @Bean
	    public AuthenticationSuccessHandler customAuthenticationSuccessHandler() {
		 return new CustomAuthenticationSuccessHandler();
	        };
	    }
