package io.wimmelstein.hellofx;

import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class LoginController {

    private static final int SET_DIGIT_BIT = 0b100;
    private static final int SET_LETTER_BIT = 0b010;
    private static final int SET_SPECIAL_BIT = 0b001;

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
                values = (byte) (values | SET_DIGIT_BIT);
            } else if (Character.isLetter(c)) {
                values = (byte) (values | SET_LETTER_BIT);
            } else {
                values = (byte) (values | SET_SPECIAL_BIT);
            }
        }
        return values == 7;
    }

}
