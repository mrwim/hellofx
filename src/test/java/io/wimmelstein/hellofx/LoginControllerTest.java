package io.wimmelstein.hellofx;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


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

    @ParameterizedTest(name = "Password validity")
    @CsvSource({
            "1q2w3e4$, true",
            "1q2w3e4r, false",
            "aaaaaaaa, false",
            "11111111, false",
            "1q!1234, false"
    })
    void testPasswordValidity(String password, boolean expected) {
        Assertions.assertEquals(expected, controller.isPasswordValid(password),
                () -> "The validity of password " + password + " is " + expected);
    }

}