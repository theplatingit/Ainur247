package com.zelmex.pracmarathon.controller;

import com.zelmex.pracmarathon.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ComboBox;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class Page8Controller {
    @FXML private TextField nameField;
    @FXML private ComboBox<String> runnerComboBox;
    @FXML private TextField cardNameField;
    @FXML private TextField cardNumberField;
    @FXML private TextField monthField;
    @FXML private TextField yearField;
    @FXML private TextField cvcField;
    @FXML private Label amountLabel;

    private int amount = 50;
    public static int selectedAmount = 50;

    @FXML
    public void initialize() {
        amountLabel.setText("$" + amount);

        ObservableList<String> runners = FXCollections.observableArrayList(
                "Иван Смирнов-204 (Russia)",
                "Валера Сидоров-223 (Argentina)",
                "Евгения Иванова-256 (Poland)"
        );
        runnerComboBox.setItems(runners);
    }

    @FXML
    private void increaseAmount() {
        if (amount < 200) {
            amount += 10;
            amountLabel.setText("$" + amount);
        }
    }

    @FXML
    private void decreaseAmount() {
        if (amount > 50) {
            amount -= 10;
            amountLabel.setText("$" + amount);
        }
    }

    @FXML
    private void pay() {
        if (nameField.getText().isEmpty()) {
            showAlert("Ошибка", "Введите ваше имя");
            return;
        }

        if (runnerComboBox.getValue() == null) {
            showAlert("Ошибка", "Выберите бегуна");
            return;
        }

        if (cardNameField.getText().isEmpty()) {
            showAlert("Ошибка", "Введите имя владельца карты");
            return;
        }

        if (cardNumberField.getText().isEmpty()) {
            showAlert("Ошибка", "Введите номер карты");
            return;
        }

        if (monthField.getText().isEmpty()) {
            showAlert("Ошибка", "Введите месяц срока действия");
            return;
        }

        if (yearField.getText().isEmpty()) {
            showAlert("Ошибка", "Введите год срока действия");
            return;
        }

        if (cvcField.getText().isEmpty()) {
            showAlert("Ошибка", "Введите CVC код");
            return;
        }

        selectedAmount = amount;
        Manager.switchTo("page9.fxml", "Подтверждение спонсорства");
    }

    @FXML
    private void cancel() {
        Manager.switchTo("page1.fxml", "Marathon Skills 2016");
    }

    @FXML
    private void logout() {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Выход");
        alert.setHeaderText("Вы уверены, что хотите выйти?");

        Optional<ButtonType> result = alert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            Manager.switchTo("page1.fxml", "Marathon Skills 2016");
        }
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}