package com.zelmex.pracmarathon.controller;

import com.zelmex.pracmarathon.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class Page3Controller {
    @FXML private TextField emailField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    @FXML
    private void login() {
        String email = emailField.getText();
        String password = passwordField.getText();

        if (email.equals("247@gmail.com") && password.equals("123123")) {
            Manager.switchTo("page7.fxml", "Меню бегуна");
        } else {
            errorLabel.setText("Неверный email или пароль!");
        }
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
}