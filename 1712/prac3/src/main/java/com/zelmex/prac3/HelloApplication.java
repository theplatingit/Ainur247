package com.zelmex.prac3;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TextArea;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;

public class HelloApplication extends Application {
    private Stage primaryStage;
    private Scene scene1, scene2, scene3, scene4, scene5;
    private Scene scene6, scene7;

    @Override
    public void start(Stage stage) throws IOException {
        primaryStage = stage;

        scene1 = createScene1();
        scene2 = createScene2();
        scene3 = createScene3();
        scene4 = createScene4();
        scene5 = createScene5();
        scene6 = createScene6();
        scene7 = createScene7();

        primaryStage.setTitle("Практическая работа 3");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private HBox createNavigationButtons() {
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");

        btn1.setOnAction(event -> primaryStage.setScene(scene1));
        btn2.setOnAction(event -> primaryStage.setScene(scene2));
        btn3.setOnAction(event -> primaryStage.setScene(scene3));
        btn4.setOnAction(event -> primaryStage.setScene(scene4));
        btn5.setOnAction(event -> primaryStage.setScene(scene5));
        btn6.setOnAction(event -> primaryStage.setScene(scene6));
        btn7.setOnAction(event -> primaryStage.setScene(scene7));

        HBox navBox = new HBox(10, btn1, btn2, btn3, btn4, btn5, btn6, btn7);
        navBox.setAlignment(Pos.CENTER);
        return navBox;
    }

    private Scene createScene1() {
        Label titleLabel = new Label("Задание 1: Кратность суммы цифр");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");

        TextField numberField = new TextField();
        numberField.setPromptText("Двузначное число");
        TextField aField = new TextField();
        aField.setPromptText("Число A");

        Button calcButton = new Button("Проверить");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size:14px;");

        calcButton.setOnAction(event -> {
            try {
                int number = Integer.parseInt(numberField.getText());
                int a = Integer.parseInt(aField.getText());

                if (number < 10 || number > 99) {
                    resultLabel.setText("Ошибка: Введите двузначное число (10-99)");
                    return;
                }

                if (a == 0) {
                    resultLabel.setText("Ошибка: Число A не может быть нулем");
                    return;
                }

                int digit1 = number / 10;
                int digit2 = number % 10;
                int sum = digit1 + digit2;

                String result = "Число: " + number + " (цифры: " + digit1 + " и " + digit2 + ")\n";
                result += "Сумма цифр: " + sum + "\n";
                result += "Число A: " + a + "\n";

                if (sum % a == 0) {
                    result += "Сумма цифр КРАТНА числу A";
                } else {
                    result += "Сумма цифр НЕ КРАТНА числу A";
                }

                resultLabel.setText(result);
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: Введите корректные числа");
            }
        });

        HBox navBox = createNavigationButtons();
        HBox inputBox1 = new HBox(10, new Label("Двузначное число:"), numberField);
        inputBox1.setAlignment(Pos.CENTER);
        HBox inputBox2 = new HBox(10, new Label("Число A:"), aField);
        inputBox2.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, titleLabel, inputBox1, inputBox2, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 450);
    }

