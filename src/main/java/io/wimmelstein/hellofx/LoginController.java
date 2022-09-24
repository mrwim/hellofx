package io.wimmelstein.hellofx;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;

import java.util.logging.Level;
import java.util.logging.Logger;

public class LoginController {

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
    public void onLoginButtonClick(ActionEvent event) {
        log.log(Level.INFO, "You have clicked on event {0}", event);
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

}
