package frgp.utn.edu.ar.controller;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
	
	    @GetMapping("/Login")
	    public String home() {
	        return "Login";
	    }
	    
	    @GetMapping("/procesar_login")
	    public String redirigirUsuario(Authentication authentication) {
	        if (authentication != null && authentication.isAuthenticated()) {
	            if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_ADMIN"))) {
	                return "redirect:/Admin";
	            } else if (authentication.getAuthorities().contains(new SimpleGrantedAuthority("ROLE_CLIENT"))) {
	                return "redirect:/Cliente";
	            }
	        }
	        return "Login"; // Muestra la página de login si no está autenticado
	    }
}
