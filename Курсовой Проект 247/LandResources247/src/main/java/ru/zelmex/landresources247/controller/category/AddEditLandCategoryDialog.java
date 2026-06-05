package ru.zelmex.landresources247.controller.category;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.zelmex.landresources247.model.LandCategory;
import ru.zelmex.landresources247.service.LandCategoryService;

public class AddEditLandCategoryDialog {

    @FXML
    private TextField nameField;

    @FXML
    private TextField restrictionsField;

    @FXML
    private TextField permittedUseField;

    @FXML
    private Button okButton;

    @FXML
    private Label errorLabel;

    private Stage dialogStage;
    private LandCategory landCategory;

    void add() {
        try {
            LandCategory category = new LandCategory();
            category.setName(nameField.getText());
            category.setRestrictions(restrictionsField.getText());
            category.setPermittedUse(permittedUseField.getText());

            new LandCategoryService().save(category);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    void edit() {
        try {
            landCategory.setName(nameField.getText());
            landCategory.setRestrictions(restrictionsField.getText());
            landCategory.setPermittedUse(permittedUseField.getText());

            new LandCategoryService().update(landCategory);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
        okButton.setOnAction(e -> add());
    }

    public void setEditDialogStage(Stage dialogStage, LandCategory landCategory) {
        this.landCategory = landCategory;
        this.dialogStage = dialogStage;

        nameField.setText(landCategory.getName());
        restrictionsField.setText(landCategory.getRestrictions());
        permittedUseField.setText(landCategory.getPermittedUse());

        okButton.setOnAction(e -> edit());
    }
}