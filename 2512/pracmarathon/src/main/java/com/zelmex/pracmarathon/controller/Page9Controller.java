package com.zelmex.pracmarathon.controller;

import com.zelmex.pracmarathon.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class Page9Controller {
    @FXML private Label amountLabel;

    @FXML
    public void initialize() {
        int amount = Page8Controller.selectedAmount;
        amountLabel.setText("$" + amount);
    }

    @FXML
    private void goBack() {
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