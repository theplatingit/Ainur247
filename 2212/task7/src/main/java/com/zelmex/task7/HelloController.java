package com.zelmex.task7;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Alert;

public class HelloController {
    @FXML
    private Label resultLabel;
    @FXML
    private TextField epsilonField;
    @FXML
    private ChoiceBox<String> formulaChoice;

    @FXML
    public void initialize() {
        formulaChoice.getItems().addAll(
                "а) Σ(1/i²) от i=1",
                "б) Σ(1/(i(i+1))) от i=1",
                "в) Σ((-1)^i/i!) от i=1",
                "г) Σ((-2)^i/i!) от i=0",
                "д) Σ((-1)^(i+1)/(i(i+1)(i+2))) от i=1",
                "е) Σ(1/(4^i + 5^(i+2))) от i=0"
        );
        formulaChoice.setValue("а) Σ(1/i²) от i=1");
    }

    @FXML
    protected void onCalculateButtonClick() {
        try {
            double epsilon = Double.parseDouble(epsilonField.getText());

            if (epsilon <= 0) {
                showError("Точность ε должна быть > 0");
                return;
            }

            double sum = 0.0;
            double term = 0.0;
            int i = 0;
            int count = 0;
            String selected = formulaChoice.getValue();

            if (selected.startsWith("а")) {
                // Σ(1/i²) от i=1
                i = 1;
                do {
                    term = 1.0 / (i * i);
                    sum += term;
                    i++;
                    count++;
                } while (Math.abs(term) >= epsilon);
                i--;

            } else if (selected.startsWith("б")) {
                // Σ(1/(i(i+1))) от i=1
                i = 1;
                do {
                    term = 1.0 / (i * (i + 1));
                    sum += term;
                    i++;
                    count++;
                } while (Math.abs(term) >= epsilon);
                i--;

            } else if (selected.startsWith("в")) {
                // Σ((-1)^i/i!) от i=1
                i = 1;
                double factorial = 1.0;
                do {
                    factorial *= i;
                    term = Math.pow(-1, i) / factorial;
                    sum += term;
                    i++;
                    count++;
                } while (Math.abs(term) >= epsilon);
                i--;

            } else if (selected.startsWith("г")) {
                // Σ((-2)^i/i!) от i=0
                i = 0;
                double factorial = 1.0; // 0! = 1
                do {
                    if (i > 0) {
                        factorial *= i;
                    }
                    term = Math.pow(-2, i) / factorial;
                    sum += term;
                    i++;
                    count++;
                } while (Math.abs(term) >= epsilon);
                i--;

            } else if (selected.startsWith("д")) {
                // Σ((-1)^(i+1)/(i(i+1)(i+2))) от i=1
                i = 1;
                do {
                    term = Math.pow(-1, i + 1) / (i * (i + 1) * (i + 2));
                    sum += term;
                    i++;
                    count++;
                } while (Math.abs(term) >= epsilon);
                i--;

            } else if (selected.startsWith("е")) {
                // Σ(1/(4^i + 5^(i+2))) от i=0
                i = 0;
                do {
                    term = 1.0 / (Math.pow(4, i) + Math.pow(5, i + 2));
                    sum += term;
                    i++;
                    count++;
                } while (Math.abs(term) >= epsilon);
                i--;
            }

            resultLabel.setText(String.format("Сумма: %.10f\nВычислено слагаемых: %d", sum, count));

        } catch (NumberFormatException e) {
            showError("Введите корректное число для ε");
        }
    }

    private void showError(String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setContentText(message);
        alert.showAndWait();
    }
}