package com.practica.productos.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.practica.productos.modelo.Producto;
import com.practica.productos.servicio.ProductoService;

public class Main extends Application {
    ProductoService servicio = new ProductoService();
    @Override
    public void start(Stage stage) {
        TextField campo = new TextField(); 
        Button boton = new Button("Mostrar"); 
        Label label = new Label(); 
        
        boton.setOnAction(e -> {
    try {
        // 1. Crear el producto
        Producto p = new Producto(campo.getText());
        
        // 2. Guardarlo en el servicio (Etapa 5)
        servicio.agregar(p);
        
        // 3. Limpiar el campo de texto para el siguiente
        campo.clear();
        
        // 4. Listar todos los productos registrados
        String texto = "Lista de Productos:\n";
        for (Producto prod : servicio.listar()) {
            texto += "- " + prod.getNombre() + "\n";
        }
        
        // 5. Mostrar la lista en el label
        label.setText(texto);
        label.setStyle("-fx-text-fill: black;");
        
    } catch (IllegalArgumentException ex) {
        label.setText(ex.getMessage());
        label.setStyle("-fx-text-fill: red;");
    }
});
        
        VBox layout = new VBox(10, campo, boton, label);
        
        Scene scene = new Scene(layout, 300, 200);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}