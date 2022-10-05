package io.wimmelstein.hellofx.controller;

import io.wimmelstein.hellofx.data.Database;
import io.wimmelstein.hellofx.model.Person;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
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
    @FXML
    private Label message;

    public MainViewController() {
        this.db = new Database();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        people = FXCollections.observableArrayList(db.getPeople());
        personTableView.setItems(people);
        personTableView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
    }

    public void onAddButtonClick(ActionEvent event) {
        try {
            Person person = new Person(firstName.getText(), lastName.getText(),
                    dob.getValue() == null
                            ? LocalDate.parse(dob.getEditor().getText(), DateTimeFormatter.ofPattern("yyyy-MM-dd"))
                            : dob.getValue());
            people.add(person);
            clearFields();
        } catch (DateTimeParseException dtpe) {
            message.setText("Error parsing date " + dob.getEditor().getText());
            event.consume();
        }

    }

    public void onDeleteButtonClick() {
        ObservableList<Person> peopleToDelete = personTableView.getSelectionModel().getSelectedItems();
        people.removeAll(peopleToDelete);
    }

    private void clearFields() {
        firstName.clear();
        lastName.clear();
        dob.getEditor().clear();
        message.setText("");
    }
}
