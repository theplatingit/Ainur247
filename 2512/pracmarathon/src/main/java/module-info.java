module com.zelmex.pracmarathon {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.zelmex.pracmarathon to javafx.fxml;
    exports com.zelmex.pracmarathon;
    exports com.zelmex.pracmarathon.controller;
    opens com.zelmex.pracmarathon.controller to javafx.fxml;
}