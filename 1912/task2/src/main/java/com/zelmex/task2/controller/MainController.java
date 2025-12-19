package com.zelmex.task2.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Label resultLabel;

    @FXML
    private TextField aField;

    @FXML
    private TextField bField;

    @FXML
    private void calculate() {
        double a = Double.parseDouble(aField.getText());
        double b = Double.parseDouble(bField.getText());

        double temp = a;
        a = b;
        b = temp;

        resultLabel.setText("A = " + a + ", B = " + b);
    }
}