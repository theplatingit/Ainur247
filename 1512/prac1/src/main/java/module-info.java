module com.zelmex.prac1 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.zelmex.prac1 to javafx.fxml;
    exports com.zelmex.prac1;
}