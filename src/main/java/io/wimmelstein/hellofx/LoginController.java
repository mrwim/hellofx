package io.wimmelstein.hellofx;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    @FXML
    private Button loginButton;

    @FXML
    public void onPasswordTextChange(StringProperty observable, String oldValue, String newValue) {
        loginButton.setDisable(!isPasswordValid(newValue));
    }

    @FXML
    public void onLoginButtonClick(ActionEvent event) {
        System.out.println("Bladiebla");
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
