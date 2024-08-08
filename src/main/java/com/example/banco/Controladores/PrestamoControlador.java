package com.example.banco.Controladores;

import com.example.banco.Entidad.Prestamo;
import com.example.banco.Servicios.ClienteServicio;
import com.example.banco.Servicios.PrestamoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/prestamos")
public class PrestamoControlador {

    @Autowired
    private PrestamoServicio prestamoServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public String listarPrestamos(Model model) {
        model.addAttribute("prestamos", prestamoServicio.listarTodos());
        return "prestamos";
    }

    @GetMapping("/{id}")
    public String obtenerPrestamo(@PathVariable Long id, Model model) {
        Optional<Prestamo> prestamo = prestamoServicio.obtenerPorId(id);
        if (prestamo.isPresent()) {
            model.addAttribute("prestamo", prestamo.get());
            model.addAttribute("clientes", clienteServicio.listarTodos());
            return "formularioPrestamo";
        }
        return "redirect:/prestamos";
    }

    @GetMapping("/nuevo")
    public String nuevoPrestamo(Model model) {
        model.addAttribute("prestamo", new Prestamo());
        model.addAttribute("clientes", clienteServicio.listarTodos());
        return "formularioPrestamo";
    }

    @PostMapping
    public String guardarPrestamo(@ModelAttribute Prestamo prestamo) {
        prestamoServicio.guardar(prestamo);
        return "redirect:/prestamos";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarPrestamo(@PathVariable Long id) {
        prestamoServicio.eliminar(id);
        return "redirect:/prestamos";
    }
}
