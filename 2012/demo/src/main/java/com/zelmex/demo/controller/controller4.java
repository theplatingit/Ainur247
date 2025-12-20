package com.zelmex.demo.controller;

import com.zelmex.demo.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controller4 {
    @FXML private Label resultLabel;
    @FXML private TextField nField;

    @FXML
    private void calculate() {
        try {
            double n = Double.parseDouble(nField.getText());

            double z = (n + 1/Math.tan(n + 1)) / Math.sin(n + 1);
            double c = Math.abs((n + Math.pow(z, 5)) / (3 + z));

            resultLabel.setText("c = " + c);
        } catch (Exception e) {
            resultLabel.setText("Ошибка: введите число!");
        }
    }

    @FXML
    private void goToScene3() {
        Manager.switchTo("scene3.fxml", "Задание 3");
    }
}