package com.zelmex.task3;

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
                showError("Число должно быть больше 0");
                return;
            }

            double sum = 0.0;
            for (int i = 1; i <= n; i++) {
                sum += 1.0 / i;
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