package com.example.banco.Controladores;

import com.example.banco.Entidad.Cliente;
import com.example.banco.Servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    @GetMapping
    public String listarClientes(Model model) {
        model.addAttribute("clientes", clienteServicio.listarTodos());
        return "clientes";
    }

    @GetMapping("/{id}")
    public String obtenerCliente(@PathVariable Long id, Model model) {
        Optional<Cliente> cliente = clienteServicio.obtenerPorId(id);
        if (cliente.isPresent()) {
            model.addAttribute("cliente", cliente.get());
            return "formularioCliente"; // Debes crear esta plantilla si es necesaria
        }
        return "redirect:/clientes";
    }

    @GetMapping("/nuevo")
    public String nuevoCliente(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formularioCliente"; // Debes crear esta plantilla si es necesaria
    }

    @PostMapping
    public String guardarCliente(@ModelAttribute Cliente cliente) {
        clienteServicio.guardar(cliente);
        return "redirect:/clientes";
    }

    @GetMapping("/eliminar/{id}")
    public String eliminarCliente(@PathVariable Long id) {
        clienteServicio.eliminar(id);
        return "redirect:/clientes";
    }
}
