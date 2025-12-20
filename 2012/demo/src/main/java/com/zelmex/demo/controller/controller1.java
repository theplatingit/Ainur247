package com.zelmex.demo.controller;

import com.zelmex.demo.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class controller1 {
    @FXML private Label resultLabel;
    @FXML private TextField aField, bField;

    @FXML
    private void calculate() {
        try {
            double a = Double.parseDouble(aField.getText());
            double b = Double.parseDouble(bField.getText());

            double a2 = a * a;
            double b2 = b * b;
            double sum = a2 + b2;
            double diff = a2 - b2;
            double prod = a2 * b2;
            double quot = a2 / b2;

            resultLabel.setText("Сумма: " + sum + ", Разность: " + diff +
                    ", Произведение: " + prod + ", Частное: " + quot);
        } catch (Exception e) {
            resultLabel.setText("Ошибка: введите числа! (b ≠ 0)");
        }
    }

    @FXML
    private void goToScene2() {
        Manager.switchTo("scene2.fxml", "Задание 2");
    }
}