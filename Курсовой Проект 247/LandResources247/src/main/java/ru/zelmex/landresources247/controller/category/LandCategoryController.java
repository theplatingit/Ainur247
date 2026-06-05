package ru.zelmex.landresources247.controller.category;

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
import ru.zelmex.landresources247.model.LandCategory;
import ru.zelmex.landresources247.service.LandCategoryService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class LandCategoryController {

    private List<LandCategory> categories;
    private ObservableList<LandCategoryTableItem> categoriesObservable;

    @FXML
    private TableView<LandCategoryTableItem> categoriesTable;

    @FXML
    private TableColumn<LandCategory, String> nameColumn;

    @FXML
    private TableColumn<LandCategory, String> restrictionsColumn;

    @FXML
    private TableColumn<LandCategory, String> permittedUseColumn;

    @FXML
    void addCategory(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(LandResourcesApp.class.getResource("add-edit-land-category-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(LandResourcesApp.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("Добавить категорию земель");

            AddEditLandCategoryDialog controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }
    }

    @FXML
    void editCategory(ActionEvent event) {
        LandCategoryTableItem currentItem = categoriesTable.getSelectionModel().getSelectedItem();
        int currentItemId = categoriesTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(LandResourcesApp.class.getResource("add-edit-land-category-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(LandResourcesApp.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать категорию земель");

                AddEditLandCategoryDialog controller = loader.getController();
                controller.setEditDialogStage(dialogStage, currentItem.getLandCategory());
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
    void deleteCategory(ActionEvent event) {
        LandCategoryTableItem currentItem = categoriesTable.getSelectionModel().getSelectedItem();
        int currentItemId = categoriesTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить \"" + currentItem.getName() + "\"?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                new LandCategoryService().delete(currentItem.getLandCategory());
                categoriesTable.getItems().remove(currentItemId);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }
    @FXML
    void btnOwnersOnAction(ActionEvent event) {
        LandResourcesApp.primaryStage.setScene(LandResourcesApp.landOwners);
    }

    @FXML
    void btnPlotsOnAction(ActionEvent event) {
        LandResourcesApp.primaryStage.setScene(LandResourcesApp.landPlots);
    }
    @FXML
    void updateCategories(ActionEvent event) {
        updateList();
    }

    @FXML
    void btnOffOnAction(ActionEvent event) {
        LandResourcesApp.primaryStage.close();
    }

    private void updateList() {
        categories = new LandCategoryService().findAll();
        categoriesObservable = FXCollections.observableArrayList();
        for (LandCategory category : categories) {
            categoriesObservable.add(new LandCategoryTableItem(category));
        }
        categoriesTable.setItems(categoriesObservable);
    }

    @FXML
    public void initialize() {
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        restrictionsColumn.setCellValueFactory(new PropertyValueFactory<>("restrictions"));
        permittedUseColumn.setCellValueFactory(new PropertyValueFactory<>("permittedUse"));
        updateList();
    }
}