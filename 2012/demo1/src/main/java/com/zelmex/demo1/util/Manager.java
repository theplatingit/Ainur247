package com.zelmex.demo1.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Manager {
    private final Stage stage;

    public Manager(Stage stage) {
        this.stage = stage;
    }

    public void switchTo(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource(fxmlFileName));
            Scene scene = new Scene(loader.load(), 600, 400);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException("Ошибка загрузки: " + fxmlFileName);
        }
    }
}