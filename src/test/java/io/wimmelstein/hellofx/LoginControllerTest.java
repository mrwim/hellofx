package io.wimmelstein.hellofx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


class LoginControllerTest {

    LoginController controller = new LoginController();

    @Test
    void onlyLettersAndNumbersIsInvalidPassword() {
        Assertions.assertFalse(controller.isPasswordValid("1q2w3e4r"));
    }

    @Test
    void lettersAndNumbersAndSpecialCharactersEightCharactersIsValid() {
        Assertions.assertTrue(controller.isPasswordValid("1q2w3e4$"));
    }
}