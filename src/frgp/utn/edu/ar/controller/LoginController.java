package frgp.utn.edu.ar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

public class LoginController {
	
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
    public ModelAndView procesarLogin(@RequestParam("txtUsuario") String usuario,
                                      @RequestParam("txtPassword") String password,
                                      HttpSession session) {
        ModelAndView MV = new ModelAndView();
        
        User user = usuarioNegocio.login(usuario);

        if (user != null && user.getPassword().equals(password)) {
            session.setAttribute("usuario", user);
            if(user.getTipoUsuario() == 1) {
            	MV.setViewName("redirect:/Admin");
            }else if(user.getTipoUsuario() == 2){
            	MV.setViewName("redirect:/Cliente");
            }
        } else {
            MV.setViewName("Login");
            MV.addObject("error", "Usuario o contraseña incorrectos");
        }
        
        return MV;
    }
	
	
	@RequestMapping("/logout")
    public ModelAndView cerrarSesion(HttpSession session) {
        session.invalidate();
        ModelAndView MV = new ModelAndView();
        MV.setViewName("redirect:/login");
        return MV;
    }

}
