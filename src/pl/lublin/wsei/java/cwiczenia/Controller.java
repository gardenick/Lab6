package pl.lublin.wsei.java.cwiczenia;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class Controller {
    public Label lbFile;
    public Button uploadBtn;
    public TableView tblNoblistas = new TableView();
    public TableColumn<Noblista, String> imieColumn;
    public TableColumn<Noblista, String> nazwiskoColumn;
    public TableColumn<Noblista, String> rokColumn;
    public TableColumn<Noblista, String> kategoriaColumn;
    public TableColumn<Noblista, String> uzasadnienieColumn;
    public TableColumn<Noblista, String> krajColumn;

    FileList fileList;
    FileChooser.ExtensionFilter csvFilter = new FileChooser.ExtensionFilter("Files CSV (*.csv)", "*.csv");
    FileChooser fileChooser = new FileChooser();

    public void uploadOnAction(ActionEvent actionEvent) {
        fileChooser.getExtensionFilters().add(csvFilter);
        File file = fileChooser.showOpenDialog(null);
        if (file != null) {
            fileList = new FileList(file.getAbsolutePath());
            lbFile.setText(file.getAbsolutePath());
            List<Noblista> noblistaList = new FileList("nobel_prize_by_winner.csv").noblistas;
            imieColumn.setCellValueFactory(new PropertyValueFactory<Noblista, String>("Imie"));


            insertDataInColumns(tblNoblistas, noblistaList);


        } else {
            lbFile.setText("Please choose file...");
        }
    }


    public void insertDataInColumns(TableView table, List list) {
        imieColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getImie()));
        nazwiskoColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getNazwisko()));
        rokColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getRok()));
        kategoriaColumn.setCellValueFactory(c -> new SimpleStringProperty(c.getValue().getKategoria()));
        uzasadnienieColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getUzasadnienie()));
        krajColumn.setCellValueFactory(c->new SimpleStringProperty(c.getValue().getKraj()));
        ObservableList<Noblista> oNoblisty = FXCollections.observableArrayList(list);

        table.setItems(oNoblisty);
    }
}

