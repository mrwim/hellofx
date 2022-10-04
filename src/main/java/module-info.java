module io.wimmelstein.hellofx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.logging;

    opens io.wimmelstein.hellofx to javafx.fxml;
    exports io.wimmelstein.hellofx;
    exports io.wimmelstein.hellofx.controller;
    opens io.wimmelstein.hellofx.controller to javafx.fxml;
}