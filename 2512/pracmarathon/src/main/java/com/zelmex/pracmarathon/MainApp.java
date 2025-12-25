package com.zelmex.pracmarathon;

import com.zelmex.pracmarathon.util.Manager;
import javafx.application.Application;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage stage) {
        stage.setWidth(900);
        stage.setHeight(700);

        new Manager(stage);
        Manager.switchTo("page1.fxml", "Marathon Skills 2016");
    }

    public static void main(String[] args) {
        launch();
    }
}