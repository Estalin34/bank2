package com.example.banco.Controladores;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/informacion")
public class InformacionControlador {

    @GetMapping
    public String showInformacion() {
        return "informacion"; // Se espera que el archivo se llame informacion.html
    }
}
