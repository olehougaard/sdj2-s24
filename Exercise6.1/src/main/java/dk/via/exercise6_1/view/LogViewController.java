package dk.via.exercise6_1.view;

import dk.via.exercise6_1.viewmodel.LogViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class LogViewController {
    private Region root;
    private ViewHandler viewHandler;

    @FXML
    public ListView<String> logs;

    public void init(ViewHandler viewHandler, LogViewModel viewModel, Region root) {
        this.viewHandler = viewHandler;
        this.root = root;

        viewModel.bindLogs(logs.itemsProperty());
    }

    public void onBack() {
        viewHandler.openView(ViewFactory.CONVERT);
    }

    public Region getRoot() {
        return root;
    }
}
