package com.zelmex.demo1.controller;

import com.zelmex.demo1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController4 {

    @FXML
    private TextField nField;
    @FXML
    private Label resultLabel;

    @FXML
    protected void onCalcButtonClick(ActionEvent event) {
        // ... код вычисления функции
    }

    @FXML
    private void goToscene(ActionEvent event) {
        HelloApplication.getManager().switchTo("scene-view.fxml", "Задание 1: Операции с числами");
    }

    @FXML
    private void goToscene2(ActionEvent event) {
        HelloApplication.getManager().switchTo("scene2-view.fxml", "Задание 2: Обмен значений");
    }

    @FXML
    private void goToscene3(ActionEvent event) {
        HelloApplication.getManager().switchTo("scene3-view.fxml", "Задание 3: Конвертер температуры");
    }
}