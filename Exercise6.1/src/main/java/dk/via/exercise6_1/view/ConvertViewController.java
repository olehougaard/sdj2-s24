package dk.via.exercise6_1.view;

import dk.via.exercise6_1.viewmodel.ConvertViewModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ConvertViewController {
    private ViewHandler viewHandler;
    private ConvertViewModel viewModel;
    private Region root;

    @FXML TextField requestField;
    @FXML TextField replyField;
    @FXML Label errorLabel;

    public void init(ViewHandler viewHandler, ConvertViewModel convertViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = convertViewModel;
        this.root = root;

        viewModel.bindRequest(requestField.textProperty());
        viewModel.bindReply(replyField.textProperty());
        viewModel.bindError(errorLabel.textProperty());
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
        viewModel.reset();
    }

    @FXML public void onSubmit() {
        viewModel.convert();
    }


    @FXML public void onEnter(ActionEvent actionEvent) {
        onSubmit();
    }

    public void showLog(ActionEvent actionEvent) {
        viewHandler.openView(ViewFactory.LOG);
    }
}
