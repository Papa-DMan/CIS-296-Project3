package com.mahaney.cis296project3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class HelloController {
    @FXML
    private Label stackDisplay;

    @FXML
    private void calcInputCallback(ActionEvent e) {
        final Node source = (Node) e.getSource();
        if (source instanceof Button) {
            if (((Button) source).getText().contains("⎵")) {
                stackDisplay.setText(stackDisplay.getText() + " ");
            } else {
                stackDisplay.setText(stackDisplay.getText() + ((Button) source).getText());
            }
        }
    }

}