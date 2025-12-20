package com.zelmex.demo.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Manager {
    private static Stage stage;

    public Manager(Stage stage) {
        Manager.stage = stage;
        stage.setMinWidth(400);
        stage.setMinHeight(300);
    }

    public static void switchTo(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Manager.class.getResource("/com/zelmex/demo/" + fxmlFileName)
            );
            Scene scene = new Scene(loader.load(), 400, 300);
            stage.setScene(scene);
            stage.setTitle(title);
            stage.show();
        } catch (IOException e) {
            e.printStackTrace();
            throw new RuntimeException("Не удалось загрузить: " + fxmlFileName);
        }
    }
}