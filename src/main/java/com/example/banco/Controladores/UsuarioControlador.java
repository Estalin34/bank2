package com.example.banco.Controladores;

import com.example.banco.Exceptions.MiException;
import com.example.banco.Servicios.UsuarioServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
public class UsuarioControlador {

    @Autowired
    private UsuarioServicio usuarioServicio;

    @GetMapping("/registrar")
    public String registrar() {
        return "Usuarios/registro";
    }

    @PostMapping("/registro")
    public String registroUsuario(@RequestParam String nombre, @RequestParam String email, @RequestParam String password, Model model) {
        try {
            usuarioServicio.registrar(nombre, email, password);
            model.addAttribute("exito", "Usuario registrado");
            return "index";
        } catch (MiException e) {
            model.addAttribute("error", e.getMessage());
            return "Usuarios/registro";
        }
    }

    @GetMapping("/login")
    public String login(@RequestParam(required = false) String error, Model model) {
        if (error != null) {
            model.addAttribute("error", "Usuario o contraseña inválidos");
        }
        return "Usuarios/login";
    }



    @GetMapping("/logout")
    public String cerrarSesion() {
        return "Usuarios/login";
    }
}

