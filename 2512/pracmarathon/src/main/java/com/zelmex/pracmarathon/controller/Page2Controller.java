package com.zelmex.pracmarathon.controller;

import com.zelmex.pracmarathon.util.Manager;
import javafx.fxml.FXML;

public class Page2Controller {
    @FXML
    private void goToPage3() {
        Manager.switchTo("page3.fxml", "Форма авторизации");
    }

    @FXML
    private void goToPage4() {
        Manager.switchTo("page4.fxml", "Регистрация бегуна");
    }

    @FXML
    private void goBack() {
        Manager.switchTo("page1.fxml", "Marathon Skills 2016");
    }

    @FXML
    private void login() {
        Manager.switchTo("page3.fxml", "Форма авторизации");
    }
}