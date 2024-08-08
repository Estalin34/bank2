package com.example.banco.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class InicioControlador {

    @GetMapping("/")
    public String mostrarInicio() {
        return "inicio"; // Nombre del archivo HTML en src/main/resources/templates
    }
}
