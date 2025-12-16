module com.zelmex.prac2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.prac2 to javafx.fxml;
    exports com.zelmex.prac2;
}