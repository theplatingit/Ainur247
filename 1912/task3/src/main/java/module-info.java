module com.zelmex.task3 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.task3 to javafx.fxml;
    exports com.zelmex.task3;
    exports com.zelmex.task3.controller;
    opens com.zelmex.task3.controller to javafx.fxml;
}