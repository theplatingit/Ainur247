package ru.zelmex.landresources247;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class LandResourcesApplication extends Application {

    public static Stage primaryStage;
    public static Scene landCategories;
    public static Scene landOwners;
    public static Scene landPlots;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        landCategories = createScene("land-category-view.fxml");
        landOwners = createScene("land-owner-view.fxml");
        landPlots = createScene("land-plot-view.fxml");

        primaryStage.setMinWidth(1200);
        primaryStage.setMinHeight(675);
        primaryStage.setTitle("Статистика земельных ресурсов");

        landCategories.getStylesheets().add("base-styles.css");
        landOwners.getStylesheets().add("base-styles.css");
        landPlots.getStylesheets().add("base-styles.css");

        primaryStage.setScene(landCategories);
        primaryStage.show();
    }

    private Scene createScene(String name) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(LandResourcesApplication.class.getResource(name));
        return new Scene(fxmlLoader.load());
    }

    public static void main(String[] args) {
        launch();
    }
}