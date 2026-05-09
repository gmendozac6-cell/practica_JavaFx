package com.practica.productos.servicio;

import com.practica.productos.modelo.Producto;
import java.util.ArrayList;
import java.util.List;

public class ProductoService {
    // Lista interna para almacenar los productos en memoria
    private List<Producto> productos = new ArrayList<>();

    public void agregar(Producto p) {
        productos.add(p);
    }

    public List<Producto> listar() {
        // Devolvemos una copia de la lista para proteger la original
        return new ArrayList<>(productos);
    }
}