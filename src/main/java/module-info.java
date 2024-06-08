module maman11.javafx1 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens q2 to javafx.fxml;
    exports q2;
}