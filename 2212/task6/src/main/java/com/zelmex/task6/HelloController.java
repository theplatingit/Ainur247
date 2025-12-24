package com.zelmex.task6;

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
    private TextField kField;

    @FXML
    protected void onCalculateButtonClick() {
        try {
            int n = Integer.parseInt(nField.getText());
            int k = Integer.parseInt(kField.getText());

            if (n <= 0 || k < 0) {
                showError("N должно быть > 0, K ≥ 0");
                return;
            }

            double sum = 0.0;
            for (int i = 1; i <= n; i++) {
                sum += Math.pow(i, k);
            }

            resultLabel.setText(String.format("Сумма: %.6f", sum));

        } catch (NumberFormatException e) {
            showError("Введите целые числа");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}