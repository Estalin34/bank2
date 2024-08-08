package com.example.banco.Controladores;

import com.example.banco.Entidad.Garantia;
import com.example.banco.Servicios.ClienteServicio;
import com.example.banco.Servicios.GarantiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/garantias")
public class GarantiaControlador {

    @Autowired
    private GarantiaServicio garantiaServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public String listarGarantias(Model model) {
        model.addAttribute("garantias", garantiaServicio.listarTodas());
        return "garantias";
    }

    @GetMapping("/{id}")
    public String obtenerGarantia(@PathVariable Long id, Model model) {
        Optional<Garantia> garantia = garantiaServicio.obtenerPorId(id);
        if (garantia.isPresent()) {
            model.addAttribute("garantia", garantia.get());
            model.addAttribute("clientes", clienteServicio.listarTodos());
            return "formularioGarantia"; // Debes crear esta plantilla si es necesaria
        }
        return "redirect:/garantias";
    }

    @GetMapping("/nuevo")
    public String nuevaGarantia(Model model) {
        model.addAttribute("garantia", new Garantia());
        model.addAttribute("clientes", clienteServicio.listarTodos());
        return "formularioGarantia"; // Debes crear esta plantilla si es necesaria
    }

    @PostMapping
    public String guardarGarantia(@ModelAttribute Garantia garantia) {
        garantiaServicio.guardar(garantia);
        return "redirect:/garantias";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarGarantia(@PathVariable Long id) {
        garantiaServicio.eliminar(id);
        return "redirect:/garantias";
    }
}
