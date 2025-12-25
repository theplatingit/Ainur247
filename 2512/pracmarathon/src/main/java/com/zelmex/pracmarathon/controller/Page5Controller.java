package com.zelmex.pracmarathon.controller;

import com.zelmex.pracmarathon.util.Manager;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import java.util.Optional;

public class Page5Controller {
    @FXML private Label totalLabel;
    @FXML private CheckBox fullMarathonCheck;
    @FXML private CheckBox halfMarathonCheck;
    @FXML private CheckBox shortMarathonCheck;
    @FXML private RadioButton kitACheck;
    @FXML private RadioButton kitBCheck;
    @FXML private RadioButton kitCCheck;
    @FXML private ToggleGroup kitToggleGroup;

    // Цены
    private final int FULL_MARATHON_PRICE = 145;
    private final int HALF_MARATHON_PRICE = 75;
    private final int SHORT_MARATHON_PRICE = 20;
    private final int SPONSOR_AMOUNT = 500; // Фиксированный взнос
    private final int KIT_A_PRICE = 0;
    private final int KIT_B_PRICE = 20;
    private final int KIT_C_PRICE = 45;

    @FXML
    public void initialize() {
        updateTotal();
    }

    @FXML
    public void updateTotal() {
        int total = 0;

        // Считаем стоимость выбранных марафонов
        if (fullMarathonCheck.isSelected()) {
            total += FULL_MARATHON_PRICE;
        }
        if (halfMarathonCheck.isSelected()) {
            total += HALF_MARATHON_PRICE;
        }
        if (shortMarathonCheck.isSelected()) {
            total += SHORT_MARATHON_PRICE;
        }

        // Добавляем спонсорский взнос
        total += SPONSOR_AMOUNT;

        // Добавляем стоимость выбранного комплекта
        if (kitACheck.isSelected()) {
            total += KIT_A_PRICE;
        } else if (kitBCheck.isSelected()) {
            total += KIT_B_PRICE;
        } else if (kitCCheck.isSelected()) {
            total += KIT_C_PRICE;
        }

        // Обновляем отображение
        totalLabel.setText("$" + total);
    }

    @FXML
    private void registerMarathon() {
        // Проверяем, что выбран хотя бы один марафон
        if (!fullMarathonCheck.isSelected() &&
                !halfMarathonCheck.isSelected() &&
                !shortMarathonCheck.isSelected()) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Внимание");
            alert.setHeaderText(null);
            alert.setContentText("Пожалуйста, выберите хотя бы один вид марафона!");
            alert.showAndWait();
            return;
        }

        Manager.switchTo("page6.fxml", "Подтверждение регистрации");
    }

    @FXML
    private void cancel() {
        Manager.switchTo("page7.fxml", "Меню бегуна");
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