package ru.zelmex.landresources247.controller.owner;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.zelmex.landresources247.LandResourcesApp;
import ru.zelmex.landresources247.model.LandOwner;
import ru.zelmex.landresources247.service.LandOwnerService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class LandOwnerController {

    private List<LandOwner> owners;
    private ObservableList<LandOwnerTableItem> ownersObservable;

    @FXML
    private TableView<LandOwnerTableItem> ownersTable;

    @FXML
    private TableColumn<LandOwner, String> fullNameColumn;

    @FXML
    private TableColumn<LandOwner, String> taxIdColumn;

    @FXML
    private TableColumn<LandOwner, String> phoneColumn;

    @FXML
    private TableColumn<LandOwner, String> addressColumn;

    @FXML
    void btnCategoriesOnAction(ActionEvent event) {
        LandResourcesApp.primaryStage.setScene(LandResourcesApp.landCategories);
    }

    @FXML
    void btnPlotsOnAction(ActionEvent event) {
        LandResourcesApp.primaryStage.setScene(LandResourcesApp.landPlots);
    }

    @FXML
    void btnAddOwner(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(LandResourcesApp.class.getResource("add-edit-land-owner-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(LandResourcesApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("Добавить правообладателя");

            AddEditLandOwnerDialog controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }
    }

    @FXML
    void btnEditOwner(ActionEvent event) {
        LandOwnerTableItem currentItem = ownersTable.getSelectionModel().getSelectedItem();
        int currentItemId = ownersTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(LandResourcesApp.class.getResource("add-edit-land-owner-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(LandResourcesApp.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать правообладателя");

                AddEditLandOwnerDialog controller = loader.getController();
                controller.setEditDialogStage(dialogStage, currentItem.getLandOwner());
                dialogStage.showAndWait();
                updateList();
            } catch (IOException e) {
                System.out.println("Ошибка открытия окна: " + e.getMessage());
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для редактирования");
            alert.showAndWait();
        }
    }

    @FXML
    void btnDeleteOwner(ActionEvent event) {
        LandOwnerTableItem currentItem = ownersTable.getSelectionModel().getSelectedItem();
        int currentItemId = ownersTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getFullName() + "\"?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                new LandOwnerService().delete(currentItem.getLandOwner());
                ownersTable.getItems().remove(currentItemId);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }

    @FXML
    void btnUpdateOwners(ActionEvent event) {
        updateList();
    }

    @FXML
    void btnOffOnAction(ActionEvent event) {
        LandResourcesApp.primaryStage.close();
    }

    private void updateList() {
        owners = new LandOwnerService().findAll();
        ownersObservable = FXCollections.observableArrayList();
        for (LandOwner owner : owners) {
            ownersObservable.add(new LandOwnerTableItem(owner));
        }
        ownersTable.setItems(ownersObservable);
    }

    @FXML
    public void initialize() {
        fullNameColumn.setCellValueFactory(new PropertyValueFactory<>("fullName"));
        taxIdColumn.setCellValueFactory(new PropertyValueFactory<>("taxId"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("phone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("address"));
        updateList();
    }
}