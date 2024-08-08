package com.example.banco.Entidad;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Garantia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    // Getters y Setters
}