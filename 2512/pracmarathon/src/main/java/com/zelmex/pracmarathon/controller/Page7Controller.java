package com.zelmex.pracmarathon.controller;

import com.zelmex.pracmarathon.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class Page7Controller {
    @FXML
    private void goToPage5() {
        Manager.switchTo("page5.fxml", "Регистрация на марафон");
    }

    @FXML
    private void goToPage10() {
        Manager.switchTo("page10.fxml", "Мои спонсоры");
    }

    @FXML
    private void showContacts() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Контакты");
        alert.setHeaderText("Для получения дополнительной информации пожалуйста свяжитесь с координаторами");
        alert.setContentText("Телефон: +55 11 9988 7766\nEmail: coordinators@marathonskills.org");
        alert.showAndWait();
    }

    @FXML
    private void showProfileAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText("Функция редактирования профиля пока не доступна");
        alert.showAndWait();
    }

    @FXML
    private void showResultsAlert() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация");
        alert.setHeaderText(null);
        alert.setContentText("Мои результаты пока не доступны");
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

    @FXML
    private void goBack() {
        Manager.switchTo("page1.fxml", "Marathon Skills 2016");
    }
}