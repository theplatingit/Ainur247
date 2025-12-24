module com.zelmex.task5 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.task5 to javafx.fxml;
    exports com.zelmex.task5;
}