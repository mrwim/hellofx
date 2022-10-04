package io.wimmelstein.hellofx.controller;

import io.wimmelstein.hellofx.HelloApplication;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

    @FXML
    private VBox vBox;

    private final Logger log = Logger.getLogger(this.getClass().getName());

    @FXML
    private Button loginButton;

    @FXML
    private PasswordField passwordField;

    @FXML
    public void onPasswordTextChange(StringProperty observable, String oldValue, String newValue) {
        loginButton.setDisable(!isPasswordValid(newValue));
    }

    @FXML
    public void onLoginButtonClick(ActionEvent event) throws IOException {
        log.log(Level.INFO, "You have logged in with password {0}", passwordField.getText());
        loadScene("main-view.fxml", new MainViewController());

    }

    protected boolean isPasswordValid(String password) {
        boolean hasLetters = false;
        boolean hasDigits = false;
        boolean hasSpecial = false;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                hasDigits = true;
            } else if (Character.isLetter(c)) {
                hasLetters = true;
            } else {
                hasSpecial = true;
            }
        }
        return password.length() > 7 && (hasLetters && hasDigits && hasSpecial);
    }

    public void loadScene(String name, Object controller) {
        try {
            FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource(name));
            fxmlLoader.setController(controller);
            Scene scene = new Scene(fxmlLoader.load(), 600, 400);
            Stage window = (Stage) vBox.getScene().getWindow();
            window.setTitle(name.replace(".fxml", ""));
            window.setScene(scene);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

}
