package com.zelmex.task1;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.event.ActionEvent;
import java.util.List;

public class ListController {
    @FXML
    private TextField numberTextField;
    @FXML
    private ListView<Integer> dataListView;
    @FXML
    private Label answerLabel;

    @FXML
    void addButtonOnAction(ActionEvent event) {
        if (numberTextField.getText().isEmpty()) {
            return;
        }
        try {
            int x = Integer.parseInt(numberTextField.getText());
            dataListView.getItems().add(x);
            numberTextField.setText("");
        } catch (NumberFormatException ex) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Введены некорректные данные");
            alert.showAndWait();
            numberTextField.setText("");
        }
    }

    @FXML
    void okButtonOnAction(ActionEvent event) {
        List<Integer> data = dataListView.getItems();

        if (data.isEmpty()) {
            answerLabel.setText("Список пуст");
            return;
        }

        // Первый элемент - количество чисел
        int n = data.get(0);

        if (n <= 0) {
            answerLabel.setText("Неверный формат: N должно быть > 0");
            return;
        }

        if (n > data.size() - 1) {
            answerLabel.setText("Недостаточно чисел");
            return;
        }

        int count = 0;

        // Перебираем числа с 1 до n (индексы 1..n)
        for (int i = 1; i <= n; i++) {
            int m = data.get(i);
            // Проверяем: кратно 3 И оканчивается на 2
            // Используем Math.abs() для работы с отрицательными числами
            if (m % 3 == 0 && Math.abs(m % 10) == 2) {
                count++;
            }
        }

        answerLabel.setText(String.valueOf(count));
    }

    @FXML
    void cancelButtonOnAction(ActionEvent event) {
        Platform.exit();
    }
}