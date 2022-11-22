package com.example.cis296project3;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.io.IOException;

public class CalculatorProject extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CalculatorProject.class.getResource("Calculator.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 250, 445);
        String style = getClass().getResource("styles.css").toExternalForm(); // load css
        scene.getStylesheets().add(style);   //add css as a stylesheet
        stage.setTitle("Calculator");
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}