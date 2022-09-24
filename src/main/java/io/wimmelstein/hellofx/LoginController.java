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
        byte values = 0b000;

        for (char c : password.toCharArray()) {
            if (Character.isDigit(c)) {
                values = (byte) (values | 0b100);
            } else if (Character.isLetter(c)) {
                values = (byte) (values | 0b010);
            } else {
                values = (byte) (values | 0b001);
            }
        }
        return values == 7;
    }

}
