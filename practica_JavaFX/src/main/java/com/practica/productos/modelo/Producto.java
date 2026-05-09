package com.practica.productos.modelo;

public class Producto {
    private String nombre;

    public Producto(String nombre) {
        // Validación: si el nombre es nulo o está vacío, lanza un error
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("Nombre inválido");
        }
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }
}