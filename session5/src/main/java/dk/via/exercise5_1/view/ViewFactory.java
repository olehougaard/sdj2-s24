package dk.via.exercise5_1.view;

import dk.via.exercise5_1.viewmodel.ViewModelFactory;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.Region;

import java.io.IOError;
import java.io.IOException;

public class ViewFactory {
    public static final String CONVERT = "convert";

    private final ViewHandler viewHandler;
    private final ViewModelFactory viewModelFactory;
    private ConvertViewController convertViewController;

    public ViewFactory(ViewHandler viewHandler, ViewModelFactory viewModelFactory) {
        this.viewHandler = viewHandler;
        this.viewModelFactory = viewModelFactory;
        this.convertViewController = null;
    }

    public Region loadConvertView() {
        return null;
    }

    public Region loadView(String id) {
        return switch (id) {
            case CONVERT -> loadConvertView();
            default -> throw new IllegalArgumentException("Unknown view: " + id);
        };
    }
}
