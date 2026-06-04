package ru.zelmex.landresources247.controller.owner;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.zelmex.landresources247.model.LandOwner;
import ru.zelmex.landresources247.service.LandOwnerService;

public class AddEditLandOwnerDialog {

    @FXML
    private TextField fullNameField;

    @FXML
    private TextField taxIdField;

    @FXML
    private TextField phoneField;

    @FXML
    private TextField addressField;

    @FXML
    private Button okButton;

    @FXML
    private Label errorLabel;

    private Stage dialogStage;
    private LandOwner landOwner;

    void add() {
        try {
            LandOwner owner = new LandOwner();
            owner.setFullName(fullNameField.getText());
            owner.setTaxId(taxIdField.getText());
            owner.setPhone(phoneField.getText());
            owner.setAddress(addressField.getText());

            new LandOwnerService().save(owner);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    void edit() {
        try {
            landOwner.setFullName(fullNameField.getText());
            landOwner.setTaxId(taxIdField.getText());
            landOwner.setPhone(phoneField.getText());
            landOwner.setAddress(addressField.getText());

            new LandOwnerService().update(landOwner);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction(e -> add());
    }

    public void setEditDialogStage(Stage dialogStage, LandOwner landOwner) {
        this.landOwner = landOwner;
        this.dialogStage = dialogStage;

        fullNameField.setText(landOwner.getFullName());
        taxIdField.setText(landOwner.getTaxId());
        phoneField.setText(landOwner.getPhone());
        addressField.setText(landOwner.getAddress());

        okButton.setOnAction(e -> edit());
    }
}