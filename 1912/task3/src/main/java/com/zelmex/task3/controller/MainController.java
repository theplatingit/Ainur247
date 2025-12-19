package com.zelmex.task3.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController {
    @FXML
    private Label resultLabel;

    @FXML
    private TextField fField;

    @FXML
    private void calculate() {
        double tf = Double.parseDouble(fField.getText());
        double tc = (tf - 32) * 5 / 9;

        resultLabel.setText("Температура по Цельсию: " + tc);
    }
}