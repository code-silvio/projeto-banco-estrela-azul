package br.com.bancoestrelaazul.web.controller;

import br.com.bancoestrelaazul.web.dto.HomeUsuario;
import br.com.bancoestrelaazul.web.dto.Usuario;
import br.com.bancoestrelaazul.web.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;

@Controller
public class UserHomeController {

    private UsuarioService usuarioService;

    @Autowired
    public UserHomeController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/home-user/{conta}")
    public ModelAndView homePage(HttpServletRequest request, @PathVariable Long conta) {
        HomeUsuario result = usuarioService.buildHomeUsuario(conta);

        return new ModelAndView("homeUser", "homeUser", result );
    }

}
