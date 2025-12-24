module com.zelmex.task4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.task4 to javafx.fxml;
    exports com.zelmex.task4;
}