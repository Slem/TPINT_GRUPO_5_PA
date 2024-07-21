package frgp.utn.edu.ar.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	/*login page*/
	
    @GetMapping("/login")
    public String login() {
        return "Login";
    }
    
    /* redireccion de los usuarios*/

    @GetMapping("/default")
    public String redirigirUsuario(Authentication authentication) {
        if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
            return "redirect:/Admin";
        } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
            return "redirect:/Cliente";
        }
        return "redirect:/Login";
    }
    
    @GetMapping("/")
    public String home() {
        return "Login"; //
    }
}
