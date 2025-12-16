package com.zelmex.prac2;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import java.io.IOException;

public class HelloApplication extends Application {

    private Stage primaryStage;
    private Scene scene1;
    private Scene scene2;
    private Scene scene3;
    private Scene scene4;
    private Scene scene5;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;
        scene1 = createScene1();
        scene2 = createScene2();
        scene3 = createScene3();
        scene4 = createScene4();
        scene5 = createScene5();
        primaryStage.setTitle("Задания по программированию");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private Scene createScene1() {
        Label titleLabel = new Label("Задание 1");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");
        Label descriptionLabel = new Label("Дано трехзначное число. Найти первую цифру (сотни).");
        descriptionLabel.setStyle("-fx-font-size:14px;");

        Label inputLabel = new Label("Трехзначное число:");
        TextField numberField = new TextField();
        Button calcButton = new Button("Найти сотни");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int number = Integer.parseInt(numberField.getText());

                if (number < 100 || number > 999) {
                    resultLabel.setText("Ошибка: введите трехзначное число (100-999)");
                    return;
                }

                int hundreds = number / 100;

                resultLabel.setText("Первая цифра (сотни): " + hundreds);
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целое число");
            }
        });

        Button btn1Button = new Button("1");
        Button btn2Button = new Button("2");
        Button btn3Button = new Button("3");
        Button btn4Button = new Button("4");
        Button btn5Button = new Button("5");
        btn1Button.setOnAction(event -> primaryStage.setScene(scene1));
        btn2Button.setOnAction(event -> primaryStage.setScene(scene2));
        btn3Button.setOnAction(event -> primaryStage.setScene(scene3));
        btn4Button.setOnAction(event -> primaryStage.setScene(scene4));
        btn5Button.setOnAction(event -> primaryStage.setScene(scene5));

        HBox root2 = new HBox(10, btn1Button, btn2Button, btn3Button, btn4Button, btn5Button);
        root2.setAlignment(Pos.CENTER);
        HBox root1 = new HBox(10, inputLabel, numberField);
        root1.setAlignment(Pos.CENTER);
        VBox root = new VBox(20, titleLabel, descriptionLabel, root1, calcButton, resultLabel, root2);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 500);
    }

    private Scene createScene2() {
        Label titleLabel = new Label("Задание 2");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");
        Label descriptionLabel = new Label("Дано число > 999. Найти цифру в разряде тысяч.");
        descriptionLabel.setStyle("-fx-font-size:14px;");

        Label inputLabel = new Label("Число (> 999):");
        TextField numberField = new TextField();
        Button calcButton = new Button("Найти цифру тысяч");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int number = Integer.parseInt(numberField.getText());

                if (number <= 999) {
                    resultLabel.setText("Ошибка: число должно быть больше 999");
                    return;
                }

                // Получаем цифру тысяч: сначала делим на 1000, затем берем остаток от деления на 10
                int thousandsDigit = (number / 1000) % 10;

                resultLabel.setText("Цифра в разряде тысяч: " + thousandsDigit);
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целое число");
            }
        });

        Button btn1Button = new Button("1");
        Button btn2Button = new Button("2");
        Button btn3Button = new Button("3");
        Button btn4Button = new Button("4");
        Button btn5Button = new Button("5");
        btn1Button.setOnAction(event -> primaryStage.setScene(scene1));
        btn2Button.setOnAction(event -> primaryStage.setScene(scene2));
        btn3Button.setOnAction(event -> primaryStage.setScene(scene3));
        btn4Button.setOnAction(event -> primaryStage.setScene(scene4));
        btn5Button.setOnAction(event -> primaryStage.setScene(scene5));

        HBox root2 = new HBox(10, btn1Button, btn2Button, btn3Button, btn4Button, btn5Button);
        root2.setAlignment(Pos.CENTER);
        HBox root1 = new HBox(10, inputLabel, numberField);
        root1.setAlignment(Pos.CENTER);
        VBox root = new VBox(20, titleLabel, descriptionLabel, root1, calcButton, resultLabel, root2);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 500);
    }

    private Scene createScene3() {
        Label titleLabel = new Label("Задание 3");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");
        Label descriptionLabel = new Label("Определить день недели для K-го дня года (1 января - суббота).");
        descriptionLabel.setStyle("-fx-font-size:14px;");
        descriptionLabel.setWrapText(true);

        Label inputLabel = new Label("День года K (1-365):");
        TextField dayField = new TextField();
        Button calcButton = new Button("Определить день недели");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int k = Integer.parseInt(dayField.getText());

                if (k < 1 || k > 365) {
                    resultLabel.setText("Ошибка: введите число от 1 до 365");
                    return;
                }

                // 1 января = суббота = 6
                // Вычитаем 1, потому что 1 января уже прошло 0 дней от начала года
                int dayOfWeek = (6 + (k - 1)) % 7;

                // Если остаток 0, это воскресенье (7)
                if (dayOfWeek == 0) {
                    dayOfWeek = 7;
                }

                String dayName = "";
                switch (dayOfWeek) {
                    case 1: dayName = "Понедельник"; break;
                    case 2: dayName = "Вторник"; break;
                    case 3: dayName = "Среда"; break;
                    case 4: dayName = "Четверг"; break;
                    case 5: dayName = "Пятница"; break;
                    case 6: dayName = "Суббота"; break;
                    case 7: dayName = "Воскресенье"; break;
                }

                resultLabel.setText("День недели: " + dayOfWeek + " (" + dayName + ")");
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целое число");
            }
        });

        Button btn1Button = new Button("1");
        Button btn2Button = new Button("2");
        Button btn3Button = new Button("3");
        Button btn4Button = new Button("4");
        Button btn5Button = new Button("5");
        btn1Button.setOnAction(event -> primaryStage.setScene(scene1));
        btn2Button.setOnAction(event -> primaryStage.setScene(scene2));
        btn3Button.setOnAction(event -> primaryStage.setScene(scene3));
        btn4Button.setOnAction(event -> primaryStage.setScene(scene4));
        btn5Button.setOnAction(event -> primaryStage.setScene(scene5));

        HBox root2 = new HBox(10, btn1Button, btn2Button, btn3Button, btn4Button, btn5Button);
        root2.setAlignment(Pos.CENTER);
        HBox root1 = new HBox(10, inputLabel, dayField);
        root1.setAlignment(Pos.CENTER);
        VBox root = new VBox(20, titleLabel, descriptionLabel, root1, calcButton, resultLabel, root2);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 500);
    }

    private Scene createScene4() {
        Label titleLabel = new Label("Задание 4");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");
        Label descriptionLabel = new Label("Найти кол-во квадратов на прямоугольнике и незанятую площадь.");
        descriptionLabel.setStyle("-fx-font-size:14px;");

        Label inputALabel = new Label("Сторона A:");
        TextField sideAField = new TextField();
        Label inputBLabel = new Label("Сторона B:");
        TextField sideBField = new TextField();
        Label inputCLabel = new Label("Сторона C (квадрата):");
        TextField sideCField = new TextField();
        Button calcButton = new Button("Вычислить");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int a = Integer.parseInt(sideAField.getText());
                int b = Integer.parseInt(sideBField.getText());
                int c = Integer.parseInt(sideCField.getText());

                if (a <= 0 || b <= 0 || c <= 0) {
                    resultLabel.setText("Ошибка: введите положительные числа");
                    return;
                }

                if (c > a || c > b) {
                    resultLabel.setText("Ошибка: сторона квадрата не может быть больше сторон прямоугольника");
                    return;
                }

                // Количество квадратов по горизонтали и вертикали
                int squaresHorizontal = a / c;
                int squaresVertical = b / c;
                int totalSquares = squaresHorizontal * squaresVertical;

                int occupiedArea = totalSquares * c * c;
                int totalArea = a * b;
                int remainingArea = totalArea - occupiedArea;

                resultLabel.setText("Количество квадратов: " + totalSquares +
                        "\nНезанятая площадь: " + remainingArea);
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целые числа");
            }
        });

        Button btn1Button = new Button("1");
        Button btn2Button = new Button("2");
        Button btn3Button = new Button("3");
        Button btn4Button = new Button("4");
        Button btn5Button = new Button("5");
        btn1Button.setOnAction(event -> primaryStage.setScene(scene1));
        btn2Button.setOnAction(event -> primaryStage.setScene(scene2));
        btn3Button.setOnAction(event -> primaryStage.setScene(scene3));
        btn4Button.setOnAction(event -> primaryStage.setScene(scene4));
        btn5Button.setOnAction(event -> primaryStage.setScene(scene5));

        HBox root2 = new HBox(10, btn1Button, btn2Button, btn3Button, btn4Button, btn5Button);
        root2.setAlignment(Pos.CENTER);
        HBox rootA = new HBox(10, inputALabel, sideAField);
        rootA.setAlignment(Pos.CENTER);
        HBox rootB = new HBox(10, inputBLabel, sideBField);
        rootB.setAlignment(Pos.CENTER);
        HBox rootC = new HBox(10, inputCLabel, sideCField);
        rootC.setAlignment(Pos.CENTER);
        VBox root = new VBox(20, titleLabel, descriptionLabel, rootA, rootB, rootC, calcButton, resultLabel, root2);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 500);
    }

    private Scene createScene5() {
        Label titleLabel = new Label("Задание 5");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");
        Label descriptionLabel = new Label("Определить номер столетия (начало 20 века = 1901 год).");
        descriptionLabel.setStyle("-fx-font-size:14px;");

        Label inputLabel = new Label("Год:");
        TextField yearField = new TextField();
        Button calcButton = new Button("Определить столетие");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int year = Integer.parseInt(yearField.getText());

                if (year <= 0) {
                    resultLabel.setText("Ошибка: введите положительный год");
                    return;
                }

                // Для расчета столетия, где 1901 год - начало 20 века
                // Вычитаем 1, так как 1900 год еще 19 век, а 1901 уже 20 век
                int century = (year - 1) / 100 + 1;

                resultLabel.setText("Номер столетия: " + century);
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целое число");
            }
        });

        Button btn1Button = new Button("1");
        Button btn2Button = new Button("2");
        Button btn3Button = new Button("3");
        Button btn4Button = new Button("4");
        Button btn5Button = new Button("5");
        btn1Button.setOnAction(event -> primaryStage.setScene(scene1));
        btn2Button.setOnAction(event -> primaryStage.setScene(scene2));
        btn3Button.setOnAction(event -> primaryStage.setScene(scene3));
        btn4Button.setOnAction(event -> primaryStage.setScene(scene4));
        btn5Button.setOnAction(event -> primaryStage.setScene(scene5));

        HBox root2 = new HBox(10, btn1Button, btn2Button, btn3Button, btn4Button, btn5Button);
        root2.setAlignment(Pos.CENTER);
        HBox root1 = new HBox(10, inputLabel, yearField);
        root1.setAlignment(Pos.CENTER);
        VBox root = new VBox(20, titleLabel, descriptionLabel, root1, calcButton, resultLabel, root2);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 500);
    }

    public static void main(String[] args) {
        launch();
    }
}
