module com.zelmex.task2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.task2 to javafx.fxml;
    exports com.zelmex.task2;
}