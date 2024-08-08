package com.example.banco.Controladores;

import com.example.banco.Entidad.Cuenta;
import com.example.banco.Servicios.ClienteServicio;
import com.example.banco.Servicios.CuentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/cuentas")
public class CuentaControlador {

    @Autowired
    private CuentaServicio cuentaServicio;

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public String listarCuentas(Model model) {
        model.addAttribute("cuentas", cuentaServicio.listarTodas());
        return "cuentas";
    }

    @GetMapping("/{id}")
    public String obtenerCuenta(@PathVariable Long id, Model model) {
        Optional<Cuenta> cuenta = cuentaServicio.obtenerPorId(id);
        if (cuenta.isPresent()) {
            model.addAttribute("cuenta", cuenta.get());
            model.addAttribute("clientes", clienteServicio.listarTodos());
            return "formularioCuenta"; // Debes crear esta plantilla si es necesaria
        }
        return "redirect:/cuentas";
    }

    @GetMapping("/nuevo")
    public String nuevaCuenta(Model model) {
        model.addAttribute("cuenta", new Cuenta());
        model.addAttribute("clientes", clienteServicio.listarTodos());
        return "formularioCuenta"; // Debes crear esta plantilla si es necesaria
    }

    @PostMapping
    public String guardarCuenta(@ModelAttribute Cuenta cuenta) {
        cuentaServicio.guardar(cuenta);
        return "redirect:/cuentas";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCuenta(@PathVariable Long id) {
        cuentaServicio.eliminar(id);
        return "redirect:/cuentas";
    }
}
