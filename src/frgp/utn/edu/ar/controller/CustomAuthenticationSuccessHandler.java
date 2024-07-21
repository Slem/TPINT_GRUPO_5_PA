package frgp.utn.edu.ar.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	 @Override
	    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
	                                        Authentication authentication) throws IOException, ServletException {
	        if (authentication.getAuthorities().stream()
	                .anyMatch(auth -> auth.getAuthority().equals("ROLE_ADMIN"))) {
	            response.sendRedirect("/Admin");
	        } else if (authentication.getAuthorities().stream()
	                .anyMatch(auth -> auth.getAuthority().equals("ROLE_CLIENT"))) {
	            response.sendRedirect("/Cliente");
	        } else {
	            response.sendRedirect("/Login");
	        }
	    }
	 
	 /* redireccion de los usuarios*/


}
