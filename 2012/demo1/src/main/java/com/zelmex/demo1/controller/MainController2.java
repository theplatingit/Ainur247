package com.zelmex.demo1.controller;

import com.zelmex.demo1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController2 {

    @FXML
    private TextField aOriginalField;
    @FXML
    private TextField bOriginalField;
    @FXML
    private Label resultLabel;

    @FXML
    protected void onSwapButtonClick(ActionEvent event) {
        // ... код обмена
    }

    @FXML
    private void goToscene(ActionEvent event) {
        HelloApplication.getManager().switchTo("scene-view.fxml", "Задание 1: Операции с числами");
    }

    @FXML
    private void goToscene3(ActionEvent event) {
        HelloApplication.getManager().switchTo("scene3-view.fxml", "Задание 3: Конвертер температуры");
    }

    @FXML
    private void goToscene4(ActionEvent event) {
        HelloApplication.getManager().switchTo("scene4-view.fxml", "Задание 4: Сложная функция");
    }
}