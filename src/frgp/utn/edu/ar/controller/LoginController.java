package frgp.utn.edu.ar.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.web.bind.annotation.GetMapping;


public class LoginController {
	
	/*login page*/
	
    @GetMapping("/login")
    public String login() {
        return "login";
    }
    
    /* redireccion de los usuarios*/

    @GetMapping("/default")
    public String redirigirUsuario(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/admin";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
            return "redirect:/client";
        }
        return "redirect:/login";
    }
}
