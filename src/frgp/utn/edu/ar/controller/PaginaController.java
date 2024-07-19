package frgp.utn.edu.ar.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PaginaController {
	
	@RequestMapping("login.html")
	public ModelAndView eventoRedireccionarPag1() {
		ModelAndView MV = new ModelAndView();
		MV.setViewName("Login");
		return MV;
	}
	
	@RequestMapping("/admin")
    public ModelAndView mostrarAdmin(HttpSession session) {
        ModelAndView MV = new ModelAndView();
        if (session.getAttribute("user") == null) {
            MV.setViewName("redirect:/login");
        } else {
            MV.setViewName("Admin");
        }
        return MV;
    }
	
	@RequestMapping("/cliente")
    public ModelAndView mostrarCliente(HttpSession session) {
        ModelAndView MV = new ModelAndView();
        if (session.getAttribute("user") == null) {
            MV.setViewName("redirect:/login");
        } else {
            MV.setViewName("Cliente");
        }
        return MV;
    }

}
