package com.zelmex.pracmarathon.controller;

import com.zelmex.pracmarathon.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;

public class Page1Controller {
    @FXML
    private void goToPage2() {
        Manager.switchTo("page2.fxml", "Marathon Skills 2016");
    }

    @FXML
    private void goToPage8() {
        Manager.switchTo("page8.fxml", "Спонсор бегуна");
    }

    @FXML
    private void showAboutEvent() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Информация о событии");
        alert.setHeaderText("Marathon Skills 2016");
        alert.setContentText("Marathon Skills 2016 пройдет в Москве 21 октября 2016 года.\n\n" +
                "Это ежегодное мероприятие, объединяющее бегунов со всего мира.\n" +
                "Доступные дистанции:\n" +
                "- 42 км (полный марафон)\n" +
                "- 21 км (полумарафон)\n" +
                "- 5 км (малая дистанция)\n\n" +
                "Регистрация открыта до 15 октября 2016 года.");
        alert.showAndWait();
    }

    @FXML
    private void login() {
        Manager.switchTo("page3.fxml", "Форма авторизации");
    }
}