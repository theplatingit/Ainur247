module com.zelmex.prac3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.zelmex.prac3 to javafx.fxml;
    exports com.zelmex.prac3;
}