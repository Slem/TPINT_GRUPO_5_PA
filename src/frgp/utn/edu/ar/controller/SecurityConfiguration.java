package frgp.utn.edu.ar.controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.User;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration{
	
	/* tipo de encriptado de seguridad, encargado de hasear las passwords, utilizamos BCRYPt */
	
	@Bean 
	public PasswordEncoder passwordEncoder() { 
	    return new BCryptPasswordEncoder(); 
	}
	
	/* se cargan los usuarios en memoria, no se usa base de datos, ya tienen las paswords encodeadas a BCRYPT*/

	 @Bean
	    public InMemoryUserDetailsManager userDetailsService() {
	        UserDetails admin = User.withUsername("admin")
	                .password(passwordEncoder().encode("admin"))
	                .roles("ADMIN")
	                .build();

	        UserDetails client = User.withUsername("cliente")
	                .password(passwordEncoder().encode("1234"))
	                .roles("CLIENTE")
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
	                .antMatchers("/Cliente/**").hasRole("CLIENTE")
	                .antMatchers("/", "/Login").permitAll()
	                .and()
	            .formLogin()
	                .loginPage("/Login")
	                .defaultSuccessUrl("/default", true)
	                .permitAll()
	                .and()
	            .logout()
	                .permitAll();

	        return http.build();
	    }
}