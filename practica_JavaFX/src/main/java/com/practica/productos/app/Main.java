package com.practica.productos.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.practica.productos.modelo.Producto;
import com.practica.productos.servicio.ProductoService;
import javafx.scene.control.TextArea;

public class Main extends Application {
    ProductoService servicio = new ProductoService();
    @Override
    public void start(Stage stage) {
        TextField campo = new TextField(); 
        Button boton = new Button("Mostrar"); 
        TextArea area = new TextArea();
        area.setEditable(false); 
        area.setPromptText("Aquí aparecerán tus productos...");
        
        Button botonEliminar = new Button("Eliminar");
        botonEliminar.setStyle("-fx-base: #ff6666;"); 
    botonEliminar.setOnAction(e -> {
    String nombre = campo.getText();
    if (!nombre.trim().isEmpty()) {
        servicio.eliminar(nombre); // Llamamos al servicio
        campo.clear();
        
        // Actualizamos el TextArea con la nueva lista
        StringBuilder listado = new StringBuilder("LISTA DE PRODUCTOS:\n");
        for (Producto prod : servicio.listar()) {
            listado.append("- ").append(prod.getNombre()).append("\n");
        }
        area.setText(listado.toString());
    }
});
        botonEliminar.setOnAction(e -> {
    String nombre = campo.getText();
    if (!nombre.trim().isEmpty()) {
        servicio.eliminar(nombre); // Llamamos al servicio
        campo.clear();
        
        // Actualizamos el TextArea con la nueva lista
        StringBuilder listado = new StringBuilder("LISTA DE PRODUCTOS:\n");
        for (Producto prod : servicio.listar()) {
            listado.append("- ").append(prod.getNombre()).append("\n");
        }
        area.setText(listado.toString());
    }
});
            
    try {
        
        Producto p = new Producto(campo.getText());
        servicio.agregar(p);

        campo.clear(); 

        
        StringBuilder listado = new StringBuilder("LISTA DE PRODUCTOS:\n");
        for (Producto prod : servicio.listar()) {
            listado.append("- ").append(prod.getNombre()).append("\n");
        }

        
        area.setText(listado.toString());

    } catch (IllegalArgumentException ex) {
        
        area.setText("ERROR: " + ex.getMessage());
    }
});
        
        VBox layout = new VBox(10, campo, boton, area);
        layout.setStyle("-fx-padding: 20;");
        
        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}