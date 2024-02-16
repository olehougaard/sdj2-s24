package dk.via.exercise5_1.view;

import dk.via.exercise5_1.viewmodel.ConvertViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Region;

public class ConvertViewController {
    private ViewHandler viewHandler;
    private ConvertViewModel viewModel;
    private Region root;

    public void init(ViewHandler viewHandler, ConvertViewModel convertViewModel, Region root) {
        this.viewHandler = viewHandler;
        this.viewModel = convertViewModel;
        this.root = root;
    }

    public Region getRoot() {
        return root;
    }

    public void reset() {
    }
}
