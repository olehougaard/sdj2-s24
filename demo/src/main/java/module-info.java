module dk.via.demo {
    requires javafx.controls;
    requires javafx.fxml;

    opens dk.via.demo to javafx.fxml;

    exports dk.via.demo;
}