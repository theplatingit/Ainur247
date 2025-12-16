package com.zelmex.prac1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import java.util.Optional;

public class HelloApplication extends Application {

    private Stage primaryStage;
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;

        scene1 = createScene1();
        scene2 = createScene2();
        scene3 = createScene3();
        scene4 = createScene4();

        primaryStage.setTitle("Практическая работа");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private Scene createScene1() {
        Label titleLabel = new Label("Задание 1");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label promptLabel = new Label("Введите два ненулевых числа:");
        promptLabel.setWrapText(true);

        TextField fieldA = new TextField();
        fieldA.setPromptText("a");
        TextField fieldB = new TextField();
        fieldB.setPromptText("b");

        Button calcButton = new Button("Вычислить");
        Label resultLabel = new Label();
        resultLabel.setWrapText(true);

        calcButton.setOnAction(event -> {
            try {
                double a = Double.parseDouble(fieldA.getText());
                double b = Double.parseDouble(fieldB.getText());
                if (a == 0 || b == 0) {
                    resultLabel.setText("Числа должны быть ненулевыми!");
                    return;
                }
                double sum = Math.pow(a, 2) + Math.pow(b, 2);
                double diff = Math.pow(a, 2) - Math.pow(b, 2);
                double prod = Math.pow(a, 2) * Math.pow(b, 2);
                double quot = Math.pow(a, 2) / Math.pow(b, 2);
                resultLabel.setText(String.format(
                        "Сумма квадратов: %.2f\n" +
                                "Разность квадратов: %.2f\n" +
                                "Произведение квадратов: %.2f\n" +
                                "Частное квадратов: %.2f",
                        sum, diff, prod, quot
                ));
            } catch (NumberFormatException e) {
                resultLabel.setText("Введите корректные числа!");
            }
        });

        HBox navBox = createNavButtons();
        HBox inputRow = new HBox(10,
                new Label("a:"), fieldA,
                new Label("b:"), fieldB
        );
        inputRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(20,
                titleLabel,
                promptLabel,
                inputRow,
                calcButton,
                resultLabel,
                navBox
        );
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        return new Scene(root, 500, 500);
    }

    private Scene createScene2() {
        Label titleLabel = new Label("Задание 2");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label promptLabel = new Label("Введите значения A и B:");
        promptLabel.setWrapText(true);

        TextField fieldA = new TextField();
        fieldA.setPromptText("A");
        TextField fieldB = new TextField();
        fieldB.setPromptText("B");

        Button swapButton = new Button("Поменять местами");
        Label resultLabel = new Label();
        resultLabel.setWrapText(true);

        swapButton.setOnAction(event -> {
            String temp = fieldA.getText();
            fieldA.setText(fieldB.getText());
            fieldB.setText(temp);
            resultLabel.setText(String.format(
                    "Новые значения: a = %s, b = %s",
                    fieldA.getText(),
                    fieldB.getText()
            ));
        });

        HBox navBox = createNavButtons();
        HBox inputRow = new HBox(10,
                new Label("A:"), fieldA,
                new Label("B:"), fieldB
        );
        inputRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(20,
                titleLabel,
                promptLabel,
                inputRow,
                swapButton,
                resultLabel,
                navBox
        );
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        return new Scene(root, 500, 500);
    }

    private Scene createScene3() {
        Label titleLabel = new Label("Задание 3");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label promptLabel = new Label("Введите температуру в градусах Фаренгейта:");
        promptLabel.setWrapText(true);

        TextField fieldTf = new TextField();
        fieldTf.setPromptText("Tf");

        Button convertButton = new Button("Преобразовать");
        Label resultLabel = new Label();
        resultLabel.setWrapText(true);

        convertButton.setOnAction(event -> {
            try {
                double tf = Double.parseDouble(fieldTf.getText());
                double tc = (tf - 32) * 5 / 9;
                resultLabel.setText(String.format(
                        "Температура в Цельсиях: %.2f",
                        tc
                ));
            } catch (NumberFormatException e) {
                resultLabel.setText("Введите корректное число!");
            }
        });

        HBox navBox = createNavButtons();
        HBox inputRow = new HBox(10,
                new Label("Tf:"), fieldTf
        );
        inputRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(20,
                titleLabel,
                promptLabel,
                inputRow,
                convertButton,
                resultLabel,
                navBox
        );
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        return new Scene(root, 500, 500);
    }

    private Scene createScene4() {
        Label titleLabel = new Label("Задание 4");
        titleLabel.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

        Label promptLabel = new Label(
                "Введите значение N (должно быть таким, чтобы sin(N+1) != 0 и z != -3):"
        );
        promptLabel.setWrapText(true);

        TextField fieldN = new TextField();
        fieldN.setPromptText("N");

        Button calcButton = new Button("Вычислить");
        Label resultLabel = new Label();
        resultLabel.setWrapText(true);

        calcButton.setOnAction(event -> {
            try {
                double n = Double.parseDouble(fieldN.getText());
                double sinVal = Math.sin(n + 1);
                if (sinVal == 0) {
                    resultLabel.setText("sin(N+1) не может быть равен 0!");
                    return;
                }
                double ctgVal = 1 / Math.tan(n + 1);
                double z = (n + ctgVal) / sinVal;
                if (z == -3) {
                    resultLabel.setText("z не может быть равен -3!");
                    return;
                }
                double numerator = n + Math.pow(z, 5);
                double denominator = 3 + z;
                if (denominator == 0) {
                    resultLabel.setText("Знаменатель не может быть равен 0!");
                    return;
                }
                double c = Math.abs(numerator / denominator);
                resultLabel.setText(String.format("Значение c: %.2f", c));
            } catch (NumberFormatException e) {
                resultLabel.setText("Введите корректное число!");
            }
        });

        HBox navBox = createNavButtons();
        HBox inputRow = new HBox(10,
                new Label("N:"), fieldN
        );
        inputRow.setAlignment(Pos.CENTER);

        VBox root = new VBox(20,
                titleLabel,
                promptLabel,
                inputRow,
                calcButton,
                resultLabel,
                navBox
        );
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));

        return new Scene(root, 500, 500);
    }

    private HBox createNavButtons() {
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");

        btn1.setOnAction(e -> primaryStage.setScene(scene1));
        btn2.setOnAction(e -> primaryStage.setScene(scene2));
        btn3.setOnAction(e -> primaryStage.setScene(scene3));
        btn4.setOnAction(e -> primaryStage.setScene(scene4));

        HBox box = new HBox(10, btn1, btn2, btn3, btn4);
        box.setAlignment(Pos.CENTER);
        return box;
    }

    public static void main(String[] args) {
        launch(args);
    }
}