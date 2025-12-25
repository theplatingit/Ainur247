package com.zelmex.pracmarathon.util;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Manager {
    private static Stage stage;

    public Manager(Stage stage) {
        Manager.stage = stage;
        // Устанавливаем минимальные размеры
        stage.setMinWidth(900);
        stage.setMinHeight(700);
    }

    public static void switchTo(String fxmlFileName, String title) {
        try {
            FXMLLoader loader = new FXMLLoader(
                    Manager.class.getResource("/com/zelmex/pracmarathon/" + fxmlFileName)
            );
            Parent root = loader.load();

            double width = stage.getWidth() > 0 ? stage.getWidth() : 900;
            double height = stage.getHeight() > 0 ? stage.getHeight() : 700;

            Scene scene = new Scene(root, width, height);


            scene.setFill(javafx.scene.paint.Color.WHITE);

            stage.setScene(scene);
            stage.setTitle(title);

            stage.centerOnScreen();
            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}