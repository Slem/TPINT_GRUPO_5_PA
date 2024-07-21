package frgp.utn.edu.ar.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	
	/* tipo de encriptado de seguridad, encargado de hasear las passwords, utilizamos BCRYPT en este ejemplo */
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	/* se cargan los usuarios en memoria, no se usa base de datos, ya tienen las paswords encodeadas a BCRYPT*/

	 @Bean
	    public UserDetailsService userDetailsService() {
	        UserDetails admin = User.builder()
	                .username("admin")
	                .password(passwordEncoder().encode("admin"))
	                .roles("ADMIN")
	                .build();

	        UserDetails cliente = User.builder()
	                .username("cliente")
	                .password(passwordEncoder().encode("1234"))
	                .roles("CLIENTE")
	                .build();

	        return new InMemoryUserDetailsManager(admin, cliente);
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
	                .antMatchers("/admin/**").hasRole("ADMIN")
	                .antMatchers("/cliente/**").hasRole("CLIENTE")
	                .antMatchers("/login").permitAll()
	                .anyRequest().authenticated()
	                .and()
	            .formLogin()
	                .loginPage("/login")
	                .defaultSuccessUrl("/default", true)
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();

	        return http.build();
	    }
}