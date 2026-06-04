package ru.zelmex.landresources247.controller.plot;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.zelmex.landresources247.model.LandCategory;
import ru.zelmex.landresources247.model.LandOwner;
import ru.zelmex.landresources247.model.LandPlot;
import ru.zelmex.landresources247.service.LandCategoryService;
import ru.zelmex.landresources247.service.LandOwnerService;
import ru.zelmex.landresources247.service.LandPlotService;

import java.util.List;

public class AddEditLandPlotDialog {

    @FXML
    private ComboBox<LandCategory> categoryField;

    @FXML
    private ComboBox<LandOwner> ownerField;

    @FXML
    private TextField areaField;

    @FXML
    private TextField cadastralNumberField;

    @FXML
    private Button okButton;

    @FXML
    private Label errorLabel;

    private Stage dialogStage;
    private LandPlot landPlot;

    void add() {
        try {
            if (categoryField.getSelectionModel().getSelectedIndex() == -1) {
                throw new IllegalArgumentException("Нужно заполнить поле \"Категория земли\"");
            }
            if (ownerField.getSelectionModel().getSelectedIndex() == -1) {
                throw new IllegalArgumentException("Нужно заполнить поле \"Правообладатель\"");
            }

            LandPlot plot = new LandPlot();
            plot.setCategory(categoryField.getSelectionModel().getSelectedItem());
            plot.setOwner(ownerField.getSelectionModel().getSelectedItem());
            plot.setArea(areaField.getText());
            plot.setCadastralNumber(cadastralNumberField.getText());

            new LandPlotService().save(plot);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setAddDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;

        List<LandCategory> categories = new LandCategoryService().findAll();
        categoryField.getItems().addAll(FXCollections.observableList(categories));
        if (!categoryField.getItems().isEmpty()) {
            categoryField.setValue(categories.get(0));
        }

        List<LandOwner> owners = new LandOwnerService().findAll();
        ownerField.getItems().addAll(FXCollections.observableList(owners));
        if (!ownerField.getItems().isEmpty()) {
            ownerField.setValue(owners.get(0));
        }

        okButton.setOnAction(e -> add());
    }

    void edit() {
        try {
            landPlot.setCategory(categoryField.getSelectionModel().getSelectedItem());
            landPlot.setOwner(ownerField.getSelectionModel().getSelectedItem());
            landPlot.setArea(areaField.getText());
            landPlot.setCadastralNumber(cadastralNumberField.getText());

            new LandPlotService().update(landPlot);
            dialogStage.close();
        } catch (IllegalArgumentException e) {
            errorLabel.setText(e.getMessage());
        }
    }

    public void setEditDialogStage(Stage dialogStage, LandPlot landPlot) {
        this.dialogStage = dialogStage;
        this.landPlot = landPlot;

        List<LandCategory> categories = new LandCategoryService().findAll();
        categoryField.getItems().addAll(FXCollections.observableList(categories));

        List<LandOwner> owners = new LandOwnerService().findAll();
        ownerField.getItems().addAll(FXCollections.observableList(owners));

        categoryField.setValue(landPlot.getCategory());
        ownerField.setValue(landPlot.getOwner());
        areaField.setText(landPlot.getArea().toString());
        cadastralNumberField.setText(landPlot.getCadastralNumber());

        okButton.setOnAction(e -> edit());
    }
}