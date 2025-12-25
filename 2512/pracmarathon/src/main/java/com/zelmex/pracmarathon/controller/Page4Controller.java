package com.zelmex.pracmarathon.controller;

import com.zelmex.pracmarathon.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.Alert.AlertType;
import java.util.Optional;

public class Page4Controller {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private PasswordField confirmPasswordField;
    @FXML private TextField firstNameField;
    @FXML private TextField lastNameField;
    @FXML private RadioButton maleRadio;
    @FXML private RadioButton femaleRadio;
    @FXML private TextField birthDateField;
    @FXML private TextField countryField;
    @FXML private Label errorLabel;

    @FXML
    private void register() {
        String email = emailField.getText();
        String password = passwordField.getText();
        String confirm = confirmPasswordField.getText();
        String firstName = firstNameField.getText();
        String lastName = lastNameField.getText();
        String birthDate = birthDateField.getText();
        String country = countryField.getText();

        if (email.isEmpty() || password.isEmpty() || confirm.isEmpty() ||
                firstName.isEmpty() || lastName.isEmpty() || birthDate.isEmpty() || country.isEmpty()) {
            errorLabel.setText("Заполните все поля!");
            return;
        }

        if (!password.equals(confirm)) {
            errorLabel.setText("Пароли не совпадают!");
            return;
        }

        if (!birthDate.matches("\\d{4}-\\d{2}-\\d{2}")) {
            errorLabel.setText("Дата должна быть в формате ГГГГ-ММ-ДД!");
            return;
        }

        Manager.switchTo("page6.fxml", "Подтверждение регистрации");
    }

    @FXML
    private void cancel() {
        Manager.switchTo("page2.fxml", "Marathon Skills 2016");
    }

    @FXML
    private void showPhotoAlert() {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText("Функция на данный момент не доступна");
        alert.showAndWait();
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
}