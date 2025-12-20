module com.zelmex.demo1 {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.zelmex.demo1 to javafx.fxml;
    opens com.zelmex.demo1.controller to javafx.fxml;
    opens com.zelmex.demo1.util to javafx.fxml;

    exports com.zelmex.demo1;
    exports com.zelmex.demo1.controller;
    exports com.zelmex.demo1.util;
}