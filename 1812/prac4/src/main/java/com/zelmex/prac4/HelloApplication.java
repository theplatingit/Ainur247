package com.zelmex.prac4;

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

public class HelloApplication extends Application {
    private Stage primaryStage;
    private Scene scene1, scene2, scene3, scene4, scene5, scene6;
    private Scene scene7, scene8;

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        scene1 = createScene1();
        scene2 = createScene2();
        scene3 = createScene3();
        scene4 = createScene4();
        scene5 = createScene5();
        scene6 = createScene6();
        scene7 = createScene7();
        scene8 = createScene8();

        primaryStage.setTitle("Практическая работа 4");
        primaryStage.setScene(scene1);
        primaryStage.show();
    }

    private Scene createScene1() {
        Label titleLabel = new Label("Задание 1: Следующая дата");
        titleLabel.setStyle("-fx-font-size:16px;-fx-font-weight:bold;");
        TextField dayField = new TextField();
        dayField.setPromptText("День");
        TextField monthField = new TextField();
        monthField.setPromptText("Месяц (1-12)");
        Button calcButton = new Button("Следующая дата");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int day = Integer.parseInt(dayField.getText());
                int month = Integer.parseInt(monthField.getText());

                int maxDays;
                switch (month) {
                    case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                        maxDays = 31;
                        break;
                    case 4: case 6: case 9: case 11:
                        maxDays = 30;
                        break;
                    case 2:
                        maxDays = 28;
                        break;
                    default:
                        resultLabel.setText("Неверный месяц (1-12)");
                        return;
                }

                if (day < 1 || day > maxDays) {
                    resultLabel.setText("Неверный день");
                    return;
                }

                day++;
                if (day > maxDays) {
                    day = 1;
                    month++;
                    if (month > 12) {
                        month = 1;
                    }
                }

                resultLabel.setText(String.format("Следующая дата: %02d.%02d", day, month));
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка ввода");
            }
        });

        HBox navBox = createNavigation();
        HBox inputBox = new HBox(10, new Label("День:"), dayField, new Label("Месяц:"), monthField);
        inputBox.setAlignment(Pos.CENTER);
        VBox root = new VBox(20, titleLabel, inputBox, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 400);
    }

    private Scene createScene2() {
        Label titleLabel = new Label("Задание 2: Название карты");
        titleLabel.setStyle("-fx-font-size:16px;-fx-font-weight:bold;");
        TextField valField = new TextField();
        valField.setPromptText("Достоинство (6-14)");
        TextField suitField = new TextField();
        suitField.setPromptText("Масть (1-4)");
        Button calcButton = new Button("Назвать карту");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int value = Integer.parseInt(valField.getText());
                int suit = Integer.parseInt(suitField.getText());

                if (value < 6 || value > 14 || suit < 1 || suit > 4) {
                    resultLabel.setText("Ошибка: достоинство 6-14, масть 1-4");
                    return;
                }

                String cardValue;
                switch (value) {
                    case 6: cardValue = "шестерка"; break;
                    case 7: cardValue = "семерка"; break;
                    case 8: cardValue = "восьмерка"; break;
                    case 9: cardValue = "девятка"; break;
                    case 10: cardValue = "десятка"; break;
                    case 11: cardValue = "валет"; break;
                    case 12: cardValue = "дама"; break;
                    case 13: cardValue = "король"; break;
                    case 14: cardValue = "туз"; break;
                    default: cardValue = "неизвестно"; break;
                }

                String cardSuit;
                switch (suit) {
                    case 1: cardSuit = "пик"; break;
                    case 2: cardSuit = "треф"; break;
                    case 3: cardSuit = "бубен"; break;
                    case 4: cardSuit = "червей"; break;
                    default: cardSuit = "неизвестно"; break;
                }

                resultLabel.setText(cardValue + " " + cardSuit);
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка ввода");
            }
        });

        HBox navBox = createNavigation();
        HBox inputBox = new HBox(10, new Label("Достоинство:"), valField, new Label("Масть:"), suitField);
        inputBox.setAlignment(Pos.CENTER);
        VBox root = new VBox(20, titleLabel, inputBox, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 600, 400);
    }

    private Scene createScene3() {
        Label titleLabel = new Label("Задание 3: Равносторонний треугольник");
        titleLabel.setStyle("-fx-font-size:16px;-fx-font-weight:bold;");
        Label infoLabel = new Label("1 — сторона a, 2 — радиус вписанной R1, 3 — радиус описанной R2, 4 — площадь S");
        TextField typeField = new TextField();
        typeField.setPromptText("Тип (1-4)");
        TextField valField = new TextField();
        valField.setPromptText("Значение");
        Button calcButton = new Button("Вычислить остальные");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int type = Integer.parseInt(typeField.getText());
                double val = Double.parseDouble(valField.getText());
                double a = 0, R1, R2, S;
                final double SQRT3 = Math.sqrt(3);

                switch (type) {
                    case 1:
                        a = val;
                        break;
                    case 2:
                        a = val * 4 / SQRT3;
                        break;
                    case 3:
                        a = val * 2 / SQRT3;
                        break;
                    case 4:
                        a = Math.sqrt(val * 4 / SQRT3);
                        break;
                    default:
                        resultLabel.setText("Тип должен быть 1-4");
                        return;
                }

                R1 = a * SQRT3 / 4;
                R2 = 2 * R1;
                S = a * a * SQRT3 / 4;

                resultLabel.setText(String.format(
                        "Сторона a = %.4f\nРадиус вписанной R1 = %.4f\nРадиус описанной R2 = %.4f\nПлощадь S = %.4f",
                        a, R1, R2, S
                ));
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка ввода чисел");
            }
        });

        HBox navBox = createNavigation();
        HBox inputBox = new HBox(10, new Label("Тип:"), typeField, new Label("Значение:"), valField);
        inputBox.setAlignment(Pos.CENTER);
        VBox root = new VBox(15, titleLabel, infoLabel, inputBox, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 550, 500);
    }

    private Scene createScene4() {
        Label titleLabel = new Label("Задание 4: Наименьшее K, где 3K > N");
        titleLabel.setStyle("-fx-font-size:16px;-fx-font-weight:bold;");
        TextField nField = new TextField();
        nField.setPromptText("N (> 1)");
        Button calcButton = new Button("Найти K");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int N = Integer.parseInt(nField.getText());
                if (N <= 1) {
                    resultLabel.setText("N должно быть > 1");
                    return;
                }

                int K = 0;
                int power = 1;

                while (power <= N) {
                    K++;
                    power *= 3;
                }

                resultLabel.setText(String.format("K = %d (3^%d = %d > %d)", K, K, power, N));
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целое число");
            }
        });

        HBox navBox = createNavigation();
        VBox root = new VBox(20, titleLabel, nField, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 400);
    }

    private Scene createScene5() {
        Label titleLabel = new Label("Задание 5: Наибольшее K, где сумма ≤ N");
        titleLabel.setStyle("-fx-font-size:16px;-fx-font-weight:bold;");
        TextField nField = new TextField();
        nField.setPromptText("N (> 1)");
        Button calcButton = new Button("Найти K и сумму");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int N = Integer.parseInt(nField.getText());
                if (N <= 1) {
                    resultLabel.setText("N должно быть > 1");
                    return;
                }

                int K = 0;
                int sum = 0;

                while (sum + (K + 1) <= N) {
                    K++;
                    sum += K;
                }

                resultLabel.setText(String.format("K = %d\nСумма 1+2+...+%d = %d", K, K, sum));
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целое число");
            }
        });

        HBox navBox = createNavigation();
        VBox root = new VBox(20, titleLabel, nField, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 400);
    }

    private Scene createScene6() {
        Label titleLabel = new Label("Задание 6: Проверка на цифру '1'");
        titleLabel.setStyle("-fx-font-size:16px;-fx-font-weight:bold;");
        TextField numField = new TextField();
        numField.setPromptText("N (> 0)");
        Button calcButton = new Button("Проверить");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int N = Integer.parseInt(numField.getText());
                if (N <= 0) {
                    resultLabel.setText("Число должно быть > 0");
                    return;
                }

                int temp = N;
                boolean hasOne = false;

                while (temp > 0 && !hasOne) {
                    if (temp % 10 == 1) {
                        hasOne = true;
                    }
                    temp /= 10;
                }

                resultLabel.setText(String.valueOf(hasOne));
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целое число");
            }
        });

        HBox navBox = createNavigation();
        VBox root = new VBox(20, titleLabel, numField, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 500, 400);
    }

    private Scene createScene7() {
        Label titleLabel = new Label("Задание 7: Описание учебных заданий");
        titleLabel.setStyle("-fx-font-size:16px;-fx-font-weight:bold;");
        TextField numField = new TextField();
        numField.setPromptText("Количество (10-40)");
        Button calcButton = new Button("Описать");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int num = Integer.parseInt(numField.getText());
                if (num < 10 || num > 40) {
                    resultLabel.setText("Число должно быть от 10 до 40");
                    return;
                }

                String tensStr, unitsStr;
                int tens = num / 10;
                int units = num % 10;

                switch (tens) {
                    case 1: tensStr = "десять"; break;
                    case 2: tensStr = "двадцать"; break;
                    case 3: tensStr = "тридцать"; break;
                    case 4: tensStr = "сорок"; break;
                    default: tensStr = ""; break;
                }

                switch (units) {
                    case 1: unitsStr = "одно"; break;
                    case 2: unitsStr = "два"; break;
                    case 3: unitsStr = "три"; break;
                    case 4: unitsStr = "четыре"; break;
                    case 5: unitsStr = "пять"; break;
                    case 6: unitsStr = "шесть"; break;
                    case 7: unitsStr = "семь"; break;
                    case 8: unitsStr = "восемь"; break;
                    case 9: unitsStr = "девять"; break;
                    default: unitsStr = ""; break;
                }

                String special = "";
                if (num >= 11 && num <= 19) {
                    switch (num) {
                        case 11: special = "одиннадцать"; break;
                        case 12: special = "двенадцать"; break;
                        case 13: special = "тринадцать"; break;
                        case 14: special = "четырнадцать"; break;
                        case 15: special = "пятнадцать"; break;
                        case 16: special = "шестнадцать"; break;
                        case 17: special = "семнадцать"; break;
                        case 18: special = "восемнадцать"; break;
                        case 19: special = "девятнадцать"; break;
                    }
                }

                String description;
                if (!special.isEmpty()) {
                    description = special + " учебных заданий";
                } else if (units == 0) {
                    description = tensStr + " учебных заданий";
                } else if (units == 1) {
                    description = tensStr + " " + unitsStr + " учебное задание";
                } else if (units >= 2 && units <= 4) {
                    description = tensStr + " " + unitsStr + " учебных задания";
                } else {
                    description = tensStr + " " + unitsStr + " учебных заданий";
                }

                resultLabel.setText(description);
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целое число");
            }
        });

        HBox navBox = createNavigation();
        VBox root = new VBox(20, titleLabel, numField, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 550, 400);
    }

    private Scene createScene8() {
        Label titleLabel = new Label("Задание 8: Число прописью (100-999)");
        titleLabel.setStyle("-fx-font-size:16px;-fx-font-weight:bold;");
        TextField numField = new TextField();
        numField.setPromptText("Число (100-999)");
        Button calcButton = new Button("Преобразовать");
        Label resultLabel = new Label();

        calcButton.setOnAction(event -> {
            try {
                int num = Integer.parseInt(numField.getText());
                if (num < 100 || num > 999) {
                    resultLabel.setText("Число должно быть от 100 до 999");
                    return;
                }

                String[] hundreds = {"", "сто", "двести", "триста", "четыреста", "пятьсот",
                        "шестьсот", "семьсот", "восемьсот", "девятьсот"};
                String[] tens = {"", "", "двадцать", "тридцать", "сорок", "пятьдесят",
                        "шестьдесят", "семьдесят", "восемьдесят", "девяносто"};
                String[] units = {"", "один", "два", "три", "четыре", "пять",
                        "шесть", "семь", "восемь", "девять"};
                String[] teens = {"десять", "одиннадцать", "двенадцать", "тринадцать",
                        "четырнадцать", "пятнадцать", "шестнадцать",
                        "семнадцать", "восемнадцать", "девятнадцать"};

                int h = num / 100;
                int t = (num / 10) % 10;
                int u = num % 10;

                StringBuilder sb = new StringBuilder();
                sb.append(hundreds[h]);

                if (t == 1) {
                    if (sb.length() > 0) sb.append(" ");
                    sb.append(teens[u]);
                } else {
                    if (t > 0) {
                        if (sb.length() > 0) sb.append(" ");
                        sb.append(tens[t]);
                    }
                    if (u > 0) {
                        if (sb.length() > 0) sb.append(" ");
                        sb.append(units[u]);
                    }
                }

                resultLabel.setText(sb.toString());
            } catch (NumberFormatException e) {
                resultLabel.setText("Ошибка: введите целое число");
            }
        });

        HBox navBox = createNavigation();
        VBox root = new VBox(20, titleLabel, numField, calcButton, resultLabel, navBox);
        root.setAlignment(Pos.CENTER);
        root.setPadding(new Insets(20));
        return new Scene(root, 550, 400);
    }




    private HBox createNavigation() {
        Button btn1 = new Button("1");
        Button btn2 = new Button("2");
        Button btn3 = new Button("3");
        Button btn4 = new Button("4");
        Button btn5 = new Button("5");
        Button btn6 = new Button("6");
        Button btn7 = new Button("7");
        Button btn8 = new Button("8");

        btn1.setOnAction(e -> primaryStage.setScene(scene1));
        btn2.setOnAction(e -> primaryStage.setScene(scene2));
        btn3.setOnAction(e -> primaryStage.setScene(scene3));
        btn4.setOnAction(e -> primaryStage.setScene(scene4));
        btn5.setOnAction(e -> primaryStage.setScene(scene5));
        btn6.setOnAction(e -> primaryStage.setScene(scene6));
        btn7.setOnAction(e -> primaryStage.setScene(scene7));
        btn8.setOnAction(e -> primaryStage.setScene(scene8));

        HBox navBox = new HBox(5, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8);
        navBox.setAlignment(Pos.CENTER);
        return navBox;
    }

    public static void main(String[] args) {
        launch(args);
    }
}