package ru.zelmex.landresources247.controller.plot;

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
import ru.zelmex.landresources247.LandResourcesApplication;
import ru.zelmex.landresources247.model.LandPlot;
import ru.zelmex.landresources247.service.LandPlotService;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public class LandPlotController {

    private List<LandPlot> plots;
    private ObservableList<LandPlotTableItem> plotsObservable;

    @FXML
    private TableView<LandPlotTableItem> plotsTable;

    @FXML
    private TableColumn<LandPlot, String> categoryColumn;

    @FXML
    private TableColumn<LandPlot, String> ownerColumn;

    @FXML
    private TableColumn<LandPlot, String> areaColumn;

    @FXML
    private TableColumn<LandPlot, String> cadastralNumberColumn;

    @FXML
    private TableColumn<LandPlot, String> taxIdColumn;

    @FXML
    private TableColumn<LandPlot, String> phoneColumn;

    @FXML
    private TableColumn<LandPlot, String> addressColumn;

    @FXML
    void addPlot(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(LandResourcesApplication.class.getResource("add-edit-land-plot-dialog.fxml"));
            Stage dialogStage = new Stage();
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(LandResourcesApplication.primaryStage);
            dialogStage.setMinWidth(400);
            dialogStage.setScene(new Scene(loader.load()));
            dialogStage.setTitle("Добавить участок");

            AddEditLandPlotDialog controller = loader.getController();
            controller.setAddDialogStage(dialogStage);
            dialogStage.showAndWait();
            updateList();
        } catch (IOException e) {
            System.out.println("Ошибка открытия окна: " + e.getMessage());
        }
    }

    @FXML
    void editPlot(ActionEvent event) {
        LandPlotTableItem currentItem = plotsTable.getSelectionModel().getSelectedItem();
        int currentItemId = plotsTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {
            try {
                FXMLLoader loader = new FXMLLoader(LandResourcesApplication.class.getResource("add-edit-land-plot-dialog.fxml"));
                Stage dialogStage = new Stage();
                dialogStage.initModality(Modality.WINDOW_MODAL);
                dialogStage.initOwner(LandResourcesApplication.primaryStage);
                dialogStage.setMinWidth(400);
                dialogStage.setScene(new Scene(loader.load()));
                dialogStage.setTitle("Редактировать участок");

                AddEditLandPlotDialog controller = loader.getController();
                controller.setEditDialogStage(dialogStage, currentItem.getLandPlot());
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
    void deletePlot(ActionEvent event) {
        LandPlotTableItem currentItem = plotsTable.getSelectionModel().getSelectedItem();
        int currentItemId = plotsTable.getSelectionModel().getSelectedIndex();

        if (currentItemId != -1) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Подтверждение удаления");
            alert.setHeaderText("Удаление записи");
            alert.setContentText("Вы действительно хотите удалить участок с кадастровым номером \"" + currentItem.getCadastralNumber() + "\"?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.isPresent() && result.get() == ButtonType.OK) {
                new LandPlotService().delete(currentItem.getLandPlot());
                plotsTable.getItems().remove(currentItemId);
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Предупреждение");
            alert.setContentText("Выберите запись в таблице для удаления");
            alert.showAndWait();
        }
    }

    @FXML
    void updatePlots(ActionEvent event) {
        updateList();
    }

    @FXML
    void onCategoriesButtonClick(ActionEvent event) {
        LandResourcesApplication.primaryStage.setScene(LandResourcesApplication.landCategories);
    }

    @FXML
    void onOwnersButtonClick(ActionEvent event) {
        LandResourcesApplication.primaryStage.setScene(LandResourcesApplication.landOwners);
    }

    @FXML
    void powerOff(ActionEvent event) {
        LandResourcesApplication.primaryStage.close();
    }

    public void updateList() {
        plots = new LandPlotService().findAll();
        plotsObservable = FXCollections.observableArrayList();
        for (LandPlot plot : plots) {
            plotsObservable.add(new LandPlotTableItem(plot));
        }
        plotsTable.setItems(plotsObservable);
    }

    public void initialize() {
        categoryColumn.setCellValueFactory(new PropertyValueFactory<>("categoryName"));
        ownerColumn.setCellValueFactory(new PropertyValueFactory<>("ownerName"));
        areaColumn.setCellValueFactory(new PropertyValueFactory<>("area"));
        cadastralNumberColumn.setCellValueFactory(new PropertyValueFactory<>("cadastralNumber"));
        taxIdColumn.setCellValueFactory(new PropertyValueFactory<>("ownerTaxId"));
        phoneColumn.setCellValueFactory(new PropertyValueFactory<>("ownerPhone"));
        addressColumn.setCellValueFactory(new PropertyValueFactory<>("ownerAddress"));
        updateList();
    }
}