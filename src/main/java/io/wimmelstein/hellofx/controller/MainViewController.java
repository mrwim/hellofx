package io.wimmelstein.hellofx.controller;

import io.wimmelstein.hellofx.data.Database;
import io.wimmelstein.hellofx.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {

    private Database db;
    private ObservableList<Person> people;
    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TextField firstName;
    @FXML
    private TextField lastName;
    @FXML
    private DatePicker dob;

    public MainViewController() {
        this.db = new Database();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        people = FXCollections.observableArrayList(db.getPeople());
        personTableView.setItems(people);
        personTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void onAddButtonClick() {
        Person person = new Person(firstName.getText(), lastName.getText(), dob.getValue() == null
                ? LocalDate.parse(dob.getEditor().getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                : dob.getValue());
        people.add(person);
        firstName.clear();
        lastName.clear();
        dob.getEditor().clear();
    }

    public void onDeleteButtonClick() {
        ObservableList<Person> peopleToDelete = personTableView.getSelectionModel().getSelectedItems();
        people.removeAll(peopleToDelete);
    }
}
