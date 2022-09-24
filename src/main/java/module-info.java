module io.wimmelstein.hellofx {
    requires javafx.controls;
    requires javafx.fxml;

    opens io.wimmelstein.hellofx to javafx.fxml;
    exports io.wimmelstein.hellofx;
}