package com.example.banco.Servicios;

import com.example.banco.Entidad.Cuenta;
import com.example.banco.Repositorios.CuentaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CuentaServicio {

    @Autowired
    private CuentaRepositorio cuentaRepositorio;

    public List<Cuenta> listarTodas() {
        return cuentaRepositorio.findAll();
    }

    public Cuenta guardar(Cuenta cuenta) {
        return cuentaRepositorio.save(cuenta);
    }

    public Optional<Cuenta> obtenerPorId(Long id) {
        return cuentaRepositorio.findById(id);
    }

    public void eliminar(Long id) {
        cuentaRepositorio.deleteById(id);
    }
}
