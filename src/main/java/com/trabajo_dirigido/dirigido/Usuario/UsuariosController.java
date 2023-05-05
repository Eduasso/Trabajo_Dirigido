package com.trabajo_dirigido.dirigido.Usuario;

import com.trabajo_dirigido.dirigido.qualifiers.DAOJpa;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.context.FacesContext;
import jakarta.faces.view.ViewScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;


@Controller
@RequestMapping("/usuarios")
public class UsuariosController{

    private final Logger logger = Logger.getLogger(UsuariosController.class.getName());
    @Autowired
    @Qualifier("usuarioJPA")
    private UsuarioDAO usuarioDAO;

    public UsuariosController(){}

    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.setValidator(new ValidadorUsuario());
    }

    @GetMapping("/registrar")
    public String registrar(ModelMap model){
        model.addAttribute("usuario", new Usuario());
        return "usuarios/registrar";
    }

    @PostMapping("/registrar")
    public String registrar(@ModelAttribute("usuario") @Valid Usuario usuario, BindingResult result, ModelMap model){
        String view = "reservar";

        if(!result.hasErrors()){
            usuarioDAO.crea(usuario);
            model.clear();
        }else {
            view = "registrar";
        }
        return view;
    }

    @GetMapping("/reservar")
    public String reservar(ModelMap model){
        return "usuarios/reservar";
    }

    @GetMapping("/index")
    public String index(){
        return "index";
    }
}
