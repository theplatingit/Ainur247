package com.zelmex.demo.controller;

import com.zelmex.demo.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controller2 {
    @FXML private Label resultLabel;
    @FXML private TextField aField, bField;

    @FXML
    private void calculate() {
        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());

            // Меняем местами
            double temp = a;
            a = b;
            b = temp;

            resultLabel.setText("A = " + a + ", B = " + b);
        } catch (Exception e) {
            resultLabel.setText("Ошибка: введите числа!");
        }
    }

    @FXML
    private void goToScene1() {
        Manager.switchTo("scene1.fxml", "Задание 1");
    }

    @FXML
    private void goToScene3() {
        Manager.switchTo("scene3.fxml", "Задание 3");
    }
}