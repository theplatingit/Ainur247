package com.zelmex.demo;

import com.zelmex.demo.util.Manager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {

    @Override
    public void start(Stage stage) {
        new Manager(stage);
        Manager.switchTo("scene1.fxml", "Задание 1");
    }

    public static void main(String[] args) {
        launch();
    }
}