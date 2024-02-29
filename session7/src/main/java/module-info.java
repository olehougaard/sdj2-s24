module mvvm {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    opens dk.via.todo to javafx.fxml;

    exports dk.via.todo;
}