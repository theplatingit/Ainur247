module com.zelmex.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.demo to javafx.fxml;
    exports com.zelmex.demo;
    exports com.zelmex.demo.controller;
    opens com.zelmex.demo.controller to javafx.fxml;
}