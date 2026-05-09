package com.practica.productos.app;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import com.practica.productos.modelo.Producto;

public class Main extends Application {
    @Override
    public void start(Stage stage) {
        TextField campo = new TextField(); 
        Button boton = new Button("Mostrar"); 
        Label label = new Label(); 
        
        boton.setOnAction(e -> {
    try {
        // Intentamos crear el producto (aquí se ejecuta la validación)
        Producto p = new Producto(campo.getText());
        
        // Si no hubo error, lo mostramos
        label.setText("Producto: " + p.getNombre());
        label.setStyle("-fx-text-fill: black;"); 
    } catch (IllegalArgumentException ex) {
        // Si el nombre estaba vacío, el modelo lanza el error y lo atrapamos aquí
        label.setText(ex.getMessage());
        label.setStyle("-fx-text-fill: red;"); // Mostrar el error en rojo
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