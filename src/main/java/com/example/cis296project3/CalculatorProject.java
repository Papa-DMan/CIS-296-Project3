package com.example.cis296project3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorProject extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorProject.class.getResource("Calculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 300, 650);
        String style = getClass().getResource("styles.css").toExternalForm();
        scene.getStylesheets().add(style);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}