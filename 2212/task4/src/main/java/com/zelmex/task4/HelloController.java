package com.zelmex.task4;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class HelloController {
    @FXML
    private Label resultLabel;
    @FXML
    private TextField aField;
    @FXML
    private TextField nField;

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double a = Double.parseDouble(aField.getText());
            int n = Integer.parseInt(nField.getText());

            if (n <= 0) {
                showError("N должно быть больше 0");
                return;
            }

            double sum = 0.0;
            double term = 1.0; // первый член (A^0)

            for (int i = 0; i <= n; i++) {
                if (i > 0) {
                    term = Math.pow(a, i);
                    if (i % 2 == 1) {
                        term = -term; // меняем знак для нечетных степеней
                    }
                }
                sum += term;
            }

            resultLabel.setText(String.format("Сумма: %.6f", sum));

        } catch (NumberFormatException e) {
            showError("Введите корректные числа");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}