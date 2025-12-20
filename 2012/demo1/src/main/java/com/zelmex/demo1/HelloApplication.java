package com.zelmex.demo1;

import com.zelmex.demo1.util.Manager;
import javafx.application.Application;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private static Manager manager;

    @Override
    public void start(Stage primaryStage) {
        manager = new Manager(primaryStage);
        manager.switchTo("scene-view.fxml", "Задание 1");
    }

    public static Manager getManager() {
        return manager;
    }

    public static void main(String[] args) {
        launch(args);
    }
}