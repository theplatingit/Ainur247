module com.zelmex.prac4 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.prac4 to javafx.fxml;
    exports com.zelmex.prac4;
}