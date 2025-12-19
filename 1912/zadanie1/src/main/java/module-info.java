module com.zelmex.zadanie1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.zadanie1 to javafx.fxml;
    exports com.zelmex.zadanie1;
    exports com.zelmex.zadanie1.controller;
    opens com.zelmex.zadanie1.controller to javafx.fxml;
}