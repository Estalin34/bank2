package com.example.banco.Controladores;

import com.example.banco.Entidad.Cliente;
import com.example.banco.Servicios.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/clientes")
public class ClienteControlador {

    @Autowired
    private ClienteServicio clienteServicio;

    // Listar todos los clientes
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("clientes", clienteServicio.listarTodos());
        return "clientes"; // Asegúrate de que el nombre del archivo Thymeleaf es clientes.html
    }

    // Mostrar el formulario para crear un nuevo cliente
    @GetMapping("/nuevo")
    public String mostrarFormulario(Model model) {
        model.addAttribute("cliente", new Cliente());
        return "formulario_cliente"; // Asegúrate de que el nombre del archivo Thymeleaf es formulario_cliente.html
    }

    // Guardar un cliente (nuevo o editado)
    @PostMapping
    public String guardar(@ModelAttribute Cliente cliente) {
        clienteServicio.guardar(cliente);
        return "redirect:/clientes";
    }

    // Mostrar el formulario para editar un cliente existente
    @GetMapping("/editar/{id}")
    public String mostrarFormularioEdicion(@PathVariable Long id, Model model) {
        Cliente cliente = clienteServicio.obtenerPorId(id);
        if (cliente != null) {
            model.addAttribute("cliente", cliente);
            return "formulario_cliente"; // Asegúrate de que el nombre del archivo Thymeleaf es formulario_cliente.html
        }
        return "redirect:/clientes"; // Redirige si no se encuentra el cliente
    }

    // Eliminar un cliente
    @GetMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        clienteServicio.eliminar(id);
        return "redirect:/clientes";
    }
}
