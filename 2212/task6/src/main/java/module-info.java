module com.zelmex.task6 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.task6 to javafx.fxml;
    exports com.zelmex.task6;
}