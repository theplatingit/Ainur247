package ru.zelmex.landresources247.controller.plot;

import javafx.beans.property.SimpleStringProperty;
import ru.zelmex.landresources247.model.LandPlot;

public class LandPlotTableItem {

    private SimpleStringProperty categoryName;
    private SimpleStringProperty ownerName;
    private SimpleStringProperty area;
    private SimpleStringProperty cadastralNumber;
    private SimpleStringProperty ownerTaxId;
    private SimpleStringProperty ownerPhone;
    private SimpleStringProperty ownerAddress;
    private LandPlot landPlot;

    public LandPlotTableItem(LandPlot landPlot) {
        this.categoryName = new SimpleStringProperty(landPlot.getCategory().getName());
        this.ownerName = new SimpleStringProperty(landPlot.getOwner().getFullName());
        this.area = new SimpleStringProperty(landPlot.getArea().toString());
        this.cadastralNumber = new SimpleStringProperty(landPlot.getCadastralNumber());
        this.ownerTaxId = new SimpleStringProperty(landPlot.getOwner().getTaxId());
        this.ownerPhone = new SimpleStringProperty(landPlot.getOwner().getPhone());
        this.ownerAddress = new SimpleStringProperty(landPlot.getOwner().getAddress());
        this.landPlot = landPlot;
    }

    public String getCategoryName() {
        return categoryName.get();
    }

    public SimpleStringProperty categoryNameProperty() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName.set(categoryName);
    }

    public String getOwnerName() {
        return ownerName.get();
    }

    public SimpleStringProperty ownerNameProperty() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName.set(ownerName);
    }

    public String getArea() {
        return area.get();
    }

    public SimpleStringProperty areaProperty() {
        return area;
    }

    public void setArea(String area) {
        this.area.set(area);
    }

    public String getCadastralNumber() {
        return cadastralNumber.get();
    }

    public SimpleStringProperty cadastralNumberProperty() {
        return cadastralNumber;
    }

    public void setCadastralNumber(String cadastralNumber) {
        this.cadastralNumber.set(cadastralNumber);
    }

    public String getOwnerTaxId() {
        return ownerTaxId.get();
    }

    public SimpleStringProperty ownerTaxIdProperty() {
        return ownerTaxId;
    }

    public void setOwnerTaxId(String ownerTaxId) {
        this.ownerTaxId.set(ownerTaxId);
    }

    public String getOwnerPhone() {
        return ownerPhone.get();
    }

    public SimpleStringProperty ownerPhoneProperty() {
        return ownerPhone;
    }

    public void setOwnerPhone(String ownerPhone) {
        this.ownerPhone.set(ownerPhone);
    }

    public String getOwnerAddress() {
        return ownerAddress.get();
    }

    public SimpleStringProperty ownerAddressProperty() {
        return ownerAddress;
    }

    public void setOwnerAddress(String ownerAddress) {
        this.ownerAddress.set(ownerAddress);
    }

    public LandPlot getLandPlot() {
        return landPlot;
    }

    public void setLandPlot(LandPlot landPlot) {
        this.landPlot = landPlot;
    }
}