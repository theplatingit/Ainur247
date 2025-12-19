package com.zelmex.task4.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Label resultLabel;

    @FXML
    private TextField nField;

    @FXML
    private void calculate() {
        double N = Double.parseDouble(nField.getText());

        double z = (N + 1/Math.tan(N + 1)) / Math.sin(N + 1);
        double c = Math.abs((N + Math.pow(z, 5)) / (3 + z));

        resultLabel.setText("Результат c = " + c);
    }
}