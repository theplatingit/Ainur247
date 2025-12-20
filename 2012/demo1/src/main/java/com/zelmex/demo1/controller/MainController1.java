package com.zelmex.demo1.controller;

import com.zelmex.demo1.HelloApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class MainController1 {

    @FXML
    private TextField num1Field;
    @FXML
    private TextField num2Field;
    @FXML
    private Label resultLabel;

    @FXML
    protected void onCalcButtonClick(ActionEvent event) {
        // ... код вычислений
    }

    @FXML
    private void goToscene2(ActionEvent event) {
        HelloApplication.getManager().switchTo("scene2-view.fxml", "Задание 2: Обмен значений");
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