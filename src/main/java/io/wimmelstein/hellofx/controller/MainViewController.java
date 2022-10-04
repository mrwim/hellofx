package io.wimmelstein.hellofx.controller;

import io.wimmelstein.hellofx.data.Database;
import io.wimmelstein.hellofx.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private Database db;
    private ObservableList<Person> people;
    @FXML
    private TableView<Person> personTableView;

    public MainViewController() {
        this.db = new Database();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        people = FXCollections.observableArrayList(db.getPeople());
        personTableView.setItems(people);
    }
}
