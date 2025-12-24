package com.zelmex.task5;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;

public class HelloController {
    @FXML
    private Label resultLabel;
    @FXML
    private TextField nField;

    @FXML
    protected void onCalculateButtonClick() {
        try {
            int n = Integer.parseInt(nField.getText());

            if (n <= 0) {
                showError("N должно быть больше 0");
                return;
            }

            double[] x = new double[n + 1];
            double[] y = new double[n + 1];

            // Инициализация
            x[1] = 1.0;
            y[1] = 1.0;

            // Вычисление последовательности
            for (int i = 2; i <= n; i++) {
                x[i] = 0.3 * x[i - 1];
                y[i] = x[i - 1] + y[i - 1];
            }

            // Вычисление суммы
            double sum = 0.0;
            for (int i = 1; i <= n; i++) {
                sum += x[i] / (1 + Math.abs(y[i]));
            }

            resultLabel.setText(String.format("Сумма: %.6f", sum));

        } catch (NumberFormatException e) {
            showError("Введите целое число");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}