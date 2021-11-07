package br.com.bancoestrelaazul.web.controller;

import br.com.bancoestrelaazul.web.dto.Usuario;
import br.com.bancoestrelaazul.web.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AppController {

    private UsuarioService usuarioService;

    @Autowired
    public AppController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/home")
    public String homePage() {
        return "home";
    }

    @GetMapping("/app")
    public String login(Usuario usuario, Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String login(Usuario usuario, BindingResult result, Model model) {
        if (result.hasErrors() || !usuarioService.isValid(usuario)) {
            return "login";
        }
        return "redirect:/home-user/" + usuario.getNumeroDaConta();
    }
}
