module mvvm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dk.via.exercise5_1 to javafx.fxml;
    opens dk.via.exercise5_1.view to javafx.fxml;

    exports dk.via.exercise5_1;
}