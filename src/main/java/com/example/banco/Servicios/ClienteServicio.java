package com.example.banco.Servicios;

import com.example.banco.Entidad.Cliente;
import com.example.banco.Repositorios.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServicio {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    public List<Cliente> listarTodos() {
        return clienteRepositorio.findAll();
    }

    public Cliente guardar(Cliente cliente) {
        return clienteRepositorio.save(cliente);
    }

    public Optional<Cliente> obtenerPorId(Long id) {
        return clienteRepositorio.findById(id);
    }

    public void eliminar(Long id) {
        clienteRepositorio.deleteById(id);
    }
}
