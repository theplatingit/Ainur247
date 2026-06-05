module ru.zelmex.landresources247 {
    requires javafx.controls;
    requires javafx.fxml;
    requires org.hibernate.orm.core;
    requires jakarta.persistence;
    requires java.naming;

    opens ru.zelmex.landresources247 to javafx.fxml;
    exports ru.zelmex.landresources247;

    opens ru.zelmex.landresources247.controller.category to javafx.fxml;
    exports ru.zelmex.landresources247.controller.category;

    opens ru.zelmex.landresources247.controller.owner to javafx.fxml;
    exports ru.zelmex.landresources247.controller.owner;

    opens ru.zelmex.landresources247.controller.plot to javafx.fxml;
    exports ru.zelmex.landresources247.controller.plot;

    opens ru.zelmex.landresources247.model to org.hibernate.orm.core, javafx.base;
    exports ru.zelmex.landresources247.model;

    opens ru.zelmex.landresources247.repository to org.hibernate.orm.core;
    exports ru.zelmex.landresources247.repository;

    opens ru.zelmex.landresources247.service to javafx.base;
    exports ru.zelmex.landresources247.service;

    opens ru.zelmex.landresources247.util to org.hibernate.orm.core;
}