    private Scene createScene2() {
        Label titleLabel = new Label("Задание 2: Перераспределение значений");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");

        TextField aField = new TextField();
        aField.setPromptText("Число A");
        TextField bField = new TextField();
        bField.setPromptText("Число B");

        Button calcButton = new Button("Выполнить перераспределение");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size:14px;");

        calcButton.setOnAction(event -> {
            try {
                double a = Double.parseDouble(aField.getText());
                double b = Double.parseDouble(bField.getText());

                String original = String.format("Исходные значения:\nA = %.3f\nB = %.3f\n\n", a, b);

                double originalA = a;
                double originalB = b;

                if (a > b) {
                    double temp = a;
                    a = b;
                    b = temp;
                }

                String result = original + String.format("После перераспределения:\n" +
                                "A = %.3f (меньшее из %.3f и %.3f)\n" +
                                "B = %.3f (большее из %.3f и %.3f)",
                        a, originalA, originalB, b, originalA, originalB);

                resultLabel.setText(result);
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: Введите корректные числа");
            }
        });

        HBox navBox = createNavigationButtons();
        HBox inputBox1 = new HBox(10, new Label("Число A:"), aField);
        inputBox1.setAlignment(Pos.CENTER);
        HBox inputBox2 = new HBox(10, new Label("Число B:"), bField);
        inputBox2.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, titleLabel, inputBox1, inputBox2, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 550, 500);
    }

    private Scene createScene3() {
        Label titleLabel = new Label("Задание 3: Найти отличное число");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");

        TextField num1Field = new TextField();
        num1Field.setPromptText("Первое число");
        TextField num2Field = new TextField();
        num2Field.setPromptText("Второе число");
        TextField num3Field = new TextField();
        num3Field.setPromptText("Третье число");

        Button calcButton = new Button("Найти отличное число");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size:14px;");

        calcButton.setOnAction(event -> {
            try {
                int num1 = Integer.parseInt(num1Field.getText());
                int num2 = Integer.parseInt(num2Field.getText());
                int num3 = Integer.parseInt(num3Field.getText());

                String numbers = "Числа: " + num1 + ", " + num2 + ", " + num3 + "\n";

                if (num1 == num2 && num2 == num3) {
                    resultLabel.setText(numbers + "Все три числа равны. Должно быть два равных и одно отличное.");
                    return;
                }

                String result;
                if (num1 == num2 && num1 != num3) {
                    result = numbers + "Отличное число: " + num3 + " (позиция 3)";
                } else if (num1 == num3 && num1 != num2) {
                    result = numbers + "Отличное число: " + num2 + " (позиция 2)";
                } else if (num2 == num3 && num2 != num1) {
                    result = numbers + "Отличное число: " + num1 + " (позиция 1)";
                } else {
                    result = numbers + "Нет двух равных чисел. Должно быть два равных и одно отличное.";
                }

                resultLabel.setText(result);
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: Введите корректные целые числа");
            }
        });

        HBox navBox = createNavigationButtons();
        HBox row1 = new HBox(10, new Label("Число 1:"), num1Field);
        row1.setAlignment(Pos.CENTER);
        HBox row2 = new HBox(10, new Label("Число 2:"), num2Field);
        row2.setAlignment(Pos.CENTER);
        HBox row3 = new HBox(10, new Label("Число 3:"), num3Field);
        row3.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, titleLabel, row1, row2, row3, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 500);
    }

    private Scene createScene4() {
        Label titleLabel = new Label("Задание 4: Вычисление сложной функции");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");

        TextField aField = new TextField();
        aField.setPromptText("Положительное целое");
        TextField bField = new TextField();
        bField.setPromptText("Положительное целое");
        TextField cField = new TextField();
        cField.setPromptText("Положительное целое");

        Button calcButton = new Button("Вычислить функцию");
        TextArea resultArea = new TextArea();
        resultArea.setEditable(false);
        resultArea.setPrefHeight(180);
        resultArea.setPrefWidth(400);
        resultArea.setWrapText(true);

        calcButton.setOnAction(event -> {
            try {
                int a = Integer.parseInt(aField.getText());
                int b = Integer.parseInt(bField.getText());
                int c = Integer.parseInt(cField.getText());

                if (a <= 0 || b <= 0 || c <= 0) {
                    resultArea.setText("Ошибка: Все числа должны быть положительными");
                    return;
                }

                if (c == 0) {
                    resultArea.setText("Ошибка: Число c не может быть нулем (деление на ноль)");
                    return;
                }

                double M = (a + Math.pow(b, 2)) / (double) c;
                int k = (int) (M % 3);

                double y = 0;
                String formula = "";

                switch (k) {
                    case 0:
                        y = Math.log(a / (double) b);
                        formula = "y = ln(a/b)";
                        break;
                    case 1:
                        y = Math.exp(M + c);
                        formula = "y = e^(M + c)";
                        break;
                    case 2:
                        y = Math.sqrt(Math.abs(Math.pow(a + b, 2) + c));
                        formula = "y = sqrt(|(a + b)² + c|)";
                        break;
                }

                String result = String.format("Исходные данные:\n" +
                                "a = %d, b = %d, c = %d\n\n" +
                                "Вычисление M:\n" +
                                "M = (a + b²) / c = (%d + %d²) / %d = %.3f\n\n" +
                                "Нахождение остатка k:\n" +
                                "k = M %% 3 = %.3f %% 3 = %d\n\n" +
                                "Вычисление функции:\n" +
                                "Формула: %s\n" +
                                "Результат: y = %.5f",
                        a, b, c, a, b, c, M, M, k, formula, y);

                resultArea.setText(result);
            } catch (NumberFormatException ex) {
                resultArea.setText("Ошибка: Введите корректные целые числа");
            } catch (ArithmeticException ex) {
                resultArea.setText("Ошибка при вычислениях: " + ex.getMessage());
            }
        });

        HBox navBox = createNavigationButtons();
        HBox row1 = new HBox(10, new Label("Число a:"), aField);
        row1.setAlignment(Pos.CENTER);
        HBox row2 = new HBox(10, new Label("Число b:"), bField);
        row2.setAlignment(Pos.CENTER);
        HBox row3 = new HBox(10, new Label("Число c:"), cField);
        row3.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, titleLabel, row1, row2, row3, calcButton, resultArea, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 550, 600);
    }

    private Scene createScene5() {
        Label titleLabel = new Label("Задание 5: Положение точки относительно квадрата");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");

        TextField xField = new TextField();
        xField.setPromptText("Координата X");
        TextField yField = new TextField();
        yField.setPromptText("Координата Y");

        Button calcButton = new Button("Проверить положение точки");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size:14px;");

        Label areaDesc = new Label("Область: квадрат со стороной 80 в центре координат\n" +
                "Границы: x = ±40, y = ±40\n" +
                "Заштрихованная область: ВНЕ квадрата\n" +
                "Незаштрихованная область: ВНУТРИ квадрата");
        areaDesc.setStyle("-fx-font-size:12px;-fx-text-fill:#555;");

        calcButton.setOnAction(event -> {
            try {
                double x = Double.parseDouble(xField.getText());
                double y = Double.parseDouble(yField.getText());

                String result = String.format("Точка: (%.2f, %.2f)\n", x, y);
                result += String.format("Границы квадрата: x = [-40, 40], y = [-40, 40]\n\n");

                double halfSide = 40.0;
                double tolerance = 0.001;

                boolean onBorderX = Math.abs(Math.abs(x) - halfSide) < tolerance;
                boolean onBorderY = Math.abs(Math.abs(y) - halfSide) < tolerance;

                if (onBorderX && Math.abs(y) <= halfSide + tolerance) {
                    result += "Точка находится на вертикальной границе квадрата\n";
                    result += "Результат: \"На границе\"";
                } else if (onBorderY && Math.abs(x) <= halfSide + tolerance) {
                    result += "Точка находится на горизонтальной границе квадрата\n";
                    result += "Результат: \"На границе\"";
                } else if (Math.abs(x) < halfSide - tolerance && Math.abs(y) < halfSide - tolerance) {
                    result += "Точка находится ВНУТРИ квадрата\n";
                    result += "Результат: \"Нет\" (точка в незаштрихованной области)";
                } else {
                    result += "Точка находится ВНЕ квадрата\n";
                    result += "Результат: \"Да\" (точка в заштрихованной области)";
                }

                resultLabel.setText(result);
            } catch (NumberFormatException ex) {
                resultLabel.setText("Ошибка: Введите корректные координаты");
            }
        });

        HBox navBox = createNavigationButtons();
        HBox inputBox1 = new HBox(10, new Label("Координата X:"), xField);
        inputBox1.setAlignment(Pos.CENTER);
        HBox inputBox2 = new HBox(10, new Label("Координата Y:"), yField);
        inputBox2.setAlignment(Pos.CENTER);

        VBox root = new VBox(15, titleLabel, areaDesc, inputBox1, inputBox2, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 550, 550);
    }

    private Scene createScene6() {
        Label titleLabel = new Label("Задание 6: Описание целого числа");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");

        TextField numberField = new TextField();
        numberField.setPromptText("Любое целое число");

        Button calcButton = new Button("Описать число");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size:14px;");

        calcButton.setOnAction(event -> {
            try {
                int number = Integer.parseInt(numberField.getText());

                String description;

                if (number == 0) {
                    description = "нулевое число";
                } else {
                    String sign = (number > 0) ? "положительное" : "отрицательное";

                    String parity = (number % 2 == 0) ? "четное" : "нечетное";

                    description = sign + " " + parity + " число";
                }

                resultLabel.setText("Число: " + number + "\n" +
                        "Описание: \"" + description + "\"");
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: Введите корректное целое число");
            }
        });

        HBox navBox = createNavigationButtons();
        HBox inputBox = new HBox(10, new Label("Целое число:"), numberField);
        inputBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, titleLabel, inputBox, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 400);
    }

    private Scene createScene7() {
        Label titleLabel = new Label("Задание 7: Описание числа (1-999)");
        titleLabel.setStyle("-fx-font-size:20px;-fx-font-weight:bold;");

        TextField numberField = new TextField();
        numberField.setPromptText("Число от 1 до 999");

        Button calcButton = new Button("Описать число");
        Label resultLabel = new Label();
        resultLabel.setStyle("-fx-font-size:14px;");

        calcButton.setOnAction(event -> {
            try {
                int number = Integer.parseInt(numberField.getText());

                if (number < 1 || number > 999) {
                    resultLabel.setText("Ошибка: Число должно быть в диапазоне 1-999");
                    return;
                }

                String parity = (number % 2 == 0) ? "четное" : "нечетное";

                String digits;
                if (number < 10) {
                    digits = "однозначное";
                } else if (number < 100) {
                    digits = "двузначное";
                } else {
                    digits = "трехзначное";
                }

                String description = parity + " " + digits + " число";

                resultLabel.setText("Число: " + number + "\n" +
                        "Описание: \"" + description + "\"");
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: Введите корректное целое число");
            }
        });

        HBox navBox = createNavigationButtons();
        HBox inputBox = new HBox(10, new Label("Число (1-999):"), numberField);
        inputBox.setAlignment(Pos.CENTER);

        VBox root = new VBox(20, titleLabel, inputBox, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 400);
    }

    public static void main(String[] args) {
        launch();
    }
}