package dk.via.todo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

public class ViewController {
    private ViewModel viewModel;

    @FXML
    public Label count;
    @FXML
    public TextField todo;
    @FXML
    public ListView<String> todos;

    @FXML
    protected void onAddButtonClick() {
        viewModel.addTodo();
    }

    public void onEnter() {
        onAddButtonClick();
    }

    public void init(ViewModel viewModel) {
        this.viewModel = viewModel;

        this.viewModel.bindTodoCount(count.textProperty());
        this.viewModel.bindTodo(todo.textProperty());
        this.viewModel.bindTodos(todos.itemsProperty());
    }
}
