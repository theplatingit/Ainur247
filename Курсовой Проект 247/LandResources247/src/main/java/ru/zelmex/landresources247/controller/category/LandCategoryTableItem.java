package ru.zelmex.landresources247.controller.category;

import javafx.beans.property.SimpleStringProperty;
import ru.zelmex.landresources247.model.LandCategory;

public class LandCategoryTableItem {

    private SimpleStringProperty name;
    private SimpleStringProperty restrictions;
    private SimpleStringProperty permittedUse;
    private LandCategory landCategory;

    public LandCategoryTableItem(LandCategory landCategory) {
        this.name = new SimpleStringProperty(landCategory.getName());
        this.restrictions = new SimpleStringProperty(
                landCategory.getRestrictions() != null ? landCategory.getRestrictions() : ""
        );
        this.permittedUse = new SimpleStringProperty(landCategory.getPermittedUse());
        this.landCategory = landCategory;
    }

    public String getName() {
        return name.get();
    }

    public SimpleStringProperty nameProperty() {
        return name;
    }

    public void setName(String name) {
        this.name.set(name);
    }

    public String getRestrictions() {
        return restrictions.get();
    }

    public SimpleStringProperty restrictionsProperty() {
        return restrictions;
    }

    public void setRestrictions(String restrictions) {
        this.restrictions.set(restrictions);
    }

    public String getPermittedUse() {
        return permittedUse.get();
    }

    public SimpleStringProperty permittedUseProperty() {
        return permittedUse;
    }

    public void setPermittedUse(String permittedUse) {
        this.permittedUse.set(permittedUse);
    }

    public LandCategory getLandCategory() {
        return landCategory;
    }

    public void setLandCategory(LandCategory landCategory) {
        this.landCategory = landCategory;
    }
}