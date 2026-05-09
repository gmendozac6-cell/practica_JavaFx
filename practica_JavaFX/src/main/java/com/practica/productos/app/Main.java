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
        area.setEditable(false); // Para que el usuario no pueda borrar los productos manualmente
        area.setPromptText("Aquí aparecerán tus productos...");
        
        boton.setOnAction(e -> {
    try {
        // Creamos y agregamos el producto al servicio
        Producto p = new Producto(campo.getText());
        servicio.agregar(p);

        campo.clear(); // Limpiamos el buscador

        // Construimos el string con la lista completa
        StringBuilder listado = new StringBuilder("LISTA DE PRODUCTOS:\n");
        for (Producto prod : servicio.listar()) {
            listado.append("- ").append(prod.getNombre()).append("\n");
        }

        // Mostramos en el TextArea
        area.setText(listado.toString());

    } catch (IllegalArgumentException ex) {
        // Para los errores, podrías seguir usando un Label pequeño 
        // o simplemente imprimirlo en el TextArea para avisar al usuario
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