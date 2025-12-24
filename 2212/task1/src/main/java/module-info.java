module com.zelmex.task1 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.task1 to javafx.fxml;
    exports com.zelmex.task1;
}