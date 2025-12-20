package com.zelmex.demo.controller;

import com.zelmex.demo.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controller3 {
    @FXML private Label resultLabel;
    @FXML private TextField tfField;

    @FXML
    private void calculate() {
        try {
            double tf = Double.parseDouble(tfField.getText());

            double tc = (tf - 32) * 5 / 9;

            resultLabel.setText("Цельсий: " + tc + " °C");
        } catch (Exception e) {
            resultLabel.setText("Ошибка: введите число!");
        }
    }

    @FXML
    private void goToScene2() {
        Manager.switchTo("scene2.fxml", "Задание 2");
    }

    @FXML
    private void goToScene4() {
        Manager.switchTo("scene4.fxml", "Задание 4");
    }
}