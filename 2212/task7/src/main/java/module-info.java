module com.zelmex.task7 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.task7 to javafx.fxml;
    exports com.zelmex.task7;
}