package ru.zelmex.landresources247.controller.owner;

import javafx.beans.property.SimpleStringProperty;
import ru.zelmex.landresources247.model.LandOwner;

public class LandOwnerTableItem {

    private SimpleStringProperty fullName;
    private SimpleStringProperty taxId;
    private SimpleStringProperty phone;
    private SimpleStringProperty address;
    private LandOwner landOwner;

    public LandOwnerTableItem(LandOwner landOwner) {
        this.fullName = new SimpleStringProperty(landOwner.getFullName());
        this.taxId = new SimpleStringProperty(landOwner.getTaxId());
        this.phone = new SimpleStringProperty(landOwner.getPhone());
        this.address = new SimpleStringProperty(landOwner.getAddress());
        this.landOwner = landOwner;
    }

    public String getFullName() {
        return fullName.get();
    }

    public SimpleStringProperty fullNameProperty() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName.set(fullName);
    }

    public String getTaxId() {
        return taxId.get();
    }

    public SimpleStringProperty taxIdProperty() {
        return taxId;
    }

    public void setTaxId(String taxId) {
        this.taxId.set(taxId);
    }

    public String getPhone() {
        return phone.get();
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public String getAddress() {
        return address.get();
    }

    public SimpleStringProperty addressProperty() {
        return address;
    }

    public void setAddress(String address) {
        this.address.set(address);
    }

    public LandOwner getLandOwner() {
        return landOwner;
    }

    public void setLandOwner(LandOwner landOwner) {
        this.landOwner = landOwner;
    }
}