package com.zelmex.zadanie1.controller;

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

        double a2 = a * a;
        double b2 = b * b;

        double sum = a2 + b2;
        double diff = a2 - b2;
        double prod = a2 * b2;
        double quot = a2 / b2;

        resultLabel.setText("Сумма: " + sum + ", Разность: " + diff + ", Произведение: " + prod + ", Частное: " + quot);
    }
}